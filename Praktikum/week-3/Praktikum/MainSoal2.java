package Praktikum;

import java.util.Scanner;

public class MainSoal2 {
    public static void printRataIPK(Mahasiswa[] arr){
        double rataIpk = 0;
        for (int i = 0; i < arr.length; i++) {
            rataIpk += arr[i].ipk;
        }
        rataIpk /= arr.length;
        System.out.println("\nRata-rata IPK: " + rataIpk);
    }

    public static void printIPKTerbesar(Mahasiswa[] arr){
        double ipkTerbesar = 0;
        for (int i = 0; i < arr.length; i++) {
            if (ipkTerbesar < arr[i].ipk)
                ipkTerbesar = arr[i].ipk;
        }
        System.out.println("IPK Terbesar: " + ipkTerbesar);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mahasiswa[] arrMahasiswa = new Mahasiswa[3];

        for (int i = 0; i < arrMahasiswa.length; i++) {
            System.out.println("Masukkan data Mahasiswa ke-" + (i + 1));
            System.out.print("Masukkan nama: ");
            String nama = sc.nextLine();
            System.out.print("Masukkan nim: ");
            String nim = sc.nextLine();
            System.out.print("Masukkan jenis kelamin: ");
            char kelamin = sc.nextLine().charAt(0);
            System.out.print("Masukkan IPK: ");
            double ipk = sc.nextDouble();
            sc.nextLine();            
            arrMahasiswa[i] = new Mahasiswa(nama, nim, kelamin, ipk);
        }
        System.out.println();
        for (int i = 0; i < arrMahasiswa.length; i++) {
            System.out.println("Data Mahasiswa ke-" + (i + 1));
            arrMahasiswa[i].printData();
        }       

        System.out.println();
        printRataIPK(arrMahasiswa);
        printIPKTerbesar(arrMahasiswa);
        
        sc.close();
    }
}
