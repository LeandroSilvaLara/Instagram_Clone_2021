package com.ngondo.instagram.register.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ngondo.instagram.R;
import com.ngondo.instagram.common.view.AbstractFragment;
import com.ngondo.instagram.common.view.CustomDialog;
import com.ngondo.instagram.common.view.LoadingButton;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterPhotoFragment extends AbstractFragment<RegisterPresenter> implements RegisterView.PhotoView {

    @BindView(R.id.register_button_next)
    LoadingButton buttonNext;

    public static RegisterPhotoFragment newInstance(RegisterPresenter presenter) {
        RegisterPhotoFragment fragment = new RegisterPhotoFragment();
        fragment.setPresenter(presenter);
        return fragment;
    }

    public RegisterPhotoFragment() {
    }


    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);
        buttonNext.setEnabled(true);

        //CustomDialog customDialog = new CustomDialog.Builder(getContext())
        //        .setTitle(R.string.define_photo_profile)
        //        .addButton((v) -> {
        //        }, R.string.take_picture)
        //        .build();

        //        customDialog.show();
    }

    @OnClick(R.id.register_button_next)
    public void onButtonNextClick() {
        presenter.jumpRegistration();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_register_photo;
    }
}
