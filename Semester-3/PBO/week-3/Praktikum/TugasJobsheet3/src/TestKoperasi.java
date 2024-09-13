import java.util.Scanner;

public class TestKoperasi {
    static int getIntScanner(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Anggota donny = new Anggota("111333444", "Donny", 5000000);
        System.out.println("Nama Anggota: " + donny.getNama());
        System.out.println("Limit Pinjaman: " + donny.getLimitPinjaman());
        while (true) {
            System.out.println("\nJumlah pinjaman saat ini: " + donny.getJumlahPinjaman());
            System.out.println("""
                    0. Exit
                    1. Pinjam
                    2. Angsur (minimal dari jumlah pinjam 10%)
                    """);
            int menu = getIntScanner(scanner);
            if(menu ==0){
                break;
            }
            if(menu == 1){
                System.out.print("Pinjam: Rp.");
                donny.pinjam(getIntScanner(scanner));
            }
            if(menu == 2){
                System.out.print("Angsur: Rp.");
                donny.angsur(getIntScanner(scanner));
            }
        }

        scanner.close();
    }
}