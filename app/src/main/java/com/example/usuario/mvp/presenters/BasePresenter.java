package com.example.usuario.mvp.presenters;

/**
 * Created by usuario on 23/05/17.
 */

public interface BasePresenter {

    void showProgress();

    void showMessage(String message);

    void hideProgress();

}
