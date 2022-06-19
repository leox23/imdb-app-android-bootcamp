package com.bootcamp.imdb.ui.screens.main_screen

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.imdb.R
import com.bootcamp.imdb.adapter.MovieAdapter
import com.bootcamp.imdb.databinding.ActivityMainBinding
import com.bootcamp.imdb.lorem.MovieProvider
import com.bootcamp.imdb.ui.components.SearchItemList
import com.bootcamp.imdb.ui.theme.Black
import com.bootcamp.imdb.ui.theme.IMDbTheme
import com.bootcamp.imdb.ui.theme.White_Smoke

@SuppressLint("InflateParams")
@Composable
fun SearchScreen() {
    Scaffold(
        topBar = { TopBar() },
        backgroundColor = White_Smoke
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            //MovieDetail() //esta es la descriocion del item seleccionado
            SearchItemList(
                "https://image.tmdb.org/t/p/w185_and_h278_bestv2/bnuC6hu7AB5dYW26A3o6NNLlIlE.jpg",
                "Godzilla vs Kong",
                "2022",
                "Godzilla es una pelicula que cuenta la pelea entre bla bla bla..."
            )
            SearchItemList(
                "https://image.tmdb.org/t/p/w185_and_h278_bestv2/bnuC6hu7AB5dYW26A3o6NNLlIlE.jpg",
                "Godzilla vs Kong",
                "2022",
                "Godzilla es una pelicula que cuenta la pelea entre bla bla bla..."
            )
            SearchItemList(
                "https://image.tmdb.org/t/p/w185_and_h278_bestv2/bnuC6hu7AB5dYW26A3o6NNLlIlE.jpg",
                "Godzilla vs Kong",
                "2022",
                "Godzilla es una pelicula que cuenta la pelea entre bla bla bla..."
            )
            // todo debe ir una barra de busqueda que pueda dar resultados del recycleView creado en Android view


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
    }
}



@Preview()
@Composable
fun SearchScreenPreview() {
    IMDbTheme {
        SearchScreen()
    }
}


/*
######################################################################
  lo siguiente es para colocar en un componente aparte
######################################################################
*/

@Composable
fun TopBar(){
    TopAppBar(
        title = { Text("Mi titulo de barra de busqueda") },
        backgroundColor = White_Smoke,
        contentColor = Black
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
    TopBar()
}



@Composable
fun SearchView(){
    val state = remember { mutableStateOf(TextFieldValue()) }

        TextField(
            value = state.value,
            onValueChange = { value ->
                state.value = value
            },
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = TextStyle(
                color = Black,
                fontSize = 10.sp),
            //falta leading icon y trailing icon
        )

}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    SearchView()
}