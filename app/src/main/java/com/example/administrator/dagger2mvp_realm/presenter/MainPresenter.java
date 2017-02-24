package com.example.administrator.dagger2mvp_realm.presenter;

import com.example.administrator.dagger2mvp_realm.base.RxPresenter;
import com.example.administrator.dagger2mvp_realm.db.RealmService;
import com.example.administrator.dagger2mvp_realm.enty.Book;
import com.example.administrator.dagger2mvp_realm.presenter.contact.MainContact;

import java.util.Iterator;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/2/24.
 */

public class MainPresenter extends RxPresenter<MainContact.View> implements MainContact.Presenter {
    private RealmService mRealmService;

    @Inject
    public MainPresenter(RealmService mRealmService) {
        this.mRealmService = mRealmService;
    }

    @Override
    public void addBook(String title, String author, String isbn, String publisher) {
        mRealmService.addBookAsync(title, author, isbn, publisher);
        mView.addSucess();
    }

    @Override
    public String queryBook() {
        StringBuilder builder = new StringBuilder();
        Iterator<Book> iterator = mRealmService.getAllBooks().iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next().toString());
        }
        return builder.toString();
    }

    public void closeRealm() {
        mRealmService.closeRealm();
    }
}
