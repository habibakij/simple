package com.namazsikkawithhabibakij.namazshikka.Others;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.namazsikkawithhabibakij.namazshikka.R;

public class NamazDetails extends AppCompatActivity {

    private AdView adView1, adView2;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namaz_details);

        adView1= findViewById(R.id.activity_namaz_details_ad);
        adView2= findViewById(R.id.activity_namaz_details_ad_bottom);

        AdvertiseMent();
    }
    private void AdvertiseMent() {
        MobileAds.initialize(this, getString(R.string.APP_ID));
        AdRequest adRequest= new AdRequest.Builder().build();
        adView1.loadAd(adRequest);
        adView2.loadAd(adRequest);

        mInterstitialAd= new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.INTERSTITIAL_ID));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mInterstitialAd.show();
    }

}
