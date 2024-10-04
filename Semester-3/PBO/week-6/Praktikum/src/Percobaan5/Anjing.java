package Percobaan5;

public class Anjing extends Hewan {
    private String jenisBulu;

    public Anjing(String nama, int umur, String jenisBulu) {
        super(nama, umur);
        this.jenisBulu = jenisBulu;
    }

    public String getJenisBulu() {
        return jenisBulu;
    }

    public void menggonggong() {
        System.out.println("Wan~ Wan~");
    }
}
