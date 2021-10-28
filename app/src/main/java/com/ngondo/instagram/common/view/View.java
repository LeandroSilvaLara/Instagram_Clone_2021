package com.ngondo.instagram.common.view;

import android.content.Context;

public interface View {

    Context getContext();

    void showProgressBar();

    void hideProgressBar();

    void setStatusBarDark();
}
