package com.example.administrator.dagger2mvp_realm;

import android.app.Application;

import com.example.administrator.dagger2mvp_realm.di.componet.AppComponet;
import com.example.administrator.dagger2mvp_realm.di.componet.DaggerAppComponet;
import com.example.administrator.dagger2mvp_realm.di.module.AppModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2017/2/23.
 */

public class App extends Application {
    private static App instance;
    private static AppComponet mAppComponet;

    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initRealm();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("book.realm").build();
        Realm.deleteRealm(config);
        Realm.setDefaultConfiguration(config);
    }

    public static AppComponet getAppComponet() {
        if (mAppComponet == null) {
            mAppComponet = DaggerAppComponet.builder().appModule(new AppModule(instance)).build();
        }
        return mAppComponet;
    }
}
