package com.bootcamp.imdb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bootcamp.imdb.ui.screens.HomeScreen
import com.bootcamp.imdb.ui.screens.PlayScreen
import com.bootcamp.imdb.ui.screens.SearchScreen
import com.bootcamp.imdb.ui.screens.UserScreen

@Composable
fun BottomNavGraph(navController : NavHostController){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
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


