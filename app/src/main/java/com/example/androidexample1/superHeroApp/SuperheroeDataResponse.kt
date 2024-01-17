package com.example.androidexample1.superHeroApp

import com.google.gson.annotations.SerializedName

data class SuperheroeDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val results: List<SuperheroeItemResponse>
)

