/*
 * Copyright (C) 2008 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zaxcler.test.zxing;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import com.zaxcler.test.base.MResource;
import com.zaxcler.test.zxing.camera.CameraManager;
import com.zaxcler.test.zxing.control.AmbientLightManager;
import com.zaxcler.test.zxing.control.BeepManager;
import com.zaxcler.test.zxing.decoding.CaptureActivityHandler;
import com.zaxcler.test.zxing.decoding.FinishListener;
import com.zaxcler.test.zxing.decoding.InactivityTimer;
import com.zaxcler.test.zxing.view.ViewfinderView;

import java.io.IOException;
import java.util.Map;
import java.util.Vector;


/**
 * This activity opens the camera and does the actual scanning on a background thread. It draws a
 * viewfinder to help the user place the barcode correctly, shows feedback as the image processing
 * is happening, and then overlays the results when a scan is successful.
 *
 * @author dswitkin@google.com (Daniel Switkin)
 * @author Sean Owen
 */
public final class CaptureActivity extends Activity implements SurfaceHolder.Callback {

    private InactivityTimer inactivityTimer;
    private ViewfinderView viewfinderView;
    private CameraManager cameraManager;
    private CaptureActivityHandler handler;
    /**
     * 声音管理器，扫描完后响应
     */
    private BeepManager beepManager;
    /**
     * 闪光灯管理器
     */
    private AmbientLightManager ambientLightManager;


    private SurfaceView surfaceView;

    private SurfaceHolder surfaceHolder;

    private final String TAG = "CaptureActivity_EORR";

    private Vector<BarcodeFormat> decodeFormats;

    private Map<DecodeHintType, ?> baseHints;

    private String characterSet;

    private boolean hasSurface = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//保持屏幕常亮
//        setContentView(R.layout.capture);
        setContentView(MResource.getIdbyName(this,"layout","capture"));


    }


    @Override
    protected void onResume() {
        inactivityTimer = new InactivityTimer(this);

        beepManager = new BeepManager(this);

        ambientLightManager = new AmbientLightManager(this);

        cameraManager = new CameraManager(this);

        viewfinderView = (ViewfinderView) findViewById(MResource.getIdbyName(this,"id","finderview"));
        surfaceView = (SurfaceView) findViewById(MResource.getIdbyName(this,"id","surfaceView"));

        viewfinderView.setVisibility(View.VISIBLE);

        viewfinderView.setCameraManager(cameraManager);
        surfaceHolder = surfaceView.getHolder();

        if (hasSurface) {
            initCamera(surfaceHolder);
        } else {
            surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
            surfaceHolder.addCallback(this);
        }
        decodeFormats = null;
        characterSet = null;
        // 恢复活动监控器
        inactivityTimer.onResume();
        // 加载声音配置，其实在BeemManager的构造器中也会调用该方法，即在onCreate的时候会调用一次
        beepManager.updatePrefs();
        // 启动闪光灯调节器
        ambientLightManager.start(cameraManager);

        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        if (handler != null) {
            handler.quitSynchronously();
            handler = null;
        }
        inactivityTimer.onPause();
        ambientLightManager.stop();
        beepManager.close();

        // 关闭摄像头
        cameraManager.closeDriver();
        if (!hasSurface) {
            SurfaceView surfaceView = (SurfaceView) findViewById(MResource.getIdbyName(this,"id","surfaceView"));
            SurfaceHolder surfaceHolder = surfaceView.getHolder();
            surfaceHolder.removeCallback(this);
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        inactivityTimer.shutdown();
        super.onDestroy();
    }

    /**
     * 初始化相机
     *
     * @param surfaceHolder
     */
    private void initCamera(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new NullPointerException("sufaceholder is null");
        }

        if (cameraManager.isOpen()) {
            Log.w(TAG, "initCamera() while already open -- late SurfaceView callback?");
            return;
        }

        try {
            cameraManager.openDriver(surfaceHolder);
            if (handler == null) {
                handler = new CaptureActivityHandler(this, decodeFormats, baseHints, characterSet, cameraManager);
            }
        } catch (IOException e) {
            Log.w(TAG, e);
            displayFrameworkBugMessageAndExit();
            e.printStackTrace();
        }

    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (holder == null) {
            Log.e(TAG,
                    "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!hasSurface) {
            hasSurface = true;
            initCamera(holder);
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        hasSurface = false;
    }

    public CameraManager getCameraManager() {
        return cameraManager;
    }


    public Handler getHandler() {

        return handler;
    }

    public ViewfinderView getViewfinderView() {

        return viewfinderView;
    }

    public void handleDecode(Result obj, Bitmap barcode, float scaleFactor) {
        inactivityTimer.onActivity();

        beepManager.playBeepSoundAndVibrate();

        String resultString = obj.getText();
        if (TextUtils.isEmpty(resultString)) {
            showErrorDialog();
        } else {
            Toast.makeText(CaptureActivity.this, resultString,
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void drawViewfinder() {
        viewfinderView.drawViewfinder();
    }

    private void showErrorDialog() {
        closeCamera();
        viewfinderView.setVisibility(View.GONE);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(MResource.getIdbyName(this,"string","app_name")));
        builder.setMessage("扫描确认出错，请重新扫描二维码！");
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                restartCamera();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                CaptureActivity.this.finish();
            }
        });
        builder.show();
    }

    void restartCamera() {
        Log.d(TAG, "hasSurface " + hasSurface);

        viewfinderView.setVisibility(View.VISIBLE);

//        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        SurfaceView surfaceView = (SurfaceView) findViewById(MResource.getIdbyName(this,"id","surfaceView"));
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        initCamera(surfaceHolder);

        // 恢复活动监控器
        inactivityTimer.onResume();
    }

    void closeCamera() {
        if (handler != null) {
            handler.quitSynchronously();
            handler = null;
        }
        inactivityTimer.onPause();

        // 关闭摄像头
        cameraManager.closeDriver();
    }


    private void displayFrameworkBugMessageAndExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(MResource.getIdbyName(this,"string","app_name")));
        builder.setMessage(getString(MResource.getIdbyName(this,"string","msg_camera_framework_bug")));
        builder.setPositiveButton(android.R.string.yes, new FinishListener(this));
        builder.setOnCancelListener(new FinishListener(this));
        builder.show();
    }
}
