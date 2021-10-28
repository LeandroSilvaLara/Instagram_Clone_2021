package com.ngondo.instagram.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ngondo.instagram.R;
import com.ngondo.instagram.common.utill.Drawables;

import butterknife.ButterKnife;

public abstract class AbstractActivity extends AppCompatActivity implements View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        onInject();
    }

    public Drawable findDrawable(@DrawableRes int drawableId) {
        return Drawables.getDrawable(this, drawableId);
    }

    @Override
    public Context getBaseContext() {
        return super.getBaseContext();
    }



    //public int findColor(@ColorRes int colorId) {
    //    return CalendarContract.Colors.getColor(this, colorId);
   // }

    //@Override
    //public Context getContext() {
    //    return getBaseContext();
   // }



    public void setStatusBarDark() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(findColor(R.color.colorAccent));
        }
    }

    protected abstract @LayoutRes
    int getLayout();

    protected abstract void onInject();

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
