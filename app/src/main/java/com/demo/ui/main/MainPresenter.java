package com.demo.ui.main;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;


import com.demo.R;
import com.demo.data.DataManager;
import com.demo.ui.base.BasePresenterClass;
import com.demo.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;



public class MainPresenter<V extends MainContract.View> extends BasePresenterClass<V> implements MainContract.Presenter<V> {

    private DrawerLayout drawer;

    @Inject
    public MainPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    public void loadMain() {
        getMvpView().onMainLoaded();
    }

    @Override
    public void setNavigationDrawer(Activity activity) {
        drawer = activity.findViewById(R.id.drawer_layout);
    }

    @Override
    public void openDrawer() {
        if (!drawer.isDrawerOpen(android.view.Gravity.LEFT)) {
            drawer.openDrawer(android.view.Gravity.LEFT);
        } else {
            drawer.closeDrawer(android.view.Gravity.LEFT);
        }
    }

    @Override
    public void closeDrawer() {
        if (drawer.isDrawerOpen(android.view.Gravity.LEFT)) {
            drawer.closeDrawer(android.view.Gravity.LEFT);
        } else {
//            drawer.openDrawer(android.view.Gravity.LEFT);
        }
    }

    @Override
    public void LogOut() {
        setUserAsLoggedOut();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroyView() {
    }
}