package com.manajemen.core;

public class Langganan {
    private String idLangganan;
    private Pelanggan pelanggan;
    private Layanan layanan;
    private int durasiBulan;

    public Langganan(String idLangganan, Pelanggan pelanggan, Layanan layanan, int durasiBulan) {
        this.idLangganan = idLangganan;
        this.pelanggan = pelanggan;
        this.layanan = layanan;
        this.durasiBulan = durasiBulan;
    }

    public String getIdLangganan() { return idLangganan; }
    public void setIdLangganan(String idLangganan) { this.idLangganan = idLangganan; }

    public Pelanggan getPelanggan() { return pelanggan; }
    public void setPelanggan(Pelanggan pelanggan) { this.pelanggan = pelanggan; }

    public Layanan getLayanan() { return layanan; }
    public void setLayanan(Layanan layanan) { this.layanan = layanan; }

    public int getDurasiBulan() { return durasiBulan; }
    public void setDurasiBulan(int durasiBulan) { this.durasiBulan = durasiBulan; }

    public int totalBiaya() {
        return layanan.getHarga() * durasiBulan;
    }
}