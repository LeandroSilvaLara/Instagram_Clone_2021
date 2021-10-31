package com.ngondo.instagram.register.presentation;

import com.ngondo.instagram.R;
import com.ngondo.instagram.common.model.UserAuth;
import com.ngondo.instagram.common.presenter.Presenter;
import com.ngondo.instagram.common.utill.Strings;
import com.ngondo.instagram.register.datasource.RegisterDataSource;

public class RegisterPresenter implements Presenter {

    private RegisterView registerview;
    private RegisterView.EmailView emailView;
    private RegisterView.NamePasswordView namePasswordView;

    private final RegisterDataSource dataSource;


    private String email;
    private String name;
    private String password;

    public RegisterPresenter(RegisterDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setRegisterView(RegisterView registerView) {
        this.registerview = registerView;
    }

    public void setEmailView(RegisterView.EmailView emailView) {
        this.emailView = emailView;
    }

    public void setNamePasswordView(RegisterView.NamePasswordView namePasswordView) {
        this.namePasswordView = namePasswordView;
    }

    public void setEmail(String email) {
        if (!Strings.emailValid(email)) {
            emailView.onFailureForm(emailView.getContext().getString(R.string.invalid_email));
            return;
        }

        this.email = email;
        registerview.showNextView(RegisterSteps.NAME_PASSWORD);
    }

    public void setNameAndPassword(String name, String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            namePasswordView.onFailureForm(null, namePasswordView.getContext().getString(R.string.password_not_equal));
            return;
        }
        this.name = name;
        this.password = password;

        namePasswordView.showProgressBar();
        dataSource.createUser(this.name, this.email, this.password, this);
    }

     public String getName() {
        return name;
     }

    public void showPhotoView() {
        registerview.showNextView(RegisterSteps.PHOTO);
    }

    public void jumpRegistration() {
        registerview.onUserCreated();
    }

    @Override
    public void onSuccess(UserAuth response) {
        registerview.showNextView(RegisterSteps.WELCOME);
    }

    @Override
    public void onError(String message) {
        namePasswordView.onFailureCreateUser(message);
    }

    @Override
    public void onComplete() {
        namePasswordView.hideProgressBar();
    }

}
