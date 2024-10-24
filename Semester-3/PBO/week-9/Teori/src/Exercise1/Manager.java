package Exercise1;

public class Manager extends  Pegawai{
    private int tunjangan;

    public Manager(String nama, int gaji, int tunjangan) {
        super(nama, gaji);
        this.tunjangan = tunjangan;
    }

    @Override
    public int getGaji() {
        return super.getGaji();
    }

    public int getTunjangan() {
        return tunjangan;
    }
}
