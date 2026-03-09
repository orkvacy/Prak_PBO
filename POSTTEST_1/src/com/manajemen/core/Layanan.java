package com.manajemen.core;

public class Layanan {
    private String idLayanan;
    private String namaLayanan;
    private int harga;

    public Layanan(String idLayanan, String namaLayanan, int harga) {
        this.idLayanan = idLayanan;
        this.namaLayanan = namaLayanan;
        this.harga = harga;
    }

    public String getIdLayanan() { return idLayanan; }
    public void setIdLayanan(String idLayanan) { this.idLayanan = idLayanan; }

    public String getNamaLayanan() { return namaLayanan; }
    public void setNamaLayanan(String namaLayanan) { this.namaLayanan = namaLayanan; }

    public int getHarga() { return harga; }

    public void setHarga(int harga) {
        if (harga < 0) {
            System.out.println("Harga tidak blh < 0");
            this.harga = 0;
        } else {
            this.harga = harga;
        }
    }
}