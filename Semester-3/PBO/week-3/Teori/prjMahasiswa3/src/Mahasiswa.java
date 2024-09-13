public class Mahasiswa {
    private String nama;
    private int nim;
    private Alamat alamat;
    private Nilai[] nilai;

    public void info() {
        System.out.println("Nama: " + nama);
        System.out.println("Nim: " + nim);
        System.out.println("Alamat");
        System.out.println("Jalan: " + alamat.getJalan());
        System.out.println("Kota: " + alamat.getKota());
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.isEmpty()) {
            this.nama = nama;
        } else {
            System.out.println("Nama tidak boleh kosong!");
        }
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        if (nim < 0) {
            System.out.println("Nim tidak boleh negatif!");
            return;
        }
        this.nim = nim;
    }

    public void setAlamat(Alamat alamat) {
        this.alamat = alamat;
    }

    public void setNilai(Nilai[] nilai) {
        this.nilai = nilai;
    }

    public void printKHS(){
        Nilai.printKHS(nilai);
    }
}
