package com.zaxcler.test.base;

import android.app.Activity;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by zaxcler on 2016/4/25.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
}
