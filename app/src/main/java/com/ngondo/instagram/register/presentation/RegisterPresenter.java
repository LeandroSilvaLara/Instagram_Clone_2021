package com.ngondo.instagram.register.presentation;

import com.ngondo.instagram.R;
import com.ngondo.instagram.common.utill.Strings;

public class RegisterPresenter {

    private RegisterView registerview;
    private RegisterView.EmailView emailView;
    private RegisterView.NamePasswordView namePasswordView;

    private String email;
    private String name;
    private String password;

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
    }
}
