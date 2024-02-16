import java.util.Scanner;

public class Array {

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

    public static float nilaiSetara(float x) {
        if (x > 80 && x <= 100)
            return 4f;
        if (x > 73 && x <= 80)
            return 3.5f;
        if (x > 65 && x <= 73)
            return 3f;
        if (x > 60 && x <= 65)
            return 2.5f;
        if (x > 50 && x <= 60)
            return 2f;
        if (x > 39 && x <= 50)
            return 1f;
        return 0f;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String separator = "==================================";
        System.out.println(separator + "\nProgram Menghitungan IP Semester\n" + separator);
        String[] matKul = { "Pancasila", "Konsep Teknologi Informasi", "Critical Thinking dan Problem Solving",
                "Matematika Dasar", "Bahasa Inggris", "Dasar Pemrograman", "Praktikum Dasar Pemrograman",
                "Keselamatan dan Kesehatan Kerja" };
        int[] sks = { 2, 2, 2, 3, 2, 2, 3, 2 };

        int[] nilaiAngka = new int[matKul.length];
        for (int i = 0; i < matKul.length; i++) {
            System.out.print("Masukkan nilai Angka untuk MK " + matKul[i] + ": ");
            nilaiAngka[i] = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println(separator + "\nHasil Konversi Nilai\n" + separator);
        System.out.printf("%-40s%-20s%-20s%-20s\n", "MatKul", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");
        for (int i = 0; i < matKul.length; i++) {
            System.out.printf("%-40s%-20s%-20s%-20s\n", matKul[i], nilaiAngka[i], nilaiHuruf(nilaiAngka[i]),
                    nilaiSetara(nilaiAngka[i]));
        }
        System.out.println(separator);

        float nilaiTotal = 0f;
        for (int i = 0; i < nilaiAngka.length; i++) {
            nilaiTotal += nilaiSetara(nilaiAngka[i]) * sks[i];
        }
        int sksTotal = 0;
        for (int i : sks) {
            sksTotal += i;
        }

        float ip = nilaiTotal / sksTotal;
        System.out.printf("IP : %.2f\n", ip);

        scanner.close();
    }
}
