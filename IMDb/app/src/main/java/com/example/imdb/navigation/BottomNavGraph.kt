package com.example.imdb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.imdb.screens.HomeScreen
import com.example.imdb.screens.PlayScreen
import com.example.imdb.screens.SearchScreen
import com.example.imdb.screens.UserScreen

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


