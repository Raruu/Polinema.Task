package Percobaan_2;

import java.util.Scanner;

public class Utama12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kapasitas Gudang: ");
        Gudang12 gudang = new Gudang12(Integer.parseInt(scanner.nextLine()));

        while (true) {
            System.out.println("\n[Kapasitas: " + gudang.size + " Terisi: " + (gudang.top + 1) + "]");
            System.out.println("Menu: ");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Ambil Barang");
            System.out.println("3. Tampilkan tumpukan Barang");
            System.out.println("4. Lihat Barang teratas");
            System.out.println("0. Keluar");
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
                    gudang.lihatBarangTeratas();
                    break;
                case 0:
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
