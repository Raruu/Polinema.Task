public class Mobil {
    String warna;
    String namaPemilik;
    int tahunProduksi;

    public Mobil(String warna, String namaPemilik, int tahunProduksi) {
        this.warna = warna;
        this.namaPemilik = namaPemilik;
        this.tahunProduksi = tahunProduksi;
    }

    public void CetakDataMobil() {
        System.out.println("Warna mobil: " + warna);
        System.out.println("Name pemilik: " + tahunProduksi);
    }

    public void CetakDataMobil(int x) {
        System.out.println("Warna mobil: " + warna);
        System.out.println("Name pemilik: " + tahunProduksi);
        System.out.println("Tahun Produksi: " + tahunProduksi);
    }
}
