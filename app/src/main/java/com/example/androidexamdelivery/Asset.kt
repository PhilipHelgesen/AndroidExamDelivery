package com.example.androidexamdelivery

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class JsonRes(
        val data: Data,
        val timestamp: String
        )

@JsonClass(generateAdapter = true)
data class Data(
        val id: String,
        val rank: String,
        val symbol: String,
        val name: String,
        val supply: String,
        val maxSupply: String?,
        val marketCapUsd: String,
        val volumeUsd24Hr: String,
        val priceUsd: String,
        val changePercent24Hr: String,
        val vwap24Hr: String
        )




