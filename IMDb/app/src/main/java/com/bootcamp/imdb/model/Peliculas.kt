package com.bootcamp.imdb.model

data class Peliculas (
    var id: String,
    var title: String,
    var vote_average: Double,
    var release_date: String,
    var overview: String,
    var poster_path: String
)
