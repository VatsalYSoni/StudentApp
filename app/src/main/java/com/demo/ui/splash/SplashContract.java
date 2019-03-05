package com.demo.ui.splash;

import android.support.annotation.NonNull;


import com.demo.ui.base.BasePresenter;
import com.demo.ui.base.BaseView;

import de.halfbit.rxandroid.permissions.RxPermissions;



public interface SplashContract {


    interface View extends BaseView {

        RxPermissions.PermissionsRequester getPermissionRequest();

        void showDashBoard();

    }


    interface Presenter<V extends View> extends BasePresenter<V> {
        void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);
    }

}
