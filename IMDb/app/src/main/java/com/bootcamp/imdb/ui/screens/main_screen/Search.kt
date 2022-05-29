package com.bootcamp.imdb.ui.screens

import android.content.Context
import android.view.LayoutInflater
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.imdb.R
import com.bootcamp.imdb.adapter.MovieAdapter
import com.bootcamp.imdb.databinding.ActivityMainBinding
import com.bootcamp.imdb.lorem.MovieProvider
import com.bootcamp.imdb.ui.theme.IMDbTheme

@Composable
fun SearchScreen() {
    AndroidView(
        factory = { context: Context ->
            val view = LayoutInflater.from(context)
                .inflate(R.layout.activity_main, null, false)
            view
        },
        update = { view ->
            val binding = ActivityMainBinding.bind(view).recyclerMovies
            binding.layoutManager = LinearLayoutManager(binding.context)
            binding.adapter = MovieAdapter(MovieProvider.movieList)
        }
    )
}


@Preview()
@Composable
fun SearchScreenPreview() {
    IMDbTheme {
        SearchScreen()
    }
}
