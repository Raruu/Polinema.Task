import java.util.Scanner;

public class MainAlatMusik12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AlatMusik12[] alatArr = new AlatMusik12[5];

        System.out.println("===========================");
        System.out.println("Input");
        System.out.println("===========================");

        for (int i = 0; i < alatArr.length; i++) {
            System.out.println("Alat Musik ke-" + (i+1));
            System.out.print("Masukkan Nama: ");
            String nama = sc.nextLine();
            System.out.print("Masukkan Merk: ");
            String merk = sc.nextLine();
            System.out.print("Masukkan Kategori: ");
            String kategori = sc.nextLine();
            System.out.print("Masukkan Stok: ");
            int stok = sc.nextInt();
            System.out.print("Masukkan Jumlah Terjual: ");
            int jumlah = sc.nextInt();
            sc.nextLine();
            System.out.println();
            alatArr[i] = new AlatMusik12(nama, merk, kategori, stok, jumlah);
        } 

        System.out.println("===========================");
        System.out.println("Output");
        System.out.println("===========================");
        for (int i = 0; i < alatArr.length; i++) {
            System.out.println("Alat Musik ke-" + (i+1));
            alatArr[i].tampil();     
            alatArr[i].hitungSisa(); 
            System.out.println();      
        }
        AlatMusik12.cariAlatMusikTidakLaku(alatArr);
        System.out.println();
        AlatMusik12.daftarAlatMusik(alatArr);
        sc.close();
    }
}
