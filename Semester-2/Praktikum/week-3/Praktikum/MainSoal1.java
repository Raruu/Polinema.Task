package Praktikum;

import java.util.Scanner;

public class MainSoal1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BangunRuang[] bangunRuang = new BangunRuang[3];

        for (int i = 0; i < bangunRuang.length; i++) {
            if (i == 0) {
                System.out.println("Kerucut");
                System.out.print("Masukkan jari-jari: ");
                int jari = sc.nextInt();
                System.out.print("Masukkan sisi miring: ");
                int sisiMiring = sc.nextInt();
                bangunRuang[i] = new Kerucut(jari, sisiMiring);
            }
            if (i == 1) {
                System.out.println("Limas Segi-4");
                System.out.print("Masukkan panjang sisi alas: ");
                int alas = sc.nextInt();
                System.out.print("Masukkan tinggi: ");
                int tinggi = sc.nextInt();
                bangunRuang[i] = new LimasSeg4(alas, tinggi);
            }
            if (i == 2) {
                System.out.println("Bola");
                System.out.print("Masukkan jari-jari: ");
                int jari = sc.nextInt();
                bangunRuang[i] = new Bola(jari);
            }
            bangunRuang[i].printLuas();
            bangunRuang[i].printVolume();
            System.out.println();
        }

        sc.close();
    }
}
