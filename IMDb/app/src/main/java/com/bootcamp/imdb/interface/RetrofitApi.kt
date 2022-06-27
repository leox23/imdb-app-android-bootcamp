package com.bootcamp.imdb

import com.bootcamp.imdb.model.MovieDB
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {
    @GET("list/1")
    fun getMovies(@Query("api_key") api_key: String = "c5c47722a4adcc77f6e84f28a48b857a"): Call<MovieDB>

    //url de las series
    // https://api.themoviedb.org/3/discover/tv?api_key=c5c47722a4adcc77f6e84f28a48b857a&language=en-US&sort_by=popularity.desc&page=1&timezone=America%2FNew_York&include_null_first_air_dates=false&with_watch_monetization_types=flatrate&with_status=0&with_type=0&language=es-ES

    //detalles de las series
    //https://api.themoviedb.org/3/tv/1?api_key=c5c47722a4adcc77f6e84f28a48b857a&language=en-US

    //url de las pelis
    //https://api.themoviedb.org/3/list/1?api_key=c5c47722a4adcc77f6e84f28a48b857a&language=es-ES

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        fun create(): RetrofitApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetrofitApi::class.java)
        }
    }

}


