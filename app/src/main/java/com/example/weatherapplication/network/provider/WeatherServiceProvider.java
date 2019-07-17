package com.example.weatherapplication.network.provider;


import android.util.Log;

import com.example.weatherapplication.model.WeatherResponse;
import com.example.weatherapplication.network.service.WeatherService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeatherServiceProvider {

    private static final String TAG = "WeatherServiceProvider";

    @Inject
    WeatherService weatherService;

    @Inject
    WeatherServiceProvider() {

    }

    public Observable<WeatherResponse> getWeatherForCity(String city) {
        return weatherService.getWeatherForCity(city).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
