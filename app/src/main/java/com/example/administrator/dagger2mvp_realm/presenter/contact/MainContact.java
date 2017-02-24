package com.example.administrator.dagger2mvp_realm.presenter.contact;

import com.example.administrator.dagger2mvp_realm.base.BasePresenter;
import com.example.administrator.dagger2mvp_realm.base.BaseView;

/**
 * Created by Administrator on 2017/2/24.
 */

public interface MainContact {
    interface View extends BaseView {


    }

    interface Presenter extends BasePresenter<View> {
        void addBook(String title,
                     String author, String isbn, String publisher);

        String queryBook();
    }
}
