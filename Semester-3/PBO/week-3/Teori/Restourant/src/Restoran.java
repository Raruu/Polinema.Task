public class Restoran {
    private String menu;
    private double harga;
    private boolean special;


    public void setMenu(String menu, double harga, boolean special) {
        this.menu = menu;
        this.harga = harga;
        this.special = special;
    }

    public String getMenu() {
        return menu;
    }

    public double getHarga() {
        return harga;
    }

    public boolean isSpecial() {
        return special;
    }
}
