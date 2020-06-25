package com.namazsikkawithhabibakij.namazshikka.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.namazsikkawithhabibakij.namazshikka.R;

public class ActivityIman extends AppCompatActivity {

    private AdView adView1, adView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iman);

        adView1= findViewById(R.id.activity_iman_ad);
        adView2= findViewById(R.id.activity_iman_ad_bottom);

        AdvertiseMent();
    }

    private void AdvertiseMent() {
        MobileAds.initialize(this, getString(R.string.APP_ID));
        AdRequest adRequest= new AdRequest.Builder().build();
        adView1.loadAd(adRequest);
        adView2.loadAd(adRequest);
    }

}
