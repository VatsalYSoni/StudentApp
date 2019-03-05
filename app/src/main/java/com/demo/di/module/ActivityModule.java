package com.demo.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;


import com.demo.di.ActivityContext;
import com.demo.di.PreActivity;
import com.demo.di.PreContext;
import com.demo.ui.dashboard.DashBoardContract;
import com.demo.ui.dashboard.DashBoardPresenter;
import com.demo.ui.main.MainContract;
import com.demo.ui.main.MainPresenter;
import com.demo.ui.splash.SplashContract;
import com.demo.ui.splash.SplashPresenter;
import com.demo.utils.rx.AppSchedulerProvider;
import com.demo.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @PreContext
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    @PreActivity
    public SplashContract.Presenter<SplashContract.View> provideSplashContractPresenter(SplashPresenter<SplashContract.View> presenter) {
        return presenter;
    }

    @Provides
    @PreActivity
    public MainContract.Presenter<MainContract.View> provideMainContractPresenter(MainPresenter<MainContract.View> mainPresenter) {
        return mainPresenter;
    }

    @Provides
    @PreActivity
    public DashBoardContract.Presenter<DashBoardContract.DView> provideDashBoardContractPresenter(DashBoardPresenter<DashBoardContract.DView> presenter) {
        return presenter;
    }

}
