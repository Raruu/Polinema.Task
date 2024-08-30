public class AlatMusik12 {
    String nama, merk, kategori;
    int stok, jumlah;

    public AlatMusik12(String nama, String merk, String kategori, int stok, int jumlah) {
        this.nama = nama;
        this.merk = merk;
        this.kategori = kategori;
        this.stok = stok;
        this.jumlah = jumlah;
    }

    public AlatMusik12() {

    }

    public void tampil() {
        System.out.println("Nama: " + nama);
        System.out.println("Merk: " + merk);
        System.out.println("Kategori: " + kategori);
        System.out.println("Stok: " + stok);
        System.out.println("Jumlah Terjual: " + jumlah);
    }

    public int hitungSisa() {
        stok = stok - jumlah;
        System.out.println("Sisa Stok " + nama + ": " + stok); 
        return stok;
    }

    public static void cariAlatMusikTidakLaku(AlatMusik12[] arr) {
        int highest = 0, index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].stok > highest) {
                highest = arr[i].stok;
                index = i;
            }
        }

        System.out.println("Alat Musik Paling Tidak Laku: \"" + arr[index].nama + "\" Dengan Sisa Stok: " + arr[index].stok);
        arr[index].tampil();
    }

    public static void daftarAlatMusik(AlatMusik12[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            AlatMusik12 temp;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].stok < arr[j + 1].stok) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        System.out.println("Urutan Alat Musik, descending, berdasarkan stok");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Alat Musik ke-" + (i + 1) + ": Nama=" + arr[i].nama + ", Stok=" + arr[i].stok);

        }
    }
}