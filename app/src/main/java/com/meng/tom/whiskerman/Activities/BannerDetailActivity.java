package com.meng.tom.whiskerman.Activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.meng.tom.whiskerman.HeWeatherUtils.HeWeatherUtil;
import com.meng.tom.whiskerman.R;

import java.util.List;

import interfaces.heweather.com.interfacesmodule.bean.weather.Weather;
import interfaces.heweather.com.interfacesmodule.view.HeWeather;

public class BannerDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_detail);
        initView();
    }

    private void initView() {
        ImageView ivBannerDetail = (ImageView) findViewById(R.id.iv_banner_detail);
        FloatingActionButton fabBannerDetail = (FloatingActionButton) findViewById(R.id.fab_banner_detail);
        NestedScrollView nsvBannerDetail = (NestedScrollView) findViewById(R.id.nsv_banner_detail);
        TextView tvBannerDetail = (TextView) findViewById(R.id.tv_banner_detail);
        Toolbar tbBannerDetail = (Toolbar) findViewById(R.id.tb_banner_detail);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        setSupportActionBar(tbBannerDetail);
        ActionBar sb = getSupportActionBar();
        if (sb != null) {
            sb.setDisplayHomeAsUpEnabled(true);
        }

        Glide.with(this).load("http://img5.imgtn.bdimg.com/it/u=3695012849,2187312718&fm=27&gp=0.jpg").into(ivBannerDetail);
        collapsingToolbar.setTitle("标题");

        HeWeather.getWeather(this, new HeWeather.OnResultWeatherDataListBeansListener() {
            @Override
            public void onError(Throwable e) {
                Log.i("Log" + this, "onError: ", e);
            }

            @Override
            public void onSuccess(List<Weather> list) {
                for (Weather w : list
                        ) {
                    Log.d("Log", "onSuccess: " + w.getBasic().getCid());
                }
            }
        });
    }
}
