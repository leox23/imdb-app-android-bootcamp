package com.example.imdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb.Movie
import com.example.imdb.R

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.list_item_movie,parent,false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) { // llama a cada uno de los item y usan fun render
        val item = movieList[position]
        holder.render(item)
    }

    override fun getItemCount() = movieList.size //la cantidad de items que se mostraran

}