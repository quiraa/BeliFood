package com.quiraadev.goculinary.ui.screens.profile

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.quiraadev.goculinary.R
import com.quiraadev.goculinary.ui.fonts.PlusJakartaSans

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val isDarkMode by profileViewModel.isDarkMode

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_placeholder),
            contentDescription = "Profile Image",
            modifier = Modifier
                .padding(32.dp)
                .aspectRatio(1f / 1f)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(id = R.string.name),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = PlusJakartaSans
        )
        Text(
            text = stringResource(id = R.string.mail),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = PlusJakartaSans
        )
        Spacer(modifier = Modifier.height(24.dp))
        ElevatedButton(
            onClick = {
                val github = "https://github.com/quiraa"
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(github)))
            }, modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.github),
                contentDescription = stringResource(id = R.string.github)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = R.string.github),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                fontFamily = PlusJakartaSans
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedButton(
            onClick = {
                val instagram = "https://www.instagram.com/aryadzkr/"
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(instagram)))
            }, modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.instagram),
                contentDescription = stringResource(id = R.string.instagram),
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = R.string.instagram),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                fontFamily = PlusJakartaSans
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedButton(
            onClick = {
                profileViewModel.setDarkMode(!isDarkMode)
            }, modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Icon(
                painter = if (isDarkMode) painterResource(id = R.drawable.light_theme) else painterResource(
                    id = R.drawable.dark_theme
                ),
                contentDescription = "Theme Button",
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = if (isDarkMode) "Change to Light Theme" else "Change to Dark Theme",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                fontFamily = PlusJakartaSans
            )
        }
    }
}