/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.raruukawaii.siram_pasien11;

/**
 *
 * @author Raruu
 */
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SIRAM_PASIEN11 {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        List<Dokter11> dokter11s = new ArrayList<>();
        List<RekamMedik11> rekamMedik11s = new ArrayList<>();

        boolean run = true;
        while (run) {
            printMenu11();
            int menuSelect = getIntScanner11("Pilih Menu Nomer ?");
            printSeperator11();
            switch (menuSelect) {
                case 1 -> tambahPasien11(rekamMedik11s);
                case 2 -> printDaftarPasien11(rekamMedik11s);
                case 3 -> tambahDokter11(dokter11s);
                case 4 -> printDaftarDokter11(dokter11s);
                case 5 -> tambahRekamMedik11(rekamMedik11s, dokter11s);
                case 6 -> printRekamMedik11(rekamMedik11s);
                case 7 -> run = false;
            }
            printSeperator11();
        }

        scanner.close();
    }

    private static void tambahPasien11(List<RekamMedik11> rekamMedik11s) {
        System.out.println("Tambah Pasien");
        while (true) {
            int id11 = getIntScanner11("Masukkan Id");
            if (RekamMedik11.checkDuplicateId11(rekamMedik11s, id11)) {
                System.out.println("Id " + id11 + " Sudah Ada!!!");
                continue;
            }
            String nama11 = getStringScanner("Masukkan Nama");
            String alamat11 = getStringScanner("Masukkan Alamat");
            String noTelp11 = getStringScanner("Masukkan NoTelp");
            rekamMedik11s.add(new RekamMedik11(id11, new Pasien11(id11, nama11, alamat11, noTelp11)));
            break;
        }
    }

    private static void printDaftarPasien11(List<RekamMedik11> rekamMedik11s) {
        if (rekamMedik11s.isEmpty()) {
            System.out.println("Kosong Pak Cik");
            return;
        }
        System.out.println("Tampilkan Daftar Pasien");
        for (RekamMedik11 rekamMedik11 : rekamMedik11s) {
            printSeperator11();
            rekamMedik11.getPasien11().printInfo11();
        }
        printSeperator11();
    }

    private static void tambahDokter11(List<Dokter11> dokter11s) {
        System.out.println("Tambah Dokter");
        while (true) {
            int id11 = getIntScanner11("Masukkan Id");
            if (Dokter11.checkDuplicateId11(dokter11s, id11)) {
                System.out.println("Id " + id11 + " Sudah Ada!!!");
                continue;
            }
            String nama11 = getStringScanner("Masukkan Nama");
            String alamat11 = getStringScanner("Masukkan Alamat");
            String noTelp11 = getStringScanner("Masukkan NoTelp");
            String spesialisasi11 = getStringScanner("Masukkan Spesialisasi");
            dokter11s.add(new Dokter11(id11, nama11, alamat11, noTelp11, spesialisasi11));
            break;
        }
    }

    private static void printDaftarDokter11(List<Dokter11> dokter11s) {
        if (dokter11s.isEmpty()) {
            System.out.println("Kosong Pak Cik");
            return;
        }
        System.out.println("Tampilkan Daftar Dokter");
        for (Dokter11 dokter11 : dokter11s) {
            printSeperator11();
            dokter11.printInfo11();
        }
        printSeperator11();
    }

    private static void tambahRekamMedik11(List<RekamMedik11> rekamMedik11s, List<Dokter11> dokter11s) {
        System.out.println("Tambah Riwayat Pemeriksaan (Rekam Medik) Pasien");
        if (rekamMedik11s.isEmpty() || dokter11s.isEmpty()) {
            System.out.println("Pastikan Semua data ada terlebih dahulu untuk menggunakan menu ini");
            return;
        }
        RekamMedik11 rekamMedik11;
        System.out.println("List Pasien:");
        for (int i = 0; i < rekamMedik11s.size(); i++) {
            System.out.print(i + 1 + ". ");
            rekamMedik11s.get(i).getPasien11().printInfoIDNama();
        }
        rekamMedik11 = getRekamMedik11("Siapa Pasien? [int]", rekamMedik11s);

        while (true) {
            System.out.println("Pemeriksaan");
            int id11 = rekamMedik11.getDaftarPemeriksaan11().size();
            System.out.println("List Dokter:");
            for (int i = 0; i < dokter11s.size(); i++) {
                System.out.print(i + 1 + ". ");
                dokter11s.get(i).printInfoIDNama();
            }
            Dokter11 dokter11 = getDokter("Diperiksa oleh dokter", dokter11s);
            String keluhan11 = getStringScanner("Keluhan");
            String diagnosa11 = getStringScanner("Diagnosa");
            String tindakan11 = getStringScanner("Tindakan");
            String obat11 = getStringScanner("Obat");
            Date tanggalPemeriksaan11 = getLocalDateScanner11();
            rekamMedik11.tambahPemeriksaan11(new Pemeriksaan11(id11, tanggalPemeriksaan11, keluhan11, diagnosa11, tindakan11, obat11, dokter11));
            break;
        }
    }

    private static void printRekamMedik11(List<RekamMedik11> rekamMedik11s) {
        if (rekamMedik11s.isEmpty()) {
            System.out.println("Kosong Pak Cik");
            return;
        }
        System.out.println("Tampilkan Riwayat Pemeriksaan (Rekam Medik) Pasien");
        System.out.println("List Pasien:");
        for (int i = 0; i < rekamMedik11s.size(); i++) {
            System.out.print(i + 1 + ". ");
            rekamMedik11s.get(i).getPasien11().printInfoIDNama();
        }
        RekamMedik11 rekamMedik11 = getRekamMedik11("Siapa Pasien? [int]", rekamMedik11s);
        System.out.println();
        System.out.println("Id Rekam Medik: " + rekamMedik11.getId11());
        System.out.print("Pasien: ");
        rekamMedik11.getPasien11().printInfoIDNama();
        for (Pemeriksaan11 pemeriksaan11 : rekamMedik11.getDaftarPemeriksaan11()) {
            System.out.println();
            pemeriksaan11.printInfo11();
        }
    }

    private static Dokter11 getDokter(String msg, List<Dokter11> dokter11s) {
        while (true) {
            try {
                return dokter11s.get(getIntScanner11(msg) - 1);
            } catch (Exception e) {
                System.out.println("Data Tidak Ada!!!");
            }
        }
    }

    private static RekamMedik11 getRekamMedik11(String msg, List<RekamMedik11> rekamMedik11s) {
        while (true) {
            try {
                return rekamMedik11s.get(getIntScanner11(msg) - 1);
            } catch (Exception e) {
                System.out.println("Data Tidak Ada!!!");
            }
        }
    }

    private static Date getLocalDateScanner11() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Masukkan tanggal (dd/MM/yyyy): ");
            String inputTanggal = scanner.nextLine();
            try {
                LocalDate tanggal = LocalDate.parse(inputTanggal, formatter);
                System.out.println("Tanggal yang dimasukkan: " + tanggal);
                return Date.from(tanggal.atStartOfDay(ZoneId.systemDefault()).toInstant());
            } catch (Exception e) {
                System.out.println("Format tanggal salah. Harap masukkan dalam format dd/MM/yyyy");
            }
        }
    }

    private static String getStringScanner(String msg11) {
        System.out.print(msg11 + ": ");
        return scanner.nextLine();
    }

    private static int getIntScanner11(String msg) {
        while (true) {
            System.out.print(msg + ": ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Input harus int!!!");
            }
        }
    }

    private static void printMenu11() {
        System.out.print("""
                Menu Program;
                1.	Tambah Pasien
                2.	Tampilkan Daftar Pasien
                3.	Tambah Dokter
                4.	Tampilkan Daftar Dokter
                5.	Tambah Riwayat Pemeriksaan (Rekam Medik) Pasien
                6.	Tampilkan Riwayat Pemeriksaan (Rekam Medik) Pasien
                7.	Selesai               
                """);
    }

    private static void printSeperator11() {
        System.out.println("-".repeat(20));
    }
}
