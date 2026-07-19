package com.example.navdrawerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.navdrawerapp.screens.MainScreen
import com.example.navdrawerapp.ui.theme.NavDrawerAppTheme

/**
 * File MainActivity.kt
 * ====================
 * Entry point aplikasi. Memanggil MainScreen sebagai root UI.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NavDrawerAppTheme {
                // Memanggil MainScreen yang sudah berisi Drawer & NavHost
                MainScreen()
            }
        }
    }
}
