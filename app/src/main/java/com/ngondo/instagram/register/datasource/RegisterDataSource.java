package com.ngondo.instagram.register.datasource;

import com.ngondo.instagram.common.presenter.Presenter;

public interface RegisterDataSource {

    void createUser(String name, String email, String password, Presenter presenter);
}
