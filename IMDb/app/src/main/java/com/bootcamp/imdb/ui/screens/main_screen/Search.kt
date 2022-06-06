package com.bootcamp.imdb.ui.screens.main_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bootcamp.imdb.ui.screens.MovieDetail
import com.bootcamp.imdb.ui.theme.IMDbTheme

@Composable
fun SearchScreen() {

    MovieDetail()

    /* todo debe ir una barra de busqueda que pueda dar resultados del recycleView creado en Android view
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

     */
}


@Preview()
@Composable
fun SearchScreenPreview() {
    IMDbTheme {
        SearchScreen()
    }
}
