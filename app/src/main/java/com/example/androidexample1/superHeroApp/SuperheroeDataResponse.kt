package com.example.androidexample1.superHeroApp

import com.google.gson.annotations.SerializedName

data class SuperheroeDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val results: List<SuperheroeItemResponse>
)

data class SuperheroeItemResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: imageSuperheroe,
    @SerializedName("powerstats") val powerstats: powerStatsResponse
)
data class imageSuperheroe(
    @SerializedName("url") val url: String
)
data class powerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)