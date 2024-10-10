public class Mobil extends  Kendaraan{
    private final String tipe;

    public Mobil(String merek, int jumlahRoda, String tipe) {
        super(merek, jumlahRoda);
        this.tipe = tipe;
    }

    @Override
    public void bergerak() {
        System.out.println("Mobil " + super.getMerek() + " tipe " + tipe + " sedang meluncur.");
    }

    @Override
    public void bergerak(int kecepatan){
        System.out.print("Mobil " + super.getMerek() + " tipe " + tipe + ", ");
        super.bergerak(kecepatan);
    }
}
