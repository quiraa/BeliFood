package com.quiraadev.goculinary.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.quiraadev.goculinary.data.local.CulinaryEntity
import com.quiraadev.goculinary.ui.components.AvailableContent
import com.quiraadev.goculinary.ui.components.EmptyContent
import com.quiraadev.goculinary.ui.components.ErrorContent
import com.quiraadev.goculinary.ui.components.LoadingContent
import com.quiraadev.goculinary.ui.components.SearchField
import com.quiraadev.goculinary.utils.UiState

@Composable
fun HomeScreen(navController: NavHostController, homeViewModel : HomeViewModel = hiltViewModel()) {
    val homeState by homeViewModel.homeState

    homeViewModel.allCulinary.collectAsState(UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> LoadingContent()
            is UiState.Error -> ErrorContent()
            is UiState.Success -> {
                HomeContent(
                    culinaries = uiState.data,
                    navController = navController,
                    query = homeState.query,
                    onQueryChange = homeViewModel::onQueryChange,
                    onUpdateWishlistedItem = homeViewModel::updateWishlistedCulinary
                )
            }
        }
    }
}

@Composable
fun HomeContent(
    culinaries: List<CulinaryEntity>,
    navController: NavHostController,
    query: String,
    onQueryChange: (newQuery: String) -> Unit,
    onUpdateWishlistedItem: (id: Int, isWishlisted: Boolean) -> Unit
) {
    return Column {
        SearchField(query = query, onQueryChange = onQueryChange)
        when (culinaries.isEmpty()) {
            true -> EmptyContent()
            false -> AvailableContent(
                culinaries = culinaries,
                navController = navController,
                onUpdateWishlistedItem = onUpdateWishlistedItem
            )
        }
    }
}