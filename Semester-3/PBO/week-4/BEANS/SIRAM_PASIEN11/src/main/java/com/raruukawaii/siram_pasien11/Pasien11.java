package com.raruukawaii.siram_pasien11;

import java.util.List;

public class Pasien11 {
    private int id11;
    private String nama11;
    private String alamat11;
    private String noTelp11;
    private RekamMedik11 rekamMedik11;

    public Pasien11(int id11, String nama11, String alamat11, String noTelp11) {
        this.id11 = id11;
        this.nama11 = nama11;
        this.alamat11 = alamat11;
        this.noTelp11 = noTelp11;
    }

    public int getId11() {
        return id11;
    }

    public void printInfo11() {
        System.out.println("Id: " + id11);
        System.out.println("Nama: " + nama11);
        System.out.println("Alamat: " + alamat11);
        System.out.println("NO Telp: " + noTelp11);
    }

    public void printInfoIDNama() {
        System.out.println("[" + id11 + "] " + nama11);
    }
}
