package Tugas;

import java.util.Scanner;

public class PembeliMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue : ");
        int jumlah = Integer.parseInt(sc.nextLine());
        Queue antri = new Queue(jumlah);

        int pilih;
        do {
            menu();
            pilih = Integer.parseInt(sc.nextLine());
            switch (pilih) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("No HP: ");
                    int noHP = Integer.parseInt(sc.nextLine());
                    Pembeli nb = new Pembeli(nama, noHP);
                    antri.enqueue(nb);
                    break;
                case 2:
                    Pembeli data = antri.dequeue();
                    if (!"".equals(data.nama) && data.noHP != 0) {
                        System.out.println("Antrian yang keluar: " + data.nama + " " + data.noHP);
                    }
                    break;
                case 3:
                    antri.peek();
                    break;
                case 4:
                    // antri.print();
                    antri.daftarPembeli();
                    break;
                case 5:
                    antri.peekRear();
                    break;
                case 6:
                    System.out.print("Nama yang dicari: ");
                    String key = sc.nextLine();
                    antri.peekPosition(key);
                    break;
                default:
                    break;
            }
        } while (pilih > 0 && pilih < 7);
        sc.close();
    }

    public static void menu() {
        System.out.println("Masukkan operasi yang diinginkan : ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian Keluar");
        System.out.println("3. Cek antrian terdepan");
        System.out.println("4. Cek semua antrian");
        System.out.println("5. Cek Antrian paling belakang");
        System.out.println("6. Cek Antrian orang");
        System.out.println("-------------------");
    }
}
