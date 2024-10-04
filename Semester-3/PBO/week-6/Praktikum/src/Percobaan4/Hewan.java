package Percobaan4;

public class Hewan {
    String nama;
    int umur;

    public Hewan(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
        System.out.println("Konstruktor Hewan dipanggil");
    }

    void berjalan(){
        System.out.println("Hewan berjalan...");
    }
}
