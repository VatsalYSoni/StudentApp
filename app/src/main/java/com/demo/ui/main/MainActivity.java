package com.demo.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demo.R;
import com.demo.ui.base.BaseActivity;
import com.demo.ui.dashboard.DashBoardFragment;
import com.demo.ui.splash.SplashActivity;
import com.demo.utils.AppConstants;

import java.util.ArrayList;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    public MainContract.Presenter<MainContract.View> mainPresenter;
    private DrawerLayout drawer;

    @Override
    protected int layoutResId() {
        return R.layout.main_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        mainPresenter.onAttach(MainActivity.this);
        mainPresenter.loadMain();
        setUpDrawer();
        drawer = findViewById(R.id.drawer_layout);
    }

    @Override
    public void onMainLoaded() {
        setDrawerLayout();
        showDashboardFragment();
        mainPresenter.setNavigationDrawer(this);
    }

    @Override
    public void onItemSelect(String fName) {
        ((DrawerLayout) findViewById(R.id.drawer_layout)).setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        changeFragment(fName);
    }

    private void setDrawerLayout() {
        findViewById(R.id.action_menu).setOnClickListener(view -> mainPresenter.openDrawer());
    }

    public void showDashboardFragment() {
        DashBoardFragment dashBoardFragment = new DashBoardFragment();
        showFragment(R.id.root_view, dashBoardFragment);
    }

    public void changeFragment(String fName) {
        findViewById(R.id.root_view).setBackgroundResource(0);
        findViewById(R.id.customToolbar).setVisibility(android.view.View.VISIBLE);
        switch (fName) {
            case AppConstants.DASHBOARD:
                ((DrawerLayout) findViewById(R.id.drawer_layout)).setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                if (!(getCurrentFragment() instanceof DashBoardFragment)) {
                    showFragment(R.id.root_view, new DashBoardFragment());
                }
                mainPresenter.closeDrawer();
                break;
//            case AppConstants.START_NEW_LOAD:
////                showFragment(R.id.root_view, new StartNewLoadFragment());
//                getSupportFragmentManager().beginTransaction().addToBackStack(String.valueOf(getCurrentFragment()))
//                        .add(R.id.root_view, new StartNewLoadFragment(), "DrawerStartNewLoad").commit();
//                mainPresenter.closeDrawer();
//                break;
//            case AppConstants.LOAD_HISTORY:
//                showFragment(R.id.root_view, new LoadHistoryFragment());
//                mainPresenter.closeDrawer();
//                break;
//            case AppConstants.MY_MESSAGES:
//                showFragment(R.id.root_view, new ChatLoadListFragment());
//                mainPresenter.closeDrawer();
////                break;
//            case AppConstants.MY_PROFILE:
////                showFragment(R.id.root_view, new ProfileFragment());
//                mainPresenter.closeDrawer();
//                break;
//            case AppConstants.UPLOAD_DOCUMENT:
//                showFragment(R.id.root_view, new UploadDocumentFragment());
//                mainPresenter.closeDrawer();
//                break;

            case AppConstants.ABOUT_INSTITUTE:
                break;

            case AppConstants.CONTACT:
                break;

            case AppConstants.RETURNABLE:
                break;


            case AppConstants.ASSIGNMENT:
                break;

            case AppConstants.NOTICE:
                break;

            case AppConstants.NOTIFICATION:
                break;

            case AppConstants.LOGOUT:
                startActivity(new android.content.Intent(this, SplashActivity.class));
                mainPresenter.LogOut();
                finish();
                break;
        }
    }

    public void setUpDrawer() {
        ArrayList<String> drawerList = new ArrayList<>();
        drawerList.add("About Institute");
        drawerList.add("Contact");
        drawerList.add("Returnable");
        drawerList.add("Issue");
        drawerList.add("Result");
        drawerList.add("Assignments");
        drawerList.add("Notice");
        drawerList.add("Notification");
        drawerList.add("Logout");

        ArrayList<Integer> drawerIconList = new ArrayList<Integer>();
        drawerIconList.add(R.mipmap.dashboard);
        drawerIconList.add(R.mipmap.start_new_load);
        drawerIconList.add(R.mipmap.load_history_1);
        drawerIconList.add(R.mipmap.my_messages);
        drawerIconList.add(R.mipmap.my_profile);
        drawerIconList.add(R.drawable.ic_document);
        drawerIconList.add(R.drawable.ic_document);
        drawerIconList.add(R.drawable.ic_document);
        drawerIconList.add(R.mipmap.logout);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvDrawer);
        DrawerAdapter drawerAdapter = new DrawerAdapter(drawerList, drawerIconList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(drawerAdapter);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void onProfile() {

    }

    @Override
    public void onNotification() {

    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(android.view.Gravity.LEFT)) {
            drawer.closeDrawer(android.view.Gravity.LEFT);
        } else {
            super.onBackPressed();
        }

    }
}
