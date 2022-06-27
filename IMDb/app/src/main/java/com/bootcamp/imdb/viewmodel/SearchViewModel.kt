package com.bootcamp.imdb.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bootcamp.imdb.di.MovieProvider.Companion.movieList

class SearchViewModel : ViewModel() {
    var search by mutableStateOf("")
    var filteredMovies by mutableStateOf(movieList)

    fun onSearchChange(onChange: String) {
        search = onChange
        filteredMovies = movieList.filter {
            it.title.lowercase().contains(search.lowercase())
        }
    }

}