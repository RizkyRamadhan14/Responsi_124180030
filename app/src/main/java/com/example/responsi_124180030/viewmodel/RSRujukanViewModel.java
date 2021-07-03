package com.example.responsi_124180030.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi_124180030.model.RSRujukan.RSRujukanResponse;
import com.example.responsi_124180030.model.RSRujukan.RSRujukanResultItem;
import com.example.responsi_124180030.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RSRujukanViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<RSRujukanResultItem>> listRSRujukan = new MutableLiveData<>();

    public void setRSRujukan(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiRSRujukan().getRSRujukan().enqueue(new Callback<RSRujukanResponse>() {
            @Override
            public void onResponse(Call<RSRujukanResponse> call, Response<RSRujukanResponse> response) {
                RSRujukanResponse responseRSRujukan = response.body();
                if (responseRSRujukan != null && responseRSRujukan.getData() != null){
                    ArrayList<RSRujukanResultItem> rsRujukanItems = responseRSRujukan.getData();
                    listRSRujukan.postValue(rsRujukanItems);
                }
            }

            @Override
            public void onFailure(Call<RSRujukanResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<RSRujukanResultItem>> getRSRujukan(){
        return listRSRujukan;
    }
}
