package com.namazsikkawithhabibakij.namazshikka.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.namazsikkawithhabibakij.namazshikka.Others.NamazDetails;
import com.namazsikkawithhabibakij.namazshikka.R;

public class ActivityNamaz extends AppCompatActivity {

    private AdView adView1, adView2;

    Button namazDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namaz);

        namazDetails= findViewById(R.id.goto_namazDetails);
        adView1= findViewById(R.id.activity_namaz_ad);
        adView2= findViewById(R.id.activity_namaz_ad_bottom);

        namazDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityNamaz.this, NamazDetails.class));
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
