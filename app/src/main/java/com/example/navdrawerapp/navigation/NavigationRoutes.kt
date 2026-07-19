package com.example.navdrawerapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * File NavigationRoutes.kt
 * =======================
 * Mendefinisikan rute dan metadata untuk setiap layar.
 */
sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Profile : Screen("profile", "Profile", Icons.Default.Person)
    object Settings : Screen("settings", "Settings", Icons.Default.Settings)
    object Notifications : Screen("notifications", "Notifications", Icons.Default.Notifications)
    object Favorites : Screen("favorites", "Favorites", Icons.Default.Star)
    object About : Screen("about", "About", Icons.Default.Info)
}

// Daftar layar yang ditampilkan di Navigation Drawer
val drawerScreens = listOf(
    Screen.Home,
    Screen.Profile,
    Screen.Settings,
    Screen.Notifications,
    Screen.Favorites,
    Screen.About
)
