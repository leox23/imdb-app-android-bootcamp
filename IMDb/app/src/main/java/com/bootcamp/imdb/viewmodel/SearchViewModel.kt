package com.bootcamp.imdb.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.imdb.RetrofitApi
import com.bootcamp.imdb.api.model.MovieDB
import com.bootcamp.imdb.model.Pelicula
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {
    init {
        viewModelScope.launch {
            getMovieList()
        }
    }
    var search by mutableStateOf("")
    var peliculas : List<Pelicula> by mutableStateOf(listOf())
    var filteredMovies by mutableStateOf(peliculas)

    fun onSearchChange(onChange: String) {
        search = onChange
        filteredMovies = peliculas.filter {
            it.title.lowercase().contains(search.lowercase())
        }
    }

    fun getMovieList() {
        val apiInterface = RetrofitApi.create().getMovies()
        apiInterface.enqueue(object : Callback<MovieDB> {
            override fun onResponse(call: Call<MovieDB>, response: Response<MovieDB>) {
                peliculas = response.body()?.items ?: listOf()
            }

            override fun onFailure(call: Call<MovieDB>, t: Throwable) {
                Log.e("ERROR", t.toString())
            }
        })
    }

}