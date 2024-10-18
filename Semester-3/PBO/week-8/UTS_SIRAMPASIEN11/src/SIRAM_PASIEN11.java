import java.time.LocalDate;
import java.time.OffsetTime;
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
        dummy(rekamMedik11s, dokter11s);

        boolean run = true;
        while (run) {
            printMenu11();
            int menuSelect = getIntScanner11("Pilih Menu Nomer ?");
            printSeperator11();
            switch (menuSelect) {
                case 1 -> tambahPasien11(rekamMedik11s);
                case 2 -> updatePasien11(rekamMedik11s);
                case 3 -> printDaftarPasien11(rekamMedik11s);
                case 4 -> tambahDokter11(dokter11s);
                case 5 -> updateDokter11(dokter11s);
                case 6 -> printDaftarDokter11(dokter11s);
                case 7 -> tambahRekamMedik11(rekamMedik11s, dokter11s);
                case 8 -> printRekamMedik11(rekamMedik11s);
                case 9 -> run = false;
            }
            printSeperator11();
        }

        scanner.close();
    }

    static void dummy(List<RekamMedik11> rekamMedik11s, List<Dokter11> dokter11s) {
        String[] nPas = {"Madoka", "Homura", "Mas Tukam", "Nox", "Ambatron"};
        boolean[] jenisKelaimPasien = {false, false, true, true, true};
        String[] alamatPasien = {"Tokyo", "Kyoto", "Osaka", "Jl Ombo", "Sapporo"};
        String[] noTelpPasien = {"081234567890", "082345678901", "083456789012", "12314", "085678901234"};

        String[] namaDokter = {"Rusdi asli ngawi", "Miyuki", "Nana", "Eeee", "Yatta"};
        boolean[] jenisKelaimDokter = {true, true, false, true, false};
        String[] alamatDokter = {"Shibuya", "Ginza", "Roppongi", "Akihabara", "Jl shika"};
        String[] noTelpDokter = {"081234567111", "082345678222", "083456789333", "084567890444", "61823871"};
        String[] spesialisasiDokter = {"Kardiologi", "Pediatri", "Ortopedi", "Neurologi", "Merubah orang menjadi rusa"};

        Date[] tanggalPemeriksaan = {
                new Date(2024 - 1900, 8, 1),  // Menggunakan offset tahun 1900 untuk membuat tanggal
                new Date(2024 - 1900, 8, 2),
                new Date(2024 - 1900, 8, 3),
                new Date(2024 - 1900, 8, 4),
                new Date(2024 - 1900, 8, 5)
        };
        String[] keluhan = {"Sakit kepala", "Demam tinggi", "Nyeri punggung", "Sesak napas", "Ruam kulit"};
        String[] diagnosa = {"Migrain", "Infeksi Virus", "Cedera otot", "Asma", "Alergi kulit"};
        String[] tindakan = {"Pemeriksaan fisik", "Pemberian obat antipiretik", "Terapi fisik", "Pemeriksaan paru", "Salep anti-alergi"};
        String[] obat = {"Parasetamol", "Ibuprofen", "Meloxicam", "Inhaler", "Hydrocortisone cream"};

        for (int i = 0; i < 5; i++) {
            rekamMedik11s.add(new RekamMedik11(1000 + i, new Pasien11(1000 + i, nPas[i], jenisKelaimPasien[i], alamatPasien[i], noTelpPasien[i])));
            Dokter11 doketer = new Dokter11(7000 + i, namaDokter[i], jenisKelaimDokter[i], alamatDokter[i], noTelpDokter[i], spesialisasiDokter[i]);
            dokter11s.add(doketer);
            Pemeriksaan11[] pemeriksaan11 = new Pemeriksaan11[2];
            for (int j = 0; j < 2; j++) {
                pemeriksaan11[j] = new Pemeriksaan11(rekamMedik11s.get(i).getDaftarPemeriksaan11().size(),
                        tanggalPemeriksaan[j], keluhan[j], diagnosa[j], tindakan[j], obat[j], doketer);
                rekamMedik11s.get(i).tambahPemeriksaan11(pemeriksaan11[j]);
            }
        }
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
            boolean jenisKelamin = getStringScanner("Jenis Kelamin [L/P]").equalsIgnoreCase("L");
            String alamat11 = getStringScanner("Masukkan Alamat");
            String noTelp11 = getStringScanner("Masukkan NoTelp");
            rekamMedik11s.add(new RekamMedik11(id11, new Pasien11(id11, nama11, jenisKelamin, alamat11, noTelp11)));
            break;
        }
    }

    private static void updatePasien11(List<RekamMedik11> rekamMedik11s) {
        if (rekamMedik11s.isEmpty()) {
            System.out.println("Kosong Pak Cik");
            return;
        }
        int noUrut = 1;
        System.out.println("Daftar Pasien");
        for (RekamMedik11 rekamMedik11 : rekamMedik11s) {
            System.out.println(noUrut + " " + rekamMedik11.getPasien11().getNama11());
            noUrut++;
        }
        noUrut = getIntScanner11("Masukkan no urut yang akan diupdate") - 1;
        if (noUrut < 0 || noUrut >= rekamMedik11s.size()) {
            System.out.println("No Urut tidak ada tuan");
            return;
        }
        RekamMedik11 rekamMedik11 = rekamMedik11s.get(noUrut);
        printSeperator11();
        System.out.println("Kosongkan untuk tidak mengganti value");
        System.out.println("Mengupdate data Pasien [" + rekamMedik11.getPasien11().getNama11() + "]");
        String nama11 = getStringScanner("Masukkan Nama");
        String inputKelamin = getStringScanner("Jenis Kelamin [L/P]");
        String alamat11 = getStringScanner("Masukkan Alamat");
        String noTelp11 = getStringScanner("Masukkan NoTelp");
        if (!nama11.isBlank()) {
            rekamMedik11.getPasien11().setNama11(nama11);
        }
        if (!inputKelamin.isBlank()) {
            rekamMedik11.getPasien11().setJenisKelamin11(nama11);
        }
        if (!alamat11.isBlank()) {
            rekamMedik11.getPasien11().setAlamat11(alamat11);
        }
        if (!noTelp11.isBlank()) {
            rekamMedik11.getPasien11().setNoTelp11(noTelp11);
        }
        printSeperator11();
        System.out.println("Selesai!");
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
            boolean jenisKelamin = getStringScanner("Jenis Kelamin [L/P]").equalsIgnoreCase("L");
            String alamat11 = getStringScanner("Masukkan Alamat");
            String noTelp11 = getStringScanner("Masukkan NoTelp");
            String spesialisasi11 = getStringScanner("Masukkan Spesialisasi");
            dokter11s.add(new Dokter11(id11, nama11, jenisKelamin, alamat11, noTelp11, spesialisasi11));
            break;
        }
    }

    private static void updateDokter11(List<Dokter11> dokter11s) {
        if (dokter11s.isEmpty()) {
            System.out.println("Kosong Pak Cik");
            return;
        }
        int noUrut = 1;
        System.out.println("Daftar Pasien");
        for (Dokter11 dokter11 : dokter11s) {
            System.out.println(noUrut + " " + dokter11.getNama11());
            noUrut++;
        }
        noUrut = getIntScanner11("Masukkan no urut yang akan diupdate") - 1;
        if (noUrut < 0 || noUrut >= dokter11s.size()) {
            System.out.println("No Urut tidak ada tuan");
            return;
        }
        Dokter11 dokter11 = dokter11s.get(noUrut);
        printSeperator11();
        System.out.println("Kosongkan untuk tidak mengganti value");
        System.out.println("Mengupdate data Pasien [" + dokter11.getNama11() + "]");
        String nama11 = getStringScanner("Masukkan Nama");
        String inputKelamin = getStringScanner("Jenis Kelamin [L/P]");
        String alamat11 = getStringScanner("Masukkan Alamat");
        String noTelp11 = getStringScanner("Masukkan NoTelp");
        String spesialisasi11 = getStringScanner("Masukkan Spesialisasi");
        if (!nama11.isBlank()) {
            dokter11.setNama11(nama11);
        }
        if (!inputKelamin.isBlank()) {
            dokter11.setJenisKelamin11(nama11);
        }
        if (!alamat11.isBlank()) {
            dokter11.setAlamat11(alamat11);
        }
        if (!noTelp11.isBlank()) {
            dokter11.setNoTelp11(noTelp11);
        }
        if(!spesialisasi11.isBlank()){
            dokter11.setSpesialisasi11(spesialisasi11);
        }
        printSeperator11();
        System.out.println("Selesai!");
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
                return Date.from(tanggal.atTime(OffsetTime.now()).toInstant());
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
                1. Tambah Pasien
                2. Update Data Pasien
                3. Tampilkan Daftar Pasien
                4. Tambah Dokter
                5. Update Data Dokter
                6. Tampilkan Daftar Dokter
                7. Tambah Riwayat Pemeriksaan (Rekam Medik) Pasien
                8. Tampilkan Riwayat Pemeriksaan (Rekam Medik) Pasien
                9. Selesai                
                """);
    }

    private static void printSeperator11() {
        System.out.println("-".repeat(20));
    }
}