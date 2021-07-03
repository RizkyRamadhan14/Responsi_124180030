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
import com.example.responsi_124180030.adapter.RSRujukanAdapter;
import com.example.responsi_124180030.model.RSRujukan.RSRujukanResultItem;
import com.example.responsi_124180030.viewmodel.RSRujukanViewModel;

import java.util.ArrayList;


public class RSRujukanFragment extends Fragment {

    private RSRujukanAdapter rsRujukanAdapter;
    private RecyclerView rv_rsRujukan;
    private RSRujukanViewModel rsRujukanViewModel;

    public RSRujukanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_r_s_rujukan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rsRujukanAdapter = new RSRujukanAdapter(getContext());
        rsRujukanAdapter.notifyDataSetChanged();

        rv_rsRujukan = view.findViewById(R.id.rv_rsRujukan);
        rv_rsRujukan.setLayoutManager(new GridLayoutManager(getContext(),1));

        rsRujukanViewModel = new ViewModelProvider(this).get(RSRujukanViewModel.class);
        rsRujukanViewModel.setRSRujukan();
        rsRujukanViewModel.getRSRujukan().observe(this, getRSRujukan);

        rv_rsRujukan.setAdapter(rsRujukanAdapter);
    }

    private Observer<ArrayList<RSRujukanResultItem>> getRSRujukan = new Observer<ArrayList<RSRujukanResultItem>>() {
        @Override
        public void onChanged(ArrayList<RSRujukanResultItem> rsRujukanResultItems) {
            if(rsRujukanResultItems!=null){
                rsRujukanAdapter.setData(rsRujukanResultItems);
            }
        }
    };

}