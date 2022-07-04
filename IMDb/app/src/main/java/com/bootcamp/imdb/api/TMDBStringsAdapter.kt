package com.bootcamp.imdb.api

import com.bootcamp.imdb.api.ApiConstants.IMAGE_W200
import com.bootcamp.imdb.api.ApiConstants.IMAGE_W500
import com.bootcamp.imdb.model.GenresOfMovie

// para facilitar el manejo de los strings por vistas y por distintos disdispositivos
class TMDBStringsAdapter {
    fun titleResolver(title : String, titleLength : Int, endChar : String = "...") : String {
        val result = if (title.length <= titleLength){
            title
        } else {
            "${title.slice(0..titleLength)} $endChar"
        }
        return result
    }

    fun voteAvrResolver(voteAvr : Double = 0.0) : String {
        return voteAvr.div(2).toString().slice(0..2)
    }

    fun relDateResolver( relDate : String ) : String{
        return relDate.slice(0..3)
    }

    fun overviewResolver(overview : String, overviewLength : Int) : String {
        val result = if (overview.length >= overviewLength){
            overview.slice(0..overviewLength) + "..."
        } else {
            overview
        }
        return result
    }

    fun posterPathResolver(imagePath : String) : String {
        return (IMAGE_W200 + imagePath).filter { !it.isWhitespace() }
    }

    fun originalTitleResolver(oTitle : String, originalTitleLength : Int) : String {
        val result = if (oTitle.length <= originalTitleLength){
            oTitle
        } else if (oTitle.length > originalTitleLength){
            "${oTitle.slice(0..originalTitleLength)} ..."
        } else {
            ""
        }
        return result
    }

    fun backDropPathResolver(imagePath : String) : String {
        return (IMAGE_W500 + imagePath).filter { !it.isWhitespace() }
    }

    fun genreResolver( genres : List<GenresOfMovie>, genresLength : Int) : String {
        val result =
        if (genres[0].name.length <= 10){
            ("${genres[0].name} | ${genres[1].name}")
                .slice(0..genresLength) + "."
        } else {
            "${genres[0].name}"
        }
        return result
    }
}