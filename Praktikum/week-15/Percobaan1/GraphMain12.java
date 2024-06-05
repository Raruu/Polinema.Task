package Percobaan1;

import java.util.Scanner;

public class GraphMain12 {
    public static void main(String[] args) {
        Graph12 gedung = new Graph12(6);
        gedung.addEdge(0, 1, 50);
        gedung.addEdge(0, 2, 100);
        gedung.addEdge(1, 3, 70);
        gedung.addEdge(2, 3, 40);
        gedung.addEdge(3, 4, 60);
        gedung.addEdge(4, 5, 80);
        gedung.degree(0);
        gedung.removeEdge(1, 3);
        gedung.printGraph();

        Scanner iwak = new Scanner(System.in);
        System.out.println("\n[Masukkan -1 pada asal untuk keluar]\n");

        while (true) {
            System.out.print("Masukkan gedung asal: ");
            int gedungAsal = Integer.parseInt(iwak.nextLine());
            if (gedungAsal < 0)
                break;
            System.out.print("Masukkan gedung tujuan: ");
            int gedungTujuan = Integer.parseInt(iwak.nextLine());
            if (gedungTujuan < 0)
                break;

            gedung.checkPath(gedungAsal, gedungTujuan);
            System.out.println();
        }

        iwak.close();
    }
}
