package com.bootcamp.imdb.model

class DataPeliculaResolved  (
    var id: String,
    var title: String,
    val vote_average: String,
    var release_date: String,
    var overview: String,
    var poster_path: String,
    val original_title : String,
    val backdrop_path : String,
    val genres : String
)

object ModelConstant {
    val EMPTY_RESOLVED = DataPeliculaResolved("","","","","","","","","")
}