package com.zaxcler.test.ui;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.zaxcler.test.R;



/**
 * Created by zaxcler on 2016/5/13.
 */
public class VideoActivity extends Activity {

    private VideoView videoView;

    private SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);
        videoView= (VideoView) findViewById(R.id.videoview);
       MediaController controller=new MediaController(this);

//        videoView.setMediaController(controller);
        controller.setAnchorView(videoView);
        videoView.setVideoURI(Uri.parse("208.75.229.59:1935/1tv/smil:1tvmulti.smil/playlist.m3u8"));
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.start();
            }
        });

//        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
//        MediaPlayer mediaPlayer=new MediaPlayer();
//        try {
//            mediaPlayer.setDataSource("http://recordcdn.quklive.com/upload/vod/user1462960877450854/1463472394331829/3/video.m3u8");
//            mediaPlayer.pause();
//            mediaPlayer.start();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    @Override
    protected void onResume() {
        super.onResume();

        //设置为横屏
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }
}
