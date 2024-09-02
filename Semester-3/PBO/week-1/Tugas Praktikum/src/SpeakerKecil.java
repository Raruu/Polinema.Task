public class SpeakerKecil extends Speaker {
    String warna;
    boolean isPowerOn, isVolumeBoost;

    public SpeakerKecil(String brand, int impedance, int volume, String warna, boolean isPowerOn, boolean isVolumeBoost) {
        super(brand, impedance, volume);
        this.warna = warna;
        this.isPowerOn = isPowerOn;
        this.isVolumeBoost = isVolumeBoost;
    }

    @Override
    void cetakInformasi() {
        super.cetakInformasi();
        System.out.println("Warna: " + warna);
        System.out.println("Menyala?: " + (isPowerOn ? "YA" : "TIDAK"));
        System.out.println("Volume Boost?: " + (isVolumeBoost ? "YA" : "TIDAK"));
    }

    void togglePower() {
        isPowerOn = !isPowerOn;
        System.out.println("isPowerOn: " + isPowerOn);
    }

    void toggleVolumeBoost() {
        isVolumeBoost = !isVolumeBoost;
        System.out.println("isVolumeBoost: " + isVolumeBoost);
    }
}
