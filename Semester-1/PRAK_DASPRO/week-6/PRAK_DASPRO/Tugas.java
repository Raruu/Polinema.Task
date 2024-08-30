import java.util.Scanner;

public class Tugas {
    public static void main(String[] args) {
        Scanner scInput = new Scanner(System.in);
        long hasilAkhir = 14700000;
        String namaBank = "BRI", noRekening = "123456789098";
        Boolean dataValid = false, transfStatus = false;
        dataValid = namaBank.equalsIgnoreCase("BRI") && noRekening.length() == 12;
        if (dataValid) {
            System.out.println(
                    "Memulai transfer uang sebesar Rp." + hasilAkhir + " ke " + noRekening + "(" + namaBank + ")");
            transfStatus = true;
            System.out.println("#############################################################");
            if (transfStatus)
                System.out.println("Transfer Berhasil");
            else {
                System.out.println("Error: ");
                System.out.println("Transfer Gagal");
            }
        } else {
            System.out.println("Data tidak valid! Mohon tijau kembali");
            System.out.println("Nama\t\t: xxxxxxxxxxxx");
            System.out.println("Nama Bank\t: " + namaBank);
            System.out.println("No Rekening\t: " + noRekening);
        }
        scInput.close();
    }
}
