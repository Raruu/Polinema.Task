public class Main {
    public static void main(String[] args) {
        Encapsulation objek = new Encapsulation("Yahalo", 987);
        System.out.println("Nama: " + objek.getNama());
        System.out.println("Nim: " + objek.getNim());
        System.out.println("--------------------------");
        objek.setNama("Muksalmina");
        System.out.println("Nama: " + objek.getNama());
        objek.setNim(1234);
        System.out.println("Nim: " + objek.getNim());
    }
}