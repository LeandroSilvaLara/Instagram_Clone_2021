package com.ngondo.instagram.login.datasource;

import com.ngondo.instagram.common.model.Database;
import com.ngondo.instagram.common.model.UserAuth;
import com.ngondo.instagram.common.presenter.Presenter;

public class LoginLocalDataSource implements LoginDataSource {


    @Override
    public void login(String email, String password, Presenter presenter) {
        Database.getInstance().login(email, password)
                .addOnSuccessListener(new Database.OnSuccessListener<UserAuth>() {
                    @Override
                    public void onSuccess(UserAuth response){
                        presenter.onSuccess(response);
                    }
                })
                .addOnFailureListener(new Datab)

    }
}
