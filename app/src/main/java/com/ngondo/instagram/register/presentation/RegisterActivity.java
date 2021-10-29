package com.ngondo.instagram.register.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ngondo.instagram.R;
import com.ngondo.instagram.common.view.AbstractActivity;
import com.ngondo.instagram.main.presentation.MainActivity;

public class RegisterActivity extends AbstractActivity {

    public static void launch(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarDark();
    }

    @Override
    protected void onInject() {
    }

    @Override
    protected int getLayout() {
       return R.layout.activity_register;
    }

}