package Percobaan6;

public class Truk extends Kendaraan{
    private int bobotMax;

    public Truk(String merk, int tahunProduksi, int bobotMax) {
        super(merk, tahunProduksi);
        this.bobotMax = bobotMax;
    }

    @Override
    void jalankan() {
        System.out.println("Truck " + merk + " berjalan...");
    }

    @Override
    void info() {
        super.info();
        System.out.println("Bobot Max Pada Truck: " + bobotMax+" Ton");
    }
}
