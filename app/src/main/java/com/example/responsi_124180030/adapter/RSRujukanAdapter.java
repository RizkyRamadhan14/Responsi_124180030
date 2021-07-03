package com.example.responsi_124180030.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_124180030.R;
import com.example.responsi_124180030.model.RSRujukan.RSRujukanResultItem;

import java.util.ArrayList;

public class RSRujukanAdapter extends RecyclerView.Adapter<RSRujukanAdapter.ViewHolder> {

    private ArrayList<RSRujukanResultItem> rsRujukanResultItems = new ArrayList<>();
    private Context context;

    public RSRujukanAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<RSRujukanResultItem>items){
        rsRujukanResultItems.clear();
        rsRujukanResultItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RSRujukanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rs_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RSRujukanAdapter.ViewHolder holder, int position) {
        holder.tvNm.setText(rsRujukanResultItems.get(position).getNama());
        holder.tvAlamat.setText(rsRujukanResultItems.get(position).getAlamat());
        holder.btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gmaps = new Intent(android.content.Intent.ACTION_VIEW,Uri
                        .parse("geo:0,0?q=" + rsRujukanResultItems.get(position).getNama()));
                gmaps.setPackage("com.google.android.apps.maps");
                context.startActivity(gmaps);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rsRujukanResultItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btn_maps;
        TextView tvNm, tvAlamat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_maps = itemView.findViewById(R.id.btn_maps);
            tvNm = itemView.findViewById(R.id.nm_rs);
            tvAlamat = itemView.findViewById(R.id.alamat_rs);
        }
    }
}
