package com.example.setelahgagal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterUlar extends RecyclerView.Adapter<AdapterUlar.ViewHolder>{
    private ArrayList<ModelUlar> listUlar = new ArrayList<>();
    private Context context;

    public AdapterUlar(ArrayList<ModelUlar> listUlar, Context context) {
        this.listUlar = listUlar;
        this.context = context;
    }

    public ArrayList<ModelUlar> getListUlar() {
        return listUlar;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ular, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //Glide.with(context).load(getListHero().get(position).getHeroImage()).into(holder.ivPahlawan);
        holder.ivUlar.setImageResource(getListUlar().get(position).getSnakeImage());
        holder.tvTitle.setText(getListUlar().get(position).getSnakeName());
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String snakeName = "Nama Ular " + getListUlar().get(position).getSnakeName();
                intent.putExtra(Intent.EXTRA_TEXT, snakeName);
                context.startActivity(Intent.createChooser(intent, "Kirim"));
            }
        });
        holder.btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailUlar.class);
                intent.putExtra("img_url", getListUlar().get(position).getSnakeImage());
                intent.putExtra("title", getListUlar().get(position).getSnakeName());
                intent.putExtra("detail", getListUlar().get(position).getSnakeDetail());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getListUlar().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivUlar;
        TextView tvTitle;
        Button btnShare, btnPreview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivUlar = itemView.findViewById(R.id.iv_ular);
            tvTitle = itemView.findViewById(R.id.tv_name);
            btnShare = itemView.findViewById(R.id.btn_share);
            btnPreview = itemView.findViewById(R.id.btn_lihat);
        }
    }
}
