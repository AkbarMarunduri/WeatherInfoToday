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
        bindingMain.coord.setText("Coord    : " + response.getCoord().getLon()+", "+ response.getCoord().getLat());
        bindingMain.id.setText("Id    : " + response.getWeather().get(0).getId());
        bindingMain.main.setText("Main    : " + response.getWeather().get(0).getMain());
        bindingMain.desc.setText("Descc    : " + response.getWeather().get(0).getDescription());
        bindingMain.icon.setText("Icon    : " + response.getWeather().get(0).getIcon());
        bindingMain.temp.setText("Temperatur    : " + response.getMain().getTemp());
        bindingMain.feelsLike.setText("Feels    : " + response.getMain().getFeelsLike());
        bindingMain.tempMin.setText("Min    : " + response.getMain().getTempMin());
        bindingMain.tempMax.setText("Max    : " + response.getMain().getTempMax());
        bindingMain.pressure.setText("Preasure    : " + response.getMain().getPressure());
    }

    @Override
    public void onFailur(String pesan) {
        Toast.makeText(getApplicationContext(), pesan, Toast.LENGTH_LONG).show();
    }
}