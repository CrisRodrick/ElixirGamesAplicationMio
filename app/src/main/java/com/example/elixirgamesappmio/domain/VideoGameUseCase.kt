package com.example.elixirgamesappmio.domain

import com.example.elixirgamesappmio.data.repository.VideoGameImpl
import com.example.elixirgamesappmio.data.repository.VideoGameRepository
import com.example.elixirgamesappmio.data.response.VideoGameResponse

class VideoGameUseCase (private val repository: VideoGameImpl) {
    suspend fun getAllVideoGamesOnStock (): MutableList<VideoGameResponse>{
        return repository.fetchVideoGames()

    }
}