package com.manajemen.core;

public class LayananJaringan extends Layanan {
    private int kecepatanMbps;

    public LayananJaringan(String idLayanan, String namaLayanan, int harga, int kecepatanMbps) {
        super(idLayanan, namaLayanan, harga);
        this.kecepatanMbps = kecepatanMbps;
    }

    public int getSpeed() { return kecepatanMbps; }
    public void setSpeed(int kecepatanMbps) { this.kecepatanMbps = kecepatanMbps; }

    @Override
    public String getKategori() {
        return "Layanan Instalasi Jaringan";
    }

    @Override
    public String getDetailTambahan() {
        return "Kecepatan Jaringan: " + kecepatanMbps + " Mbps";
    }
}