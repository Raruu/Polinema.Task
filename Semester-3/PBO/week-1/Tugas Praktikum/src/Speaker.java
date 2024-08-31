public class Speaker {
    String brand;
    int impedance, volume;

    public Speaker(String brand, int impedance, int volume) {
        this.brand = brand;
        this.impedance = impedance;
        this.volume = volume;
    }

    void cetakInformasi() {
        System.out.println("Brand: " + brand);
        System.out.println("Impedance: " + impedance);
        System.out.println("Power Output: " + volume);
    }

    void hasilkanSuara() {
        System.out.println("FumoFumo~~~");
    }

    void mengaturVolume(int value) {
        System.out.println("Volume diatur set: " + value);
        volume = value;
    }
}
