package Tugas;

import java.util.Scanner;

public class DeretDescendingRekursif {
    static void rekursif(int n) {
        if (n <= 0) {
            System.out.println(n);
            return;
        }
        System.out.print(n + ", ");
        rekursif(n - 1);
    }

    static void iteratif(int n) {
        for (int i = n; i >= 0; i--) {
            System.out.print(i);
            if (i != 0)
                System.out.print(", ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        rekursif(n);
        iteratif(n);
        sc.close();
    }
}
