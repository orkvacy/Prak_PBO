# Sistem Manajemen Langganan Layanan IT

> **Nama:** Muhammad Nabil Rahmatullah
>
> **NIM:** 2409106046
>
> **Mata Kuliah:** Pemrograman Berbasis Objek
>
> **Bahasa Pemrograman:** Java

---

## Daftar Isi

1. [Deskripsi Proyek](#deskripsi-proyek)
2. [Struktur Proyek](#struktur-proyek)
3. [Arsitektur & Desain OOP](#arsitektur--desain-oop)
4. [Penjelasan Kelas](#penjelasan-kelas)
5. [Fitur Aplikasi](#fitur-aplikasi)
6. [Alur Program](#alur-program)
7. [Contoh Penggunaan](#contoh-penggunaan)

---

## Deskripsi Proyek

Proyek ini merupakan **Sistem Manajemen Langganan Layanan IT** berbasis konsol (CLI) yang dibangun menggunakan Java. Aplikasi ini memungkinkan pengguna untuk mengelola data langganan berbagai jenis layanan IT secara lengkap mulai dari menambah, menampilkan, memperbarui, hingga menghapus data langganan.

Proyek ini merupakan lanjutan dari praktikum sebelumnya (diupdate untuk **Post-Test 4**) mata kuliah Pemrograman Berorientasi Objek. Fokus pengembangan pada versi ini adalah penerapan konsep **Polymorphism** (Method Overriding & Method Overloading) secara logis, mempertahankan konsep **Inheritance (Pewarisan)**, **Enkapsulasi**, dan **Komposisi Objek**.

---

## Struktur Proyek

```text
POSTTEST_4/
├── src/
│   └── com/
│       └── manajemen/
│           ├── aplikasi/
│           │   └── Main.java               # File Main
│           └── core/
│               ├── Pelanggan.java          # Class Pelanggan (Constructor Overloading)
│               ├── Langganan.java          # Class Langganan (Method Overloading: totalBiaya)
│               ├── Layanan.java            # Superclass (Base: hitungDiskon, getKategori, getDetailTambahan)
│               ├── LayananHosting.java     # Subclass (Override: hitungDiskon, getKategori, getDetailTambahan)
│               ├── LayananJaringan.java    # Subclass (Override: hitungDiskon, getKategori, getDetailTambahan)
│               └── LayananSoftware.java    # Subclass (Override: hitungDiskon, getKategori, getDetailTambahan)
└── README.md
```

---

## Arsitektur & Desain OOP

Proyek ini menerapkan prinsip-prinsip OOP sebagai berikut:

### 1. Polymorphism *(Fokus Utama Post-Test 4)*

#### A. Method Overriding (lebih dari 1 fungsi)

Setiap subclass `Layanan` meng-*override* **3 method** dari class induknya:

| Method | Layanan (Parent) | LayananHosting | LayananJaringan | LayananSoftware |
|---|---|---|---|---|
| `getKategori()` | "Layanan IT Umum" | "Layanan Cloud Hosting" | "Layanan Instalasi Jaringan" | "Layanan Software (SaaS)" |
| `getDetailTambahan()` | "-" | "Kapasitas Storage: X GB" | "Kecepatan Jaringan: X Mbps" | "Jenis Lisensi: X" |
| `hitungDiskon()` | `return 0` | Bertingkat by storage GB | Bertingkat by kecepatan Mbps | Bertingkat by jenis lisensi |

**Penerapan `hitungDiskon()` yang logis:**
- **`LayananHosting`**: Diskon 5-15% berdasarkan kapasitas storage. Semakin besar kapasitas, semakin besar diskon (insentif paket besar).
- **`LayananJaringan`**: Diskon 0-10% berdasarkan kecepatan. Kecepatan > 1000 Mbps mendapat 10%, > 100 Mbps mendapat 5%.
- **`LayananSoftware`**: Diskon 0-20% berdasarkan jenis lisensi. Enterprise 20%, Tim 10%, Personal 0% (insentif volume pengguna).

#### B. Method Overloading (lebih dari 1 fungsi)

**Overload 1 — `totalBiaya()` pada class `Langganan`:**
```java
// Tanpa parameter: menghitung biaya penuh tanpa diskon
public int totalBiaya()

// Dengan parameter: menghitung biaya setelah dipotong diskon tertentu
public int totalBiaya(int diskonPersen)
```
Logika: Operator bisa melihat biaya normal sekaligus biaya setelah diskon promosi tanpa membuat method terpisah.

**Overload 2 — Constructor `Pelanggan`:**
```java
// Constructor standar: hanya nama
public Pelanggan(String idPelanggan, String nama)

// Constructor dengan email: untuk pelanggan yang mendaftarkan email
public Pelanggan(String idPelanggan, String nama, String email)
```
Logika: Tidak semua pelanggan wajib mengisi email, sehingga kedua versi constructor dibutuhkan.

---

### 2. Inheritance (Pewarisan)

Sistem mengimplementasikan **Hierarchical Inheritance**, di mana satu *Superclass* `Layanan` diturunkan menjadi 3 *Subclass*: `LayananHosting`, `LayananJaringan`, dan `LayananSoftware`. Atribut dasar menggunakan modifier `protected` agar dapat diakses langsung oleh class turunan.

### 3. Enkapsulasi

Setiap kelas menjaga integritas datanya menggunakan modifier `private`/`protected` dan menyediakan akses melalui method `getter`/`setter`. Contohnya, `setHarga()` memvalidasi agar harga tidak boleh kurang dari 0.

### 4. Komposisi Objek

Kelas `Langganan` berperan sebagai penghubung (*has-a relationship*). Kelas ini *memiliki* objek `Pelanggan` dan `Layanan` sebagai atributnya.

---

## Penjelasan Kelas

### 1. Entitas Pendukung
- **`Pelanggan.java`**: Merepresentasikan data pelanggan (`idPelanggan`, `nama`, `email`). Menerapkan **constructor overloading** — dapat dibuat dengan atau tanpa email.
- **`Langganan.java`**: Kelas penghubung yang menggabungkan objek `Pelanggan` dan `Layanan`. Menerapkan **method overloading** pada `totalBiaya()` — versi tanpa diskon dan dengan diskon manual.

### 2. Hierarki Layanan (Inheritance + Polymorphism)
- **`Layanan.java` (Superclass)**: Kelas induk dengan method `getKategori()`, `getDetailTambahan()`, dan `hitungDiskon()` sebagai definisi dasar.
- **`LayananHosting.java` (Subclass)**: Override ketiga method; `hitungDiskon()` memberikan diskon 5-15% berdasarkan kapasitas storage.
- **`LayananJaringan.java` (Subclass)**: Override ketiga method; `hitungDiskon()` memberikan diskon 0-10% berdasarkan kecepatan jaringan.
- **`LayananSoftware.java` (Subclass)**: Override ketiga method; `hitungDiskon()` memberikan diskon 0-20% berdasarkan jenis lisensi.

### 3. `Main.java`
Kelas antarmuka CLI yang mengelola CRUD. Memanfaatkan polimorfisme saat memanggil `getKategori()`, `getDetailTambahan()`, dan `hitungDiskon()` — referensi bertipe `Layanan` (parent) secara otomatis memanggil implementasi subclass yang sesuai.

---

## Fitur Aplikasi

| No | Fitur | Deskripsi |
|---|---|---|
| 1 | **Tambah Data Langganan** | Input data pelanggan (dengan/tanpa email) dan memilih kategori layanan beserta spesifikasi uniknya. Menampilkan diskon otomatis setelah data ditambahkan. |
| 2 | **Tampilkan Data Langganan** | Menampilkan daftar seluruh langganan beserta persentase diskon otomatis, biaya normal, dan biaya setelah diskon. |
| 3 | **Update Durasi Langganan** | Memperbarui durasi berlangganan menggunakan ID Langganan. |
| 4 | **Hapus Data Langganan** | Menghapus data langganan berdasarkan ID. |
| 0 | **Keluar** | Mengakhiri eksekusi program. |

---

## Alur Program

```text
[Mulai]
    |
    v
[Tampilkan Menu Utama]
    |
    ├── [1] Tambah → Input Pelanggan (nama + opsional email) → Pilih Kategori → Input Spesifikasi
    |           → Simpan objek → Tampilkan diskon otomatis (hitungDiskon() via polimorfisme)
    |
    ├── [2] Tampilkan → Iterasi ArrayList → Cetak info: Kategori, Spesifikasi, Diskon (%),
    |           Biaya Normal (totalBiaya()), Biaya Diskon (totalBiaya(int))
    |
    ├── [3] Update → Input ID → Cari → Update Durasi
    |
    ├── [4] Hapus → Input ID → Cari → Hapus dari sistem
    |
    └── [0] Keluar → Terminasi
```

---

## Contoh Penggunaan

Contoh menambahkan Layanan Software (SaaS) dengan lisensi Enterprise:

```text
====================================
  Sistem Manajemen Langganan IT
====================================
1. Tambah Data Langganan
...
Pilih menu (1-4), 0 untuk keluar: 1

--- Tambah Data Langganan ---
ID Langganan  : 101
Nama Pelanggan: Nabil
Email Pelanggan (kosongkan jika tidak ada): nabil@email.com

Pilih Kategori Layanan IT:
1. Layanan Cloud Hosting
2. Layanan Software (SaaS)
3. Layanan Instalasi Jaringan
Pilih (1/2/3): 2
Nama Layanan (Merek/Paket): Microsoft 365
Harga Layanan per Bulan: Rp 500000
Pilih Jenis Lisensi:
1. Personal
2. Tim
3. Enterprise
Pilih (1/2/3): 3
Durasi Langganan (Bulan): 12

Data Berhasil Ditambahkan!
Info Diskon Otomatis : 20%
Biaya Normal         : Rp 6000000
Biaya Setelah Diskon : Rp 4800000

Pilih menu (1-4), 0 untuk keluar: 2

====== Daftar Langganan Layanan IT ======
------------------------------------------
ID Langganan   : 101
Pelanggan      : Nabil
Email          : nabil@email.com
Kategori IT    : Layanan Software (SaaS)
Layanan        : Microsoft 365
Spesifikasi    : Jenis Lisensi: Enterprise
Durasi         : 12 bulan
Diskon         : 20%
Biaya Normal   : Rp 6000000
Biaya (diskon) : Rp 4800000
==========================================
```

---

## Ringkasan Penerapan Polymorphism

| Tipe | Method/Constructor | Lokasi | Keterangan |
|---|---|---|---|
| **Override** | `getKategori()` | Semua subclass Layanan | Mengembalikan nama kategori spesifik |
| **Override** | `getDetailTambahan()` | Semua subclass Layanan | Mengembalikan spesifikasi teknis unik |
| **Override** | `hitungDiskon()` *(baru)* | Semua subclass Layanan | Logika diskon berbeda tiap jenis layanan |
| **Overload** | `totalBiaya()` *(baru)* | `Langganan` | Tanpa vs. dengan parameter diskon |
| **Overload** | Constructor `Pelanggan` *(baru)* | `Pelanggan` | Tanpa vs. dengan parameter email |