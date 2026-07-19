package com.example.navdrawerapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.navdrawerapp.navigation.Screen
import com.example.navdrawerapp.navigation.drawerScreens
import com.example.navdrawerapp.ui.theme.DrawerHeaderBackground
import com.example.navdrawerapp.ui.theme.DrawerHeaderText
import com.example.navdrawerapp.ui.theme.DrawerItemSelected
import com.example.navdrawerapp.ui.theme.DrawerItemSelectedText

/**
 * File DrawerContent.kt
 * ====================
 * Berisi UI untuk isi dari Navigation Drawer.
 */
@Composable
fun DrawerContent(
    navController: NavHostController,
    onItemClick: (Screen) -> Unit
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    ModalDrawerSheet(
        drawerContainerColor = Color.White,
        modifier = Modifier.width(300.dp)
    ) {
        // --- Header Section ---
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(DrawerHeaderBackground)
                .padding(24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                tint = Color.White
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Nama Praktikan",
                color = DrawerHeaderText,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "NIM: 123456789",
                color = DrawerHeaderText.copy(alpha = 0.8f),
                fontSize = 14.sp
            )
            Text(
                text = "Program Studi: Informatika",
                color = DrawerHeaderText.copy(alpha = 0.8f),
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // --- Menu Items Section ---
        drawerScreens.forEachIndexed { index, screen ->
            val isSelected = currentRoute == screen.route
            
            NavigationDrawerItem(
                label = { Text(text = screen.title) },
                selected = isSelected,
                onClick = { onItemClick(screen) },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.title,
                        tint = if (isSelected) DrawerItemSelectedText else Color.Gray
                    )
                },
                badge = {
                    // Menambahkan badge sebagai fitur tambahan
                    if (isSelected) {
                        Surface(
                            color = DrawerHeaderBackground,
                            shape = CircleShape
                        ) {
                            Text(
                                text = "Active",
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                                fontSize = 10.sp
                            )
                        }
                    }
                },
                colors = NavigationDrawerItemDefaults.colors(
                    selectedContainerColor = DrawerItemSelected,
                    selectedTextColor = DrawerItemSelectedText,
                    unselectedTextColor = Color.Black
                ),
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
            )
        }
    }
}
