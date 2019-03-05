package com.demo;

import android.app.Application;

import com.demo.data.DataManager;
import com.demo.di.component.AppComponent;
import com.demo.di.component.DaggerAppComponent;
import com.demo.di.module.AppModule;

import javax.inject.Inject;



public class StudentApp extends Application {

    @Inject
    DataManager mDataManager;

    private AppComponent mAppComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)).build();

        mAppComponent.inject(this);


    }

    public AppComponent getComponent() {
        return mAppComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(AppComponent applicationComponent) {
        mAppComponent = applicationComponent;
    }

}