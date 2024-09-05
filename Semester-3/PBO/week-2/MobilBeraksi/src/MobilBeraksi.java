public class MobilBeraksi {
    public static void main(String[] args) {
       Mobil mobil = new Mobil("Putih", "Loli", 2017);
       mobil.CetakDataMobil(2);

       mobil.warna = "Merah";
       mobil.namaPemilik = "Chino";
       mobil.tahunProduksi = 2024;

        System.out.println("--------------------------------------------------");
        mobil.CetakDataMobil();
        System.out.println("--------------------------------------------------");
        mobil.CetakDataMobil(2);
    }
}