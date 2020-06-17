package com.example.healthnote.daixie;

import android.app.Application;

import com.example.utils.SPUtil;
import com.raizlabs.android.dbflow.config.FlowManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
        SPUtil.getInstance(this);
    }
}
