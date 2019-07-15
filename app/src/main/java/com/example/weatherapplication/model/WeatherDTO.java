package com.example.weatherapplication.model;

import com.example.weatherapplication.utils.StringUtils;


public class WeatherDTO {

    private String city;


    private Double temperature;

    private String weatherDesc;

    private static final String TAG = "WeatherDTO";

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    private String imgURL;

    public WeatherDTO() {
        this.city = "Loading data....";
        this.weatherDesc = "Loading data....";
        this.temperature = new Double(0);
        this.imgURL = null;
    }

    WeatherDTO(Builder builder) {
        this.city = builder.getCity();
        this.temperature = builder.getTemperature();
        this.weatherDesc = builder.getWeatherDesc();
        this.imgURL = builder.getImgURL();
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public static class Builder {

        private String city;

        private Double temperature;

        private String weatherDesc;

        private String imgURL;

        public Builder() {

        }

        public String getImgURL() {
            return imgURL;
        }

        public Builder setImgURL(String imgURL) {
            this.imgURL = String.format("http://openweathermap.org/img/w/%s.png",imgURL);
            return this;
        }

        public String getCity() {
            return city;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Double getTemperature() {
            return temperature;
        }

        public Builder setTemperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public String getWeatherDesc() {
            return weatherDesc;
        }

        public Builder setWeatherDesc(String weatherDesc) {

            this.weatherDesc = StringUtils.capitalize(weatherDesc);
            return this;
        }

        public WeatherDTO create() {
            return new WeatherDTO(this);
        }

    }
}
