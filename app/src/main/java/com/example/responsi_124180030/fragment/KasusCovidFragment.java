package com.example.responsi_124180030.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsi_124180030.R;
import com.example.responsi_124180030.adapter.KasusCovidAdapter;
import com.example.responsi_124180030.model.KasusCovid.KasusCovidResultItem;
import com.example.responsi_124180030.viewmodel.KasusCovidViewModel;

import java.util.ArrayList;

public class KasusCovidFragment extends Fragment {

    private KasusCovidAdapter kasusCovidAdapter;
    private RecyclerView rvKasusCovid;
    private KasusCovidViewModel kasusCovidViewModel;

    public KasusCovidFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus_covid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        kasusCovidAdapter = new KasusCovidAdapter(getContext());
        kasusCovidAdapter.notifyDataSetChanged();

        rvKasusCovid = view.findViewById(R.id.rv_kasusCovid);
        rvKasusCovid.setLayoutManager(new GridLayoutManager(getContext(),1));

        kasusCovidViewModel = new ViewModelProvider(this).get(KasusCovidViewModel.class);
        kasusCovidViewModel.setKasusCovid();
        kasusCovidViewModel.getKasusCovid().observe(this,getKasusCovid);

        rvKasusCovid.setAdapter(kasusCovidAdapter);
    }




    private Observer<ArrayList<KasusCovidResultItem>> getKasusCovid = new Observer<ArrayList<KasusCovidResultItem>>() {
        @Override
        public void onChanged(ArrayList<KasusCovidResultItem> kasusCovidResultItems) {
            if (kasusCovidResultItems != null){
                kasusCovidAdapter.setData(kasusCovidResultItems);
            }
        }
    };
}