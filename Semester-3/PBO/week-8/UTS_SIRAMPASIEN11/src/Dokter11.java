import java.util.List;

public class Dokter11 extends Orang11 {
    private int id11;
    private String spesialisasi11;

    public Dokter11(int id11, String nama11, boolean jenisKelamin11, String alamat11, String noTelp11, String spesialisasi11) {
        super(nama11, jenisKelamin11, alamat11, noTelp11);
        this.id11 = id11;
        this.spesialisasi11 = spesialisasi11;
    }

    public int getId11() {
        return id11;
    }

    public String getSpesialisasi11() {
        return spesialisasi11;
    }

    public void setSpesialisasi11(String spesialisasi11) {
        this.spesialisasi11 = spesialisasi11;
    }

    @Override
    public void printInfo11() {
        System.out.println("Id: " + id11);
        super.printInfo11();
        System.out.println("Spesialisasi: " + spesialisasi11);
    }

    public void printInfoIDNama() {
        System.out.println("[" + id11 + "] " + super.getNama11());
    }

    public static boolean checkDuplicateId11(List<Dokter11> dokter11s, int id11) {
        for (Dokter11 dokter11 : dokter11s) {
            if (dokter11.getId11() == id11) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getNama11() {
        return super.getNama11();
    }

    @Override
    public String getJenisKelamin(boolean returnKataPenuh) {
        return super.getJenisKelamin(returnKataPenuh);
    }

    @Override
    public boolean getJenisKelamin11() {
        return super.getJenisKelamin11();
    }

    @Override
    public String getAlamat11() {
        return super.getAlamat11();
    }

    @Override
    public String getNoTelp11() {
        return super.getNoTelp11();
    }
}
