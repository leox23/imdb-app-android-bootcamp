package com.bootcamp.imdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.bootcamp.imdb.model.MovieDB
import com.bootcamp.imdb.navigation.AppNavigation
import com.bootcamp.imdb.ui.theme.IMDbTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.Toast
import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMDbTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val apiInterface = RetrofitApi.create().getMovies()

                    apiInterface.enqueue(object : Callback<MovieDB> {
                        override fun onResponse(call: Call<MovieDB>, response: Response<MovieDB>) {
                            //Toast.makeText(this, "respuesta: "+ response.body()?.items, Toast.LENGTH_LONG).show()
                            val peliculas = response.body()?.items ?: listOf()
                            Log.d("lista leida: ",peliculas[0].toString())

                        }

                        override fun onFailure(call: Call<MovieDB>, t: Throwable) {
                            Log.e("ERROR", t.toString())
                        }
                    })


                    AppNavigation()

                }
            }
        }
    }
}
