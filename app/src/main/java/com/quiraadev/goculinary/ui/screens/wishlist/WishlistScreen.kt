package com.quiraadev.goculinary.ui.screens.wishlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.quiraadev.goculinary.data.local.CulinaryEntity
import com.quiraadev.goculinary.ui.components.AvailableWishlistContent
import com.quiraadev.goculinary.ui.components.EmptyContent
import com.quiraadev.goculinary.ui.components.ErrorContent
import com.quiraadev.goculinary.ui.components.LoadingContent
import com.quiraadev.goculinary.utils.UiState

@Composable
fun WishlistScreen(
    navController: NavHostController,
    wishlistViewModel: WishlistViewModel = hiltViewModel()
) {

    wishlistViewModel.allWishlistedItem.collectAsState().value.let { uiState ->
        when (uiState) {
            is UiState.Error -> ErrorContent()
            is UiState.Loading -> LoadingContent()
            is UiState.Success -> {
                WishlistContent(
                    listOfWishlist = uiState.data,
                    navController = navController,
                    onUpdateWishlistedItem = wishlistViewModel::updateWishlistedItem
                )
            }
        }
    }

}

@Composable
fun WishlistContent(
    listOfWishlist: List<CulinaryEntity>,
    navController: NavHostController,
    onUpdateWishlistedItem: (itemdId: Int, isWishlisted: Boolean) -> Unit
) {
    when (listOfWishlist.isEmpty()) {
        true -> EmptyContent()
        false -> AvailableWishlistContent(
            culinaries = listOfWishlist,
            navController = navController,
            onUpdateWishlistedItem = onUpdateWishlistedItem
        )
    }
}