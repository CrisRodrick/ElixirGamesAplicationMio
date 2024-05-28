package com.example.elixirgamesappmio.data.network.api

import com.example.elixirgamesappmio.data.response.VideoGameResponse
import retrofit2.http.GET

interface VideoGameService {

    @GET ("games")          //es servicio es "games" que viene a continuacion de la base del HTTPS
    suspend fun getAllVideoGames (): MutableList<VideoGameResponse>
    //suspend dado que no se sabe el peso de la info y la trabajaré con Corrutinas
}