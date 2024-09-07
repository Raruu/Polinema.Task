public class Main {
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa();
        mhs1.nim = 101;
        mhs1.nama = "Lestari";
        mhs1.alamat = "Jl. Vinolia No 1A";
        mhs1.kelas = "1A";
        mhs1.tampilBioData();
        System.out.println();
        Mahasiswa mhs2 = new Mahasiswa();
        mhs2.nim = 696;
        mhs2.nama = "Sentaku";
        mhs2.alamat = "Jl. GondongPahit No 69A";
        mhs2.kelas = "9F";
        mhs2.tampilBioData();
        System.out.println();
        Mahasiswa mhs3 = new Mahasiswa();
        mhs3.nim = 777;
        mhs3.nama = "Ruuu";
        mhs3.alamat = "Jl. GondongManis No 777A";
        mhs3.kelas = "2C";
        mhs3.tampilBioData();
    }
}