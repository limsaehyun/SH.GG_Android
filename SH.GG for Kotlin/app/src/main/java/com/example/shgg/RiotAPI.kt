package com.example.shgg

import com.example.shgg.data.SummonerResponse
import com.example.shgg.data.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RiotAPI {
    @GET("lol/summoner/v4/summoners/by-name/{summonerName}")
    fun getSummoner(
        @Path("summonerName") name: String,
        @Query("api_key") apiKey: String
    ): Call<SummonerResponse>

    @GET("lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
    fun getUser(
        @Path("encryptedSummonerId") id: String,
        @Query("api_key") apiKey: String
    ): Call<List<UserResponse>>
}
