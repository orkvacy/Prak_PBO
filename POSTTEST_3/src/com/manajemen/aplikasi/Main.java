package com.manajemen.aplikasi;

import com.manajemen.core.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static ArrayList<Langganan> daftarLangganan = new ArrayList<>();
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    boolean run = true;

    while (run) {
      System.out.println("Sistem Manajemen Langganan Layanan IT");
      System.out.println("1. Tambah Data Langganan");
      System.out.println("2. Tampilkan Data Langganan");
      System.out.println("3. Update Durasi Langganan");
      System.out.println("4. Hapus Data Langganan");
      System.out.println("0. Keluar");
      System.out.print("Pilih menu (1-4), 0 Untuk keluar: ");

      int select = scanner.nextInt();
      scanner.nextLine();

      switch (select) {
        case 1: createData(); break;
        case 2: readData(); break;
        case 3: updateData(); break;
        case 4: deleteData(); break;
        case 0:
          run = false;
          System.out.println("Terima kasih telah menggunakan program ini!");
          break;
        default: System.out.println("Silahkan pilih 1-4");
      }
    }
  }

  static void createData() {
    System.out.println("\nTambah Data");
    System.out.print("ID Langganan: ");
    String idLang = scanner.nextLine();

    System.out.print("Nama Pelanggan: ");
    String namaPel = scanner.nextLine();
    Pelanggan p = new Pelanggan("IDP-" + idLang, namaPel);

    System.out.println("\nPilih Kategori Layanan IT:");
    System.out.println("1. Layanan Cloud Hosting");
    System.out.println("2. Layanan Software (SaaS)");
    System.out.println("3. Layanan Instalasi Jaringan");
    System.out.print("Pilih (1/2/3): ");
    int jenisLayanan = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Nama Layanan (Merek/Paket): ");
    String namaLay = scanner.nextLine();
    System.out.print("Harga Layanan per Bulan: Rp ");
    int hargaLay = scanner.nextInt();
    scanner.nextLine();

    Layanan l = null;

    if (jenisLayanan == 1) {
      System.out.print("Masukkan Kapasitas Storage (GB): ");
      int kapasitas = scanner.nextInt();
      scanner.nextLine();
      l = new LayananHosting("IDS-" + idLang, namaLay, hargaLay, kapasitas);
    } else if (jenisLayanan == 2) {
      System.out.println("Pilih Jenis Lisensi:");
      System.out.println("1. Personal");
      System.out.println("2. Tim");
      System.out.println("3. Enterprise");
      System.out.print("Pilih (1/2/3): ");
      int pilihLisensi = scanner.nextInt();
      scanner.nextLine();

      String lisensi;
      switch (pilihLisensi) {
        case 1:
          lisensi = "Personal";
          break;
        case 2:
          lisensi = "Tim";
          break;
        case 3:
          lisensi = "Enterprise";
          break;
        default:
          System.out.println("Pilihan tidak valid. Default diatur ke: Personal");
          lisensi = "Personal";
          break;
      }
      l = new LayananSoftware("IDS-" + idLang, namaLay, hargaLay, lisensi);
    } else if (jenisLayanan == 2) {
      System.out.println("Pilih Jenis Lisensi:");
      System.out.println("1. Personal");
      System.out.println("2. Tim");
      System.out.println("3. Enterprise");
      System.out.print("Pilih (1/2/3): ");
      int pilihLisensi = scanner.nextInt();
      scanner.nextLine();

      String lisensi;
      switch (pilihLisensi) {
        case 1:
          lisensi = "Personal";
          break;
        case 2:
          lisensi = "Tim";
          break;
        case 3:
          lisensi = "Enterprise";
          break;
        default:
          System.out.println("Pilihan tidak valid. Default diatur ke: Personal");
          lisensi = "Personal";
          break;
      }
      l = new LayananSoftware("IDS-" + idLang, namaLay, hargaLay, lisensi);

    } else if (jenisLayanan == 3) {
      System.out.print("Masukkan Kecepatan Jaringan (Mbps): ");
      int kecepatan = scanner.nextInt();
      scanner.nextLine();
      l = new LayananJaringan("IDS-" + idLang, namaLay, hargaLay, kecepatan);
    } else {
      System.out.println("Pilihan tidak valid, menggunakan Layanan Umum.");
      l = new Layanan("IDS-" + idLang, namaLay, hargaLay);
    }

    System.out.print("Durasi Langganan (Bulan): ");
    int durasi = scanner.nextInt();
    scanner.nextLine();

    Langganan langgananBaru = new Langganan(idLang, p, l, durasi);
    daftarLangganan.add(langgananBaru);
    System.out.println("Data Berhasil Ditambahkan!");
  }

  static void readData() {
    System.out.println("\n--- Daftar Langganan Layanan IT ---");
    if (daftarLangganan.isEmpty()) {
      System.out.println("Belum ada data langganan");
      return;
    }

    for (Langganan lang : daftarLangganan) {
      System.out.println("ID Langganan : " + lang.getIdLangganan());
      System.out.println("Pelanggan    : " + lang.getPelanggan().getNama());

      Layanan layananTerpilih = lang.getLayanan();
      System.out.println("Kategori IT  : " + layananTerpilih.getKategori());
      System.out.println("Layanan      : " + layananTerpilih.getNamaLayanan());
      System.out.println("Spesifikasi  : " + layananTerpilih.getDetailTambahan());

      System.out.println("Durasi       : " + lang.getDurasiBulan() + " bulan");
      System.out.println("Biaya Total  : Rp " + lang.totalBiaya());
    }
  }

  static void updateData() {
    System.out.println("\n--- Update Durasi ---");
    if (daftarLangganan.isEmpty()) {
      System.out.println("Data masih kosong");
      return;
    }

    System.out.print("Masukkan ID Langganan yang ingin diupdate : ");
    String idEdit = scanner.nextLine();
    boolean ditemukan = false;

    for (Langganan lang : daftarLangganan) {
      if (lang.getIdLangganan().equals(idEdit)) {
        System.out.print("Masukkan durasi bulan yang baru: ");
        int durasiBaru = scanner.nextInt();
        scanner.nextLine();

        lang.setDurasiBulan(durasiBaru);
        System.out.println("Data berhasil Diubah");
        ditemukan = true;
        break;
      }
    }
    if (!ditemukan) {
      System.out.println("Data dengan ID " + idEdit + " tidak ditemukan.");
    }
  }

  static void deleteData() {
    System.out.println("\n--- Hapus Data ---");
    if (daftarLangganan.isEmpty()) {
      System.out.println("Data masih kosong");
      return;
    }

    System.out.print("Masukkan ID Langganan yang ingin dihapus : ");
    String idHapus = scanner.nextLine();
    boolean dihapus = false;

    for (int i = 0; i < daftarLangganan.size(); i++) {
      if (daftarLangganan.get(i).getIdLangganan().equals(idHapus)) {
        daftarLangganan.remove(i);
        System.out.println("Data berhasil terhapus");
        dihapus = true;
        break;
      }
    }
    if (!dihapus) {
      System.out.println("Data dengan ID " + idHapus + " tidak ditemukan.");
    }
  }
}