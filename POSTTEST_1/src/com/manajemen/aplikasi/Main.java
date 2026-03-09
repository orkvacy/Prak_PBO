package com.manajemen.aplikasi;

import com.manajemen.core.Pelanggan;
import com.manajemen.core.Layanan;
import com.manajemen.core.Langganan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static ArrayList<Langganan> daftarLangganan = new ArrayList<>();
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    boolean Run = true;

    while (Run) {
      System.out.println("Sistem Manajemen Langganan Layanan");
      System.out.println("1. Tambah Data Langganan");
      System.out.println("2. Tampilkan Data Langganan");
      System.out.println("3. Update Durasi Langganan");
      System.out.println("4. Hapus Data Langganan");
      System.out.println("0. Keluar");
      System.out.print("Pilih menu (1-4), 0 Untuk keluar: ");

      int select = scanner.nextInt();
      scanner.nextLine(); 

      switch (select) {
        case 1:
          createData();
          break;
        case 2:
          readData();
          break;
        case 3:
          updateData();
          break;
        case 4:
          deleteData();
          break;
        case 0:
          Run = false;
          System.out.println("Terima kasih telah menggnkan Progrm ini");
          break;
        default: System.out.println("Silahkan pilih 1-4");
      }
    }
  }

  static void createData() {
    System.out.println("Tambah Data");
    System.out.print("ID Langganan: ");
    String idLang = scanner.nextLine();

    System.out.print("Nama Pelanggan: ");
    String namaPel = scanner.nextLine();
    Pelanggan p = new Pelanggan("IDP-" + idLang, namaPel); //next di pengembangan akun admin

    System.out.print("Nama Layanan : ");
    String namaLay = scanner.nextLine();
    System.out.print("Harga Layanan per Bulan: ");
    int hargaLay = scanner.nextInt();

    System.out.print("Durasi Langganan (Bulan): ");
    int durasi = scanner.nextInt();
    scanner.nextLine();

    Layanan l = new Layanan("IDS-" + idLang, namaLay, hargaLay);
    Langganan langgananBaru = new Langganan(idLang, p, l, durasi);

    daftarLangganan.add(langgananBaru);
    System.out.println("Data Tertambah");
  }

  static void readData() {
    System.out.println("Daftar Langganan");
    if (daftarLangganan.isEmpty()) {
      System.out.println("Belum ada data langganan");
      return;
    }

    for (Langganan lang : daftarLangganan) {
      System.out.println("ID Langganan : " + lang.getIdLangganan());
      System.out.println("Pelanggan    : " + lang.getPelanggan().getNama());
      System.out.println("Layanan      : " + lang.getLayanan().getNamaLayanan());
      System.out.println("Durasi       : " + lang.getDurasiBulan() + " bulan");
      System.out.println("Biaya Total  : Rp " + lang.totalBiaya());
    }
  }

  static void updateData() {
    System.out.println("Update Durasi");
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
    System.out.println("Hapus Data");
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
        System.out.println("Data berhasil terhapsu");
        dihapus = true;
        break;
      }
    }
    if (!dihapus) {
      System.out.println("Data dengan ID " + idHapus + " tidak ditemukan.");
    }
  }
}