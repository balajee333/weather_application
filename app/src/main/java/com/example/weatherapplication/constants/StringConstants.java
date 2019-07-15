package com.example.weatherapplication.constants;

import java.util.ArrayList;
import java.util.List;

public class StringConstants {


    public static final String CITY = "CITY";
    public static final String X_RapidAPI_Key = "X-RapidAPI-Key";
    public static final String RAPID_API_KEY = "d874d8ac73mshbe78b4c511a867dp1adf44jsn2c0cc9643d43";
    public static final String APP_PREF_NAME = "CITY";
    public static final int PREF_MODE_PRIVATE = 1;
    public static final String NA = "NA";//not available
    public static final String WEATHER_DAO = "WEATHER_DAO";

    private static List<String> cities = new ArrayList<>();

    public static List<String> getCities() {
        if(cities.isEmpty()) {
            cities.add("Chennai");
            cities.add("London,uk");
            cities.add("Coimbatore");
            cities.add("Madurai");
            cities.add("Salem");
        }
        return cities;
    }
}
