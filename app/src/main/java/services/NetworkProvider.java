package services;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkProvider {
    private static volatile NetworkProvider mInstance = null;
    private Retrofit retrofit;
    private NetworkProvider() {
        retrofit = new Retrofit.Builder()
                .baseUrl( "https://api.ulu.vn/api/adx/dantri" )
                .client( new OkHttpClient.Builder().build() )
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();
    }
    public static NetworkProvider self() {
        if (mInstance == null)
            mInstance = new NetworkProvider();
        return mInstance;
    }

}
