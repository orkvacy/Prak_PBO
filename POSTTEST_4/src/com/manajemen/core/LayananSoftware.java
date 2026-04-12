package com.manajemen.core;

public class LayananSoftware extends Layanan {
    private String jenisLisensi;

    public LayananSoftware(String idLayanan, String namaLayanan, int harga, String jenisLisensi) {
        super(idLayanan, namaLayanan, harga);
        this.jenisLisensi = jenisLisensi;
    }

    public String getJenisLisensi() { return jenisLisensi; }
    public void setJenisLisensi(String jenisLisensi) { this.jenisLisensi = jenisLisensi; }

    // ovr
    @Override
    public String getKategori() {
        return "Layanan Software (SaaS)";
    }

    @Override
    public String getDetailTambahan() {
        return "Jenis Lisensi: " + jenisLisensi;
    }

    @Override
    public int hitungDiskon() {
        switch (jenisLisensi) {
            case "Enterprise":
                return 20;
            case "Tim":
                return 10;
            default: // Personal
                return 0;
        }
    }
}