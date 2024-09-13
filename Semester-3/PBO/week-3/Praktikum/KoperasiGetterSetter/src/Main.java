public class Main {
    public static void main(String[] args) {
        Anggota anggota1 = new Anggota("Iwan","Jalan Mawar" );
        System.out.println("Simpanan " + anggota1.getNama() + " : Rp." + anggota1.getSimpanan());

        anggota1.setor(100000);
        System.out.println("Simpanan " + anggota1.getNama() + " : Rp." + anggota1.getSimpanan());
        anggota1.pinjam(5000);
        System.out.println("Simpanan " + anggota1.getNama() + " : Rp." + anggota1.getSimpanan());
    }
}