package com.bootcamp.imdb.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bootcamp.imdb.ui.components.SplashIntro
import com.bootcamp.imdb.ui.screens.MovieDetail
import com.bootcamp.imdb.ui.screens.Register
import com.bootcamp.imdb.ui.screens.StandartLogin
import com.bootcamp.imdb.ui.screens.main_screen.HomeScreen
import com.bootcamp.imdb.ui.screens.main_screen.PlayScreen
import com.bootcamp.imdb.ui.screens.main_screen.SearchScreen
import com.bootcamp.imdb.ui.screens.main_screen.UserScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ViewsNavRoutes.LoginPath.route
    ) {

        splashAndLogin(navController)
        composable(route = BottomBarScreen.Home.route) {
            ButtomNav()
        }

    }
}

fun NavGraphBuilder.splashAndLogin(navController: NavController) {
    navigation(startDestination = ViewsNavRoutes.Splash.route, route = ViewsNavRoutes.LoginPath.route) {
        composable(route = ViewsNavRoutes.Splash.route) {
            SplashIntro(navController = navController)
        }
        composable(route = ViewsNavRoutes.Login.route) {
            BackHandler(true) {}             //para finalmente persistir
            StandartLogin(navController = navController, viewModel())
        }
        composable(route = ViewsNavRoutes.Register.route) {
            Register(navController = navController, viewModel())
        }
    }
}


fun NavGraphBuilder.MainNav(navController: NavController) {
    navigation(startDestination = BottomBarScreen.Home.route, route = ViewsNavRoutes.MainScreen.route) {
        composable(route = BottomBarScreen.Home.route) {
            BackHandler(true) {}
            HomeScreen(viewModel())
        }

        searchAndDetail(navController)

        composable(route = BottomBarScreen.Play.route) {
            PlayScreen()
        }

        composable(route = BottomBarScreen.User.route) {
            UserScreen()
        }
    }
}

fun NavGraphBuilder.searchAndDetail(navController: NavController) {
    navigation(startDestination = BottomBarScreen.Search.route, route = ViewsNavRoutes.SearchPath.route){
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(navController,viewModel())
        }

        val routeMDetailAndData = "${ViewsNavRoutes.MovieDetail.route}/{argument}"
        composable(
            routeMDetailAndData,
            arguments = listOf(navArgument(name = "argument"){})
        ){ navEntry ->
            MovieDetail( navEntry.arguments?.getString("argument"), navController, viewModel())
        }
    }
}



