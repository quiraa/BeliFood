@file:OptIn(ExperimentalMaterial3Api::class)

package com.quiraadev.goculinary.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.quiraadev.goculinary.R
import com.quiraadev.goculinary.data.local.CulinaryEntity
import com.quiraadev.goculinary.ui.fonts.PlusJakartaSans
import com.quiraadev.goculinary.ui.navigations.Screen

@Composable
fun AvailableContent(
    culinaries: List<CulinaryEntity>,
    navController: NavHostController,
    onUpdateWishlistedItem: (id: Int, isWishlisted: Boolean) -> Unit
) {
    return LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp)) {
        items(items = culinaries, key = { it.name }) { culinary ->
            CulinaryCardItem(
                culinary = culinary,
                navController = navController,
                onUpdateWishlistedItem = onUpdateWishlistedItem
            )
        }
    }
}

@Composable
fun CulinaryCardItem(
    culinary: CulinaryEntity,
    navController: NavHostController,
    onUpdateWishlistedItem: (id: Int, isWishlisted: Boolean) -> Unit
) {
    val (id, name, photoUrl, _, _, rating, _, totalReview, isWishlisted) = culinary

    return ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            navController.navigate(Screen.Detail.createRoute(id ?: 0))
        }
    ) {
        Box(modifier = Modifier.wrapContentSize()) {
            AsyncImage(
                model = photoUrl,
                contentDescription = "",
                placeholder = painterResource(id = R.drawable.img_placeholder),
                error = painterResource(id = R.drawable.img_error),
                contentScale = ContentScale.Crop,
                modifier = Modifier.aspectRatio(16f / 10f)
            )
            IconButton(onClick = {
                onUpdateWishlistedItem(id ?: 0, !isWishlisted)
            }, modifier = Modifier.align(Alignment.TopEnd)) {
                Icon(
                    imageVector = if (isWishlisted) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                    contentDescription = "Wishlist Icon",
                    tint = if (isWishlisted) Color.Red else Color.White
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Rating Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(8.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "$rating Rating",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Medium,
                    fontFamily = PlusJakartaSans
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.users),
                    contentDescription = "Total Review Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(8.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "$totalReview Reviews",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Medium,
                    fontFamily = PlusJakartaSans
                )
            }
        }
    }
}