package com.example.responsi_124180030.model.KasusCovid;

import com.google.gson.annotations.SerializedName;

public class KasusCovidResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private KasusCovidData data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(KasusCovidData data){
		this.data = data;
	}

	public KasusCovidData getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"KasusCovidResponse{" + 
			"status_code = '" + statusCode + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}