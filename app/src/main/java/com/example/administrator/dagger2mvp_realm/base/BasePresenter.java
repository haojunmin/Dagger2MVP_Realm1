package com.example.administrator.dagger2mvp_realm.base;

/**
 * Created by Administrator on 2017/2/23.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void detachView();
}
