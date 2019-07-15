package com.example.weatherapplication.service;

import com.example.weatherapplication.model.WeatherInfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {




    @GET("/weather")
    public Call<WeatherInfoResponse> getWeatherForCity(@Query("q") String city);
}
