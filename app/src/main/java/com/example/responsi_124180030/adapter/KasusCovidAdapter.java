package com.example.responsi_124180030.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_124180030.R;
import com.example.responsi_124180030.model.KasusCovid.KasusCovidResultItem;

import java.util.ArrayList;

public class KasusCovidAdapter extends RecyclerView.Adapter<KasusCovidAdapter.ViewHolder> {

    private ArrayList<KasusCovidResultItem> kasusCovidItems = new ArrayList<>();
    private Context context;

    public KasusCovidAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<KasusCovidResultItem>items){
        kasusCovidItems.clear();
        kasusCovidItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KasusCovidAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kasus_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KasusCovidAdapter.ViewHolder holder, int position) {
        holder.tvTanggal.setText(kasusCovidItems.get(position).getTanggal());
        holder.tvKonfirmasi.setText(String.valueOf(kasusCovidItems.get(position).getConfirmationDiisolasi()));
        holder.tvSembuh.setText(String.valueOf(kasusCovidItems.get(position).getConfirmationSelesai()));
        holder.tvMeninggal.setText(String.valueOf(kasusCovidItems.get(position).getConfirmationMeninggal()));
    }

    @Override
    public int getItemCount() {
        return kasusCovidItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggal, tvKonfirmasi, tvSembuh, tvMeninggal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvKonfirmasi = itemView.findViewById(R.id.tv_konfirmasi);
            tvSembuh = itemView.findViewById(R.id.tv_sembuh);
            tvMeninggal = itemView.findViewById(R.id.tv_meninggal);
        }
    }
}
