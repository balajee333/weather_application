package com.example.weatherapplication.viewmodel;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.weatherapplication.BR;
import com.example.weatherapplication.adapter.WeatherViewPagerAdapter;
import com.example.weatherapplication.constants.StringConstants;
import com.example.weatherapplication.model.WeatherDTO;
import com.example.weatherapplication.model.WeatherInfoResponse;
import com.example.weatherapplication.network.NetworkFactory;
import com.example.weatherapplication.service.WeatherService;
import com.example.weatherapplication.utils.WeatherUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends BaseObservable implements LifecycleObserver {

    private static final String TAG = "WeatherViewModel";

    private WeatherDTO weatherDTO;
    private WeatherService weatherService;
    private List<String> cityList;
    private ObservableField<WeatherDTO> weatherDTOOb = new ObservableField<WeatherDTO>();

    public WeatherViewModel() {
        weatherDTOOb.set(new WeatherDTO());
        this.cityList = StringConstants.getCities();
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        updateWeatherData(0);
    }

    public String getCity(){
        return this.weatherDTOOb.get().getCity();
    }

    public String getTemperature(){
        return String.format("%s%sC", String.valueOf(weatherDTOOb.get().getTemperature().intValue()), (char) 0x00B0);
    }

    public String getWeatherDesc(){
        return this.weatherDTOOb.get().getWeatherDesc();
    }

    public String getImageURL() {
        return this.weatherDTOOb.get().getImgURL();
    }
    
    public void updateWeatherData(int position) {

        weatherService = NetworkFactory.getWeatherAPIClient().create(WeatherService.class);
        Call<WeatherInfoResponse> weatherInfoCall = weatherService.getWeatherForCity(this.cityList.get(position));
        weatherInfoCall.enqueue(new Callback<WeatherInfoResponse>() {
            @Override
            public void onResponse(Call<WeatherInfoResponse> call, Response<WeatherInfoResponse> response) {
                WeatherInfoResponse weatherInfoResponse = response.body();
                weatherDTO = new WeatherDTO.Builder().setWeatherDesc(weatherInfoResponse.weatherList.get(0).description).
                        setCity(weatherInfoResponse.name).
                        setTemperature(WeatherUtil.getTemperatureInCelcius(
                                weatherInfoResponse.main.temp
                        )).
                        setImgURL(weatherInfoResponse.weatherList.get(0).icon).create();
                weatherDTOOb.set(weatherDTO);
                notifyPropertyChanged(BR._all);
            }

            @Override
            public void onFailure(Call<WeatherInfoResponse> call, Throwable t) {

            }
        });
    }
}
