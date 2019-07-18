package com.example.weatherapplication.dependecyinjection.application;

import android.app.Application;

import com.example.weatherapplication.AddCityActivity;
import com.example.weatherapplication.MainActivity;
import com.example.weatherapplication.WeatherActivity;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

   @ContributesAndroidInjector
    abstract WeatherActivity providesWeatherActivity();

    @ContributesAndroidInjector
    abstract AddCityActivity providesAddCityActivity();

}