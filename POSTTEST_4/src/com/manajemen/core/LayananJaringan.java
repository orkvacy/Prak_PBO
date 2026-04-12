package com.manajemen.core;

public class LayananJaringan extends Layanan {
    private int kecepatanMbps;

    public LayananJaringan(String idLayanan, String namaLayanan, int harga, int kecepatanMbps) {
        super(idLayanan, namaLayanan, harga);
        this.kecepatanMbps = kecepatanMbps;
    }

    public int getSpeed() { return kecepatanMbps; }
    public void setSpeed(int kecepatanMbps) { this.kecepatanMbps = kecepatanMbps; }

    // ovr
    @Override
    public String getKategori() {
        return "Layanan Instalasi Jaringan";
    }


    @Override
    public String getDetailTambahan() {
        return "Kecepatan Jaringan: " + kecepatanMbps + " Mbps";
    }

    @Override
    public int hitungDiskon() {
        if (kecepatanMbps > 1000) {
            return 10;
        } else if (kecepatanMbps > 100) {
            return 5;
        } else {
            return 0;
        }
    }
}