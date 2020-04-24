package com.example.chinadxdantri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.APIService;
import services.AdZone;
import services.Payload;

public class MainActivity extends AppCompatActivity {


    private AdView adView;
    private FrameLayout adContainerView;
    private FrameLayout adContainerView1;
    private Payload payload;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adView = new AdView(this);
        adContainerView = findViewById(R.id.ad_view_container);
        adContainerView1 = findViewById( R.id.ad_view_container_2 );


        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });


        APIService apiService = new Retrofit.Builder()
                .baseUrl( "https://api.ulu.vn" )
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create( APIService.class );



        apiService.getAds()
            .enqueue(new Callback<AdZone>() {
                @Override
                public void onResponse(Call<AdZone> call, Response<AdZone> response) {

                    AdZone adZone = response.body();

                    payload =  adZone.findAdZoneByName("home_1");
                    adContainerView.post(new Runnable() {
                        @Override
                        public void run() {
                            String adUnit = "ca-app-pub-3940256099942544/6300978111";
                            AdSize adSize = new AdSize( payload.getBannerWidth(), payload.getBannerHeight() );
                            loadBanner( adUnit , adSize , adContainerView );
                        }
                    });

                    payload =  adZone.findAdZoneByName("home_10");
                    adContainerView1.post(new Runnable() {
                        @Override
                        public void run() {
                            String adUnit = "ca-app-pub-3940256099942544/6300978111";
                            AdSize adSize = new AdSize( payload.getBannerWidth(), payload.getBannerHeight() );
                            loadBanner( adUnit , adSize , adContainerView1 );
                        }
                    });



                }

                @Override
                public void onFailure(Call<AdZone> call, Throwable t) {
                    // Log error here since request failed
                }
            });


    }

    private void loadBanner( String adUnitId, AdSize adSize, FrameLayout adContainerView ) {
        // Create an ad request.
        adView = new AdView(this);
        adView.setAdUnitId(adUnitId);
        adContainerView.removeAllViews();
        adContainerView.addView(adView);
        adView.setAdSize( adSize );
        AdRequest adRequest = new AdRequest.Builder().build();
        // Start loading the ad in the background.
        adView.loadAd(adRequest);
    }

}
