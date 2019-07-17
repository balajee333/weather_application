package com.example.weatherapplication.dependecyinjection.component;

import com.example.weatherapplication.dependecyinjection.application.ActivityBuilderModule;
import com.example.weatherapplication.dependecyinjection.application.WeatherApplication;
import com.example.weatherapplication.dependecyinjection.module.WeatherModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {WeatherModule.class, AndroidSupportInjectionModule.class, ActivityBuilderModule.class})
public interface AppComponent extends AndroidInjector<WeatherApplication>  {


}