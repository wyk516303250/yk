package com.example.zuoye25;

import android.app.Application;

/**
 * Created by 康康 on 2019/6/21.
 */

public class MyApp extends Application {
    private static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public static MyApp getApp() {
        return app;
    }
}
