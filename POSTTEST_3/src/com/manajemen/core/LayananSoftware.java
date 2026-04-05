package com.manajemen.core;

public class LayananSoftware extends Layanan {
    private String jenisLisensi;

    public LayananSoftware(String idLayanan, String namaLayanan, int harga, String jenisLisensi) {
        super(idLayanan, namaLayanan, harga);
        this.jenisLisensi = jenisLisensi;
    }

    public String getJenisLisensi() { return jenisLisensi; }
    public void setJenisLisensi(String jenisLisensi) { this.jenisLisensi = jenisLisensi; }

    @Override
    public String getKategori() {
        return "Layanan Software (SaaS)";
    }

    @Override
    public String getDetailTambahan() {
        return "Jenis Lisensi: " + jenisLisensi;
    }
}