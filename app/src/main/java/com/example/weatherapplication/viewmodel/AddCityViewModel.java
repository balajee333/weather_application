package com.example.weatherapplication.viewmodel;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.weatherapplication.persistance.dao.CityDao;
import com.example.weatherapplication.persistance.entity.City;
import com.example.weatherapplication.persistance.repo.CityRepo;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

public class AddCityViewModel extends BaseObservable {


    private String cityName;

    private static final String TAG = "AddCityViewModel";
    
    @Inject
    public AddCityViewModel() {
    }

    @Inject
    CityRepo cityRepo;

    @Bindable
    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void addCity() {
        Log.i(TAG, "addCity: "+this.cityName);
        //adding city
        /*City newCity = new City(this.cityName);
        try {
            Long cityId = cityRepo.addCity(newCity);
            Log.i(TAG, "addCity: added"+cityId);
        } catch (ExecutionException | InterruptedException e) {
            Log.i(TAG, "addCity: "+e.getLocalizedMessage());
        }*/


        List<City> cities = null;
        try {
            cities = cityRepo.getAllCities();
            Log.i(TAG, "addCity: "+cities);
            for(City city : cities)
                Log.i(TAG, "City name = "+ city.getName());
        } catch (ExecutionException | InterruptedException e) {
            Log.i(TAG, "addCity: "+e.getLocalizedMessage());
        }



    }
}
