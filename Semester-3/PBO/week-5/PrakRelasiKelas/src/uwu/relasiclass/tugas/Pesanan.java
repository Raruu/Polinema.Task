package uwu.relasiclass.tugas;

public class Pesanan {
    private String id, statusPesanan;
    private KeranjangBelanja keranjangBelanja;

    public Pesanan(String id, String statusPesanan, KeranjangBelanja keranjangBelanja) {
        this.id = id;
        this.statusPesanan = statusPesanan;
        this.keranjangBelanja = keranjangBelanja;
    }

    public String getStatusPesanan() {
        return statusPesanan;
    }

    public void setStatusPesanan(String statusPesanan) {
        this.statusPesanan = statusPesanan;
    }

    public String getId() {
        return id;
    }

    public KeranjangBelanja getKeranjangBelanja() {
        return keranjangBelanja;
    }
}
