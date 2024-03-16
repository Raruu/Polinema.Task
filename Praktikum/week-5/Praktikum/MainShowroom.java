public class MainShowroom {
    public static void main(String[] args) {
        int[] acceleration = { 6816, 3921, 4360, 4058, 6255, 3700, 4180, 4180 };
        int[] top_power = { 728, 575, 657, 609, 703, 553, 609, 631 };
        Showroom showroom = new Showroom(acceleration, top_power);

        System.out.println("| merk       | tipe            | tahun | top_acceleration | top_power |\r\n" + //
                "| ---------- | --------------- | ----- | ---------------- | --------- |\r\n" + //
                "| BMW        | M2 Coupe        | 2016  | 6816             | 728       |\r\n" + //
                "| Ford       | Fiesta ST       | 2014  | 3921             | 575       |\r\n" + //
                "| Nissan     | 370Z            | 2009  | 4360             | 657       |\r\n" + //
                "| Subaru     | BRZ             | 2014  | 4058             | 609       |\r\n" + //
                "| Subaru     | Impreza WRX STI | 2013  | 6255             | 703       |\r\n" + //
                "| Toyota     | AE86 Trueno     | 1986  | 3700             | 553       |\r\n" + //
                "| Toyota     | 86/GT86         | 2014  | 4180             | 609       |\r\n" + //
                "| Volkswagen | Golf GTI        | 2014  | 4180             | 631       |");

        System.out.println();
        System.out.println("top_acceleration tertinggi: " + showroom.highest_acceleration());
        System.out.println("top_acceleration terendah: " + showroom.lowest_acceleration());
        System.out.println("rata-rata top_power: " + showroom.mean_top_power());
    }
}
