package com.example.responsi_124180030.service;

import com.example.responsi_124180030.model.KasusCovid.KasusCovidResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KasusCovidRepository {
    @GET("rekapitulasi_v2/jabar/harian?level=prov")
    Call<KasusCovidResponse> getKasusCovid();
}
