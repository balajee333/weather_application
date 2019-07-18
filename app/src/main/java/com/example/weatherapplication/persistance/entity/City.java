package com.example.weatherapplication.persistance.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "city")
public class City {

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PrimaryKey(autoGenerate = true)
    private int cityId;

    @ColumnInfo(name = "name")
    private String name;

    public City(int cityId, String name) {
        this.cityId = cityId;
        this.name = name;
    }

    @Ignore
    public City(String name) {
        this.name = name;
    }
}
