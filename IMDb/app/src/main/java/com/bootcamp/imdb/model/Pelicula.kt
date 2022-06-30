package com.bootcamp.imdb.model

data class Pelicula (
    val id: String,
    val title: String,
    val vote_average: Double,
    val release_date: String,
    val overview: String,
    val poster_path: String
)

data class DetallePelicula (
    val id: String,
    val title: String,
    val vote_average: Double,
    val release_date: String,
    val overview: String,
    val poster_path: String,

    val original_title : String,
    val backdrop_path : String,
    val genres : List<Int>,
)