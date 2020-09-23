package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.model.Batik;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Batik> mData ;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Batik> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.activity_row_item,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, Batik.class);
                i.putExtra("nama_batik",mData.get(viewHolder.getAdapterPosition()).getNama_batik());
                i.putExtra("daerah_batik",mData.get(viewHolder.getAdapterPosition()).getDaerah_batik());
                i.putExtra("makna_batik",mData.get(viewHolder.getAdapterPosition()).getMakna_batik());
                i.putExtra("harga_rendah",mData.get(viewHolder.getAdapterPosition()).getHarga_rendah());
                i.putExtra("harga_tinggi",mData.get(viewHolder.getAdapterPosition()).getHarga_tinggi());
                i.putExtra("hitung_view",mData.get(viewHolder.getAdapterPosition()).getHitung_view());
                i.putExtra("link_batik",mData.get(viewHolder.getAdapterPosition()).getLink_batik());

                mContext.startActivity(i);

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_batik_name.setText(mData.get(position).getNama_batik());
        holder.tv_batik_daerah.setText(mData.get(position).getDaerah_batik());
        holder.tv_batik_deskripsi.setText(mData.get(position).getMakna_batik());
        holder.tv_batik_min.setText(mData.get(position).getHarga_rendah());
        holder.tv_batik_max.setText(mData.get(position).getHarga_tinggi());
        holder.tv_batik_view.setText(mData.get(position).getHitung_view());
        holder.tv_batik_min.setText(mData.get(position).getHarga_rendah());


        // Load Image from the internet and set it into Imageview using Glide

        Glide.with(mContext).load(mData.get(position).getLink_batik()).apply(option).into(holder.img_thumbnail);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_batik_name ;
        TextView tv_batik_daerah ;
        TextView tv_batik_view ;
        TextView tv_batik_min;
        TextView tv_batik_max;
        TextView tv_batik_deskripsi;
        ImageView img_thumbnail;
        LinearLayout view_container;


        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_batik_name = itemView.findViewById(R.id.batik_name);
            tv_batik_daerah = itemView.findViewById(R.id.batik_daerah);
            tv_batik_view = itemView.findViewById(R.id.batik_view);
            tv_batik_min = itemView.findViewById(R.id.batik_min);
            tv_batik_max = itemView.findViewById(R.id.batik_max);
            tv_batik_deskripsi = itemView.findViewById(R.id.batik_deskripsi);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }




}
