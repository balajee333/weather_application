package com.example.weatherapplication.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.example.weatherapplication.constants.StringConstants;
import com.example.weatherapplication.databinding.WeatherInfoItemBinding;
import com.example.weatherapplication.viewmodel.WeatherViewModel;

import java.util.List;

public class WeatherViewPagerAdapter extends PagerAdapter {


    private List<String> cityList = StringConstants.getCities();
    private WeatherViewModel weatherViewModel;

    private static final String TAG = "WeatherViewPagerAdapter";

    public WeatherViewPagerAdapter(WeatherViewModel weatherViewModel) {
        this.weatherViewModel = weatherViewModel;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        WeatherInfoItemBinding binding = WeatherInfoItemBinding.inflate(inflater,container,true);
        binding.setVm(weatherViewModel);
        return binding;
    }

    @Override
    public int getCount() {
        return cityList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (((WeatherInfoItemBinding)object).getRoot() == view);
    }


   @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        WeatherInfoItemBinding binding = ((WeatherInfoItemBinding)object);
        binding.setVm(null);
        container.removeView(binding.getRoot());
    }
}
