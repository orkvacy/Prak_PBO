package com.manajemen.core;

public class Pelanggan {
    private String idPelanggan;
    private String nama;
    private String email; // field baru

    // constr
    public Pelanggan(String idPelanggan, String nama) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.email = "-"; // default
    }

    public Pelanggan(String idPelanggan, String nama, String email) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.email = email;
    }

    public String getIdPelanggan() { return idPelanggan; }
    public void setIdPelanggan(String idPelanggan) { this.idPelanggan = idPelanggan; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}