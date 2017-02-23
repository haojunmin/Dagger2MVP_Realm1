package com.example.administrator.dagger2mvp_realm.di.componet;

import com.example.administrator.dagger2mvp_realm.App;
import com.example.administrator.dagger2mvp_realm.db.RealmService;
import com.example.administrator.dagger2mvp_realm.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/2/23.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponet {
    App getContext();

    RealmService realmService();
}
