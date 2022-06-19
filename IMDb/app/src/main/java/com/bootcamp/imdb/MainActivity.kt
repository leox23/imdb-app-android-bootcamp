package com.bootcamp.imdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.bootcamp.imdb.navigation.AppNavigation
import com.bootcamp.imdb.ui.components.Carousel
import com.bootcamp.imdb.ui.screens.Register
import com.bootcamp.imdb.ui.screens.StandartLogin
import com.bootcamp.imdb.ui.theme.IMDbTheme
import com.bootcamp.imdb.viewmodel.LoginViewModel
import com.bootcamp.imdb.viewmodel.RegisterViewModel

class MainActivity : ComponentActivity() {
    val registerViewModel by viewModels<RegisterViewModel>()
    val loginViewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMDbTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AppNavigation()
                    //StandartLogin(navController = NavController(this), loginViewModel)
                    //Register(navController = NavController(this), registerViewModel)
                /*
                aplicar viewmodel a la main screen en nava bar?? ver si es necesario

                crear lazycolumn en compose con su buscador

                aplicar room a los datos

                 */
                }
            }
        }
    }
}
