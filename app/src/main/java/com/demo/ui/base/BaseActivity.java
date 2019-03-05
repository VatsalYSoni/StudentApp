package com.demo.ui.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.demo.R;
import com.demo.StudentApp;
import com.demo.di.component.ActivityComponent;
import com.demo.di.component.DaggerActivityComponent;
import com.demo.di.module.ActivityModule;
import com.demo.ui.dashboard.DashBoardFragment;
import com.demo.utils.NetworkUtils;


public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @LayoutRes
    protected abstract int layoutResId();

    private ActivityComponent mActivityComponent;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(((StudentApp) getApplication()).getComponent())
                .build();


        if (layoutResId() != 0) {
            setContentView(layoutResId());
        }
        drawer = this.findViewById(R.id.drawer_layout);

    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    public void showFragment(@IdRes int containId, BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().addToBackStack(fragment.name())
                .replace(containId, fragment, fragment.name()).commitAllowingStateLoss();
    }

    protected boolean isDisplayHomeUpEnabled() {
        return true;
    }

    protected boolean isDisplayShowTitleEnabled() {
        return false;
    }


    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onBack() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            this.finish();
        } else if (getSupportFragmentManager().findFragmentById(R.id.root_view) instanceof DashBoardFragment) {
            this.finish();
        }
//        else if (getSupportFragmentManager().findFragmentById(R.id.root_view) instanceof LoadDetailFragment) {
//            getSupportFragmentManager().popBackStackImmediate();
//            DashBoardFragment dashBoardFragment = new DashBoardFragment();
//            showFragment(R.id.root_view, dashBoardFragment);
//        }
        else {
            super.onBackPressed();
        }
    }

    public Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.root_view);
    }
}
