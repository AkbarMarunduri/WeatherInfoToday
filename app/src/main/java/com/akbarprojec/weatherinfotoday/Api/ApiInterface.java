package com.akbarprojec.weatherinfotoday.Api;

import com.akbarprojec.weatherinfotoday.Model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather")
    Call<Response> getWeatherInfo(@Query("q") String kota, @Query("appid") String key);


}
