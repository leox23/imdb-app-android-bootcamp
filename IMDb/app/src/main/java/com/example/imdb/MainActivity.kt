package com.example.imdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.example.imdb.ui.theme.IMDbTheme
//luego cuando no necesite regresar a importar quitare los imports



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*
// aqui la actividad de recycle view
        setContentView(R.layout.activity_main)
        val recyclerView = recyclerMovies
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieAdapter(MovieProvider.movieList)
*/
        setContent {
            IMDbTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AppInit()
                }
            }
        }



    }
}


/*
@Preview(showBackground = true)
@Composable
fun StandartLoginPreview() {
    IMDbTheme {
        StandartLogin(navController = navController)
        //Greeting()
        //Register()
    }
}
*/
