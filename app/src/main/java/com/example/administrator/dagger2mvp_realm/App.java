package com.example.administrator.dagger2mvp_realm;

import android.app.Application;

/**
 * Created by Administrator on 2017/2/23.
 */

public class App extends Application {
    private static App instance;

    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
