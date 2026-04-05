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
7. [Cara Menjalankan](#cara-menjalankan)
8. [Contoh Penggunaan](#contoh-penggunaan)

---

## Deskripsi Proyek

Proyek ini merupakan **Sistem Manajemen Langganan Layanan IT** berbasis konsol (CLI) yang dibangun menggunakan Java. Aplikasi ini memungkinkan pengguna untuk mengelola data langganan berbagai jenis layanan IT secara lengkap mulai dari menambah, menampilkan, memperbarui, hingga menghapus data langganan.

Proyek ini merupakan lanjutan dari praktikum sebelumnya (diupdate untuk **Post-Test 3**) mata kuliah Pemrograman Berorientasi Objek. Fokus pengembangan pada versi ini adalah penerapan konsep **Inheritance (Pewarisan)** secara logis, serta mempertahankan konsep **Enkapsulasi** dan **Komposisi Objek**.

---

## Struktur Proyek

```text
POSTTEST_3/
├── src/
│   └── com/
│       └── manajemen/
│           ├── aplikasi/
│           │   └── Main.java               # File Main
│           └── core/
│               ├── Pelanggan.java          # Class Pelanggan
│               ├── Langganan.java          # Class Langganan
│               ├── Layanan.java            # Superclass Layanan
│               ├── LayananHosting.java     # Subclass (Child)
│               ├── LayananJaringan.java    # Subclass (Child)
│               └── LayananSoftware.java    # Subclass (Child)
├── .idea/                             
├── untitled.iml                       
├── .gitignore
└── README.md
```

---

## Arsitektur & Desain OOP

Proyek ini menerapkan prinsip-prinsip OOP sebagai berikut:

### 1. Inheritance (Pewarisan)
Sistem ini mengimplementasikan **Hierarchical Inheritance**, di mana terdapat satu *Superclass/Parent Class* yaitu `Layanan`, yang diturunkan menjadi **3 Subclass/Child Class** (Lebih dari syarat minimal 2 child class).
- Atribut dasar `idLayanan`, `namaLayanan`, dan `harga` pada class parent diubah modifiernya menjadi `protected` agar dapat diakses langsung oleh class turunannya.
- Setiap subclass mewarisi sifat `Layanan` namun memiliki tambahan spesifikasi yang unik (misalnya kapasitas untuk hosting, kecepatan untuk jaringan, dan jenis lisensi untuk software). Method bawaan seperti `getKategori()` dan `getDetailTambahan()` di-*override* untuk memberikan output spesifik sesuai jenis layanan.

### 2. Enkapsulasi
Setiap kelas menjaga integritas datanya menggunakan modifier `private` (atau `protected` untuk pewarisan) dan menyediakan akses melalui method `getter` dan `setter`. Contohnya, setter `setHarga()` memvalidasi agar harga tidak boleh kurang dari 0.

### 3. Komposisi Objek
Kelas `Langganan` berperan sebagai penghubung (*has-a relationship*). Kelas ini tidak mewarisi entitas lain, melainkan *memiliki* objek `Pelanggan` dan `Layanan` sebagai atributnya untuk membentuk kesatuan data langganan.

---

## Penjelasan Kelas

### 1. Entitas Pendukung
- **`Pelanggan.java`**: Merepresentasikan data pelanggan (memiliki `idPelanggan` dan `nama`).
- **`Langganan.java`**: Kelas utama yang menggabungkan objek pelanggan, objek layanan, serta mencatat `durasiBulan`. Terdapat method `totalBiaya()` untuk menghitung total pembayaran (harga layanan x durasi).

### 2. Hierarki Layanan (Inheritance)
- **`Layanan.java` (Superclass)**: Kelas induk yang mendefinisikan kerangka dasar layanan IT. Memiliki atribut `idLayanan`, `namaLayanan`, `harga`.
- **`LayananHosting.java` (Subclass)**: Turunan dari `Layanan`. Menambahkan atribut khusus `kapasitasPenyimpanan` (dalam satuan GB).
- **`LayananJaringan.java` (Subclass)**: Turunan dari `Layanan`. Menambahkan atribut khusus `kecepatanMbps` (dalam satuan Mbps).
- **`LayananSoftware.java` (Subclass)**: Turunan dari `Layanan`. Menambahkan atribut khusus `jenisLisensi` (opsi: Personal, Tim, Enterprise).

### 3. `Main.java`
Kelas yang menjalankan antarmuka CLI. Berisi koleksi `ArrayList<Langganan>` sebagai penyimpanan sementara (in-memory) dan mengelola seluruh operasi CRUD. Pada saat input data, sistem mendukung instansiasi dinamis (*polymorphism*) di mana tipe referensi `Layanan` dapat menyimpan objek `LayananHosting`, `LayananJaringan`, maupun `LayananSoftware` tergantung input *user*.

---

## Fitur Aplikasi

| No | Fitur | Deskripsi |
|---|---|---|
| 1 | **Tambah Data Langganan** | Input data pelanggan dan memilih kategori layanan IT beserta spesifikasi uniknya. |
| 2 | **Tampilkan Data Langganan** | Menampilkan daftar seluruh langganan, termasuk kategori, detail spesifikasi layanan, dan total biaya. |
| 3 | **Update Durasi Langganan** | Memperbarui durasi berlangganan menggunakan ID Langganan. |
| 4 | **Hapus Data Langganan** | Menghapus keseluruhan data langganan tertentu berdasarkan ID. |
| 0 | **Keluar** | Mengakhiri eksekusi program. |

---

## Alur Program

```text
[Mulai]
    |
    v
[Tampilkan Menu Utama]
    |
    ├── [1] Tambah → Input Pelanggan → Pilih Kategori (Hosting/SaaS/Jaringan) → Input Spesifikasi Khusus + Harga + Durasi → Simpan objek
    |
    ├── [2] Tampilkan → Iterasi ArrayList → Cetak Info Pelanggan, Kategori Layanan, Spesifikasi Tambahan, dan Biaya Total
    |
    ├── [3] Update → Input ID Langganan → Cari Data → Update nilai Durasi
    |
    ├── [4] Hapus → Input ID Langganan → Cari Data → Hapus dari sistem
    |
    └── [0] Keluar → Terminasi
```

---

## Contoh Penggunaan

Berikut adalah contoh saat user memilih menambahkan layanan berjenis Cloud Hosting:

```text
Sistem Manajemen Langganan Layanan IT
1. Tambah Data Langganan
2. Tampilkan Data Langganan
3. Update Durasi Langganan
4. Hapus Data Langganan
0. Keluar
Pilih menu (1-4), 0 Untuk keluar: 1

Tambah Data
ID Langganan: 101
Nama Pelanggan: Nabil

Pilih Kategori Layanan IT:
1. Layanan Cloud Hosting
2. Layanan Software (SaaS)
3. Layanan Instalasi Jaringan
Pilih (1/2/3): 1
Nama Layanan (Merek/Paket): AWS EC2 Basic
Harga Layanan per Bulan: Rp 150000
Masukkan Kapasitas Storage (GB): 50
Durasi Langganan (Bulan): 12
Data Berhasil Ditambahkan!

Pilih menu (1-4), 0 Untuk keluar: 2

--- Daftar Langganan Layanan IT ---
ID Langganan : 101
Pelanggan    : Nabil
Kategori IT  : Layanan Cloud Hosting
Layanan      : AWS EC2 Basic
Spesifikasi  : Kapasitas Storage: 50 GB
Durasi       : 12 bulan
Biaya Total  : Rp 1800000
```