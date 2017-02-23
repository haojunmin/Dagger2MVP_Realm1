package com.example.administrator.dagger2mvp_realm.di.module;

import com.example.administrator.dagger2mvp_realm.App;
import com.example.administrator.dagger2mvp_realm.db.RealmService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/2/23.
 */

@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return app;
    }

    @Provides
    @Singleton
    RealmService provideRealmService() {
        return new RealmService();
    }
}
