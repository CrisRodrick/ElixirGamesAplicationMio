package com.example.elixirgamesappmio.data.response

import com.google.gson.annotations.SerializedName

data class VideoGameResponse (
    val id: Long,
    val name: String,
    val released: String,
    @SerializedName("background_image") //se borra name e igual
    val backgroundImage: String,
    val metacritic: Long,
    val rating: Double

    /*se compara con el modelo de la API para ver si coinciden en cuanto a las
    variables, sino se eliminan las sobrates y hacen coincidir los nombres*/

)
