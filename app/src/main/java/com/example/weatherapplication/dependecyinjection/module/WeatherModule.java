package com.example.weatherapplication.dependecyinjection.module;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.example.weatherapplication.constants.StringConstants;
import com.example.weatherapplication.dependecyinjection.application.WeatherApplication;
import com.example.weatherapplication.network.service.WeatherService;
import com.example.weatherapplication.persistance.dao.CityDao;
import com.example.weatherapplication.persistance.database.WeatherDatabase;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class WeatherModule {

    private Application application;

    public WeatherModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

    @Singleton
    @Provides
    WeatherService provideWeatherService(Retrofit retrofit) {
        return retrofit.create(WeatherService.class);
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client,GsonConverterFactory gsonConverterFactory,RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {

        Retrofit retrofitClient = new Retrofit.Builder().
                client(client).
                addConverterFactory(gsonConverterFactory).
                addCallAdapterFactory(rxJava2CallAdapterFactory).
                baseUrl(StringConstants.BASE_URL).build();

        return retrofitClient;
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(Interceptor headerInterceptor,HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient client = new OkHttpClient.Builder().
                addInterceptor(httpLoggingInterceptor).
                addInterceptor(headerInterceptor).build();
        return client;
    }

    @Singleton
    @Provides
    Interceptor provideHeaderInterceptor() {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Headers headers = request.headers().newBuilder().
                        add(StringConstants.X_RapidAPI_Key,StringConstants.RAPID_API_KEY).build();
                request = request.newBuilder().headers(headers).build();
                return chain.proceed(request);
            }
        };
        return headerInterceptor;

    }

    @Singleton
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }


    @Provides
    @Singleton
    WeatherDatabase provideWeatherDatabase(Application application) {
        return Room.databaseBuilder(application.getApplicationContext(),WeatherDatabase.class, StringConstants.DB_NAME).build();
    }

    @Provides
    @Singleton
    CityDao provideDao(WeatherDatabase weatherDatabase) {
        return weatherDatabase.getCityDao();
    }

}
