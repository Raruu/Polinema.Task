package Tugas2;

public class Kapal extends Kendaraan implements RefillFuel{
    public String jenisKapal;

    public Kapal(int jumlahRoda, int kecepatanMaksimum, String jenisBahanBakar, String jenisKapal) {
        super(jumlahRoda, kecepatanMaksimum, jenisBahanBakar);
        this.jenisKapal = jenisKapal;
    }

    public void turunkanJangkar() {
        System.out.println("Jangkar diturunkan...");
    }

    public void naikkanJangkar() {
        System.out.println("Jangkar dinaikkan...");
    }

    @Override
    public void bergerak() {
        System.out.println("Kapal " + jenisKapal + " Bergerak...");
    }

    @Override
    public void berhenti() {
        System.out.println("Kapal " + jenisKapal + " Berhenti...");
    }

    @Override
    public void belok() {
        System.out.println("Kapal " + jenisKapal + " Mengubah Haluan...");
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Class: Kapal");
        System.out.println("Jenis Kapal: " + jenisKapal);
    }

    @Override
    public double isiBahanBakar(double liters) {
        return 11900 * liters;
    }
}
