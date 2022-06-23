package com.bootcamp.imdb.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bootcamp.imdb.model.Movie
import com.bootcamp.imdb.respository.MovieDetailProvider.Companion.movieDetailList
import com.bootcamp.imdb.respository.MovieProvider.Companion.movieList

class HomeViewModel : ViewModel() { //todo pendiente refactor, quiza sea posible lograr trabajar con los id de Movie, en ves de ids locales aca, aunque quisa sea mas facil asi pora pasar argumentos en navegacion
    var selectedHomeMovie : Int? by mutableStateOf(null)
    var last : Int = movieList.size - 1
    var titleTrailer by mutableStateOf("")
    var trailerImage by mutableStateOf("")
    var coverImage by mutableStateOf("")
    var description by mutableStateOf("")

    var carouselItemsId : MutableList<Int> by mutableStateOf(mutableListOf(0,0,0,0,0,0,0))
    var carouselItems : List<Movie>? by mutableStateOf(null)
    var ranVal : Int? = null

    fun featuredHomeMovie() {
        selectedHomeMovie = (0..last).random()
        titleTrailer = movieList[selectedHomeMovie!!].title
        trailerImage = movieDetailList[selectedHomeMovie!!].trailerImage
        coverImage = movieList[selectedHomeMovie!!].featuredImage
        description = movieList[selectedHomeMovie!!].description
    }

    fun carouselItems() {
        //todo los items del carousel deberian ser solo los 7 con mayor rating, queda asi por ahora
        var i : Int = 0
        while(i <= 6){
            ranVal = (0..last).random()
            if (!carouselItemsId.contains(ranVal) && ranVal != selectedHomeMovie){
                carouselItemsId[i] = ranVal as Int
                i++
            }
        }
        carouselItems = movieList.filter{
            carouselItemsId.contains(it.id)
        }.shuffled()
    }

}
