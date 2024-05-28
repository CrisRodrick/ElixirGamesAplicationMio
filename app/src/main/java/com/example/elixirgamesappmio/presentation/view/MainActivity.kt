package com.example.elixirgamesappmio.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.elixirgamesappmio.R
import com.example.elixirgamesappmio.data.network.api.VideoGameService
import com.example.elixirgamesappmio.data.network.retrofit.RetrofitHelper
import com.example.elixirgamesappmio.data.repository.VideoGameImpl
import com.example.elixirgamesappmio.data.repository.VideoGameRepository
import com.example.elixirgamesappmio.databinding.ActivityMainBinding
import com.example.elixirgamesappmio.domain.VideoGameUseCase
import com.example.elixirgamesappmio.presentation.viewModel.VideoGameViewModel
import com.example.elixirgamesappmio.presentation.viewModel.ViewModelFactory

private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //aqui se pasan capa por capa
        val apiService = RetrofitHelper.getRetrofit().create(VideoGameService::class.java)
        val repository = VideoGameImpl(apiService)
        val useCase = VideoGameUseCase(repository)

        //luego viene viewModel que se instancia de otra forma y no permite pasar el UseCase
        //..el metodo para subsanarlo es creando como clase el viewModelFactory
        val viewModelFactory = ViewModelFactory(useCase)
        val viewModel = ViewModelProvider(this, viewModelFactory)[VideoGameViewModel::class.java]

        //luego de crear el Adapter creo las siguientes 3 lineas y la ultima
        val adapterVideoGame = VideoGameAdapter()
        binding.vgRecycler.adapter = adapterVideoGame
        binding.vgRecycler.layoutManager= LinearLayoutManager(this)

        viewModel.videoGameLV.observe(this){
            Log.i("GAMES", it.toString())
            adapterVideoGame.videoGames= it

        }

    }
}