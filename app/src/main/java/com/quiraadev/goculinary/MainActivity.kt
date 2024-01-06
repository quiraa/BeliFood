package com.quiraadev.goculinary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.chibatching.kotpref.Kotpref
import com.example.compose.GoCulinaryTheme
import com.quiraadev.goculinary.ui.screens.profile.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Kotpref.init(this@MainActivity)
        setContent {
            val profileViewModel = hiltViewModel<ProfileViewModel>()
            GoCulinaryTheme(darkTheme = profileViewModel.isDarkMode.value) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        homeViewModel = hiltViewModel(),
                        detailViewModel = hiltViewModel(),
                        wishlistViewModel = hiltViewModel(),
                        profileViewModel = hiltViewModel()
                    )
                }
            }
        }
    }
}