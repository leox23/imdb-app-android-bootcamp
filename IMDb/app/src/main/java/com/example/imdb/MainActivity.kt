package com.example.imdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb.MovieProvider.Companion.movieList
import com.example.imdb.adapter.MovieAdapter
import com.example.imdb.ui.components.Greeting
import com.example.imdb.ui.login.StandartLogin
import com.example.imdb.ui.start_app.Register
import com.example.imdb.ui.theme.IMDbTheme
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.recyclerMovies
import kotlinx.android.synthetic.main.list_item_movie.*
//luego cuando no necesite regresar a importar quitare los imports



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

/* aqui la actividad de recycle view
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
                    StandartLoginPreview()

                    // otras vistas... (un no esta linkeada la navegacion)
                    //Greeting()
                    //Register()
                }
            }
        }



    }
}

@Preview(showBackground = true)
@Composable
fun StandartLoginPreview() {
    IMDbTheme {
        StandartLogin()
        //Greeting()
        //Register()
    }
}

