package com.example.elixirgamesappmio.data.repository

import com.example.elixirgamesappmio.data.network.api.VideoGameApiClient
import com.example.elixirgamesappmio.data.network.api.VideoGameService
import com.example.elixirgamesappmio.data.response.VideoGameDetailRespose
import com.example.elixirgamesappmio.data.response.VideoGameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//conecto repository con API (trayendo el metodo de la interface)
class VideoGameImpl (private var apiservice: VideoGameService): VideoGameRepository {
    override suspend fun fetchVideoGames(): MutableList<VideoGameResponse> {
        //aqui en repository implemento la corrutina con lo siguiente
        return withContext(Dispatchers.IO){    //context lineas de entrada I y salida O
            val listVideoGames = apiservice.getAllVideoGames()
            listVideoGames
        }
    }

    override suspend fun fetchVideoGameById(idVideoGameService: Long): VideoGameDetailRespose {
        //lo mismo de arriba, aplico corrutina
        return withContext(Dispatchers.IO){
            val videoGameDetail = apiservice.getVideoGameById(idVideoGameService)
            videoGameDetail
        }
    }

}