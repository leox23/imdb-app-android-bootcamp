package com.bootcamp.imdb.model

data class PeliculasMejorCalificadas (
    val id: String,
    val title: String,
    val vote_average: Double,
    val overview: String,
    val poster_path: String,
    val backdrop_path : String
)