package com.example.weatherapplication.utils;

public class WeatherUtil {

    private static final Double K_TO_C = 273.15;

    public static Double getTemperatureInCelcius(Double tempInKelvin) {
        return tempInKelvin - K_TO_C;
    }
}
