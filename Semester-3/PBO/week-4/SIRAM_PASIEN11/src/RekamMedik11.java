import java.util.ArrayList;
import java.util.List;

public class RekamMedik11 {
    private int id11;
    private Pasien11 pasien11;
    private List<Pemeriksaan11> daftarPemeriksaan11;

    public RekamMedik11(int id11, Pasien11 pasien11) {
        this.id11 = id11;
        this.pasien11 = pasien11;
        this.daftarPemeriksaan11 = new ArrayList<>();
    }

    public void tambahPemeriksaan11(Pemeriksaan11 pemeriksaan) {
        if (daftarPemeriksaan11 == null) {
            daftarPemeriksaan11 = new ArrayList<>();
        }
        daftarPemeriksaan11.add(pemeriksaan);
    }

    public List<Pemeriksaan11> getDaftarPemeriksaan11() {
        return daftarPemeriksaan11; // Mengembalikan referensi ke list
    }

    public int getId11() {
        return id11;
    }

    public Pasien11 getPasien11() {
        return pasien11;
    }

    public static boolean checkDuplicateId11(List<RekamMedik11> rekamMedik11s, int id11) {
        for (RekamMedik11 rekamMedik11 : rekamMedik11s) {
            if (rekamMedik11.getPasien11().getId11() == id11) {
                return true;
            }
        }
        return false;
    }
}
