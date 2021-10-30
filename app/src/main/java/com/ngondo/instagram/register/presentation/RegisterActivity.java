package com.ngondo.instagram.register.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ngondo.instagram.R;
import com.ngondo.instagram.common.view.AbstractActivity;
import com.ngondo.instagram.main.presentation.MainActivity;

public class RegisterActivity extends AbstractActivity implements RegisterView {

    public static void launch(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }


    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarDark();
    }

    @Override
    protected void onInject() {
        presenter = new RegisterPresenter();
        presenter.setRegisterView(this);

        showNextView(RegisterSteps.EMAIL);


    }

    @Override
    public void showNextView(RegisterSteps step) {
        Fragment frag = RegisterEmailFragment.newInstance(presenter);
        switch (step) {
            case EMAIL:
                break;
            case NAME_PASSWORD:
                frag = RegisterNamePasswordFragment.newInstance(presenter);
                break;
        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (manager.findFragmentById(R.id.register_fragment) == null){
        transaction.add(R.id.register_fragment, frag, step.name());
        } else {
            transaction.replace(R.id.register_fragment, frag, step.name());
            transaction.addToBackStack(step.name());
        }

        transaction.commit();
    }

    @Override
    protected int getLayout() {
       return R.layout.activity_register;
    }

}