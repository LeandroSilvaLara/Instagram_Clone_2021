package com.ngondo.instagram.register.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.ngondo.instagram.R;
import com.ngondo.instagram.common.view.AbstractFragment;
import com.ngondo.instagram.common.view.LoadingButton;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class RegisterEmailFragment extends AbstractFragment<RegisterPresenter> implements RegisterView.EmailView{

    @BindView(R.id.register_edit_text_email_input)
    TextInputLayout inputLayoutEmail;

    @BindView(R.id.register_edit_text_email)
    EditText editTextEmail;

    @BindView(R.id.register_button_next)
    LoadingButton buttonNext;


    public  RegisterEmailFragment() {
    }

    public static RegisterEmailFragment newInstance(RegisterPresenter presenter) {
        RegisterEmailFragment fragment = new RegisterEmailFragment();

        fragment.setPresenter(presenter);
        presenter.setEmailView(fragment);

        return fragment;
    }

    @Override
    public void showProgressBar() {
        buttonNext.showProgress(true);
    }

    @Override
    public void hideProgressBar() {
        buttonNext.showProgress(false);
    }

    @Override
    public void onFailureForm(String emailError) {
        inputLayoutEmail.setError(emailError);
        editTextEmail.setBackground(findDrawable(R.drawable.edit_text_background_error));
    }


    @OnClick(R.id.register_text_view_email_login)
    public void onTextViewLoginClick() {
        if (isAdded() && getActivity() != null)
            getActivity().finish();
    }

    @OnClick(R.id.register_button_next)
    public void onButtonNextClick(){
        presenter.setEmail(editTextEmail.getText().toString());
    }

    @OnTextChanged(R.id.register_edit_text_email)
    public void onTextChanged(CharSequence s) {
        buttonNext.setEnabled(!editTextEmail.getText().toString().isEmpty());

        editTextEmail.setBackground(findDrawable(R.drawable.edit_text_background));
        inputLayoutEmail.setError(null);
        inputLayoutEmail.setErrorEnabled(false);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_register_email;
    }

    public class newInstance extends RegisterEmailFragment {

    }
}
