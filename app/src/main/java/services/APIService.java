package services;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("api/adx/dantri")
    Call<AdZone> getAds();
}
