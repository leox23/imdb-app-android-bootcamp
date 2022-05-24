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


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        //welcomeMessage.text = "Hello Kotlin desde el id directamten!"
        val recyclerView = recyclerMovies
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieAdapter(MovieProvider.movieList)
/*
        setContent {
            IMDbTheme {
                Surface(

                    modifier = Modifier.fillMaxSize()
                ) {
                    //Greeting()
                    //StandartLoginPreview()
                    //setContentView(R.layout.activity_main)
                }
            }
        }


 */

    }
}



/*
//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IMDbTheme {
        Greeting()
    }
}
*/


/*
@Preview(showBackground = true)
@Composable
fun StandartLoginPreview() {
    IMDbTheme {
        //Register()
        //Greeting()
        StandartLogin()
    }
}


 */

