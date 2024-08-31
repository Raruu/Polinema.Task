public class SpeakerBesar extends Speaker {
    double versi;
    boolean isRGBOn;

    public SpeakerBesar(String brand, int impedance, int volume, double versi, boolean isRGBOn) {
        super(brand, impedance, volume);
        this.versi = versi;
        this.isRGBOn = isRGBOn;
    }

    @Override
    void cetakInformasi() {
        super.cetakInformasi();
        System.out.println("Versi: " + versi);
        System.out.println("RGB menyala?: " + (isRGBOn ? "YA" : "TIDAK"));
    }

    void meneruskanSuara() {
        System.out.println("Meneruskan suara ke port: 0");
    }

    void toggleRGBOn() {
        isRGBOn = !isRGBOn;
        System.out.println("isRGBOn: " + isRGBOn);
    }
}
