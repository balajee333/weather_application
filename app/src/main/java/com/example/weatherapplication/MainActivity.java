package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.weatherapplication.persistance.database.WeatherDatabase;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openWeatherActivity(View view) {

        Intent weatherIntent = new Intent(this,WeatherActivity.class);
        startActivity(weatherIntent);
    }

    public void openAddCityActivity(View view) {

        Intent addCityIntent = new Intent(this, AddCityActivity.class);
        startActivity(addCityIntent);
    }
}
