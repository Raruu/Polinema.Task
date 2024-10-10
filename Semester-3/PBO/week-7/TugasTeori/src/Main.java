public class Main {
    public static void main(String[] args) {
        System.out.println("-".repeat(20));
        Motor motor = new Motor("Honda", 2, false);
        motor.bergerak();
        motor.bergerak(60);
        System.out.println("-".repeat(20));
        Mobil mobil = new Mobil("Xiaomi", 4, "Sedan");
        mobil.bergerak();
        mobil.bergerak(220);
        System.out.println("-".repeat(20));
        Bus bus = new Bus("Hina", 6, 36);
        bus.bergerak();
        bus.bergerak(110);
        System.out.println("-".repeat(20));
    }
}
