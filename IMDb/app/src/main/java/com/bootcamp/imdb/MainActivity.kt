package com.bootcamp.imdb

import kotlinx.android.synthetic.main.activity_main.recyclerMovies
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.imdb.adapter.MovieAdapter
import com.bootcamp.imdb.lorem.MovieProvider
import com.bootcamp.imdb.navigation.AppNavigation
import com.bootcamp.imdb.ui.theme.IMDbTheme
import kotlinx.android.synthetic.main.activity_main.view.*

//luego cuando no necesite regresar a importar quitare los imports



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMDbTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AppNavigation()
                    //leyendoXml()
                }
            }
        }



    }
}
@Composable
fun leyendoXml() {
    AndroidView(
        factory = { context: Context ->
            val view = LayoutInflater.from(context)
                .inflate(R.layout.activity_main, null, false)
            view
        },
        update = { view ->
            val recyclerView = view.recyclerMovies
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.adapter = MovieAdapter(MovieProvider.movieList)
        }
    )
}

