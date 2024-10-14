package TugasOverriding;

public class Main {
    public static void main(String[] args) {
        Manusia manusia = new Manusia();
        manusia.bernafas();
        manusia.makan();
        System.out.println("-".repeat(20));
        Dosen dosen = new Dosen();
        dosen.bernafas();
        dosen.makan();
        dosen.lembur();
        System.out.println("-".repeat(20));
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.bernafas();
        mahasiswa.makan();
        mahasiswa.tidur();
    }
}
