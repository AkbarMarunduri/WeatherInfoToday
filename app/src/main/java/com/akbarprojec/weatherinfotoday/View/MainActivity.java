package com.akbarprojec.weatherinfotoday.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.akbarprojec.weatherinfotoday.Api.ApiInterface;
import com.akbarprojec.weatherinfotoday.Model.Response;
import com.akbarprojec.weatherinfotoday.Presenter.WeatherPresenter;
import com.akbarprojec.weatherinfotoday.R;
import com.akbarprojec.weatherinfotoday.ViewInterface.WeaterInterface;
import com.akbarprojec.weatherinfotoday.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements WeaterInterface {
    ActivityMainBinding bindingMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final WeatherPresenter presenter = new WeatherPresenter(this);

        bindingMain.btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.weaterData(bindingMain.txCity.getText().toString());
            }
        });
    }

    @Override
    public void onSuccses(Response response) {
        Toast.makeText(getApplicationContext(), response.getWeather().get(0).getDescription().toUpperCase(), Toast.LENGTH_LONG).show();
        bindingMain.tcLon.setText("lon : "+response.getCoord().getLon());
        bindingMain.txLat.setText("lat : "+response.getCoord().getLat());
    }

    @Override
    public void onFailur(String pesan) {
        Toast.makeText(getApplicationContext(), pesan, Toast.LENGTH_LONG).show();
    }
}