package com.example.myapplication.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;

public class BatikActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batik);

        // hide the default actionbar
        getSupportActionBar().hide();

        // Recieve data

        String nama_batik  = getIntent().getExtras().getString("nama_batik");
        String daerah_batik = getIntent().getExtras().getString("daerah_batik");
        String makna_batik = getIntent().getExtras().getString("makna_batik") ;
        String harga_rendah = getIntent().getExtras().getString("harga_rendah");
        String harga_tinggi = getIntent().getExtras().getString("harga_tinggi");
        String hitung_view = getIntent().getExtras().getString("hitung_view");
        String link_batik = getIntent().getExtras().getString("link_batik") ;

        // ini views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_batik_name = findViewById(R.id.batik_name) ;
        TextView tv_batik_daerah= findViewById(R.id.batik_daerah);
        TextView tv_batik_view =findViewById(R.id.batik_view);
        TextView tv_batik_min= findViewById(R.id.batik_min);
        TextView tv_batik_max =findViewById(R.id.batik_max);
        TextView tv_batik_deskripsi =findViewById(R.id.batik_deskripsi);
        ImageView img= findViewById(R.id.aa_thumbnail);

        // setting values to each view

        tv_batik_name.setText(nama_batik);
        tv_batik_daerah.setText(daerah_batik);
        tv_batik_view.setText(hitung_view);
        tv_batik_min.setText(harga_rendah);
        tv_batik_max.setText(harga_tinggi);
        tv_batik_deskripsi.setText(makna_batik);

        collapsingToolbarLayout.setTitle(nama_batik);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // set image using Glide
        Glide.with(this).load(link_batik).apply(requestOptions).into(img);






    }
}