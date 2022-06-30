package com.bootcamp.imdb.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bootcamp.imdb.RetrofitApi
import com.bootcamp.imdb.model.MovieDB
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitViewModel : ViewModel() {

    val apiInterface = RetrofitApi.create().getMovies()
    fun callList(){
        apiInterface.enqueue(object : Callback<MovieDB> {
            override fun onResponse(call: Call<MovieDB>, response: Response<MovieDB>) {
                val peliculas = response.body()?.items ?: listOf()
                Log.d("lista leida: ",peliculas[0].toString())
            }

            override fun onFailure(call: Call<MovieDB>, t: Throwable) {
                Log.e("ERROR", t.toString())
            }
        })
    }
}