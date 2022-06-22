package com.bootcamp.imdb.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class OthersViews (val route : String){
    object LoginPath : OthersViews(route = "loginPath")
    object Splash : OthersViews(route = "splash")
    object Login : OthersViews(route = "login")
    object Register : OthersViews(route = "register")
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

