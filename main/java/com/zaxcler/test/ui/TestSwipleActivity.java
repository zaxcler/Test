package com.zaxcler.test.ui;

import android.app.Activity;
import android.os.Bundle;

import com.zaxcler.test.R;
import com.zaxcler.test.base.SwipeActivity;

/**
 * Created by zaxcler on 2016/4/28.
 */
public class TestSwipleActivity extends SwipeActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testswiple_activity);
        setSwipeAnyWhere(true);

    }
}
