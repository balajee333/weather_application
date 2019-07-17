package com.example.weatherapplication.model;

import com.example.weatherapplication.constants.StringConstants;
import com.example.weatherapplication.utils.StringUtils;
import com.example.weatherapplication.utils.WeatherUtil;


public class WeatherDTO {

    private String city;


    private String temperature;

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
        this.temperature = "Loading data....";
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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
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

        private String temperature;

        private String weatherDesc;

        private String imgURL;

        public Builder() {

        }

        public String getImgURL() {
            return imgURL;
        }

        public Builder setImgURL(String imgURL) {
            this.imgURL = String.format(StringConstants.IMAGE_API_URL,imgURL);
            return this;
        }

        public String getCity() {
            return city;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public String getTemperature() {
            return temperature;
        }

        public Builder setTemperature(Double temperature) {
            this.temperature = String.format("%s%sC", String.valueOf(temperature.intValue()), (char) 0x00B0);
            return this;
        }

        public String getWeatherDesc() {
            return weatherDesc;
        }

        public Builder setWeatherDesc(String weatherDesc) {

            this.weatherDesc = StringUtils.capitalizeWords(weatherDesc);
            return this;
        }

        public WeatherDTO create() {
            return new WeatherDTO(this);
        }

        public Builder buildWithWeatherResponse(WeatherResponse weatherResponse) {
            this.setWeatherDesc(weatherResponse.weatherList.get(0).description).
                    setCity(weatherResponse.name).
                    setTemperature(WeatherUtil.getTemperatureInCelcius(
                            weatherResponse.main.temp
                    )).
                    setImgURL(weatherResponse.weatherList.get(0).icon);
            return this;

        }

    }
}
