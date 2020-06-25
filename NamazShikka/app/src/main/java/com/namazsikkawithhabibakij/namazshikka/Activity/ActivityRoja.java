package com.namazsikkawithhabibakij.namazshikka.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.namazsikkawithhabibakij.namazshikka.Others.MoreDetails;
import com.namazsikkawithhabibakij.namazshikka.R;

public class ActivityRoja extends AppCompatActivity {

    private AdView adView1, adView2;

    Button bistarito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roja);

        bistarito= findViewById(R.id.bistarito);
        adView1= findViewById(R.id.activity_roja_ad);
        adView2= findViewById(R.id.activity_roja_ad_bottom);

        bistarito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityRoja.this, MoreDetails.class));
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
