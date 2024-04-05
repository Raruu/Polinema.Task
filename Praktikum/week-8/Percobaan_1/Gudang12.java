package Percobaan_1;

public class Gudang12 {
    Barang12[] tumpukan;
    int size;
    int top;

    public Gudang12(int size) {
        this.size = size;
        tumpukan = new Barang12[size];
        top = -1;
    }

    public boolean cekKosong() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cekPenuh() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void tambahBarang(Barang12 barang) {
        if (!cekPenuh()) {
            top++;
            tumpukan[top] = barang;
            System.out.println("Barang " + barang.nama + " berhasil ditambahkan ke Gudang");
        } else {
            System.out.println("Gagal! Tumpukan barang di Gudang sudah penuh");
        }
    }

    public Barang12 ambilBarang() {
        if (!cekKosong()) {
            Barang12 delete = tumpukan[top];
            top--;
            System.out.println("Barang " + delete.nama + " diambil dari Gudang.");
            return delete;
        } else {
            System.out.println("Tumpukan barang kosong");
            return null;
        }
    }

    public Barang12 lihatBarangTeratas() {
        if (!cekKosong()) {
            Barang12 barangTerartas = tumpukan[top];
            System.out.println("Barang teratas " + barangTerartas.nama);
            return barangTerartas;
        } else {
            System.out.println("Tumpukan barang kosong");
            return null;
        }
    }

    public void tampilkanBarang() {
        if (!cekKosong()) {
            // for (int i = top; i >= 0; i--) {
            for (int i = 0; i <= top; i++) {
                System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama,
                        tumpukan[i].kategori);
            }
        } else {
            System.out.println("Tumpukan barang kosong");
        }
    }
}
