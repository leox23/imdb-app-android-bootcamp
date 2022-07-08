package com.bootcamp.imdb.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ViewsNavRoutes (val route : String){
    object LoginPath : ViewsNavRoutes(route = "loginPath")
    object Splash : ViewsNavRoutes(route = "splash")
    object Login : ViewsNavRoutes(route = "login")
    object Register : ViewsNavRoutes(route = "register")
    object MainScreen : ViewsNavRoutes(route = "mainScreen")
    object SearchPath : ViewsNavRoutes(route = "searchPath")
    object MovieDetail : ViewsNavRoutes(route = "movieDetail")
}

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: ImageVector
)
{
    object  Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object  Search : BottomBarScreen(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )
    object  Play : BottomBarScreen(
        route = "play",
        title = "Play",
        icon = Icons.Default.PlayArrow //todo buscar icono parecido
    )
    object  User : BottomBarScreen(
        route = "user",
        title = "User",
        icon = Icons.Default.AccountBox //todo buscar icono parecido
    )
}

