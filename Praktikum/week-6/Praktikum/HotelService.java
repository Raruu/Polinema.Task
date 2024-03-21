package Praktikum;

public class HotelService {
    Hotel[] rooms = new Hotel[5];
    int allocatedRooms = 0;

    void tambah(Hotel H) {
        if (allocatedRooms < rooms.length) {
            rooms[allocatedRooms] = H;
            allocatedRooms++;
        } else {
            System.out.println("Data sudah penuh!!");
        }
    }

    void tampilAll() {
        for (Hotel hotel : rooms) {
            System.out.println("Nama: " + hotel.nama);
            System.out.println("Kota: " + hotel.kota);
            System.out.println("Harga: " + hotel.harga);
            System.out.println("Bintang: " + hotel.bintang);
            System.out.println("---------------------------");
        }
    }

    void bubleSortHarga() {
        for (int i = 0; i < rooms.length - 1; i++) {
            for (int j = 1; j < rooms.length - i; j++) {
                if(rooms[j].harga < rooms[j - 1].harga) {
                    Hotel temp = rooms[j];
                    rooms[j] = rooms[j - 1];
                    rooms[j - 1] = temp;
                }
            }
        }
    }

    void bubleSortRating() {
        for (int i = 0; i < rooms.length - 1; i++) {
            for (int j = 1; j < rooms.length - i; j++) {
                if(rooms[j].bintang > rooms[j - 1].bintang) {
                    Hotel temp = rooms[j];
                    rooms[j] = rooms[j - 1];
                    rooms[j - 1] = temp;
                }
            }
        }
    }

    void selectionSortHarga() {
        for (int i = 0; i < rooms.length; i++) {
            Hotel temp = rooms[i];
            int j = i;
            while (j > 0 && rooms[j - 1].harga > temp.harga) {
                rooms[j] = rooms[j - 1];
                j--;
            }
            rooms[j] = temp;
        }
    }

    void selectionSortRating() {
        for (int i = 0; i < rooms.length; i++) {
            Hotel temp = rooms[i];
            int j = i;
            while (j > 0 && rooms[j - 1].bintang < temp.bintang) {
                rooms[j] = rooms[j - 1];
                j--;
            }
            rooms[j] = temp;
        }
    }
}
