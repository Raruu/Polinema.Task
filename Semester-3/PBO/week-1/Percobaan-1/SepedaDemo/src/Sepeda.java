public class Sepeda {
    private String merek;
    private int kecepatan;
    private int gear;


    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void gantiGear(int gear) {
        this.gear = gear;
    }

    public void tambahKecepatan(int increment) {
        kecepatan += increment;
    }

    public void rem(int decrement) {
        kecepatan -= decrement;
    }

    public void cetakStatus() {
        System.out.println("Merek: " + merek);
        System.out.println("Kecepatan: " + kecepatan);
        System.out.println("Gear: " + gear);
    }
}
