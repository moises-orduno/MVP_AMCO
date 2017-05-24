package com.example.usuario.mvp.presenters;

import android.content.Context;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;

import com.example.usuario.mvp.views.MainActivityView;

/**
 * Created by usuario on 23/05/17.
 */

public class MainActivityPresenterImpl extends BasePresenterImpl implements MainActivityPresenter {

    private final MainActivityView mView;
    private final EditText mEditText;
    private final TextView mTextView;
    private String mMessage;

    public MainActivityPresenterImpl(MainActivityView view) {
        super(view.getContext());
        mView = view;
        mEditText = view.getEditText();
        mTextView = view.getTextView();
    }

    @Override
    public void deleteEditText() {
        mTextView.setText("");
    }

    @Override
    public void concatEditTextTextView() {
        mMessage=mTextView.getText().toString();
        mMessage+=mEditText.getText().toString();
        mEditText.setText("");
        mView.setText(mMessage);
    }

    @Override
    public void send() {

        showProgress();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
               showMessage("enviado");
                hideProgress();
            }
        }, 3000);

    }
}
