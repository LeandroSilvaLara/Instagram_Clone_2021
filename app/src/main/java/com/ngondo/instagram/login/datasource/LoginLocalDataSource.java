package com.ngondo.instagram.login.datasource;

import com.ngondo.instagram.common.presenter.Presenter;

public class LoginLocalDataSource implements LoginDataSource {


    @Override
    public void login(String email, String password, Presenter presenter) {
        presenter.onError("Error1");
        presenter.onComplete();
    }
}
