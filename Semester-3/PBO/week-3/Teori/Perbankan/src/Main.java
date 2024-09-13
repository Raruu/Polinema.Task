import java.util.Scanner;

public class Main {
    static double getInputDouble(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {

            return 0;
        }
    }

    static void printSeperator() {
        System.out.println("-".repeat(20));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tabungan tabungan = new Tabungan("2341720157", "Raruu", 1000000.00);
        tabungan.cekSaldo();
        printSeperator();
        System.out.print("Tambah Uang: Rp.");
        tabungan.simpanUang(getInputDouble(scanner));
        printSeperator();
        System.out.print("Ambil Uang: Rp.");
        tabungan.ambilUang(getInputDouble(scanner));
        printSeperator();
        System.out.println("Penyesuaian saldo");
        tabungan.penyesuaianSaldo();
        printSeperator();
        System.out.print("Kirim Uang Rp.");
        tabungan.kirimUang(getInputDouble(scanner));

        scanner.close();
    }
}