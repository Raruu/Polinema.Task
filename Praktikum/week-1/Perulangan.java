import java.util.Scanner;

public class Perulangan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.println("==================================");

        int n = Integer.parseInt(nim.substring(nim.length() - 2));
        n = (n < 10) ? n + 10 : n;

        System.out.println("n: " + n);
        System.out.print("OUTPUT: ");

        for (int i = 1; i <= n; i++) {
            if (i == 6 || i == 10) {
                continue;
            }
            if (i % 2 == 1) {
                System.out.print("*");
            } else {
                System.out.print(i);
            }
            System.out.print(" ");
        }

        scanner.close();
    }
}
