package Tugas;

import java.util.Scanner;

public class CekPrimaRekursif {
    static boolean isMerekaPrima(int n, int i) {
        if (n == 0 || n == 1)
            return false;
        if (n == i)
            return true;
        if (n % i == 0)
            return false;
        return isMerekaPrima(n, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan bilangan: ");
        int n = sc.nextInt();
        System.out.println(n + (isMerekaPrima(n, 2) ? " Prima" : " Bukan Prima"));
        sc.close();
    }
}
