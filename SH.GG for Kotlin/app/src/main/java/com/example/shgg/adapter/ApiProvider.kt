package com.example.shgg.adapter

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiProvider {

    private lateinit var instance: Retrofit
    private var BASE_URL: String = "https://kr.api.riotgames.com/"

    fun getInstance(): Retrofit{
        instance = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return instance
    }
}