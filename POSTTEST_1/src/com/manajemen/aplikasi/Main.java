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
      System.out.println("header");
