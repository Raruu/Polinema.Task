package com.raruukawaii.uts_sirampasien11;

import java.util.Date;

public class Pemeriksaan11 {
    private int id11;
    private Date tanggalPemeriksaan11;
    private String keluhan11;
    private String diagnosa11;
    private String tindakan11;
    private String obat11;
    private Dokter11 dokter11;

    public Pemeriksaan11(int id11, Date tanggalPemeriksaan11, String keluhan11, String diagnosa11, String tindakan11, String obat11, Dokter11 dokter11) {
        this.id11 = id11;
        this.tanggalPemeriksaan11 = tanggalPemeriksaan11;
        this.keluhan11 = keluhan11;
        this.diagnosa11 = diagnosa11;
        this.tindakan11 = tindakan11;
        this.obat11 = obat11;
        this.dokter11 = dokter11;
    }

    public int getId11() {
        return id11;
    }

    public void printInfo11() {
        System.out.println("Id: " + id11);
        System.out.print("Dokter: ");
        dokter11.printInfoIDNama();
        System.out.println("Tanggal Pemeriksaan: " + tanggalPemeriksaan11);
        System.out.println("Keluhan: " + keluhan11);
        System.out.println("Diagnosa: " + diagnosa11);
        System.out.println("Tindakan: " + tindakan11);
        System.out.println("Obat: " + obat11);
    }
}
