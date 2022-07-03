package com.bootcamp.imdb

import com.bootcamp.imdb.api.ApiConstants.API_KEY
import com.bootcamp.imdb.api.ApiConstants.BASE_URL
import com.bootcamp.imdb.model.DetallePelicula
import com.bootcamp.imdb.api.model.MovieDB
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApi {
    @GET("list/1")
    fun getMovies(
        @Query("api_key") api_key : String = API_KEY
    ): Call<MovieDB>

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movie_id : Int,
        @Query("api_key") api_key : String = API_KEY
    ): Call<DetallePelicula>

    companion object {
        fun create(): RetrofitApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetrofitApi::class.java)
        }
    }

}

