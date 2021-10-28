package com.ngondo.instagram.login.datasource;


import com.ngondo.instagram.common.presenter.Presenter;

public interface LoginDataSource {

    void login(String email, String password, Presenter presenter);

}
