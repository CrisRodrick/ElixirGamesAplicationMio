package com.example.elixirgamesappmio.presentation.viewModel.listvg

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.elixirgamesappmio.domain.VideoGameUseCase
import java.lang.IllegalArgumentException

//esta clase es necesaria para que en la clase Main el ViewModel conecte con anteriores capas

class ViewModelFactory (private val videoGamesUseCase: VideoGameUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VideoGameViewModel::class.java)){
            return VideoGameViewModel(videoGamesUseCase) as T
    }
        throw IllegalArgumentException("Unknown ViewModel class")

}


}