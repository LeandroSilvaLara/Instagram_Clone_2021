package com.ngondo.instagram.common.presenter;

public interface Presenter {

    void onSuccess();

    void onError(String message);

    void onComplete();
}
