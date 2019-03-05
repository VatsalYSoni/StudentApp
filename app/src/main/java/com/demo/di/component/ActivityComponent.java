package com.demo.di.component;


import com.demo.di.PreActivity;
import com.demo.di.module.ActivityModule;
import com.demo.ui.dashboard.DashBoardFragment;
import com.demo.ui.main.MainActivity;
import com.demo.ui.splash.SplashActivity;

import dagger.Component;

@PreActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity activity);

    void inject(MainActivity activity);

    void inject(DashBoardFragment dashBoardFragment);

}
