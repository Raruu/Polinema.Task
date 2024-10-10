public class Motor extends Kendaraan {
    private final boolean matic;

    public Motor(String merek, int jumlahRoda, boolean matic) {
        super(merek, jumlahRoda);
        this.matic = matic;
    }

    @Override
    public void bergerak() {
        System.out.println("Motor " + super.getMerek() + (matic ? " Matic" : " Manual") + " sedang meluncur.");
    }

    @Override
    public void bergerak(int kecepatan){
        System.out.print("Motor " + super.getMerek() + (matic ? " Matic" : " Manual" + ", "));
        super.bergerak(kecepatan);
    }
}
