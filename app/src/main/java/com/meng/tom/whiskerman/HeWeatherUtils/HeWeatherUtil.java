package com.meng.tom.whiskerman.HeWeatherUtils;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import interfaces.heweather.com.interfacesmodule.bean.Lang;
import interfaces.heweather.com.interfacesmodule.bean.Unit;
import interfaces.heweather.com.interfacesmodule.bean.basic.Basic;
import interfaces.heweather.com.interfacesmodule.bean.weather.Weather;
import interfaces.heweather.com.interfacesmodule.view.HeWeather;

public class HeWeatherUtil {
    public static HeWeatherUtil instance;

    public static HeWeatherUtil getInstance() {
        if (instance == null) {
            instance = new HeWeatherUtil();
        }
        return instance;
    }

    public String showWether(Context context) {
        final String[] response = new String[1];

        HeWeather.getWeather(context, new HeWeather.OnResultWeatherDataListBeansListener() {
            @Override
            public void onError(Throwable e) {
                Log.i("Log", "onError: ",e);
            }

            @Override
            public void onSuccess(List<Weather> list) {
                for (Weather w:list
                     ) {
                    Log.d("Log", "onSuccess: "+w.getBasic().getCid());
                }
            }
        });
        /**
         * 实况天气
         * 实况天气即为当前时间点的天气状况以及温湿风压等气象指数，具体包含的数据：体感温度、
         * 实测温度、天气状况、风力、风速、风向、相对湿度、大气压强、降水量、能见度等。
         *
         * @param context  上下文
         * @param location 地址详解
         * @param lang       多语言，默认为简体中文
         * @param unit        单位选择，公制（m）或英制（i），默认为公制单位
         * @param listener  网络访问回调接口
         */
        HeWeather.getWeatherNow(context, null, Lang.CHINESE_SIMPLIFIED, Unit.METRIC,
                new HeWeather.OnResultWeatherNowBeanListener() {
                    @Override
                    public void onError(Throwable e) {
                        Log.i("Log", "onError: ",e);
                    }

                    @Override
                    public void onSuccess(List dataObject) {
                        Log.i("Log", "onSuccess: " + new Gson().toJson(dataObject));
                        response[0] = new Gson().toJson(dataObject);
                    }
                });
        if (response.length > 0) {
            return response[0];
        } else {
            return "";
        }
    }
}