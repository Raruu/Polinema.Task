public class Main {
    public static void main(String[] args) {
        Speaker speaker = new Speaker("Bare", 10, 100);
        speaker.mengaturVolume(15);
        speaker.hasilkanSuara();
        speaker.cetakInformasi();
        System.out.println();

        SpeakerBesar speakerBesar = new SpeakerBesar("Onikuma", 4, 50, 1.0, false);
        speakerBesar.mengaturVolume(90);
        speakerBesar.hasilkanSuara();
        speakerBesar.toggleRGBOn();
        speakerBesar.meneruskanSuara();
        speakerBesar.cetakInformasi();
        System.out.println();

        SpeakerKecil speakerKecil = new SpeakerKecil("Advan", 3, 50, "Merah", false, true);
        speakerKecil.mengaturVolume(90);
        speakerKecil.hasilkanSuara();
        speakerKecil.togglePower();
        speakerKecil.toggleVolumeBoost();
        speakerKecil.cetakInformasi();
        System.out.println();

        Keyboard keyboard = new Keyboard(true, 3);
        keyboard.toggleRGBOn();
        keyboard.knobValueChange();
        keyboard.cetakInformasi();
        System.out.println();

        Monitor monitor = new Monitor(12, 165.0);
        monitor.tampilkanGambar();
        monitor.tampilkanMenuOSD();
        monitor.cetakInformasi();
    }
}