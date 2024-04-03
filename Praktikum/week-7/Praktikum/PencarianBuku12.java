public class PencarianBuku12 {
    Buku12[] listBk = new Buku12[5];
    int idx;

    public void tambah(Buku12 m) {
        if (idx < listBk.length) {
            listBk[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }

    public void tampil() {
        for (Buku12 buku12 : listBk) {
            buku12.tampilDataBuku();
        }
    }

    public int FindSeqSearch(String cari) {
        int posisi = -1;
        for (int i = 0; i < listBk.length; i++) {
            if (listBk[i].kodeBuku.equals(cari)) {
                posisi = i;
                break;
            }
        }
        return posisi;
    }

    public void TampilPosisi(String x, int pos) {
        if (pos != -1) {
            System.out.println("data: " + x + " ditemukan pada index " + pos);
        } else {
            System.out.println("data: " + x + " tidak ditemukan");
        }
    }

    public void TampilData(String x, int pos) {
        if (pos != -1) {
            System.out.println("Kode Buku\t : " + x);
            System.out.println("Judul\t\t : " + listBk[pos].judulBuku);
            System.out.println("Tahun Terbit\t : " + listBk[pos].tahunTerbit);
            System.out.println("Pengarang\t : " + listBk[pos].pengarang);
            System.out.println("Stock\t\t : " + listBk[pos].stock);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }

    public Buku12 FindBuku(String kodeBuku) {
        for (int i = 0; i < listBk.length; i++) {
            if (listBk[i].kodeBuku == kodeBuku) {
                return listBk[i];
            }
        }
        return null;
    }

    public int FindBinarySearch(String cari, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            int compare = cari.compareTo(listBk[mid].kodeBuku);

            if (listBk[mid].kodeBuku.equals(cari)) {
                return mid;
            } else if (compare > 0) {
                return FindBinarySearch(cari, left, mid - 1);
            } else {
                return FindBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;
    }
}
