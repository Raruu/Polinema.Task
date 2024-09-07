public class Main {
    public static void main(String[] args) {
        Peminjam peminjam = new Peminjam(123, "Aka", "Benshin", 10000);
        peminjam.cetakInfo(30);
        System.out.println();
        Lingkaran lingkaran = new Lingkaran(3.14, 21);
        lingkaran.hitungLuas();
        lingkaran.hitungKeliling();
        System.out.println();
        Barang barang = new Barang("DX12", "Tas", 1000000, 30);
        barang.tampilData();
    }
}