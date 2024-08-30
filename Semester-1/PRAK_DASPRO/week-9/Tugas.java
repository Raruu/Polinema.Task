import java.util.Scanner;

public class Tugas {
    public static void main(String[] args) {
        Scanner scInput = new Scanner(System.in);
        System.out.print("Masukkan banyaknya elemen: ");
        int elemen = scInput.nextInt();
        int[] dataInt = new int[elemen];
        for (int i = 0; i < dataInt.length; i++) {
            System.out.print("Masukkan nilai untuk elemen " + i + " : ");
            dataInt[i] = scInput.nextInt();
        }
        int temp = 0;
        for (int i = 0; i < dataInt.length; i++) {
            for (int j = 1; j < dataInt.length - i; j++) {
                if (dataInt[j - 1] > dataInt[j]) {
                    temp = dataInt[j];
                    dataInt[j] = dataInt[j - 1];
                    dataInt[j - 1] = temp;
                }
            }
        }
        int tertinggi = dataInt[dataInt.length - 1];
        int terendah = dataInt[0];
        double rata = 0;
        for (int i : dataInt) {
            rata += i;
        }
        rata /= dataInt.length;
        System.out.println("Nilai tertinggi: " + tertinggi);
        System.out.println("Nilai terendah: " + terendah);
        System.out.println("Nilai rata: " + rata);
        scInput.close();
    }
}
