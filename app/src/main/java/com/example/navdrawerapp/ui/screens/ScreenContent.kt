package com.example.navdrawerapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navdrawerapp.ui.theme.*

/**
 * File ScreenContent.kt
 * =====================
 * Composable generik yang dipakai oleh Screen 1, Screen 2, dan Screen 3.
 *
 * Setiap screen memiliki pola yang sama:
 * - TopAppBar dengan tombol back arrow dan judul
 * - Area konten di tengah layar berisi teks
 *
 * Dengan membuat komponen generik ini, kita menghindari duplikasi kode.
 * Prinsip DRY (Don't Repeat Yourself)!
 *
 * Analogi: Seperti template surat. Isi dan judul berubah,
 * tapi formatnya tetap sama.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenContent(
    title: String,               // Judul yang ditampilkan di TopAppBar (misal "Screen 1")
    contentText: String,         // Teks konten yang ditampilkan di area isi
    onBackClick: () -> Unit      // Callback ketika tombol back arrow diklik
) {
    // Scaffold menyediakan struktur dasar: TopBar + Content area
    Scaffold(
        // === TOP APP BAR ===
        topBar = {
            TopAppBar(
                // Judul halaman (misal: "Screen 1")
                title = {
                    Text(
                        text = title,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                // Tombol navigasi back (panah kembali) di sebelah kiri
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Kembali"
                        )
                    }
                },
                // Warna TopAppBar: background biru, teks dan ikon putih
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = TopBarBackground,       // Background biru dari color.xml
                    titleContentColor = TopBarContent,       // Teks putih dari color.xml
                    navigationIconContentColor = TopBarContent // Ikon putih dari color.xml
                )
            )
        },
        // Warna background area konten
        containerColor = BackgroundScreen                    // Background abu-abu terang dari color.xml
    ) { paddingValues ->
        // === AREA KONTEN ===
        // Box mengisi seluruh layar dan menempatkan konten di tengah
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),                     // Padding dari Scaffold (menghindari overlap TopBar)
            contentAlignment = Alignment.Center              // Konten ditempatkan di tengah layar
        ) {
            // Teks konten utama
            Text(
                text = contentText,
                color = ContentText,                         // Warna teks hitam lembut dari color.xml
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}
