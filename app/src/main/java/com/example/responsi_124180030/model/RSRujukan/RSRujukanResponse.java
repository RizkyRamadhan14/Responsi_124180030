package com.example.responsi_124180030.model.RSRujukan;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class RSRujukanResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<RSRujukanResultItem> data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(ArrayList<RSRujukanResultItem> data){
		this.data = data;
	}

	public ArrayList<RSRujukanResultItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"RSRujukanResponse{" + 
			"status_code = '" + statusCode + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}