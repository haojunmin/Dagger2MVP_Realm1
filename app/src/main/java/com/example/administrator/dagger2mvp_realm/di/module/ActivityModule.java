package com.example.administrator.dagger2mvp_realm.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/2/23.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    public Activity provideActivity()
    {
        return  mActivity;
    }
}
