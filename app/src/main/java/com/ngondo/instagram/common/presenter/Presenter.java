package com.ngondo.instagram.common.presenter;

import com.ngondo.instagram.common.model.UserAuth;

public interface Presenter {

    void onSuccess(UserAuth response);

    void onError(String message);

    void onComplete();
}
