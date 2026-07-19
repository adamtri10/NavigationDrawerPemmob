package com.example.navdrawerapp.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navdrawerapp.components.DrawerContent
import com.example.navdrawerapp.navigation.NavGraph
import com.example.navdrawerapp.navigation.Screen
import com.example.navdrawerapp.navigation.drawerScreens
import com.example.navdrawerapp.ui.theme.TopBarBackground
import com.example.navdrawerapp.ui.theme.TopBarContent
import kotlinx.coroutines.launch

/**
 * File MainScreen.kt
 * =================
 * Container utama yang menyediakan Navigation Drawer untuk seluruh aplikasi.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    
    // Mendapatkan rute saat ini untuk menentukan judul di TopAppBar
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    // Cari judul berdasarkan rute
    val currentTitle = drawerScreens.find { it.route == currentRoute }?.title ?: "NavDrawerApp"

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            DrawerContent(
                navController = navController,
                onItemClick = { screen ->
                    scope.launch { drawerState.close() }
                    // Navigasi dengan singleTop untuk menghindari tumpukan duplikat
                    navController.navigate(screen.route) {
                        popUpTo(Screen.Home.route) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = currentTitle, color = TopBarContent) },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Open Drawer",
                                tint = TopBarContent
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = TopBarBackground
                    )
                )
            }
        ) { innerPadding ->
            // Area konten tempat NavHost berada
            NavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
