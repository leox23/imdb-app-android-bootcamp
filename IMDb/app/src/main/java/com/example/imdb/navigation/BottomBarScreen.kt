package com.example.imdb.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: ImageVector
        ) {
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
        icon = Icons.Default.PlayArrow
    )
    object  User : BottomBarScreen(
        route = "user",
        title = "User",
        icon = Icons.Default.Add
    )
}
