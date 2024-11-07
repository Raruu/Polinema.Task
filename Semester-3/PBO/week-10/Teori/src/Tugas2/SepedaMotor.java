package Tugas2;

public class SepedaMotor extends Kendaraan implements RefillFuel{
    public int jumlahGigi;
    public String jenisMotor;
    private boolean isStandarDown;

    public SepedaMotor(int jumlahRoda, int kecepatanMaksimum, String jenisBahanBakar, int jumlahGigi, String jenisMotor) {
        super(jumlahRoda, kecepatanMaksimum, jenisBahanBakar);
        this.jumlahGigi = jumlahGigi;
        this.jenisMotor = jenisMotor;
        isStandarDown = false;
    }

    public void toggleStandar() {
        isStandarDown = !isStandarDown;
        if (isStandarDown) {
            System.out.println("Menurunkan Standar...");
        } else {
            System.out.println("Menaikkan Standar...");
        }
    }

    @Override
    public void bergerak() {
        System.out.println("Sepeda Motor " + jenisMotor + " Bergerak...");
    }

    @Override
    public void berhenti() {
        System.out.println("Sepeda Motor " + jenisMotor + " Berhenti...");
    }

    @Override
    public void belok() {
        System.out.println("Sepeda Motor " + jenisMotor + " Berbelok...");
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Class: SepedaMotor");
        System.out.println("Jenis Sepeda Motor: " + jenisMotor);
        System.out.println("Jumlah Gigi: " + jumlahGigi);
        System.out.println("Status Standar: "
                + (isStandarDown ? "Standar turun" : "Standar tidak turun"));
    }

    @Override
    public double isiBahanBakar(double liters) {
        return 10000 * liters;
    }
}
