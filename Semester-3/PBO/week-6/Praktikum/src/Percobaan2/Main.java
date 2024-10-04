package Percobaan2;

public class Main {
    public static void main(String[] args) {
        Kucing kucing = new Kucing("Milo");
        kucing.bersuara();
        kucing.mengeong();

        System.out.println();
        Anjing anjing = new Anjing("Kuso Inu");
        anjing.bersuara();
        anjing.menggonggong();
    }
}
