package com.demo.ui.main;

import android.app.Activity;

import com.demo.ui.base.BasePresenter;
import com.demo.ui.base.BaseView;


public interface MainContract {

    public interface View extends BaseView {
        void onMainLoaded();

        void onItemSelect(String fName);
    }

    public interface Presenter<V extends View> extends BasePresenter<V> {
        void loadMain();

        //OnNavigationItemSelectedListener mListener removed
        void setNavigationDrawer(Activity activity);

        void openDrawer();

        void closeDrawer();

        void LogOut();

    }
}
