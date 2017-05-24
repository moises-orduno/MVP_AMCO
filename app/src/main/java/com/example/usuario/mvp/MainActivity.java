package com.example.usuario.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.usuario.mvp.presenters.MainActivityPresenter;
import com.example.usuario.mvp.presenters.MainActivityPresenterImpl;
import com.example.usuario.mvp.views.MainActivityView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @BindView(R.id.et)
    EditText mEditText;
    @BindView(R.id.tv)
    TextView mTextView;

    @OnClick(R.id.fab_delete)
    public void delete() {
        mPresenter.deleteEditText();
    }

    @OnClick(R.id.fab_send)
    void send() {
        mPresenter.send();
    }

    @OnClick(R.id.fab_add)
    void add() {
        mPresenter.concatEditTextTextView();
    }

    private MainActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        mPresenter = new MainActivityPresenterImpl(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public EditText getEditText() {
        return mEditText;
    }

    @Override
    public TextView getTextView() {
        return mTextView;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void setText(String mMessage) {
        mTextView.setText(mMessage);
    }
}
