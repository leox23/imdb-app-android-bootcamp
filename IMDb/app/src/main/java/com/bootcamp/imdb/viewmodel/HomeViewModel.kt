package com.bootcamp.imdb.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.imdb.RetrofitApi
import com.bootcamp.imdb.api.model.TopRatedApiModel
import com.bootcamp.imdb.model.PeliculasMejorCalificadas
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() { //todo pendiente refactor, quiza sea posible lograr trabajar con los id de Movie, en ves de ids locales aca, aunque quisa sea mas facil asi pora pasar argumentos en navegacion
    init {
        viewModelScope.launch {
            getTopRatedMovieList()
        }
    }

    var selectedHomeMovie : Int? by mutableStateOf(null)
    var featuredMovie : PeliculasMejorCalificadas? by mutableStateOf(null)

    var peliculasMasPuntuadas : List<PeliculasMejorCalificadas> by mutableStateOf(listOf())

    fun getTopRatedMovieList() {
        val apiInterface = RetrofitApi.create().getTopRatedMovies()
        apiInterface.enqueue(object : Callback<TopRatedApiModel> {
            override fun onResponse(call: Call<TopRatedApiModel>, response: Response<TopRatedApiModel>) {
                peliculasMasPuntuadas = response.body()?.results?.shuffled() ?: listOf()
                featuredHomeMovie()
            }

            override fun onFailure(call: Call<TopRatedApiModel>, t: Throwable) {
                Log.e("ERROR", t.toString())
            }
        })
    }

    fun featuredHomeMovie() {
        selectedHomeMovie = (7..19).random()
        featuredMovie = peliculasMasPuntuadas[selectedHomeMovie!!]
    }



}
