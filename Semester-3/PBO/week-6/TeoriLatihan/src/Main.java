public class Main {
    public static void main(String[] args) {
        Dosen dosen1 = new Dosen("Dosen1", "D001", "1234", "saa");
        Mahasiswa mahasiswa1 = new Mahasiswa("Yahalo", "M001", "234172", "TI");
        SistemInformasiTataTertib sistemInformasiTataTertib = new SistemInformasiTataTertib();
        TataTertib tataTertib1 = new TataTertib("Terlambat", "Aplha 1 menit");
        sistemInformasiTataTertib.catatPelanggaran(new Pelanggaran(mahasiswa1,tataTertib1, "2024-10-03"));
        sistemInformasiTataTertib.lihatRiwayatPelanggaran(mahasiswa1);
    }
}