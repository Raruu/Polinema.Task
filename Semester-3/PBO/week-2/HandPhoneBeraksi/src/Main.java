public class Main {
    public static void main(String[] args) {
        Handphone handphoneBudi = new Handphone();
        Handphone handphoneYono = new Handphone();

        handphoneBudi.setStatusAktif(1);
        handphoneBudi.setStatusPanggilan(0);
        handphoneBudi.setStatusSMS(2);
        handphoneBudi.tampilSemuaStatus();
        System.out.println("---------------------------------------------------");
        handphoneYono.setStatusAktif(1);
        handphoneYono.setStatusPanggilan(2);
        handphoneYono.setStatusSMS(1);
        handphoneYono.tampilSemuaStatus();
    }
}