package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.weatherapplication.adapter.WeatherViewPagerAdapter;
import com.example.weatherapplication.constants.StringConstants;
import com.example.weatherapplication.databinding.ActivityWeatherBinding;
import com.example.weatherapplication.viewmodel.WeatherViewModel;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeatherViewModel vm = new WeatherViewModel();
        WeatherViewPagerAdapter adapter = new WeatherViewPagerAdapter(vm);
        ActivityWeatherBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_weather);
        binding.setVm(vm);
        binding.weatherViewPager.setAdapter(adapter);
        this.getLifecycle().addObserver(vm);
    }
}
