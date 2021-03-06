package com.ngondo.instagram.register.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

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

public class RegisterNamePasswordFragment extends AbstractFragment<RegisterPresenter> implements RegisterView.NamePasswordView {

    @BindView(R.id.register_edit_text_name_input)
    TextInputLayout inputLayoutName;

    @BindView(R.id.register_edit_text_name)
    EditText editTextName;

    @BindView(R.id.register_edit_text_name_password_input)
    TextInputLayout inputLayoutNamePassword;

    @BindView(R.id.register_edit_text_name_password)
    EditText editTextPassword;

    @BindView(R.id.register_edit_text_name_password_confirm_input)
    TextInputLayout inputLayoutConfirm;

    @BindView(R.id.register_edit_text_name_password_confirm)
    EditText editTextConfirm;

    @BindView(R.id.register_button_next)
    LoadingButton buttonNext;

    public static RegisterNamePasswordFragment newInstance(RegisterPresenter presenter) {
        RegisterNamePasswordFragment fragment = new RegisterNamePasswordFragment();
        fragment.setPresenter(presenter);
        presenter.setNamePasswordView(fragment);
        return fragment;
    }

    public RegisterNamePasswordFragment() {
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
    public void onFailureForm(String nameError, String passwordError) {
        if (nameError != null) {
            inputLayoutName.setError(nameError);
            editTextName.setBackground(findDrawable(R.drawable.edit_text_background_error));
        }
        if (passwordError != null) {
            inputLayoutNamePassword.setError(passwordError);
            editTextPassword.setBackground(findDrawable(R.drawable.edit_text_background_error));
        }
    }

    @Override
    public void onFailureCreateUser(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.register_text_view_login)
    public void onTextViewLoginClick() {
        if (isAdded() && getActivity() != null)
            getActivity().finish();
    }

    @OnClick(R.id.register_name_button_next)
        public void onButtonNextClick() {
        presenter.setNameAndPassword(editTextName.getText().toString(), editTextPassword.getText().toString(),
                editTextConfirm.getText().toString());
    }

    @OnTextChanged({
            R.id.register_edit_text_name,
            R.id.register_edit_text_name_password,
            R.id.register_edit_text_name_password_confirm
    })
    public void onTextChanged(CharSequence s) {
        buttonNext.setEnabled(!editTextName.getText().toString().isEmpty() &&
                !editTextPassword.getText().toString().isEmpty() &&
                !editTextConfirm.getText().toString().isEmpty());

        editTextName.setBackground(findDrawable(R.drawable.edit_text_background));
        inputLayoutName.setError(null);
        inputLayoutName.setErrorEnabled(false);

        editTextPassword.setBackground(findDrawable(R.drawable.edit_text_background));
        inputLayoutNamePassword.setError(null);
        inputLayoutNamePassword.setErrorEnabled(false);

        editTextConfirm.setBackground(findDrawable(R.drawable.edit_text_background));
        inputLayoutConfirm.setError(null);
        inputLayoutConfirm.setErrorEnabled(false);
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_register_name_password;
    }

}
