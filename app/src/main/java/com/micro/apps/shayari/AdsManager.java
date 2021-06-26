package com.micro.apps.shayari;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


import org.jetbrains.annotations.NotNull;

public class AdsManager {
    private Context ctx;
    public AdsManager(Context ctx)
    {
      this.ctx = ctx;
        MobileAds.initialize(ctx, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull @org.jetbrains.annotations.NotNull InitializationStatus initializationStatus) {

            }
        });
    }

    public void createAds(AdView adView, int rid){
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(@NonNull @org.jetbrains.annotations.NotNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Toast.makeText(ctx, ""+loadAdError.getCode(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }
        });

        adView.loadAd(adRequest);
    }

    public InterstitialAd createInterstialAds() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd interstitialAd = new InterstitialAd(ctx);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(adRequest);
        return interstitialAd;
    }

}
