# Implementasi Navigasi dan Halaman Lengkap (NavDrawerApp)

Membangun alur navigasi yang fungsional antar halaman menggunakan Navigation Compose, serta mengimplementasikan konten detail untuk setiap menu (Home, Profile, Settings, Notifications, Favorites, About) tanpa mengubah desain UI Drawer yang sudah ada.

## User Review Required

> [!IMPORTANT]
> - Struktur navigasi akan diubah sehingga `ModalNavigationDrawer` berada di level teratas (`MainScreen`), memastikan Drawer tersedia di semua halaman.
> - File `Screen1.kt` sampai `Screen5.kt` akan dihapus dan digantikan dengan file bernama deskriptif seperti `ProfileScreen.kt`, `SettingsScreen.kt`, dll.

## Proposed Changes

### Navigation Logic

#### [MODIFY] [NavigationRoutes.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/navigation/NavigationRoutes.kt)
Update `sealed class Screen` agar memiliki nama object dan route yang sesuai (Profile, Settings, dll) dan route lowercase ("home", "profile", ...).

#### [MODIFY] [NavGraph.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/navigation/NavGraph.kt)
Update pemetaan rute ke Composable screen yang baru.

### UI Components & Screens

#### [NEW] [MainScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/MainScreen.kt)
Membuat container utama yang membungkus `ModalNavigationDrawer`, `Scaffold`, `TopAppBar` dengan tombol hamburger, dan `NavHost`. Ini memastikan Drawer konsisten di semua layar.

#### [MODIFY] [HomeScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/HomeScreen.kt)
Update konten: Judul Home, Card info aplikasi, dan Welcome text.

#### [NEW] [ProfileScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/ProfileScreen.kt)
Implementasi detail profil: Foto (Icon), Nama, NIM, Prodi, Email, dan Tombol Edit.

#### [NEW] [SettingsScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/SettingsScreen.kt)
Implementasi pengaturan: Toggles (Dark Mode, Notifications) dan Selectors (Language, Theme).

#### [NEW] [NotificationsScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/NotificationsScreen.kt)
Implementasi daftar notifikasi menggunakan `LazyColumn` dan `Card`.

#### [NEW] [FavoritesScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/FavoritesScreen.kt)
Implementasi daftar favorit menggunakan `LazyColumn` dengan icon favorit.

#### [NEW] [AboutScreen.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/screens/AboutScreen.kt)
Implementasi info aplikasi: Versi, Deskripsi, Nama Pengembang, dan Info Mata Kuliah.

#### [DELETE] `Screen1.kt` - `Screen5.kt`
Menghapus file lama untuk menjaga kebersihan struktur project.

### Main Activity

#### [MODIFY] [MainActivity.kt](file:///D:/Semester 6/Pemrograman Mobile/Fix Tugas/5. NavDrawerApp/app/src/main/java/com/example/navdrawerapp/MainActivity.kt)
Mengarahkan `setContent` untuk memanggil `MainScreen`.

## Verification Plan

### Automated Tests
- Menjalankan Build Gradle (`app:assembleDebug`).

### Manual Verification
- Klik setiap menu di Drawer dan pastikan halaman berpindah.
- Pastikan Drawer otomatis tertutup setelah item diklik.
- Pastikan `TopAppBar` menampilkan judul yang benar sesuai halaman aktif.
- Pastikan menu aktif di Drawer memiliki highlight (Selected state).
- Uji navigasi back Android (kembali ke stack sebelumnya).
