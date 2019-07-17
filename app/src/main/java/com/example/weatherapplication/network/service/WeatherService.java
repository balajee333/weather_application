package com.example.weatherapplication.network.service;

import com.example.weatherapplication.model.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("/weather")
    public Observable<WeatherResponse> getWeatherForCity(@Query("q") String city);
}
