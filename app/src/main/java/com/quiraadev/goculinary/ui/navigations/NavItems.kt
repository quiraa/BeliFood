package com.quiraadev.goculinary.ui.navigations

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.quiraadev.goculinary.R
import com.quiraadev.goculinary.ui.fonts.PlusJakartaSans

data class NavItems(
    val label: String,
    val icon: Painter,
    val screen: Screen
)

@Composable
fun BottomNavBar(
    navController: NavHostController,
    currentRoute: String?
) {
    val navItems = listOf(
        NavItems(
            "Home",
            painterResource(id = R.drawable.home),
            Screen.Home
        ),
        NavItems(
            "Wishlist",
            painterResource(id = R.drawable.wishlist),
            Screen.Wishlist
        ),
        NavItems(
            "Profile",
            painterResource(id = R.drawable.profile),
            Screen.Profile
        ),
    )

    NavigationBar {
        navItems.forEach { items ->
            NavigationBarItem(
                selected = currentRoute == items.screen.route,
                onClick = {
                    navController.navigate(items.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(painter = items.icon, contentDescription = "Icon")
                },
                label = {
                    Text(text = items.label, fontFamily = PlusJakartaSans)
                },
            )
        }
    }
}
