import java.util.Scanner;

public class Pemilihan {
    public static boolean checkNilai(int[] arr) {
        for (int i : arr) {
            if (i > 100)
                return false;
        }
        return true;
    }

    public static String nilaiHuruf(float x) {
        if (x > 80 && x <= 100)
            return "A";
        if (x > 73 && x <= 80)
            return "B+";
        if (x > 65 && x <= 73)
            return "B";
        if (x > 60 && x <= 65)
            return "C+";
        if (x > 50 && x <= 60)
            return "C";
        if (x > 39 && x <= 50)
            return "D";
        return "E";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String separator = "==================================";
        System.out.println("Program Menghitung Nilai Akhir\n" + separator);
        String[] titles = { "Tugas", "Kuis", "UTS", "UAS" };
        float[] persen = { 20f, 20f, 30f, 30f };
        int[] inputNilai = new int[titles.length];
        float nilaiAkhir = 0f;

        for (int i = 0; i < titles.length; i++) {
            System.out.print("Masukkan Nilai " + titles[i] + ": ");
            inputNilai[i] = scanner.nextInt();
            scanner.nextLine();
            nilaiAkhir += inputNilai[i] * (persen[i] / 100);
        }
        System.out.println(separator + "\n" + separator);

        if (checkNilai(inputNilai)) {
            System.out.println("Nilai Akhir : " + nilaiAkhir);
            System.out.println("Nilai Huruf: " + nilaiHuruf(nilaiAkhir));
            System.out.println(separator + "\n" + separator);
            System.out.println("SELAMAT ANDA LULUS");
        } else {
            System.out.println("Nilai Tidak Valid");
            System.out.println(separator + "\n" + separator);
        }
        scanner.close();
    }
}