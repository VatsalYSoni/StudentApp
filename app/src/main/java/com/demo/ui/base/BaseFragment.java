package com.demo.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.demo.R;
import com.demo.di.component.ActivityComponent;
import com.demo.utils.NetworkUtils;

public abstract class BaseFragment extends Fragment implements BaseView {

    private BaseActivity mActivity;

    @LayoutRes
    protected abstract int layoutResId();

    protected abstract String name();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(layoutResId(), container, false);
    }

//    public Toolbar setToolBar(int type, BaseView mView) {
//        ToolBar toolbar = (ToolBar) mView.getActivity().findViewById(R.id.customToolbar);
//        toolbar.setToolBarType(type);
//        toolbar.setListener(mView);
//        return toolbar;
//    }

    public void showFragment(@IdRes int containId, BaseFragment fragment) {
        DrawerLayout drawerLayout = (DrawerLayout) mActivity.findViewById(R.id.drawer_layout);
        if (drawerLayout != null) {
            (drawerLayout).setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }

        getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(fragment.name())
                .replace(containId, fragment, fragment.name()).commitAllowingStateLoss();
    }

//    public abstract void onBack();
//
//    public abstract String getName();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
        }
    }

    public ActivityComponent getActivityComponent() {
        if (mActivity != null) {
            return mActivity.getActivityComponent();
        }
        return null;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getActivity());
    }

    @Override
    public void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public Fragment getCurrentFragment() {
        return getFragmentManager().findFragmentById(R.id.root_view);
    }
}
