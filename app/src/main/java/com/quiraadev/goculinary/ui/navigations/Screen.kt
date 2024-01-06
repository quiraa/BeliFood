package com.quiraadev.goculinary.ui.navigations

sealed class Screen(val route : String) {
    object Home : Screen("home")
    object Wishlist : Screen("wishlist")
    object Profile : Screen("profile")
    object Detail : Screen("home/{culinaryId}") {
        fun createRoute(culinaryId : Int) = "home/$culinaryId"
    }
}