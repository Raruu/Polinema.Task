package Exercise1;

public class Bayaran {
    public int hitungBayaran(Pegawai pg) {
        int uang = pg.getGaji();
        if (pg instanceof Manager) {
            uang += ((Manager) pg).getTunjangan();
        } else if (pg instanceof Programmer) {
            uang += ((Programmer) pg).getBonus();
        }

        return uang;
    }
}