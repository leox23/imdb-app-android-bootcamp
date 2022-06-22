package com.bootcamp.imdb.model

data class MovieDetail(
    val originalTitle : String,
    val trailerImage : String,
    val genre : String,
    var isSerie : Boolean?,
    var emissionTime : String?,
    var chapters : Int?
)