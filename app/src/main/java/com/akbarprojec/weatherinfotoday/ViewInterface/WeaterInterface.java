package com.akbarprojec.weatherinfotoday.ViewInterface;

import com.akbarprojec.weatherinfotoday.Model.Response;

public interface WeaterInterface {

    void onSuccses(Response response);

    void onFailur(String pesan);
}
