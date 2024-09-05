public class Handphone {
    boolean statusAktif;
    String statusPanggilan;
    String statusSMS;

    public Handphone() {
        statusAktif = false;
        statusPanggilan = "Menunggu";
        statusSMS = "Menunggu";
    }

    public void setStatusAktif(int status) {
        statusAktif = status == 1;
    }

    public void setStatusPanggilan(int status) {
        switch (status) {
            case 1 -> statusPanggilan = "Menerima Panggilan";
            case 2 -> statusPanggilan = "Melakukan Panggilan";
            default -> statusPanggilan = "Menunggu";
        }
    }

    public void setStatusSMS(int status) {
        switch (status) {
            case 1 -> statusSMS = "Menerima SMS";
            case 2 -> statusSMS = "Mengirim SMS";
            default -> statusSMS = "Menunggu";
        }
    }

    public void tampilSemuaStatus() {
        System.out.println("statusAktif: " + (statusAktif ? "Aktif" : "Tidak Aktif"));
        System.out.println("statusPanggilan: " + statusPanggilan);
        System.out.println("statusSMS: " + statusSMS);
    }
}
