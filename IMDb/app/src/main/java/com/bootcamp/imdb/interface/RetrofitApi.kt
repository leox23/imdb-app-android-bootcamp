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

