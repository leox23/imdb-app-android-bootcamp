package com.bootcamp.imdb.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.imdb.RetrofitApi
import com.bootcamp.imdb.api.model.MoviesApiModel
import com.bootcamp.imdb.model.Peliculas
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
    var peliculas : List<Peliculas> by mutableStateOf(listOf())
    var filteredMovies by mutableStateOf(peliculas)

    private fun getMovieList() {
        val apiInterface = RetrofitApi.create().getMovies()
        apiInterface.enqueue(object : Callback<MoviesApiModel> {
            override fun onResponse(call: Call<MoviesApiModel>, response: Response<MoviesApiModel>) {
                peliculas = response.body()?.items ?: listOf()
            }

            override fun onFailure(call: Call<MoviesApiModel>, t: Throwable) {
                Log.e("ERROR", t.toString())
            }
        })
    }

    fun onSearchChange(onChange: String) {
        search = onChange
        filteredMovies = peliculas.filter {
            it.title.lowercase().contains(search.lowercase())
        }
    }
}