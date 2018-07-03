package com.meng.tom.whiskerman.NetUtils.Utils;

import com.meng.tom.whiskerman.NetUtils.Interface.GetRequest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2Util {
    static Retrofit2Util instace;
    public static Retrofit2Util getInstance(){
        if (instace==null){
            instace=new Retrofit2Util();
        }
        return instace;
    }
    // 在创建Retrofit实例时通过.baseUrl()设置
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("") //设置网络请求的Url地址
            .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
            .build();
    GetRequest service = retrofit.create(GetRequest.class);
}