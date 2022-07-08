package com.bootcamp.imdb.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
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
        NavHost(
            navController,
            startDestination = ViewsNavRoutes.MainScreen.route,
            Modifier.padding(innerPadding)
        ) { MainNav(navController) }
    }
}



