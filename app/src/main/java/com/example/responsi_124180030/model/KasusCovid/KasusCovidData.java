package com.example.responsi_124180030.model.KasusCovid;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class KasusCovidData {

	@SerializedName("metadata")
	private KasusCovidMetadata metadata;

	@SerializedName("content")
	private ArrayList<KasusCovidResultItem> content;

	public void setMetadata(KasusCovidMetadata metadata){
		this.metadata = metadata;
	}

	public KasusCovidMetadata getMetadata(){
		return metadata;
	}

	public void setContent(ArrayList<KasusCovidResultItem> content){
		this.content = content;
	}

	public ArrayList<KasusCovidResultItem> getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"metadata = '" + metadata + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}