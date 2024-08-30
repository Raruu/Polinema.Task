import java.util.Scanner;

public class BukuMain12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PencarianBuku12 data = new PencarianBuku12();
        int jumBuku = 5;

        System.out.println("--------------------------------------------------");
        System.out.println("Masukkan Data buku secara urut daru KodeBuku terkecil:");
        for (int i = 0; i < jumBuku; i++) {
            System.out.println("-----------------------------");
            System.out.print("Kode Buku \t : ");
            int kodeBuku = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Judul Buku \t : ");
            String judulBuku = scanner.nextLine();
            System.out.print("Tahun Terbit \t : ");
            int tahunTerbit = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Pengarang \t : ");
            String pengarang = scanner.nextLine();
            System.out.print("Stock \t\t : ");
            int stock = scanner.nextInt();
            scanner.nextLine();

            Buku12 m = new Buku12(kodeBuku, judulBuku, tahunTerbit, pengarang, stock);
            data.tambah(m);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Data keseluruhan Buku : ");
        data.tampil();

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan Kode Buku yang ingin dicari : ");
        System.out.print("Kode Buku : ");
        int cari = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Menggunakan sequential search");
        int posisi = data.FindSeqSearch(cari);
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);

        // 6.2.3. Pertanyaan no 3
        // Buku12 dataBuku12 = data.FindBuku(cari);
        // dataBuku12.tampilDataBuku();

        System.out.println("==================================");
        System.out.println("Menggunakan binary search");
        posisi = data.FindBinarySearch(cari, 0, data.listBk.length - 1);
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);
        
        scanner.close();
    }
}
