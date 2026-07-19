# NavDrawerApp - Simulasi Navigation Drawer
## Android Jetpack Compose Project

### Deskripsi
Aplikasi Android yang mendemonstrasikan implementasi **Navigation Drawer** 
menggunakan Jetpack Compose dan Material3.

Terdapat 3 menu di drawer: **Screen 1**, **Screen 2**, dan **Screen 3**.
Setiap screen menampilkan TopAppBar dengan back arrow dan area konten.

---

### Struktur Project

```
NavDrawerApp/
├── app/src/main/
│   ├── java/com/example/navdrawerapp/
│   │   ├── MainActivity.kt                    ← Activity utama (entry point)
│   │   └── ui/
│   │       ├── components/
│   │       │   └── DrawerContent.kt            ← Isi Navigation Drawer (menu)
│   │       ├── navigation/
│   │       │   ├── NavigationRoutes.kt         ← Definisi route setiap halaman
│   │       │   └── NavGraph.kt                 ← Peta navigasi antar halaman
│   │       ├── screens/
│   │       │   ├── HomeScreen.kt               ← Halaman utama + Drawer
│   │       │   ├── ScreenContent.kt            ← Komponen generik screen
│   │       │   ├── Screen1.kt                  ← Halaman Screen 1
│   │       │   ├── Screen2.kt                  ← Halaman Screen 2
│   │       │   └── Screen3.kt                  ← Halaman Screen 3
│   │       └── theme/
│   │           ├── Color.kt                    ← Warna Compose (sinkron color.xml)
│   │           └── Theme.kt                    ← Tema Material3
│   └── res/values/
│       ├── color.xml                           ← Semua warna hexadecimal
│       ├── strings.xml                         ← String resources
│       └── themes.xml                          ← Tema XML
```

---

### Alur Navigasi

```
┌─────────────────────┐
│   HomeScreen        │
│   (Navigation       │──── Geser kiri / tap ikon ≡
│    Drawer)          │
└────────┬────────────┘
         │
    ┌────┼────┐
    ▼    ▼    ▼
Screen1  Screen2  Screen3
    │    │    │
    └────┼────┘
         │ (Back Arrow)
         ▼
    HomeScreen
```

---

### Cara Menjalankan

1. Buka Android Studio
2. Pilih **File → Open** → arahkan ke folder `NavDrawerApp`
3. Tunggu Gradle sync selesai
4. Klik **Run** (▶) atau tekan Shift + F10
5. Pilih emulator atau device fisik

---

### Dependencies Utama

| Library                | Kegunaan                          |
|------------------------|-----------------------------------|
| Jetpack Compose BOM    | UI toolkit modern                 |
| Material3              | Desain komponen Material You      |
| Navigation Compose     | Navigasi antar halaman            |
| Material Icons Extended| Ikon tambahan (Menu, ArrowBack)   |

---

### Warna (color.xml)

Semua warna tersimpan di `res/values/color.xml` dan diduplikasi 
di `Color.kt` untuk penggunaan di Compose.

---

<h1 align="center">📱 Tampilan Aplikasi</h1>

<h2>📸 Screenshot Aplikasi</h2>

<table>
  <tr>
    <td align="center">
      <b>Screen 1</b>
    </td>
    <td align="center">
      <b>Screen 2</b>
    </td>
    <td align="center">
      <b>Screen 3</b>
    </td>
  </tr>

  <tr>
    <td align="center">
      <img src="Screen%201.jpeg" width="250">
    </td>
    <td align="center">
      <img src="Screen%202.jpeg" width="250">
    </td>
    <td align="center">
      <img src="Screen%203.jpeg" width="250">
    </td>
  </tr>

  <tr>
    <td align="center">
      Tampilan screen pertama aplikasi.
    </td>
    <td align="center">
      Tampilan screen kedua aplikasi.
    </td>
    <td align="center">
      Tampilan screen ketiga aplikasi.
    </td>
  </tr>
</table>

<h2>🧭 Navigation</h2>

<table>
  <tr>
    <td align="center">
      <b>Bilah Navigation</b>
    </td>
    <td align="center">
      <b>Menu Utama</b>
    </td>
  </tr>

  <tr>
    <td align="center">
      <img src="Bilah%20Navigation.jpeg" width="250">
    </td>
    <td align="center">
      <img src="Menu%20utama.jpeg" width="250">
    </td>
  </tr>
</table>
