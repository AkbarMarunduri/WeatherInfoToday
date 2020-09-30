package com.akbarprojec.weatherinfotoday.Model;

import com.google.gson.annotations.SerializedName;

public class Wind{

	@SerializedName("deg")
	private int deg;

	@SerializedName("speed")
	private double speed;

	public int getDeg(){
		return deg;
	}

	public double getSpeed(){
		return speed;
	}
}