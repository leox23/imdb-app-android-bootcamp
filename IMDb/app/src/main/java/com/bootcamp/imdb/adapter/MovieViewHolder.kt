package com.bootcamp.imdb.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bootcamp.imdb.lorem.Movie
import kotlinx.android.synthetic.main.list_item_movie.view.*

class MovieViewHolder( view : View):RecyclerView.ViewHolder(view) {
    val title = view.movieName
    val age =  view.movieAge
    val description = view.movieDescription
    val image = view.movieFeaturedImage

    fun render(movieModel : Movie){
        title.text = movieModel.title
        age.text = movieModel.age.toString()
        description.text = movieModel.description
        Glide.with(image.context).load(movieModel.featuredImage).into(image)
    }
}