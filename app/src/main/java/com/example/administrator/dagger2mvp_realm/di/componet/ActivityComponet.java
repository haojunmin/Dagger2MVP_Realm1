package com.example.administrator.dagger2mvp_realm.di.componet;

import android.app.Activity;

import com.example.administrator.dagger2mvp_realm.MainActivity;
import com.example.administrator.dagger2mvp_realm.di.ActivityScope;
import com.example.administrator.dagger2mvp_realm.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by Administrator on 2017/2/23.
 */
@ActivityScope
@Component(dependencies = AppComponet.class, modules = ActivityModule.class)
public interface ActivityComponet {
    Activity getActivity();

    void inject(MainActivity activity);
}
