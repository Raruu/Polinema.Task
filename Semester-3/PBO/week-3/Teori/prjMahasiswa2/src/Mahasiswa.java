public class Mahasiswa {
    private String nama;
    private int nim;

    public void info(){
        System.out.println("Nama: " + nama);
        System.out.println("Nim: " + nim);
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
        if(nim < 0){
            System.out.println("Nim tidak boleh negatif!");
            return;
        }
        this.nim = nim;
    }
}
