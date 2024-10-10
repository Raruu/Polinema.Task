public class Bus extends Kendaraan {
    private final int kapasitas;

    public Bus(String merek, int jumlahRoda, int kapasitas) {
        super(merek, jumlahRoda);
        this.kapasitas = kapasitas;
    }

    @Override
    public void bergerak() {
        System.out.println("Bus " + super.getMerek() + " dengan kapasitas " + kapasitas + " sedang meluncur.");
    }

    @Override
    public void bergerak(int kecepatan){
        System.out.print("Mobil " + super.getMerek() + " dengan kapasitas " + kapasitas + ", ");
        super.bergerak(kecepatan);
    }
}
