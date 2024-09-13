import java.util.Scanner;

public class Main {
    static int getIntScanner(Scanner scanner){
        try {
            return Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Set Nama: ");
        mhs.setNama(scanner.nextLine());
        System.out.print("Set Nim: ");
        mhs.setNim(getIntScanner(scanner));
        System.out.println();
        System.out.println("Nama: " + mhs.getNama());
        System.out.println("NIM: " + mhs.getNim());

        scanner.close();
    }
}
