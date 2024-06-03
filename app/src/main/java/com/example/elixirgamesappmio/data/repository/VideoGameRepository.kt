package com.example.elixirgamesappmio.data.repository

import com.example.elixirgamesappmio.data.network.api.VideoGameService
import com.example.elixirgamesappmio.data.response.VideoGameDetailRespose
import com.example.elixirgamesappmio.data.response.VideoGameResponse

interface VideoGameRepository {

    //una funcion que devuelva  un listado del modelo VideoGameResponse
    suspend fun fetchVideoGames(): MutableList<VideoGameResponse>


    suspend fun fetchVideoGameById(idVideoGameService: Long): VideoGameDetailRespose

}