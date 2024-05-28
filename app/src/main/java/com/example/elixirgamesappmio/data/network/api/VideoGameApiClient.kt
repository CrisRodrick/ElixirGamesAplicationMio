package com.example.elixirgamesappmio.data.network.api

import com.example.elixirgamesappmio.data.network.retrofit.RetrofitHelper
import com.example.elixirgamesappmio.data.response.VideoGameResponse
import retrofit2.create

class VideoGameApiClient {
    //para conectarme a retrofit
    private val retrofit = RetrofitHelper.getRetrofit()

    //conectarse a los metodos (servicios=APIs Services)
    //instanciar retrofit

    suspend fun getVideoGames(): MutableList<VideoGameResponse>{

        val response = retrofit.create(VideoGameService::class.java).getAllVideoGames()
        return response
    }


}