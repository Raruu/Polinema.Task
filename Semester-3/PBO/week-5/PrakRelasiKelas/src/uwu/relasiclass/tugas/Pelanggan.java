package uwu.relasiclass.tugas;

import java.util.ArrayList;
import java.util.List;

public class Pelanggan {
    private String nama, alamat, email, nomorTelp;
    private List<Pesanan> riwatPembelian;

    public Pelanggan(String nama, String alamat, String email, String nomorTelp) {
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.nomorTelp = nomorTelp;
        riwatPembelian = new ArrayList<>();
    }

    public void lakukanPembelian(KeranjangBelanja keranjangBelanja) {
        riwatPembelian.add(new Pesanan("P" + riwatPembelian.size(), "Selesai", keranjangBelanja));
    }

    public void printIdentitas() {
        System.out.println("Nama : " + nama);
        System.out.println("Alamat :" + alamat);
        System.out.println("Email : " + email);
        System.out.println("No Telp : " + nomorTelp);
    }

    public void printRiwayat() {
        for (Pesanan pesanan : riwatPembelian) {
            System.out.println("Id Pesanan : " + pesanan.getId());
            System.out.println("Status Pesanan : " + pesanan.getStatusPesanan());
            System.out.println("List Pesanan :");
            pesanan.getKeranjangBelanja().printPembelian();
        }
    }
}
