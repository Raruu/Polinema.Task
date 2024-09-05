import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan sebuah angka bulat: ");
            try {
                int angka = Integer.parseInt(scanner.nextLine());
                System.out.println("Angka yang Anda masukkan: " + angka);
                break; // Keluar dari loop jika input valid
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka bulat yang benar.");
            }
        }
        scanner.close();


    }
}