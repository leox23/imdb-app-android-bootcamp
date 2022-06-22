package com.bootcamp.imdb.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bootcamp.imdb.respository.MovieDetailProvider.Companion.movieDetailList
import com.bootcamp.imdb.respository.MovieProvider.Companion.movieList

class MovieDetailViewModel : ViewModel() {
    var id : Int? by mutableStateOf(null)
    var title by mutableStateOf("")
    var rating by mutableStateOf("")
    var year by mutableStateOf("")
    var description by mutableStateOf("")
    var featuredImage by mutableStateOf("")

    var originalTitle by mutableStateOf("")
    var trailerImage by mutableStateOf("")
    var genre by mutableStateOf("")
    var isSerie : Boolean? by mutableStateOf(null)
    var emissionTime : String? by mutableStateOf(null)
    var chapters : Int? by mutableStateOf(null)

    fun onMovieSearchResultClick(index : Int){
        id = movieList[index].id
        title = movieList[index].title
        rating = movieList[index].rating.toString()
        year = movieList[index].year.toString()
        description = movieList[index].description
        featuredImage = movieList[index].featuredImage

        originalTitle = movieDetailList[index].originalTitle
        trailerImage = movieDetailList[index].trailerImage
        genre = movieDetailList[index].genre
        isSerie = movieDetailList[index].isSerie
        emissionTime = movieDetailList[index].emissionTime
        chapters = movieDetailList[index].chapters
    }

}