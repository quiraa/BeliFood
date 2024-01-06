@file:OptIn(ExperimentalMaterial3Api::class)

package com.quiraadev.goculinary

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.quiraadev.goculinary.ui.navigations.BottomNavBar
import com.quiraadev.goculinary.ui.navigations.Screen
import com.quiraadev.goculinary.ui.screens.detail.DetailScreen
import com.quiraadev.goculinary.ui.screens.detail.DetailViewModel
import com.quiraadev.goculinary.ui.screens.home.HomeScreen
import com.quiraadev.goculinary.ui.screens.home.HomeViewModel
import com.quiraadev.goculinary.ui.screens.profile.ProfileScreen
import com.quiraadev.goculinary.ui.screens.profile.ProfileViewModel
import com.quiraadev.goculinary.ui.screens.wishlist.WishlistScreen
import com.quiraadev.goculinary.ui.screens.wishlist.WishlistViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    detailViewModel: DetailViewModel,
    wishlistViewModel: WishlistViewModel,
    profileViewModel: ProfileViewModel
) {
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    return Scaffold(bottomBar = {
        if (currentRoute != Screen.Detail.route) {
            BottomNavBar(navController = navController, currentRoute = currentRoute)
        }
    }) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController = navController, homeViewModel = homeViewModel)
            }
            composable(route = Screen.Detail.route, arguments = listOf(navArgument("culinaryId") {
                type = NavType.IntType
            })) {
                val culinaryId = it.arguments?.getInt("culinaryId") ?: 0
                DetailScreen(culinaryId, navController, detailViewModel = detailViewModel)
            }
            composable(Screen.Wishlist.route) {
                WishlistScreen(navController, wishlistViewModel = wishlistViewModel)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(profileViewModel = profileViewModel)
            }
        }
    }
}

