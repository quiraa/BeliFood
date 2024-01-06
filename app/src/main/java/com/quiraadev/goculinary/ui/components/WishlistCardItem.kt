@file:OptIn(ExperimentalMaterial3Api::class)

package com.quiraadev.goculinary.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.quiraadev.goculinary.R
import com.quiraadev.goculinary.data.local.CulinaryEntity
import com.quiraadev.goculinary.ui.fonts.PlusJakartaSans
import com.quiraadev.goculinary.ui.navigations.Screen


@Composable
fun AvailableWishlistContent(
    culinaries: List<CulinaryEntity>,
    navController: NavHostController,
    onUpdateWishlistedItem: (id: Int, isWishlisted: Boolean) -> Unit
) {
    return LazyColumn(contentPadding = PaddingValues(vertical = 8.dp)) {
        items(items = culinaries, key = { item -> item.name }) { culinary ->
            WishlistCardItem(
                culinary = culinary,
                navController = navController,
                onUpdateWishlistedItem = onUpdateWishlistedItem
            )
        }
        item {
            Text(
                text = "That's all for now",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium,
                fontFamily = PlusJakartaSans
            )
        }
    }
}

@Composable
fun WishlistCardItem(
    culinary: CulinaryEntity,
    navController: NavHostController,
    onUpdateWishlistedItem: (id: Int, isWishlisted: Boolean) -> Unit
) {
    val (id, name, photoUrl, description, _, _, _, _, isWishlisted) = culinary

    return ElevatedCard(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
        onClick = {
            navController.navigate(Screen.Detail.createRoute(id ?: 0))
        }
    ) {
        Row {
            AsyncImage(
                model = photoUrl,
                contentDescription = name,
                modifier = Modifier
                    .height(156.dp)
                    .aspectRatio(2f / 3f),
                placeholder = painterResource(id = R.drawable.img_placeholder),
                error = painterResource(id = R.drawable.img_error),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    fontFamily = PlusJakartaSans
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = PlusJakartaSans
                )
            }
            IconButton(onClick = {
                onUpdateWishlistedItem(id ?: 0, !isWishlisted)
            }, modifier = Modifier.padding(8.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = "Delete Icon",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}