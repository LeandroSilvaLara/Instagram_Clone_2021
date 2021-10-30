package com.ngondo.instagram.register.presentation;

import com.ngondo.instagram.R;
import com.ngondo.instagram.common.utill.Strings;

public class RegisterPresenter {

    private RegisterView.EmailView emailView;

    private String email;

    public void setEmailView(RegisterView.EmailView emailView) {
        this.emailView = emailView;
    }

    public void setEmail(String email) {
        if (!Strings.emailValid(email)) {
            emailView.onFailureForm(emailView.getContext().getString(R.string.invalid_email));
            return;
        }

        this.email = email;
    }
}