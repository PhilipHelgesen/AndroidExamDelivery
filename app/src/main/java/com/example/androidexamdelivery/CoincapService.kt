package com.example.androidexamdelivery

import retrofit2.http.GET
import retrofit2.http.Path

interface CoincapService {

    @GET("assets/{id}")
    suspend fun getCurrencyAssets(@Path("id") id: String) : JsonRes

    @GET("assets")
    suspend fun getAllCurrencyAssets() : JsonRes


}