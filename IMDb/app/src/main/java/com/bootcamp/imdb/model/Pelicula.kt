package com.bootcamp.imdb.model

data class Pelicula (
    val id: String,
    val title: String,
    val vote_average: Double,
    val release_date: String,
    val overview: String,
    val poster_path: String
)
