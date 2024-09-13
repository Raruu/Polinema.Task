import java.util.Scanner;

public class Main {
    static int getIntScanner(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Wrong Input!");
            return 0;
        }
    }

    static double getDoubleScanner(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Wrong Input!");
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
        Alamat alamat = new Alamat();
        System.out.print("Set Jalan: ");
        alamat.setJalan(scanner.nextLine());
        System.out.print("Set Kota: ");
        alamat.setKota(scanner.nextLine());
        mhs.setAlamat(alamat);
        mhs.info();


        Nilai[] nilai = new Nilai[5];
        for (int i = 0; i < nilai.length; i++) {
            System.out.println("-".repeat(20));
            System.out.println("Nilai ke-" + (i + 1));
            System.out.print("Nama Matkul: ");
            String namaMatkul = scanner.nextLine();
            System.out.print("SKS: ");
            int sks = getIntScanner(scanner);
            System.out.print("Nilai Tugas: ");
            double nilaiTugas = getDoubleScanner(scanner);
            System.out.print("Nilai UTS: ");
            double nilaiUTS = getDoubleScanner(scanner);
            System.out.print("Nilai UAS: ");
            double nilaiUAS = getDoubleScanner(scanner);
            nilai[i] = new Nilai(namaMatkul, sks, nilaiTugas, nilaiUTS, nilaiUAS);
        }
        mhs.setNilai(nilai);
        System.out.println();
        mhs.printKHS();

        scanner.close();
    }
}
