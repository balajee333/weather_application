package com.example.weatherapplication.dependecyinjection.application;

import android.app.Activity;
import android.app.Application;

import com.example.weatherapplication.dependecyinjection.component.AppComponent;
import com.example.weatherapplication.dependecyinjection.component.DaggerAppComponent;
import com.example.weatherapplication.dependecyinjection.module.WeatherModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class WeatherApplication extends Application implements HasActivityInjector {

    @Inject
    public WeatherApplication() {

    }

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppComponent appComponent = DaggerAppComponent.builder().weatherModule(new WeatherModule(this)).build();
        appComponent.inject(this);
    }
}
