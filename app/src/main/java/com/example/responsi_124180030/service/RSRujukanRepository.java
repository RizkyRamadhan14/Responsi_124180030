package com.example.responsi_124180030.service;

import com.example.responsi_124180030.model.RSRujukan.RSRujukanResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RSRujukanRepository {
    @GET("sebaran_v2/jabar/faskes?tipe=rsrujukan")
    Call<RSRujukanResponse> getRSRujukan();
}
