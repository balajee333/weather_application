package com.example.weatherapplication.viewmodel;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.weatherapplication.BR;
import com.example.weatherapplication.constants.StringConstants;
import com.example.weatherapplication.model.WeatherDTO;
import com.example.weatherapplication.model.WeatherResponse;
import com.example.weatherapplication.network.provider.WeatherServiceProvider;
import com.example.weatherapplication.persistance.database.WeatherDatabase;
import com.example.weatherapplication.persistance.entity.City;
import com.example.weatherapplication.persistance.repo.CityRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class WeatherViewModel extends BaseObservable implements LifecycleObserver {

    private static final String TAG = "WeatherViewModel";

    private WeatherDTO weatherDTO;
    private List<String> cityList = new ArrayList<>();
    private ObservableField<WeatherDTO> weatherData = new ObservableField<WeatherDTO>();

    @Inject
    WeatherServiceProvider weatherServiceProvider;

    @Inject
    CityRepo cityRepo;

    @Inject
    public WeatherViewModel() {
        weatherData.set(new WeatherDTO());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        loadCities();
        updateWeatherData(0);
    }

    private void loadCities() {
        try {
            List<City> cities = cityRepo.getAllCities();
            for(City city : cities) {
                this.cityList.add(city.getName());
            }
        } catch (ExecutionException|InterruptedException e) {
            Log.i(TAG, "loadCities: Error"+e.getLocalizedMessage());
        }
        Log.i(TAG, "loadCities: size = "+this.cityList.size());
    }

    public String getCity(){
        return this.weatherData.get().getCity();
    }

    public String getTemperature(){
        return weatherData.get().getTemperature();
    }

    public String getWeatherDesc(){
        return this.weatherData.get().getWeatherDesc();
    }

    public String getImageURL() {
        return this.weatherData.get().getImgURL();
    }
    

    public void updateWeatherData(int position) {

        weatherServiceProvider.getWeatherForCity(this.cityList.get(position)).subscribe(new Consumer<WeatherResponse>() {

            @Override
            public void accept(WeatherResponse weatherResponse) throws Exception {
                weatherDTO = new WeatherDTO.Builder().buildWithWeatherResponse(weatherResponse).create();
                weatherData.set(weatherDTO);
                notifyPropertyChanged(BR._all);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.i(TAG, "Error loading data ");
            }
        });
    }

    
}
