package TugasIndividuToKelompok;

import java.util.Scanner;

public class pertanyaan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nilai N: ");
        int N = scanner.nextInt();
        scanner.close();
        for (int i = N - 1; i > -1; i--) {
            int k = 0;
            for (int j = 0; j < i; j++, k++) {
                System.out.print(' ');
            }
            for (int j = 1; k < N; j++, k++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
