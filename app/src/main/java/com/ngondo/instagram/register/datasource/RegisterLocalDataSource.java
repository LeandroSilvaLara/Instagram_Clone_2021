package com.ngondo.instagram.register.datasource;

import com.ngondo.instagram.common.model.Database;
import com.ngondo.instagram.common.model.UserAuth;
import com.ngondo.instagram.common.presenter.Presenter;

public class RegisterLocalDataSource implements RegisterDataSource{
    @Override
    public void createUser(String name, String email, String password, Presenter presenter) {
        Database.getInstance().createUser(name, email, password)
                .addOnSuccessListener((Database.OnSuccessListener<UserAuth>) presenter::onSuccess)
                .addOnFailureListener(e -> presenter.onError(e.getMessage()))
                .addOnCompleteListener(presenter::onComplete);
    }
}
