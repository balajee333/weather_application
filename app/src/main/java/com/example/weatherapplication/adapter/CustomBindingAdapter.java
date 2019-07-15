package com.example.weatherapplication.adapter;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.weatherapplication.listener.ViewPagerSwipeListener;

public class CustomBindingAdapter {

    private static final String TAG = "CustomBindingAdapter";

    @BindingAdapter("onViewSwipe")
    public static void setOnViewSwipe(final ViewPager viewPager, final ViewPagerSwipeListener swipeListener) {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                swipeListener.onSwipe(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @BindingAdapter("loadImage")
    public static void loadImage(ImageView imageView, String url) {
        if(url != null)
            Glide.with(imageView).load(url).apply(new RequestOptions().circleCrop()).into(imageView);
    }
}