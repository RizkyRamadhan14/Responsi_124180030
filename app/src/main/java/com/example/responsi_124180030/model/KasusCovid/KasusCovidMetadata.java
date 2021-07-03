package com.example.responsi_124180030.model.KasusCovid;

import com.google.gson.annotations.SerializedName;

public class KasusCovidMetadata {

	@SerializedName("last_update")
	private Object lastUpdate;

	public void setLastUpdate(Object lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public Object getLastUpdate(){
		return lastUpdate;
	}

	@Override
 	public String toString(){
		return 
			"Metadata{" + 
			"last_update = '" + lastUpdate + '\'' + 
			"}";
		}
}