public class Kendaraan {
    private final String merek;
    private final int jumlahRoda;

    public Kendaraan(String merek, int jumlahRoda) {
        this.merek = merek;
        this.jumlahRoda = jumlahRoda;
    }

    public String getMerek() {
        return merek;
    }

    public int getJumlahRoda() {
        return jumlahRoda;
    }

    public void printInfo() {
        System.out.println("Merek: " + merek);
        System.out.println("Jumlah Roda: " + jumlahRoda);
    }

    public void bergerak() {
        System.out.println("Kendaraan sedang bergerak.");
    }

    public void bergerak(int kecepatan) {
        System.out.println("Kendaraan sedang bergerak dengan kecepatan " + kecepatan + " km/jam.");
    }
}
