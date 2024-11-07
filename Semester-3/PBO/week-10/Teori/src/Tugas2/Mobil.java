package Tugas2;

public class Mobil extends Kendaraan implements RefillFuel{
    public int jumlahPintu, jumlahGigi;
    public String jenisMobil;
    private boolean isWiperOn;

    public Mobil(int jumlahRoda, int kecepatanMaksimum, String jenisBahanBakar, int jumlahPintu, int jumlahGigi, String jenisMobil) {
        super(jumlahRoda, kecepatanMaksimum, jenisBahanBakar);
        this.jumlahPintu = jumlahPintu;
        this.jumlahGigi = jumlahGigi;
        this.jenisMobil = jenisMobil;
        isWiperOn = false;
    }

    public void toggleWiper() {
        isWiperOn = !isWiperOn;
        if (isWiperOn) {
            System.out.println("Wiper dinyalakan...");
        } else {
            System.out.println("Wiper dimatikan...");
        }
    }

    @Override
    public void bergerak() {
        System.out.println("Mobil " + jenisMobil + " Bergerak...");
    }

    @Override
    public void berhenti() {
        System.out.println("Mobil " + jenisMobil + " Berhenti...");
    }

    @Override
    public void belok() {
        System.out.println("Mobil " + jenisMobil + " Berbelok...");
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Class: Mobil");
        System.out.println("Jenis Mobil: " + jenisMobil);
        System.out.println("Jumlah Gigi: " + jumlahGigi);
        System.out.println("Jumlah Pintu: " + jumlahPintu);
        System.out.println("Status Wiper: " + (isWiperOn ? "Menyala" : "Mati"));
    }

    @Override
    public double isiBahanBakar(double liters) {
        return 15000 * liters;
    }
}
