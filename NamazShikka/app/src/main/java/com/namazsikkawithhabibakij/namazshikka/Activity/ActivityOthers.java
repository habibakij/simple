package com.namazsikkawithhabibakij.namazshikka.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.namazsikkawithhabibakij.namazshikka.Others.Gosol;
import com.namazsikkawithhabibakij.namazshikka.Others.Oju;
import com.namazsikkawithhabibakij.namazshikka.R;
import com.namazsikkawithhabibakij.namazshikka.Others.Surah;
import com.namazsikkawithhabibakij.namazshikka.Others.Tayammum;

public class ActivityOthers extends AppCompatActivity {

    private AdView adView1, adView2;

    Button btnSurah, btnGosol, btnOju, btnTayammum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);

        btnSurah= findViewById(R.id.surah);
        btnGosol= findViewById(R.id.gosol);
        btnOju= findViewById(R.id.oju);
        btnTayammum= findViewById(R.id.tayammum);

        adView1= findViewById(R.id.activity_others_ad);
        adView2= findViewById(R.id.activity_others_ad_bottom);

        btnSurah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityOthers.this, Surah.class));
            }
        });

        btnGosol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityOthers.this, Gosol.class));
            }
        });

        btnOju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityOthers.this, Oju.class));
            }
        });

        btnTayammum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityOthers.this, Tayammum.class));
            }
        });

        AdvertiseMent();
    }

    private void AdvertiseMent() {
        MobileAds.initialize(this, getString(R.string.APP_ID));
        AdRequest adRequest= new AdRequest.Builder().build();
        adView1.loadAd(adRequest);
        adView2.loadAd(adRequest);
    }

}
