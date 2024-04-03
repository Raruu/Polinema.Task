package Praktikum;

import java.util.Scanner;

public class BukuMain12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PencarianBuku12 data = new PencarianBuku12();
        data.tambah(new Buku12("UwU", "Buku Atashi Dezz", 2021, "Pengarang A", 10));
        data.tambah(new Buku12("OwO", "Buku OniichanBaka", 2021, "Pengarang B", 10));
        data.tambah(new Buku12("666", "Buku Comel Terlarang", 2021, "Pengarang C", 10));
        data.tambah(new Buku12("111", "Buku Durian Runtuh", 2021, "Pengarang D", 10));
        data.tambah(new Buku12("234", "Buku Enggatau", 2021, "Pengarang E", 10));
        data.tambah(new Buku12("999", "Buku Enggatau desu", 2021, "Pengarang F", 10));
        String line = "--------------------------------------------------";

        int menu = -1;
        do {
            System.out.println(line);
            System.out.println("Data Buku:");
            data.tampil();

            System.out.println(line);
            System.out.println("Menu: ");
            System.out.println("1. Cari Data (KodeBuku)");
            System.out.println("2. Cari Data (JudulBuku)");
            System.out.println("3. Tambah Data");
            System.out.println("4. Print data dengan decsending sort berdasrakan length (JudulBuku)"); 
            System.out.println("5. Exit\n");
            System.out.print("Pilih Menu: ");
            menu = Integer.parseInt(scanner.nextLine());
            System.out.println(line);

            switch (menu) {
                case 1 -> searchBuku(scanner, data, "kode");
                case 2 -> searchBuku(scanner, data, "judul");
                case 3 -> addBuku(scanner, data);
                case 4 -> printSorted(scanner, data, "judul");
                default -> System.out.println("Menu Tidak Tersedia");
            }

            System.out.println(line);
        } while (menu != 5);

        scanner.close();
    }

    static void searchBuku(Scanner scanner, PencarianBuku12 data, String mode) {
        System.out.println("Pencarian");
        System.out.print("Masukkan " + mode.toUpperCase() + " yang dicari: ");
        String cari = scanner.nextLine();
        String separator = "=============================";
        System.out.println(separator);
        System.out.println("Menggunakan sequential search");
        int posisi = data.FindSeqSearch(cari, mode);
        data.TampilPosisi(cari, posisi);
        data.TampilData(posisi);
        System.out.println(separator);
        System.out.println("Menggunakan binary search [Array Tersort Secara descending][Coba lihat di menu 4]");
        Buku12[] sortedArr = data.descendingSort(data.listBk);
        posisi = data.FindBinarySearch(sortedArr, cari, mode);
        data.TampilPosisi(cari, posisi);
        data.TampilData(sortedArr, posisi);
        
        System.out.println("\nTekan Enter untuk lanjut...");
        scanner.nextLine();
    }

    static void addBuku(Scanner scanner, PencarianBuku12 data) {
        System.out.println("-----------------------------");
        System.out.print("Kode Buku \t : ");
        String kodeBuku = scanner.nextLine();
        System.out.print("Judul Buku \t : ");
        String judulBuku = scanner.nextLine();
        System.out.print("Tahun Terbit \t : ");
        int tahunTerbit = Integer.parseInt(scanner.nextLine());
        System.out.print("Pengarang \t : ");
        String pengarang = scanner.nextLine();
        System.out.print("Stock \t\t : ");
        int stock = Integer.parseInt(scanner.nextLine());

        Buku12 m = new Buku12(kodeBuku, judulBuku, tahunTerbit, pengarang, stock);
        data.tambah(m);
    }

    static void printSorted(Scanner scanner, PencarianBuku12 data, String mode){
        System.out.println("Descding sort berdasarkan [" + mode.toUpperCase() + "]");
        data.tampil(data.descendingSort(data.listBk));
        System.out.println("\nTekan Enter untuk lanjut...");
        scanner.nextLine();
    }
}
