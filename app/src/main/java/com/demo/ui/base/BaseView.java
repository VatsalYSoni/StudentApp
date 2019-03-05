package com.demo.ui.base;

import android.app.Activity;



public interface BaseView {

    void onBack();

    Activity getActivity();

    void onProfile();

    void onError(String message);

    void showMessage(String message);

    boolean isNetworkConnected();

    void hideKeyboard();

    void onNotification();
}
