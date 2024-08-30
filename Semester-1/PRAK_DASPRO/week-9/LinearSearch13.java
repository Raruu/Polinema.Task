import java.util.Scanner;

public class LinearSearch13 {
    public static void main(String[] args) {
        Scanner scInput = new Scanner(System.in);
        System.out.print("Masukkan jumlah elemen array: ");
        int elemen = scInput.nextInt();
        int[] arrayInt = new int[elemen];
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.print("Masukkan elemen array ke-" + i + " : ");
            arrayInt[i] = scInput.nextInt();
        }
        System.out.print("Masukkan key yang ingin dicari: ");
        int key = scInput.nextInt();
        int hasil = 0;
        Boolean keyFound = false;
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] == key) {
                hasil = i;
                keyFound = true;
                break;
            }
        }
        if (keyFound)
            System.out.println("Key ada di posisi indeks ke-" + hasil);
        else
            System.out.println("Key tidak ditemukan");
        scInput.close();
    }
}
