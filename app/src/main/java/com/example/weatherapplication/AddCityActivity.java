package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.weatherapplication.databinding.ActivityAddCityBinding;
import com.example.weatherapplication.databinding.ActivityWeatherBinding;
import com.example.weatherapplication.viewmodel.AddCityViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class AddCityActivity extends AppCompatActivity {

    @Inject
    AddCityViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        ActivityAddCityBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_add_city);
        binding.setVm(vm);
    }
}
