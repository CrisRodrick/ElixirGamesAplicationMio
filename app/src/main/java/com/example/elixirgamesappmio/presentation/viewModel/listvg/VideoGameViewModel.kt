package com.example.elixirgamesappmio.presentation.viewModel.listvg

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elixirgamesappmio.data.response.VideoGameResponse
import com.example.elixirgamesappmio.domain.VideoGameUseCase
import kotlinx.coroutines.launch

class VideoGameViewModel(private var useCase: VideoGameUseCase): ViewModel() {

    //en ViewModel van de la mano un MutableLiveData y una MutableList
    private var videoGameList = MutableLiveData<MutableList<VideoGameResponse>>()

    //el siguiente atributo no va private porque requiere acceder desde la Main
    //van private si solo se ocupa en este clase y archivo no mas (LV:LiveData)
    //cuando invoque desde la Main Activity a videoGameLV esta va a contener a videoGameList

    val videoGameLV
        get() = videoGameList

    //a penas abra viewModel init trae de inmediato los juegos que estan en corrutina
    //... y le paso todo lo que esta para abajo en useCase

    init {
        viewModelScope.launch {
            videoGameList.value = useCase.getAllVideoGamesOnStock()
        }
    }

}