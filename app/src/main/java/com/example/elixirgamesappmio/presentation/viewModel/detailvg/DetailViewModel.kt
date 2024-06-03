package com.example.elixirgamesappmio.presentation.viewModel.detailvg

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elixirgamesappmio.data.response.VideoGameDetailRespose
import com.example.elixirgamesappmio.domain.VideoGameUseCase
import kotlinx.coroutines.launch

class DetailViewModel (private val userCase: VideoGameUseCase): ViewModel() {

    private val _videoGameDetail = MutableLiveData<VideoGameDetailRespose>()
            val videoGameDetailLV: LiveData<VideoGameDetailRespose>
            get() = _videoGameDetail    //con esto presiono que solo sea variable de lectura
                                        //...y no se pueda modificar

    fun getDetailVideoGameById(idVideoGame: Long) {

        viewModelScope.launch {  //a este nivel abro las corrutinas (las llamo a todas)
            val videoGame = userCase.getVideoGameByIdOnStock(idVideoGame)
            _videoGameDetail.value = videoGame
        }
    }

}