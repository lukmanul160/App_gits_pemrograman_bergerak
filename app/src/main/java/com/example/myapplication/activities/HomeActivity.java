package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.Batik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    private CardView card1,card2,card3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        card1 =(CardView) findViewById(R.id.card1);
        card2 =(CardView) findViewById(R.id.card2);
        card3 =(CardView) findViewById(R.id.card3);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicit = new Intent(getApplicationContext(), ListBatik.class);
                startActivity(explicit);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicit = new Intent(getApplicationContext(), Batik.class);
                startActivity(explicit);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_SHORT).show();

            }
        });



//        oncreate akhir
    }


// kepala
}