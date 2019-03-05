package com.demo.di.component;

import android.app.Application;
import android.content.Context;


import com.demo.StudentApp;
import com.demo.data.DataManager;
import com.demo.di.ApplicationContext;
import com.demo.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})

public interface AppComponent {

    void inject(StudentApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}