package Tugas;

import java.util.Scanner;

public class TugasNo2_13 {
    private static Scanner scanner;

    public static int[][] inputData(String[] name, int[][] arrData) {
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < arrData[i].length; j++) {
                System.out.print("Nilai untuk " + name[i] + " pada minggu ke-" + (j + 1) + ": ");
                arrData[i][j] = scanner.nextInt();
            }
        }
        System.out.println("\nInput Selesai\n");
        return arrData;
    }

    public static void printNilai(String[] name, int[][] arrData) {
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < arrData[i].length; j++) {
                System.out.println("Nilai " + name[i] + " pada minggu ke-" + (j + 1) + ": " + arrData[i][j]);
            }
        }
        System.out.println("\nPrint Nilai Selesai\n");
    }

    public static int mingguTertinggi(int[][] arrData) {
        int[] sumEveryWeeks = new int[arrData[0].length];
        for (int i = 0; i < arrData[0].length; i++) {
            for (int j = 0; j < arrData.length; j++) {
                sumEveryWeeks[i] += arrData[j][i];
            }
        }
        int highest = sumEveryWeeks[0];
        int week = 1;
        for (int i = 1; i < sumEveryWeeks.length; i++) {
            if (highest < sumEveryWeeks[i]) {
                highest = sumEveryWeeks[i];
                week = i + 1;
            }
        }
        return week;
    }

    public static void printTertinggi(String[] name, int[][] arrData) {
        int highest = 0, index = 0;
        for (int i = 0; i < arrData.length; i++) {
            for (int j = 0; j < arrData[i].length; j++) {
                if (highest < arrData[i][j]) {
                    highest = arrData[i][j];
                    index = i;
                }
            }
        }
        System.out.println(name[index] + " memiliki nilai tertinggi yaitu " + highest + " pada minggu ke-"
                + mingguTertinggi(arrData));
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah Mahasiswa: ");
        int jumMaha = scanner.nextInt();
        System.out.print("Masukkan jumlah Minggu: ");
        int jumMinggu = scanner.nextInt();
        String[] namaMaha = new String[jumMaha];
        scanner.nextLine();
        for (int i = 0; i < namaMaha.length; i++) {
            System.out.print("Masukkan nama Mahasiswa ke-" + (i + 1) + " :");
            namaMaha[i] = scanner.nextLine();
        }
        int[][] nilaiMaha = new int[jumMaha][jumMinggu];
        nilaiMaha = inputData(namaMaha, nilaiMaha);
        printNilai(namaMaha, nilaiMaha);
        System.out.println(
                "Pada minggu ke-" + mingguTertinggi(nilaiMaha) + " adalah jumlah tertinggi dari minggu yang lain");
        printTertinggi(namaMaha, nilaiMaha);
        scanner.close();
    }
}
