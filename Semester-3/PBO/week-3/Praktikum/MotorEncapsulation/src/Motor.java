public class Motor {
    private int kecepatan;
    private boolean kontakOn;

    public void nyalakanMesin() {
        kontakOn = true;
    }

    public void matikanMesin() {
        kontakOn = false;
        kecepatan = 0;
    }

    public void tambahKecepatan() {
        if (kontakOn) {
            kecepatan += 5;
        } else {
            System.out.println("Kecepatan tidak bisa bertambah karena Mesin off!\n");
        }
        if(kecepatan > 100){
            kecepatan = 100;
            System.out.println("Kecepatan mencapai maks (100)");
        }
    }

    public void kurangiKecepatan() {
        if (kontakOn) {
            kecepatan -= 5;
        } else {
            System.out.println("Kecepatan tidak bisa berkurang karena Mesin off!\n");
        }
    }

    public void printStatus() {
        System.out.println("Kontak " + (kontakOn ? "On" : "Off"));
        System.out.println("Kecepatan " + kecepatan + "\n");
    }
}
