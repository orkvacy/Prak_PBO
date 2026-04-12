package com.manajemen.core;

public class LayananHosting extends Layanan {
    private int kapasitasPenyimpanan;

    public LayananHosting(String idLayanan, String namaLayanan, int harga, int kapasitasPenyimpanan) {
        super(idLayanan, namaLayanan, harga);
        this.kapasitasPenyimpanan = kapasitasPenyimpanan;
    }

    public int getKapasitasPenyimpanan() { return kapasitasPenyimpanan; }
    public void setKapasitasPenyimpanan(int kapasitasPenyimpanan) { this.kapasitasPenyimpanan = kapasitasPenyimpanan; }

    // ovr
    @Override
    public String getKategori() {
        return "Layanan Cloud Hosting";
    }

    @Override
    public String getDetailTambahan() {
        return "Kapasitas Storage: " + kapasitasPenyimpanan + " GB";
    }


    @Override
    public int hitungDiskon() {
        if (kapasitasPenyimpanan > 500) {
            return 15;
        } else if (kapasitasPenyimpanan > 100) {
            return 10;
        } else {
            return 5;
        }
    }
}