package com.bootcamp.imdb.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.imdb.databinding.ListItemMovieBinding
import com.bumptech.glide.Glide
import com.bootcamp.imdb.lorem.Movie

class MovieViewHolder( view : View):RecyclerView.ViewHolder(view) {
    private val binding = ListItemMovieBinding.bind(view)

    val title = binding.movieName
    val age =  binding.movieAge
    val description = binding.movieDescription
    val image = binding.movieFeaturedImage

    fun render(movieModel : Movie){
        title.text = movieModel.title
        age.text = movieModel.age.toString()
        description.text = movieModel.description
        Glide.with(image.context).load(movieModel.featuredImage).into(image)
    }
}