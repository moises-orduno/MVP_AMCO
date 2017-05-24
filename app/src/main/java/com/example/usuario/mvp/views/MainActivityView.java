package com.example.usuario.mvp.views;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by usuario on 23/05/17.
 */

public interface MainActivityView {
    EditText getEditText();

    TextView getTextView();

    Context getContext();

    void setText(String mMessage);
}
