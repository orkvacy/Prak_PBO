package com.manajemen.core;

public class Layanan {
    protected String idLayanan;
    protected String namaLayanan;
    protected int harga;

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
            System.out.println("harga gaboleh kurang dari 0");
            this.harga = 0;
        } else {
            this.harga = harga;
        }
    }

    public String getKategori() {
        return "Layanan IT Umum";
    }

    public String getDetailTambahan() {
        return "-";
    }
}