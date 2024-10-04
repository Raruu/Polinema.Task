public class Pelanggaran {
    public AnggotaKampus pelanggar;
    public TataTertib peraturanDilanggar;
    public String tanggal;

    public Pelanggaran(AnggotaKampus pelanggar, TataTertib peraturanDilanggar, String tanggal) {
        this.pelanggar = pelanggar;
        this.peraturanDilanggar = peraturanDilanggar;
        this.tanggal = tanggal;
    }

    public AnggotaKampus getPelanggar() {
        return pelanggar;
    }

    public TataTertib getPeraturanDilanggar() {
        return peraturanDilanggar;
    }

    public String getTanggal() {
        return tanggal;
    }
}
