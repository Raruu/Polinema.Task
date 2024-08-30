import java.util.Scanner;

public class HargaBayar13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int harga, jumlah, jmlHalaman_Buku;
        String merk_Buku;
        double dis, total, bayar, jmlDis;
        System.out.println("Masukkan merk Buku ");
        merk_Buku = input.nextLine();
        System.out.println("Masukkan banyak halaman Buku");
        jmlHalaman_Buku = input.nextInt();
        System.out.println("Masukkan harga barang yang dibeli ");
        harga = input.nextInt();
        System.out.println("Masukkan Jumlah jumlah barang yang dibeli ");
        jumlah = input.nextInt();
        System.out.println("Masukkan persentase diskon dalam bentuk desimal ");
        dis = input.nextDouble();
        total = harga * jumlah;
        jmlDis = total * dis;
        bayar = total - jmlDis;
        System.out.println("Diskon yang anda dapatkan adalah " + jmlDis);
        System.out.println("Jumlah yang harus dibayar adalah " + bayar);
        System.out.println("Merk buku yang dimasukkan: " + merk_Buku);
        System.out.println("Banyak halaman buku: " + jmlHalaman_Buku);
        input.close();
    }
}
