package Percobaan5;

public class Main {
    public static void main(String[] args) {
        Kucing kucing = new Kucing("Milo", 2, "Oranye");
        kucing.info();
        kucing.berjalan();
//        System.out.println(kucing.nama);
        System.out.println(kucing.umur);
    }
}
