package com.example.usuario.mvp.presenters;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by usuario on 23/05/17.
 */

public class BasePresenterImpl implements BasePresenter{

    final private Context mContext;
    private ProgressDialog mDialog;

    public BasePresenterImpl(Context context) {
        mContext=context;
    }

    @Override
    public void showProgress() {
            mDialog= ProgressDialog.show(mContext, "",
                "Loading. Please wait...", true);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideProgress() {
        if(mDialog!=null) mDialog.dismiss();
    }
}
