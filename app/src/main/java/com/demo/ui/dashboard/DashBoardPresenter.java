package com.demo.ui.dashboard;


import android.support.v4.widget.DrawerLayout;


import com.demo.R;
import com.demo.data.DataManager;
import com.demo.ui.base.BasePresenterClass;
import com.demo.ui.view.ToolBar;
import com.demo.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class DashBoardPresenter<V extends DashBoardContract.DView> extends BasePresenterClass<V> implements DashBoardContract.Presenter<V> {

    private ToolBar toolBar;
    private DrawerLayout drawer;

    @Inject
    public DashBoardPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void setToolbar() {
        toolBar = getMvpView().getActivity().findViewById(R.id.customToolbar);
        toolBar.setTitle("Dashboard");
        toolBar.setToolBarType(ToolBar.DASHBOARD);
        toolBar.setListener(getMvpView());
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
            drawer.openDrawer(android.view.Gravity.LEFT);
        }
    }

}
