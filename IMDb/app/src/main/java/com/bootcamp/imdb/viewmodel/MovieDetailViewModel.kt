package com.bootcamp.imdb.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bootcamp.imdb.RetrofitApi
import com.bootcamp.imdb.api.TMDBStringsAdapter
import com.bootcamp.imdb.model.DataPeliculaResolved
import com.bootcamp.imdb.model.DetallePelicula
import com.bootcamp.imdb.model.ModelConstant.EMPTY_RESOLVED
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailViewModel : ViewModel() {

    var pelicula : DetallePelicula? by mutableStateOf(null)
    var MovieDetailResolved : DataPeliculaResolved by mutableStateOf(EMPTY_RESOLVED)
    val r = TMDBStringsAdapter()

    fun apiCallDetailMovie(movieId : Int){
        val apiInterface = RetrofitApi.create().getMovieDetail(movieId)
        apiInterface.enqueue(object : Callback<DetallePelicula> {
            override fun onResponse(call: Call<DetallePelicula>, response: Response<DetallePelicula>) {
                pelicula  = response.body()
                processModel(pelicula!!)
            }

            override fun onFailure(call: Call<DetallePelicula>, t: Throwable) {
                Log.e("ERROR", t.toString())
            }
        })
    }

    fun processModel(
        movie : DetallePelicula,
        titleLength: Int = 28,
        overviewLength: Int = 118,
        originalTitleLength: Int = 31,
        genresLength: Int = 17
    )  {
        MovieDetailResolved = DataPeliculaResolved(
            movie.id,
            r.titleResolver(movie.title, titleLength),
            r.voteAvrResolver(movie.vote_average),
            r.relDateResolver(movie.release_date),
            r.overviewResolver(movie.overview, overviewLength),
            r.posterPathResolver(movie.poster_path),
            r.originalTitleResolver(movie.original_title, originalTitleLength),
            r.backDropPathResolver(movie.backdrop_path),
            r.genreResolver(movie.genres, genresLength),
        )
    }
}