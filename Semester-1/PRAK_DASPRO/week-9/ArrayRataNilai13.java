import java.util.Scanner;

public class ArrayRataNilai13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa : ");
        int jumMahasiswa = sc.nextInt();
        int[] nilaiMhs = new int[jumMahasiswa];
        double rata2 = 0, rata2_tidakLulus = 0;
        int countLulus = 0;
        for (int i = 0; i < nilaiMhs.length; i++) {
            System.out.print("Masukkan nilai mahasiswa ke-" + (i + 1) + " : ");
            nilaiMhs[i] = sc.nextInt();
        }
        for (int i = 0; i < nilaiMhs.length; i++) {
            if (nilaiMhs[i] > 70) {
                rata2 += nilaiMhs[i];
                countLulus++;
            } else
                rata2_tidakLulus += nilaiMhs[i];
        }
        rata2 /= countLulus;
        rata2_tidakLulus /= (nilaiMhs.length - countLulus);
        System.out.println("Rata-rate nilai lulus= " + rata2);
        System.out.println("Rata-rate nilai tidak lulus= " + rata2_tidakLulus);
        sc.close();
    }
}