public class Keyboard {
    boolean isRGBOn;
    int type;

    public Keyboard(boolean isRGBOn, int type) {
        this.isRGBOn = isRGBOn;
        this.type = type;
    }

    void cetakInformasi() {
        System.out.println("Type:" + type);
        System.out.println("RGB menyala?: " + (isRGBOn ? "YA" : "TIDAK"));
    }


    int knobValueChange() {
        int value = (int) (Math.random() * 100);
        System.out.println("Knob Value: " + value);
        return value;
    }


    void toggleRGBOn() {
        isRGBOn = !isRGBOn;
        System.out.println("isRGBOn: " + isRGBOn);
    }
}
