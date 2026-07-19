package com.example.navdrawerapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.navdrawerapp.ui.theme.Primary

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            tint = Primary
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "NavDrawerApp",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Primary
        )
        Text(
            text = "Versi 1.0.0 (Stable)",
            style = MaterialTheme.typography.bodyMedium
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Aplikasi ini dirancang sebagai implementasi praktis penggunaan Navigation Drawer dengan Jetpack Compose dan Material 3.",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Text(text = "Dikembangkan Oleh:", style = MaterialTheme.typography.labelLarge)
        Text(text = "Praktikan Pemrograman Mobile", fontWeight = FontWeight.Medium)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Matakuliah: Pemrograman Mobile\nProgram Studi Informatika",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }
}
