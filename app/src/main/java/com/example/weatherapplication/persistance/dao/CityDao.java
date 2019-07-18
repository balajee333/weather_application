package com.example.weatherapplication.persistance.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.weatherapplication.persistance.entity.City;

import java.util.List;

@Dao
public interface CityDao {

    @Query("select * from City")
    List<City> getAllCities();

    @Insert
    void insertCity(City city);

}
