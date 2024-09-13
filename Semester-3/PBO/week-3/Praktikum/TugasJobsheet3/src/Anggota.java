public class Anggota {
    private String noKTP;
    private String nama;
    private int limitPinjaman, pinjaman;

    public Anggota(String noKTP, String nama, int limitPinjam) {
        this.noKTP = noKTP;
        this.nama = nama;
        this.limitPinjaman = limitPinjam;
        pinjaman = 0;
    }

    public String getNama() {
        return nama;
    }

    public int getLimitPinjaman() {
        return limitPinjaman;
    }

    public void pinjam(int jumlah) {
        if (jumlah > limitPinjaman) {
            System.out.println("Maaf, jumlah pinjaman melebihi limit.");
            return;
        }
        pinjaman += jumlah;
    }

    public void angsur(int jumlah) {
        if ((pinjaman * 0.1) > jumlah) {
            System.out.println("Maaf, angsuran harus 10% dari jumlah pinjaman");
            return;
        }
        pinjaman -= jumlah;
    }

    public int getJumlahPinjaman() {
        return pinjaman;
    }
}
