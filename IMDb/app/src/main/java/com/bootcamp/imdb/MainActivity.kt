package com.bootcamp.imdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.bootcamp.imdb.navigation.AppNavigation
import com.bootcamp.imdb.ui.theme.IMDbTheme
import com.bootcamp.imdb.viewmodel.RetrofitViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMDbTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    RetrofitViewModel().callList()
                    AppNavigation()
                }
            }
        }
    }
}
