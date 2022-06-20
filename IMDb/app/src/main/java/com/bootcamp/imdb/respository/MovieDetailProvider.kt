package com.bootcamp.imdb.respository

import com.bootcamp.imdb.model.MovieDetail

class MovieDetailProvider {
    companion object {
        val movieDetailList = listOf(
            MovieDetail(
                "titulo original",
                "url de la imagen del trailer",
                "genero accion?",
                null,
                null,
                null
            ),
            MovieDetail(
                "titulo original",
                "url de la imagen del trailer",
                "genero accion?",
                null,
                null,
                null
            )
        )
    }
}