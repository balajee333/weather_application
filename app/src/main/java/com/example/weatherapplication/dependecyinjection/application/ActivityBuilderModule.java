package com.example.weatherapplication.dependecyinjection.application;

import com.example.weatherapplication.WeatherActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

   @ContributesAndroidInjector
    abstract WeatherActivity providesWeatherActivity();

}