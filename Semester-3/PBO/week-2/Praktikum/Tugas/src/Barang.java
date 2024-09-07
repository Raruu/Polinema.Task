public class Barang {
    String kode;
    String namaBarang;
    int hargaDasar;
    float diskon;

    public Barang() {
    }

    public Barang(String kode, String namaBarang, int hargaDasar, float diskon) {
        this.kode = kode;
        this.namaBarang = namaBarang;
        this.hargaDasar = hargaDasar;
        this.diskon = diskon;
    }

    public int hitungHargaJual() {
        return hargaDasar - (int) ((diskon / 100) * hargaDasar);
    }

    public void tampilData() {
        System.out.println("Kode: " + kode);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Harga Dasar: " + hargaDasar);
        System.out.println("Harga Jual: " + hitungHargaJual());
    }
}
