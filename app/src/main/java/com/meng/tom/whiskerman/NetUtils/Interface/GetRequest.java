package com.meng.tom.whiskerman.NetUtils.Interface;

import com.meng.tom.whiskerman.Moudels.RetrofitMoudel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetRequest {
    @GET("")
    Call<RetrofitMoudel> getData();
}