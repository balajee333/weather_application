package com.example.weatherapplication.network;

import com.example.weatherapplication.constants.StringConstants;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkFactory {

    private static Retrofit retrofitClient = null;

    private static final String BASE_URL = "https://community-open-weather-map.p.rapidapi.com";


    static Interceptor headerInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Headers headers = request.headers().newBuilder().
                    add(StringConstants.X_RapidAPI_Key,StringConstants.RAPID_API_KEY).build();
            request = request.newBuilder().headers(headers).build();
            return chain.proceed(request);
        }
    };


    public static Retrofit getWeatherAPIClient() {
        if(retrofitClient == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().
                    addInterceptor(httpLoggingInterceptor).
                    addInterceptor(headerInterceptor).build();
            retrofitClient = new Retrofit.Builder().
                    client(client).
                    addConverterFactory(GsonConverterFactory.create()).
                    baseUrl(BASE_URL).build();
        }
        return retrofitClient;
    }
}
