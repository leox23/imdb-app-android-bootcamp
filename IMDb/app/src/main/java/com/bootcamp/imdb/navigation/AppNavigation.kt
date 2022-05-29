package com.bootcamp.imdb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bootcamp.imdb.ui.components.SplashIntro
import com.bootcamp.imdb.ui.session.Register
import com.bootcamp.imdb.ui.session.StandartLogin

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = OthersViews.Splash.route
    ) {
        composable(route = OthersViews.Splash.route) {
            SplashIntro(navController = navController)
        }
        composable(route = OthersViews.Login.route) {
            //ButtonExample(navController = navController)
            StandartLogin(navController = navController)
        }
        composable(route = OthersViews.Register.route) {
            Register(navController = navController)
        }
        composable(route = OthersViews.Search.route) {
            //Search(navController = navController)
        }

    }
}
