package com.bootcamp.imdb

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.bootcamp.imdb.navigation.AppNavigation
import com.bootcamp.imdb.ui.theme.IMDbTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMDbTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        App.setContext(this)
    }

    companion object {
        private lateinit var application: Application

        private fun setContext(app : App){
            App.application = app
        }

        fun getContext() : Context {
            return application
        }
    }
}