package com.bootcamp.imdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.imdb.lorem.Movie
import com.bootcamp.imdb.R
import com.bootcamp.imdb.databinding.ActivityMainBinding

class MovieAdapter( val movieList: List<Movie> ): RecyclerView.Adapter<MovieViewHolder>() {
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movieList[position]
        holder.render(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.list_item_movie,parent,false))
    }

    override fun getItemCount() = movieList.size

}