package com.example.weatherapplication.persistance.database;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.weatherapplication.constants.StringConstants;
import com.example.weatherapplication.persistance.dao.CityDao;
import com.example.weatherapplication.persistance.entity.City;


@Database(entities = {City.class}, version = 1)
public abstract class WeatherDatabase extends RoomDatabase {



    private static WeatherDatabase weatherDatabase;


    public abstract CityDao getCityDao();

}
