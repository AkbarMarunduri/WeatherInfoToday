package com.akbarprojec.weatherinfotoday.Presenter;

import com.akbarprojec.weatherinfotoday.Api.ApiClient;
import com.akbarprojec.weatherinfotoday.Api.ApiInterface;
import com.akbarprojec.weatherinfotoday.Model.Response;
import com.akbarprojec.weatherinfotoday.ViewInterface.WeaterInterface;

import retrofit2.Call;
import retrofit2.Callback;

public class WeatherPresenter {
    WeaterInterface weaterInterface;

    public WeatherPresenter(WeaterInterface weaterInterface) {
        this.weaterInterface = weaterInterface;
    }

    public void weaterData(String kota) {
        ApiInterface mApiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<Response> weathet = mApiInterface.getWeatherInfo(kota, "ea9f7700fe834f4e863947b628a43f6c");
        weathet.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.body() == null) {
                    weaterInterface.onFailur("Opps..\nData kota anda tidak dapat ditemukan");
                } else {
                    weaterInterface.onSuccses(response.body());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}
