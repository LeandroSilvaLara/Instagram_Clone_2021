package com.ngondo.instagram.login.presentation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.ngondo.instagram.R;
import com.ngondo.instagram.common.view.AbstractActivity;
import com.ngondo.instagram.common.view.LoadingButton;
import com.ngondo.instagram.login.datasource.LoginDataSource;
import com.ngondo.instagram.login.datasource.LoginLocalDataSource;
import com.ngondo.instagram.main.presentation.MainActivity;
import com.ngondo.instagram.register.presentation.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginActivity extends AbstractActivity implements LoginView, TextWatcher  {

    @BindView(R.id.login_edit_text_email)
    EditText editTextEmail;
    @BindView(R.id.login_edit_text_password)
    EditText editTextPassword;
    @BindView(R.id.login_edit_text_email_input)
    TextInputLayout inputLayoutEmail;
    @BindView(R.id.login_edit_text_password_input) TextInputLayout inputLayoutPassword;
    @BindView(R.id.login_button_enter) LoadingButton buttonEnter;

    LoginPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        }


    }

    @Override
    public void showProgressBar() {
        buttonEnter.showProgress(true);
    }

    @Override
    public void hideProgressBar() {
        buttonEnter.showProgress(false);
    }

    @Override
    public void onFailureForm(String emailError, String passwordError) {
        if (emailError != null) {
            inputLayoutEmail.setError(emailError);
            editTextEmail.setBackground(findDrawable(R.drawable.edit_text_background_error));
        }
        if (passwordError != null) {
            inputLayoutPassword.setError(passwordError);
            editTextPassword.setBackground(findDrawable(R.drawable.edit_text_background_error));
        }
    }

    @Override
    public void onUserLogged() {
        //MainActivity.launch(this, MainActivity.LOGIN_ACTIVITY);
        //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @OnClick(R.id.login_button_enter)
    public void onButtonEnterClick() {
        presenter.login(editTextEmail.getText().toString(), editTextPassword.getText().toString());
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @OnTextChanged({R.id.login_edit_text_email, R.id.login_edit_text_password})
        public void OnTextChanged(CharSequence s) {
            buttonEnter.setEnabled(
                    !editTextEmail.getText().toString().isEmpty() &&
                            !editTextPassword.getText().toString().isEmpty());

            if (s.hashCode() == editTextEmail.getText().hashCode()) {
                editTextEmail.setBackground(findDrawable(R.drawable.edit_text_background));
                inputLayoutEmail.setError(null);
                inputLayoutEmail.setErrorEnabled(false);
            } else if (s.hashCode() == editTextPassword.getText().hashCode()) {
                editTextPassword.setBackground(findDrawable(R.drawable.edit_text_background));
                inputLayoutPassword .setError(null);
                inputLayoutPassword.setErrorEnabled(false);
            }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }


    @Override
    public void afterTextChanged(Editable s) {

    }

    public void afterTextChanged(EditText s){

    }

    @Override
    protected void onInject() {
        LoginDataSource dataSource = new LoginLocalDataSource();
        presenter = new LoginPresenter(this, dataSource);

    }
}






