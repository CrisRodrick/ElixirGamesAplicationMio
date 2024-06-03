package com.example.elixirgamesappmio.presentation.view.listvg

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.elixirgamesappmio.data.response.VideoGameResponse
import com.example.elixirgamesappmio.databinding.GameItemBinding
import com.squareup.picasso.Picasso


class VideoGameAdapter: RecyclerView.Adapter<VideoGameAdapter.ViewHolder>() {

    var videoGames= mutableListOf<VideoGameResponse>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {     //para notificar al recycleview que hay cambios
            field = value
            this.notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GameItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //este es el que pinta junta al viewHolder que se creara luego (por eso estaban en rojo)
        //se crea como Inner Class
        val videoGame = videoGames[position]
        holder.bindVideoGame(videoGame)
    }

    override fun getItemCount(): Int {
        return videoGames.size
    }

    inner class ViewHolder (private var binding: GameItemBinding): RecyclerView.ViewHolder(binding.root){
        //se crea la funcion en rojo en onBindViewHoldel
      //  private val imageView: ImageView = binding.img_videoGame
        fun bindVideoGame(viewvideoGame: VideoGameResponse){
            binding.viewvideoGame.setImageResource(0)
            Picasso.get()
                .load(viewvideoGame.backgroundImage)
                .centerCrop()
                .fit()
                .into(binding.viewvideoGame)

            //entre () salia url, se cambio
            // .resize(50, 50)  se lo saco y en .into(imageView) lo reemplazo
            //Picasso fue obtenido en la web

            binding.txtNameVideoGame.text= viewvideoGame.name
            binding.txtReleasedVideoGame.text= viewvideoGame.released
            binding.txtRatingVideoGame.text= viewvideoGame.rating.toString()

            //asegurate de que los parámetros de que los parametros de layout no cambien inesperadamente
            //con esto me aseguro que las imagenes se vean todas y no falte alguna por lo pesadas
            val layoutParams = binding.root.layoutParams as RecyclerView.LayoutParams
            layoutParams.height = RecyclerView.LayoutParams.WRAP_CONTENT
            binding.root.layoutParams = layoutParams

        }
    }
}

