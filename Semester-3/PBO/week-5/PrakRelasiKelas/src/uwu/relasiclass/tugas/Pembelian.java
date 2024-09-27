package uwu.relasiclass.tugas;

public class Pembelian {
    private Produk produk;
    private int jumlah;
    private double jumlahHarga;

    public Pembelian(Produk produk, int jumlah) {
        this.produk = produk;
        this.jumlah = jumlah;
        jumlahHarga = produk.hitungHarga(jumlah);
    }

    public Produk getProduk() {
        return produk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getJumlahHarga() {
        return jumlahHarga;
    }
}
