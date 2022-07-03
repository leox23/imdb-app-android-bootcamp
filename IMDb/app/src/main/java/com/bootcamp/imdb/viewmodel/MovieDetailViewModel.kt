package com.bootcamp.imdb.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bootcamp.imdb.RetrofitApi
import com.bootcamp.imdb.model.DetallePelicula
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailViewModel : ViewModel() {
    var pelicula : DetallePelicula? by mutableStateOf(null)
    var originalTitleCutCheck : String by mutableStateOf("")
    var genreJoined : String by mutableStateOf("")
    var rating : String by mutableStateOf("")

    fun apicalldetailMovie(movieId : Int){
        val apiInterface2 = RetrofitApi.create().getMovieDetail(movieId)
        apiInterface2.enqueue(object : Callback<DetallePelicula> {
            override fun onResponse(call: Call<DetallePelicula>, response: Response<DetallePelicula>) {
                pelicula  = response.body()
                resolveTextsLength()
            }

            override fun onFailure(call: Call<DetallePelicula>, t: Throwable) {
                Log.e("ERROR", t.toString())
            }

        })
    }

    fun resolveTextsLength() {
        originalTitleCutCheck =
            if (pelicula?.original_title?.length!! >= 28){
                pelicula?.original_title?.slice(0..28) + "..."
            } else {
                (pelicula?.original_title)!!
            }

        genreJoined = "${pelicula!!.genres[0].name} | ${pelicula!!.genres[1].name}"
        if (genreJoined.length >= 17){
            genreJoined = genreJoined.slice(0..17) + "."
        }

        rating = pelicula?.vote_average?.div(2).toString()
    }
}