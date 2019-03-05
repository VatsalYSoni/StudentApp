package com.demo.ui.splash;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;


import com.demo.data.DataManager;
import com.demo.ui.base.BasePresenterClass;
import com.demo.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import de.halfbit.rxandroid.permissions.RxPermissions;
import io.reactivex.disposables.CompositeDisposable;
import rx.Subscription;

public class SplashPresenter<V extends SplashContract.View> extends BasePresenterClass<V> implements SplashContract.Presenter<V> {


    private Subscription permissions;

    @Inject
    public AppCompatActivity activity;

    @Inject
    public SplashPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onStart() {
        checkPermission();
    }

    @Override
    public void onDestroyView() {
        if (permissions != null) {
            permissions.unsubscribe();
            permissions = null;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        checkPermission();
    }

    private void checkPermission() {
        int readExternal = ContextCompat.checkSelfPermission(getMvpView().getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE);
        int writeExternal = ContextCompat.checkSelfPermission(getMvpView().getActivity(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (readExternal == PackageManager.PERMISSION_GRANTED &&
                writeExternal == PackageManager.PERMISSION_GRANTED) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                        getMvpView().showDashBoard();
//                    }
                }
            }, 1000);
        } else {
            showPermissionDialog();
        }
    }

    private void showPermissionDialog() {

        permissions = RxPermissions.get(getMvpView().getActivity())
                .request(getMvpView().getPermissionRequest(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET)
                .subscribe(granted -> {
                    if (granted) {
                            getMvpView().showDashBoard();
                    } else {
                        getMvpView().showMessage("user denied request");
                    }
                });
    }

}
