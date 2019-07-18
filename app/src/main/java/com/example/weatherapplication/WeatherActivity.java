package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.example.weatherapplication.adapter.WeatherViewPagerAdapter;
import com.example.weatherapplication.constants.StringConstants;
import com.example.weatherapplication.databinding.ActivityWeatherBinding;
import com.example.weatherapplication.dependecyinjection.application.WeatherApplication;
import com.example.weatherapplication.persistance.database.WeatherDatabase;
import com.example.weatherapplication.viewmodel.WeatherViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class WeatherActivity extends AppCompatActivity {


    private static final String TAG = "WeatherActivity";

    @Inject
    WeatherViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        WeatherViewPagerAdapter adapter = new WeatherViewPagerAdapter(vm);
        ActivityWeatherBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_weather);
        binding.setVm(vm);
        binding.weatherViewPager.setAdapter(adapter);
        this.getLifecycle().addObserver(vm);

    }
}
