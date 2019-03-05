package com.demo.ui.splash;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;


import com.demo.R;
import com.demo.ui.base.BaseActivity;
import com.demo.ui.main.MainActivity;

import javax.inject.Inject;

import de.halfbit.rxandroid.permissions.RxPermissions;

public class SplashActivity extends BaseActivity implements SplashContract.View {

    private static final int REQ_PERMISSIONS = 101;

    @Inject
    public SplashContract.Presenter<SplashContract.View> mPresenter;

    private final RxPermissions.PermissionsRequester mPermissionsRequester = new RxPermissions.PermissionsRequester() {
        @Override
        public void performRequestPermissions(String[] permissions) {
            // forward request to the system by calling fragment's method
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissions, REQ_PERMISSIONS);
            }
        }
    };


    @Override
    protected int layoutResId() {
        return R.layout.splash;
    }

    @Override
    public void onProfile() {

    }

    @Override
    public void onNotification() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.splash_root).setBackgroundResource(R.drawable.splash_background);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        mPresenter.onStart();
    }

    @Override
    public RxPermissions.PermissionsRequester getPermissionRequest() {
        return mPermissionsRequester;
    }

    @Override
    public void showDashBoard() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mPresenter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
