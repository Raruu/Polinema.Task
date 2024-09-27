package uwu.relasiclass.tugas;

public class Produk {
    private String nama, kategori;
    private int stok;
    private double harga;

    public Produk(String nama, String kategori, int stok, double harga) {
        this.nama = nama;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
    }

    public void kurangiStok(int jumlah){
        if(jumlah >= stok){
            System.out.println("Stok tidak cukup!");
            return;
        }
        stok -= jumlah;
    }

    public String getNama() {
        return nama;
    }

    public double hitungHarga(int jummlah){
        return harga * jummlah;
    }
}
