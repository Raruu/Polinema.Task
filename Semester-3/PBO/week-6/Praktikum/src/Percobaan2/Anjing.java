package Percobaan2;

public class Anjing extends Hewan {
    public Anjing(String nama) {
        super(nama);
    }

    @Override
    void bersuara() {
        System.out.println("Wan~ Wan~");
    }

    void menggonggong() {
        System.out.println("Wan~ Wan~");
    }
}
