package Exercise2;

public class Manusia {
    public void nyalakanPerangkat(Elektronik perangkat) {
        System.out.print("Nyalakan televisi ");
        if (perangkat instanceof TelevisiJadul) {
            System.out.println("jadul dengan input: " + ((TelevisiJadul) perangkat).getModelInput());
        } else if (perangkat instanceof TelevisiModern) {
            System.out.println("modern dengan input: " + ((TelevisiModern) perangkat).getModelInput());
        }
        System.out.println("Voltase televisi: " + perangkat.getVoltase());
    }
}
