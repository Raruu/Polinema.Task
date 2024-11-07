package Tugas2;

public abstract class Kendaraan {
    protected int jumlahRoda, kecepatanMaksimum;
    protected String jenisBahanBakar;

    public Kendaraan(int jumlahRoda, int kecepatanMaksimum, String jenisBahanBakar) {
        this.jumlahRoda = jumlahRoda;
        this.kecepatanMaksimum = kecepatanMaksimum;
        this.jenisBahanBakar = jenisBahanBakar;
    }

    public abstract void bergerak();

    public abstract void berhenti();

    public abstract void belok();

    public void info() {
        System.out.println("Kendaraan");
        System.out.println("Jumlah Roda: " + jumlahRoda);
        System.out.println("Kecepatan Maksimum: " + kecepatanMaksimum);
        System.out.println("Jenis Bahan Bakar: " + jenisBahanBakar);
    }
}
