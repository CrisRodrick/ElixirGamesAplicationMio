package com.example.elixirgamesappmio.data.response

import com.google.gson.annotations.SerializedName

data class VideoGameDetailRespose (
    val id: Long,
    val name: String,
    val released: String,
    @SerializedName("background_image") //se borra name e igual
    val backgroundImage: String,
    val rating: Double,
    val metacritic: Long,
    val playtime: Long,
    val platforms: String,
    val genres: String,
    val format: String,
    val price: Double,
    val lastPrice: Double,
    val delivery: Boolean

)








