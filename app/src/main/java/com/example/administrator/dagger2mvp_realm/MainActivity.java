package com.example.administrator.dagger2mvp_realm;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.dagger2mvp_realm.base.BaseActivity;
import com.example.administrator.dagger2mvp_realm.presenter.MainPresenter;
import com.example.administrator.dagger2mvp_realm.presenter.contact.MainContact;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContact.View {

    private static final String TAG = "MainActivity";

    @BindView(R.id.showcontent)
    TextView showContent;
    @BindView(R.id.addButton)
    Button add;
    @BindView(R.id.queryButton)
    Button query;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void initInject() {
        getActivityComponet().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick(R.id.addButton)
    public void addBook() {
        mPresenter.addBook("title", "author", "isbn", "publisher");
    }

    @OnClick(R.id.queryButton)
    public void queryBook() {
        showContent.setText(mPresenter.queryBook());
    }

    @Override
    public void addSucess() {
        Toast.makeText(mContext, "添加成功", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.closeRealm();
        Log.i(TAG, "onDesory");
    }
}
