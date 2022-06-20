package com.bootcamp.imdb.model

data class Movie(
    val id: Int,
    val title: String,
    val rating: Double,
    val year: Int,
    val description: String,
    val featuredImage: String
)
