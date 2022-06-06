package com.bootcamp.imdb.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.bootcamp.imdb.ui.components.SplashIntro
import com.bootcamp.imdb.ui.screens.Register
import com.bootcamp.imdb.ui.screens.StandartLogin

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "loginPath"
    ) {

        splashAndLogin(navController)

        composable(route = BottomBarScreen.Home.route) {
            ButtomNav()
        }

    }
}


fun NavGraphBuilder.splashAndLogin(navController: NavController) {
    navigation(startDestination = OthersViews.Splash.route, route = "loginPath") {
        composable(route = OthersViews.Splash.route) {
            SplashIntro(navController = navController)
        }
        composable(route = OthersViews.Login.route) {
            BackHandler(true) {}
            StandartLogin(navController = navController)
        }
        composable(route = OthersViews.Register.route) {
            Register(navController = navController)
        }
    }
}

