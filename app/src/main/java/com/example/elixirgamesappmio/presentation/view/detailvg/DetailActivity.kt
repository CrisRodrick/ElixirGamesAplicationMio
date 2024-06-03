package com.example.elixirgamesappmio.presentation.view.detailvg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.elixirgamesappmio.data.network.api.VideoGameService
import com.example.elixirgamesappmio.data.network.retrofit.RetrofitHelper
import com.example.elixirgamesappmio.data.repository.VideoGameImpl
import com.example.elixirgamesappmio.databinding.ActivityDetailBinding
import com.example.elixirgamesappmio.domain.VideoGameUseCase
import com.example.elixirgamesappmio.presentation.viewModel.detailvg.DetailViewModel
import com.example.elixirgamesappmio.presentation.viewModel.detailvg.ViewModelDetailFactory
import com.squareup.picasso.Picasso

class DetailActivity: AppCompatActivity() {
    private lateinit var bindingDetail : ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingDetail = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(bindingDetail.root)


        val idVideogame = intent.getLongExtra("ID_VIDEO_GAME", -1)
        if (idVideogame == -1L) {   //comprobacion y evito que se caiga
            finish()
            return
        }

        val apiService = RetrofitHelper.getRetrofit().create(VideoGameService::class.java)
        val repository = VideoGameImpl(apiService)
        val useCase = VideoGameUseCase(repository)
        val viewModelFactory = ViewModelDetailFactory(useCase)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        viewModel.getDetailVideoGameById(idVideogame)

        viewModel.videoGameDetailLV.observe(this){
          //  Log.i("DetailsActivity", it.toString())
            //como ya tengo datos del xml de los detalles, puedo pintar mi vista

            with(it){
                bindingDetail.txtNameVideoGame.text = name
                bindingDetail.ratingBar.rating = rating.toFloat()
                bindingDetail.txtReleasedVideoGame.text = released
                bindingDetail.txtGenre.text = genres
                bindingDetail.txtMetacritic.text = metacritic.toString()
                bindingDetail.txtPrice.text = price.toString()
                bindingDetail.txtLastPrice.text = lastPrice.toString()
                bindingDetail.txtPlatform.text = platforms
                Picasso
                    .get()
                    .load(backgroundImage)
                    .into(bindingDetail.imgVideoGame)



            }

        }

    }

}
