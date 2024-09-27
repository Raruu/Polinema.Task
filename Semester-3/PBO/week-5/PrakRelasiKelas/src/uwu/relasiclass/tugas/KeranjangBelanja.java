package uwu.relasiclass.tugas;

import java.util.ArrayList;
import java.util.List;

public class KeranjangBelanja {
    private List<Pembelian> pembelians;

    public KeranjangBelanja() {
        pembelians = new ArrayList<>();
    }

    public void tambahBarang(Pembelian pembelian) {
        pembelians.add(pembelian);
    }

    public void printPembelian() {
        for (Pembelian i : pembelians) {
            System.out.println("Produk : " + i.getProduk().getNama());
            System.out.println("Jumlah : " + i.getJumlah());
            System.out.println("Total harga : " + i.getJumlahHarga());
        }
    }
}
