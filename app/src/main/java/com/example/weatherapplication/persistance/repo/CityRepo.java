package com.example.weatherapplication.persistance.repo;

import com.example.weatherapplication.persistance.dao.CityDao;
import com.example.weatherapplication.persistance.entity.City;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;

public class CityRepo {


    @Inject
    CityDao cityDao;

    @Inject
    CityRepo(){

    }

    public List<City> getAllCities() throws ExecutionException,InterruptedException {
        Callable<List<City>> callable = new Callable<List<City>>() {
            @Override
            public List<City> call() throws Exception {
                return cityDao.getAllCities();
            }
        };
        Future<List<City>> future = Executors.newSingleThreadExecutor().submit(callable);
        return future.get();
    }


    public Long addCity(final City city) throws ExecutionException,InterruptedException {

        Long cityId = Long.valueOf(0);

        Callable<Long> insertCallable = new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return cityDao.insertCity(city);
            }
        };

        Future<Long> future = Executors.newSingleThreadExecutor().submit(insertCallable);
        return future.get();

    }


}
