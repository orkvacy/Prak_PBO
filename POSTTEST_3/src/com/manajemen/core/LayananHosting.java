package com.manajemen.core;

public class LayananHosting extends Layanan {
    private int kapasitasPenyimpanan;

    public LayananHosting(String idLayanan, String namaLayanan, int harga, int kapasitasPenyimpanan) {
        super(idLayanan, namaLayanan, harga);
        this.kapasitasPenyimpanan = kapasitasPenyimpanan;
    }

    public int getKapasitasPenyimpanan() { return kapasitasPenyimpanan; }
    public void setKapasitasPenyimpanan(int kapasitasPenyimpanan) { this.kapasitasPenyimpanan = kapasitasPenyimpanan; }

    @Override
    public String getKategori() {
        return "Layanan Cloud Hosting";
    }

    @Override
    public String getDetailTambahan() {
        return "Kapasitas Storage: " + kapasitasPenyimpanan + " GB";
    }
}