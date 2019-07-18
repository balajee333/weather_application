package com.example.weatherapplication.viewmodel;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.weatherapplication.persistance.dao.CityDao;
import com.example.weatherapplication.persistance.entity.City;

import java.util.List;

import javax.inject.Inject;

public class AddCityViewModel extends BaseObservable {


    private String cityName;

    private static final String TAG = "AddCityViewModel";
    
    @Inject
    public AddCityViewModel() {
    }

    @Inject
    CityDao cityDao;

    @Bindable
    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        Log.i(TAG, "setCityName: ");
        this.cityName = cityName;
    }

    public void addCity() {
        Log.i(TAG, "addCity: "+this.cityName);
        //adding city
        City newCity = new City(this.cityName);
        cityDao.insertCity(newCity);
        Log.i(TAG, "addCity: added");
        List<City> cities = cityDao.getAllCities();
        for(City city : cities)
            Log.i(TAG, "City name = "+ city.getName());
    }
}
