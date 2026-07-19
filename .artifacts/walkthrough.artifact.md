# Walkthrough - Implementasi Navigasi & Halaman Lengkap

Implementasi navigasi antar halaman pada **NavDrawerApp** telah selesai. Sekarang, setiap menu di Navigation Drawer memiliki halaman tujuan dengan konten yang sesuai spesifikasi.

## Perubahan Utama

### 1. Navigasi Global (`MainScreen.kt`)
Saya memperkenalkan `MainScreen` sebagai container utama aplikasi. Komponen ini membungkus:
- **ModalNavigationDrawer**: Tersedia di seluruh halaman aplikasi.
- **TopAppBar**: Menampilkan judul halaman secara dinamis berdasarkan rute yang aktif dan tombol hamburger untuk membuka Drawer.
- **NavHost**: Mengelola perpindahan antar layar secara halus.

### 2. Peningkatan Konten Halaman
Setiap halaman kini memiliki fitur unik:
- **Home**: Menampilkan Welcome text dan Card informasi aplikasi.
- **Profile**: Menampilkan detail identitas diri (Nama, NIM, Prodi, Email) dan tombol edit.
- **Settings**: Dilengkapi dengan toggle Switch untuk Dark Mode dan Notifikasi.
- **Notifications & Favorites**: Menggunakan `LazyColumn` untuk menampilkan daftar item secara efisien dengan Card dan Icon.
- **About**: Informasi lengkap mengenai versi aplikasi dan pengembang.

### 3. Perilaku Drawer yang Lebih Baik
- **Auto-Close**: Drawer otomatis tertutup saat item menu ditekan.
- **Selected State**: Menu yang sedang aktif akan tersorot (highlight) dan memiliki badge "Active".
- **Navigasi Aman**: Menggunakan `singleTop` dan `popUpTo` untuk mencegah tumpukan layar yang berlebihan saat berpindah-pindah menu.

## Daftar File Baru

- [MainScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/MainScreen.kt): Container utama dengan Drawer.
- [ProfileScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/ProfileScreen.kt): Halaman Profil.
- [SettingsScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/SettingsScreen.kt): Halaman Pengaturan.
- [NotificationsScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/NotificationsScreen.kt): Daftar Notifikasi.
- [FavoritesScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/FavoritesScreen.kt): Daftar Favorit.
- [AboutScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/AboutScreen.kt): Halaman Tentang.

## Verifikasi Akhir
- **Gradle Build**: Berhasil (`assembleDebug`).
- **Navigasi**: Berjalan mulus ke seluruh 6 rute.
- **Selected State**: Bekerja dengan `currentBackStackEntryAsState`.
