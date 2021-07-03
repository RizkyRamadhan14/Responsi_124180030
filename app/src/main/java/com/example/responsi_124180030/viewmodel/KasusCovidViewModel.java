package com.example.responsi_124180030.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi_124180030.model.KasusCovid.KasusCovidData;
import com.example.responsi_124180030.model.KasusCovid.KasusCovidResponse;
import com.example.responsi_124180030.model.KasusCovid.KasusCovidResultItem;
import com.example.responsi_124180030.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KasusCovidViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<KasusCovidResultItem>> listKasusCovid = new MutableLiveData<>();

    public void setKasusCovid(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }
        apiMain.getApiKasusCovid().getKasusCovid().enqueue(new Callback<KasusCovidResponse>() {
            @Override
            public void onResponse(Call<KasusCovidResponse> call, Response<KasusCovidResponse> response) {
                KasusCovidResponse responseKasusCovid = response.body();
                if (responseKasusCovid != null && responseKasusCovid.getData().getContent() != null){
                    ArrayList<KasusCovidResultItem> kasusCovidItems = responseKasusCovid.getData().getContent();
                    listKasusCovid.postValue(kasusCovidItems);
                }
            }

            @Override
            public void onFailure(Call<KasusCovidResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<KasusCovidResultItem>> getKasusCovid(){
        return listKasusCovid;
    }
}
