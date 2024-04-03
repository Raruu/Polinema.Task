package Praktikum;

import java.util.Arrays;

public class PencarianBuku12 {
    Buku12[] listBk = new Buku12[0];

    public void tambah(Buku12 value) {
        listBk = Arrays.copyOf(listBk, listBk.length + 1);
        listBk[listBk.length - 1] = value;
    }

    public void tampil() {
        for (Buku12 buku12 : listBk) {
            buku12.tampilDataBuku();
        }
    }

    public void tampil(Buku12[] arr) {
        for (Buku12 buku12 : arr) {
            buku12.tampilDataBuku();
        }
    }

    public int FindSeqSearch(String cari, String searchBy) {
        if (searchBy.equalsIgnoreCase("judul")) {
            return judulBukuFindSeqSearch(cari);
        }
        if (searchBy.equalsIgnoreCase("kode")) {
            return kodeBukuFindSeqSearch(cari);
        }
        return -1;
    }

    public int kodeBukuFindSeqSearch(String cari) {
        int posisi = -1;
        for (int i = 0; i < listBk.length; i++) {
            if (listBk[i].kodeBuku.equals(cari)) {
                posisi = i;
                break;
            }
        }
        return posisi;
    }

    public int judulBukuFindSeqSearch(String cari) {
        int posisi = -1;
        for (int i = 0; i < listBk.length; i++) {
            if (listBk[i].judulBuku.equals(cari)) {
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

    public void TampilData(int pos) {
        if (pos != -1) {
            System.out.println("Kode Buku\t : " + listBk[pos].kodeBuku);
            System.out.println("Judul\t\t : " + listBk[pos].judulBuku);
            System.out.println("Tahun Terbit\t : " + listBk[pos].tahunTerbit);
            System.out.println("Pengarang\t : " + listBk[pos].pengarang);
            System.out.println("Stock\t\t : " + listBk[pos].stock);
        } else {
            System.out.println("data tidak ditemukan");
        }
    }

    public void TampilData(Buku12[] arr, int pos) {
        if (pos != -1) {
            System.out.println("Kode Buku\t : " + arr[pos].kodeBuku);
            System.out.println("Judul\t\t : " + arr[pos].judulBuku);
            System.out.println("Tahun Terbit\t : " + arr[pos].tahunTerbit);
            System.out.println("Pengarang\t : " + arr[pos].pengarang);
            System.out.println("Stock\t\t : " + arr[pos].stock);
        } else {
            System.out.println("data tidak ditemukan");
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

    public int FindBinarySearch(Buku12[] sortedArr, String cari, String searchBy) {
        if (searchBy.equalsIgnoreCase("kode")) {
            return kodeBukuFindBinarySearch(sortedArr, cari, 0, sortedArr.length - 1);
        }
        if (searchBy.equalsIgnoreCase("judul")) {
            return judulBukuFindBinarySearch(sortedArr, cari, 0, sortedArr.length - 1);
        }
        return -1;
    }

    private int kodeBukuFindBinarySearch(Buku12[] arr, String cari, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            int compare = cari.compareToIgnoreCase(arr[mid].kodeBuku);

            if (compare == 0) {
                return mid;
            } else if (compare > 0) {
                return kodeBukuFindBinarySearch(arr, cari, left, mid - 1);
            } else {
                return kodeBukuFindBinarySearch(arr, cari, mid + 1, right);
            }
        }
        return -1;
    }

    private int judulBukuFindBinarySearch(Buku12[] arr, String cari, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            int compare = cari.compareToIgnoreCase(arr[mid].judulBuku);

            if (compare == 0) {
                return mid;
            } else if (compare > 0) {
                return judulBukuFindBinarySearch(arr, cari, left, mid - 1);
            } else {
                return judulBukuFindBinarySearch(arr, cari, mid + 1, right);
            }
        }
        return -1;
    }

    public Buku12[] descendingSort(Buku12[] arr) {
        Buku12[] data = Arrays.copyOf(arr, arr.length);
        int n = data.length;
        for (int i = 1; i < n; ++i) {
            Buku12 key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j].judulBuku.length() < key.judulBuku.length()) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
        return data;
    }

    public int duplicateCheck(String cari){
        int foundDuplicate = -1;
        for (int i = 0; i < listBk.length; i++) {
            if(listBk[i].judulBuku.equalsIgnoreCase(cari)){
                foundDuplicate++;
            }
        }
        return foundDuplicate;
    }
}
