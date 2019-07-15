package com.example.weatherapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherInfoResponse {

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("cod")
    public Integer cod;

    @SerializedName("dt")
    public String dt;

    @SerializedName("base")
    public String base;

    @SerializedName("coord")
    public Coord coord;

    public class Coord {

        @SerializedName("lon")
        public Double lon;

        @SerializedName("lat")
        public Double lat;
    }

    @SerializedName("sys")
    public Sys sys;

    public class Sys {

        @SerializedName("message")
        public Double message;

        @SerializedName("country")
        public String country;

        @SerializedName("sunrise")
        public Long sunrise;

        @SerializedName("sunset")
        public Long sunset;

    }

    @SerializedName("weather")
    public List<Weather> weatherList;

    public class Weather {

        @SerializedName("id")
        public Integer id;

        @SerializedName("main")
        public String main;

        @SerializedName("description")
        public String description;

        @SerializedName("icon")
        public String icon;
    }

    @SerializedName("main")
    public Main main;

    public class Main {

        @SerializedName("temp")
        public Double temp;

        @SerializedName("humidity")
        public Integer humidity;

        @SerializedName("pressure")
        public Integer pressure;

        @SerializedName("temp_min")
        public Double temp_min;

        @SerializedName("temp_max")
        public Double temp_max;

    }

    @SerializedName("wind")
    public Wind wind;

    public class Wind {

        @SerializedName("speed")
        public Double speed;

        @SerializedName("gust")
        public Double gust;

        @SerializedName("deg")
        public Integer deg;
    }

    @SerializedName("rain")
    public Rain rain;

    public class Rain {

        @SerializedName("1h")
        public Double h1;
    }

    @SerializedName("clouds")
    public Clouds clouds;

    public class Clouds {

        @SerializedName("all")
        public Integer all;
    }


}
