package Percobaan4;

public class Main {
    public static void main(String[] args) {
        Kucing kucing = new Kucing("Milo", 2);
        kucing.berjalan();
        kucing.menyusui();
        System.out.println();
        Anjing anjing = new Anjing("Dog", 10);
        anjing.berjalan();
        anjing.menyusui();
        anjing.menggonggong();
    }
}
