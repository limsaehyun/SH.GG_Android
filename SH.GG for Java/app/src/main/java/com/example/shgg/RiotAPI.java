package com.example.shgg;

import android.os.Build;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RiotAPI {

    @GET("lol/summoner/v4/summoners/by-name/{summonerName}")
    Call<Summoner> getSummoner(
            @Path("summonerName") String name,
            @Query("api_key") String apiKey
    );

    @GET("lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
    Call<List<UserInfo>> getUserInfo(
            @Path("encryptedSummonerId") String id,
            @Query("api_key") String apiKey
    );
}
