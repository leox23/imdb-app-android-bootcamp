package com.example.imdb

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imdb.screens.HomeScreen
import com.example.imdb.screens.PlayScreen
import com.example.imdb.screens.SearchScreen
import com.example.imdb.screens.UserScreen
import com.example.imdb.ui.components.SplashIntro
import com.example.imdb.ui.start_app.Register
import com.example.imdb.ui.start_app.StandartLogin

@Composable
fun BottomNavGraph(navController : NavHostController){
    NavHost(
        navController= navController,
        startDestination = OthersViews.Splash.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Search.route){
            SearchScreen()
        }
        composable(route = BottomBarScreen.Play.route){
            PlayScreen()
        }
        composable(route = BottomBarScreen.User.route){
            UserScreen()
        }
    }
}

@Composable
fun AppInit(){
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

    }
}

sealed class OthersViews (val route : String){
    object Splash : OthersViews (route = "splash")
    object Login : OthersViews (route = "login")
    object Register : OthersViews (route = "register")
}

