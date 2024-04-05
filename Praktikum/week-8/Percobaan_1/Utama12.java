package Percobaan_1;

import java.util.Scanner;

public class Utama12 {
    public static void main(String[] args) {
        Gudang12 gudang = new Gudang12(7);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu: ");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Ambil Barang");
            System.out.println("3. Tampilkan tumpukan Barang");
            System.out.println("4. Keluar");
            System.out.print("Pilih operasi: ");
            int pilihan = Integer.parseInt(scanner.nextLine());

            boolean stop = false;
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    int kode = Integer.parseInt(scanner.nextLine());
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nama kategori: ");
                    String kategori = scanner.nextLine();
                    Barang12 barangBaru = new Barang12(kode, nama, kategori);
                    gudang.tambahBarang(barangBaru);
                    break;
                case 2:
                    gudang.ambilBarang();
                    break;
                case 3:
                    gudang.tampilkanBarang();
                    break;
                case 4:
                    stop = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }

            if (stop)
                break;
        }
        scanner.close();
    }
}
