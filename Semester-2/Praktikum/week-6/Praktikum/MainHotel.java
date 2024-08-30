package Praktikum;

public class MainHotel {
    static HotelService siapkanData() {
        HotelService list = new HotelService();
        Hotel m1 = new Hotel("Nusa", "Malang", 25000, (byte) 3);
        Hotel m2 = new Hotel("Rara", "Surabaya", 10000, (byte) 4);
        Hotel m3 = new Hotel("Dampu", "Jakarta", 19000, (byte) 5);
        Hotel m4 = new Hotel("Abdul", "Jember", 23000, (byte) 2);
        Hotel m5 = new Hotel("Ummi", "Bogor", 21000, (byte) 3);

        list.tambah(m1);
        list.tambah(m2);
        list.tambah(m3);
        list.tambah(m4);
        list.tambah(m5);

        return list;
    }

    public static void main(String[] args) {
        HotelService list = siapkanData();

        System.out.println("Data Hotel sebelum sorting: ");
        list.tampilAll();

        System.out.println("Data Hotel setelah sorting menggunakan bubblesort: ");
        System.out.println("Berdasarkan harga: (termurah ke tertinggi)");
        list.bubleSortHarga();
        list.tampilAll();
        System.out.println("Berdasarkan bintang: (tertinggi ke terendah)");
        list.bubleSortRating();
        list.tampilAll();

        // Reset
        System.out.println("\n");
        list = siapkanData();
        System.out.println("Data Hotel sebelum sorting: ");
        list.tampilAll();

        System.out.println("Data Hotel setelah sorting menggunakan selection sort: ");
        System.out.println("Berdasarkan harga: (termurah ke tertinggi)");
        list.selectionSortHarga();
        list.tampilAll();
        System.out.println("Berdasarkan bintang: (tertinggi ke terendah)");
        list.selectionSortRating();
        list.tampilAll();
    }
}
