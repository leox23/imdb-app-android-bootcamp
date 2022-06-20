package com.bootcamp.imdb.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bootcamp.imdb.ui.screens.main_screen.HomeScreen
import com.bootcamp.imdb.ui.screens.main_screen.PlayScreen
import com.bootcamp.imdb.ui.screens.main_screen.SearchScreen
import com.bootcamp.imdb.ui.screens.main_screen.UserScreen
import com.bootcamp.imdb.ui.theme.Charcoal
import com.bootcamp.imdb.ui.theme.Mustard

@Composable
fun ButtomNav() {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Search,
        BottomBarScreen.Play,
        BottomBarScreen.User
    )
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                Modifier
                    .clip(
                        shape = RoundedCornerShape(
                            45,
                            45,
                            0,
                            0
                        )
                    ),
                backgroundColor = Mustard
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                screens.forEach { screen ->
                    BottomNavigationItem(
                        unselectedContentColor = Charcoal.copy(alpha = ContentAlpha.medium),
                        icon = { Icon(screen.icon, contentDescription = "Pantalla $screen.Title") },
                        label = { Text(screen.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost( //todo pendiente para colocar grafo al archivo de AppNavigation
            navController,
            startDestination = BottomBarScreen.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(route = BottomBarScreen.Home.route) {
                BackHandler(true) {}
                HomeScreen()
            }
            composable(route = BottomBarScreen.Search.route) {
                SearchScreen(viewModel())
            }
            composable(route = BottomBarScreen.Play.route) {
                PlayScreen()
            }
            composable(route = BottomBarScreen.User.route) {
                UserScreen()
            }
        }
    }
}