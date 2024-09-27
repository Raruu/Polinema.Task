package uwu.relasiclass.tugas;

public class Main {
    public static void main(String[] args) {
        Produk susu = new Produk("Susu", "Minuman", 10, 12000.0);
        Produk mie = new Produk("Mie", "Makanan", 100, 2000.0);

        KeranjangBelanja keranjangBelanja = new KeranjangBelanja();
        keranjangBelanja.tambahBarang(new Pembelian(susu, 2));
        susu.kurangiStok(2);
        keranjangBelanja.tambahBarang(new Pembelian(mie, 5));
        mie.kurangiStok(5);

        Pelanggan pelanggan = new Pelanggan("Kuma", "Jl uwu", "uwu@gmail.uwu", "123456789");
        pelanggan.lakukanPembelian(keranjangBelanja);
        pelanggan.printIdentitas();
        System.out.println();
        pelanggan.printRiwayat();
    }
}
