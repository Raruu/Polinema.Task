public class Buku11 {
    String judul, pengarang;
    int halaman, stok, harga, terjual;

    public Buku11() {

    }

    public Buku11(String jud, String pg, int hal, int stok, int har) {
        judul = jud;
        pengarang = pg;
        halaman = hal;
        this.stok = stok;
        harga = har;
        terjual = 0;
    }

    void tampilInformasi() {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Jumlah halaman: " + halaman);
        System.out.println("Sisa stok: " + stok);
        System.out.println("Harga Rp: " + harga);
    }

    void terjual(int jml) {
        if (stok <= 0) {
            System.out.println("Stock habis!");
        } else if (stok - jml < 0) {
            System.out.println("Stock tidak cukup");
        } else {
            stok -= jml;
            terjual += jml;
        }
    }

    void restock(int jml) {
        stok += jml;
    }

    void gantiHarga(int hrg) {
        harga = hrg;
    }

    int hitungHargaTotal() {
        return harga * terjual;
    }

    int hitungDiskon() {
        int x = hitungHargaTotal();
        if (x > 150000) {
            x = (int) (x * 0.12);
        } else if (x >= 75000 && x <= 150000) {
            x = (int) (x * 0.05);
        } else {
            return 0;
        }
        return x;
    }

    int hitungHargaBayar() {
        return hitungHargaTotal() - hitungDiskon();
    }
}