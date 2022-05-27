package com.bootcamp.imdb.navigation


sealed class OthersViews (val route : String){
    object Splash : OthersViews(route = "splash")
    object Login : OthersViews(route = "login")
    object Register : OthersViews(route = "register")
    object Search : OthersViews(route = "search")

}

