public class Main {
    public static void main(String[] args) {
        Restoran data =  new Restoran();
        data.setMenu("Ayam Goreng", 17000.75, true);

        System.out.println("Menu Makanan: " + data.getMenu());
        System.out.println("Harga Makanan: Rp."+data.getHarga());
        System.out.println("Menu Spesial: " + data.isSpecial());
    }
}