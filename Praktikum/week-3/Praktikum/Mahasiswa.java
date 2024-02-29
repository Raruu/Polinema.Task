package Praktikum;

public class Mahasiswa {
    String nama, nim;
    char jenisKelamin;
    double ipk;

    public Mahasiswa(String nama, String nim, char jenisKelamin, double ipk){
        this.nama = nama;
        this.nim = nim;
        this.jenisKelamin = jenisKelamin;
        this.ipk = ipk;
    }

    public void printData(){
        System.out.println("nama: " + nama);
        System.out.println("nim: " + nim);
        System.out.println("Jenis kelamin: " + jenisKelamin);
        System.out.println("Nilai IPK: " + ipk);
    }
}
