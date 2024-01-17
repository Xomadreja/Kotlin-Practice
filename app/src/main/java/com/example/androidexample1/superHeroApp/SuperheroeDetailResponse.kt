package com.example.androidexample1.superHeroApp

import com.google.gson.annotations.SerializedName

data class SuperheroeItemResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: imageSuperheroe,
    @SerializedName("powerstats") val powerstats: powerStatsResponse,
    @SerializedName("biography") val biography: Biography
)
data class imageSuperheroe(
    @SerializedName("url") val url: String
)
data class Biography(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("alignment") val alignment: String,
)
data class powerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)