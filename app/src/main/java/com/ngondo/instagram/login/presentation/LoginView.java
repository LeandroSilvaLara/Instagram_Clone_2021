package com.ngondo.instagram.login.presentation;

import com.ngondo.instagram.common.view.View;

public interface LoginView extends View {


    void onFailureForm(String emailError, String passwordError);

    void onUserLogged();
}
