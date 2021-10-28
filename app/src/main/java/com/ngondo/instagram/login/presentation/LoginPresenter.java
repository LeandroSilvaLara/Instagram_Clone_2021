package com.ngondo.instagram.login.presentation;

import android.os.Handler;

import com.ngondo.instagram.R;
import com.ngondo.instagram.common.presenter.Presenter;
import com.ngondo.instagram.common.utill.Strings;
import com.ngondo.instagram.login.datasource.LoginDataSource;

public class LoginPresenter implements Presenter {

    private final LoginView view;
    private final LoginDataSource dataSource;

    LoginPresenter(LoginView view, LoginDataSource dataSource) {
        this.view = view;
        this.dataSource = dataSource;
    }

    void login(String email, String password) {
        if (!Strings.emailValid(email)) {
            view.onFailureForm(view.getContext().getString(R.string.invalid_email), null);
            return;
        }

        view.showProgressBar();
        dataSource.login(email, password, this);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError(String message) {
        view.onFailureForm(null, message);
    }

    @Override
    public void onComplete() {
    view.hideProgressBar();
    }
}
