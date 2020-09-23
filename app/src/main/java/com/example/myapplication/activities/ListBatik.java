package com.example.myapplication.activities;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;
import com.example.myapplication.adapters.RecyclerViewAdapter;
import com.example.myapplication.model.Batik;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListBatik extends AppCompatActivity {

    private final String JSON_URL = "https://api.jikan.moe/v3/search/anime?q=naruto" ;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Batik> lstBatik ;
    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_batik);

        lstBatik = new ArrayList<>() ;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewid);

        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject =null;

                for (int i = 0 ; i < response.length(); i++ ) {

                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Batik batik = new Batik() ;
                        batik.setNama_batik(jsonObject.getString("nama_batik"));
                        batik.setDaerah_batik(jsonObject.getString("daerah_batik"));
                        batik.setMakna_batik(jsonObject.getString("makna_batik"));
                        batik.setHarga_rendah(jsonObject.getInt("harga_rendah"));
                        batik.setHarga_tinggi(jsonObject.getInt("harga_tinggi"));
                        batik.setHitung_view(jsonObject.getInt("hitung_view"));
                        batik.setLink_batik(jsonObject.getString("link_batik"));
                        lstBatik.add(batik);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(lstBatik);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(ListBatik.this);
        requestQueue.add(request) ;

    }

    private void setuprecyclerview(List<Batik> lstBatik) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(getApplicationContext(),lstBatik) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(myadapter);

    }
}