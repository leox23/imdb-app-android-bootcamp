package com.example.imdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.imdb.ui.components.Greeting
import com.example.imdb.ui.login.StandartLogin
import com.example.imdb.ui.start_app.Register
import com.example.imdb.ui.theme.IMDbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMDbTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    //Greeting()
                    StandartLoginPreview()
                }
            }
        }
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



@Preview(showBackground = true)
@Composable
fun StandartLoginPreview() {
    IMDbTheme {
        //Register()
        //Greeting()
        StandartLogin()
    }
}


