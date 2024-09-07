public class Peminjam {
    int id;
    String memberName;
    String gameName;
    int harga;

    public Peminjam(int id, String memberName, String gameName, int harga) {
        this.id = id;
        this.memberName = memberName;
        this.gameName = gameName;
        this.harga = harga;
    }

    public int cekHarusBayar(int lamaSewa) {
        return harga * lamaSewa;
    }

    public void cetakInfo(int lamaSewa) {
        System.out.println("Id: " + id);
        System.out.println("Member Name: " + memberName);
        System.out.println("Game Name: " + gameName);
        System.out.println("Harga: " + harga);
        System.out.println("Harus Bayar: " + cekHarusBayar(lamaSewa));
    }
}
