package TugasIndividuToKelompok;

import java.util.Scanner;

public class pertanyaan2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nilai N: ");
        int N = scanner.nextInt();
        scanner.close();
        for (int i = N; i > 0; i--) {
            for (int j = N - i; j < N; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
