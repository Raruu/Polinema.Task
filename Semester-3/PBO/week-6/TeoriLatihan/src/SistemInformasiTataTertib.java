import java.util.ArrayList;
import java.util.List;

public class SistemInformasiTataTertib {
    List<Pelanggaran> pelanggarans;

    public SistemInformasiTataTertib() {
        pelanggarans = new ArrayList<>();
    }

    public void catatPelanggaran(Pelanggaran pelanggaran) {
        pelanggarans.add(pelanggaran);
        System.out.println("Tercatat pelanggaran oleh: " + pelanggaran.pelanggar.getNama());
    }

    public void lihatRiwayatPelanggaran(AnggotaKampus anggota) {
        for (Pelanggaran pelanggaran : pelanggarans){
            if(pelanggaran.pelanggar.equals(anggota)){
                System.out.println("Peraturan yang dilanggar oleh: " + anggota.getNama());
                System.out.println("Peraturan dilanggar: " + pelanggaran.peraturanDilanggar.getPeraturan());
                System.out.println("Sanksi : " + pelanggaran.peraturanDilanggar.getSanksi());
                System.out.println();
                break;
            }
        }
    }
}
