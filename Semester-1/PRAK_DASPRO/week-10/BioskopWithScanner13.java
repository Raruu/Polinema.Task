import java.util.Scanner;

public class BioskopWithScanner13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int baris, kolom;
        String nama, next;
        String[][] penonton = new String[4][2];
        Boolean isRunning = true;
        while (isRunning) {
            int menuItem;
            System.out.println("\nPilih menu\n" +
                    "- Menu 1: Input data penonton\n" +
                    "- Menu 2: Tampilkan daftar penonton\n" +
                    "- Menu 3: Exit");
            System.out.print("Masukkan Menu: ");
            menuItem = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (menuItem) {
                case 1:
                    while (true) {
                        System.out.print("Masukkan nama: ");
                        nama = sc.nextLine();
                        while (true) {
                            System.out.print("Masukkan baris: ");
                            baris = sc.nextInt();
                            System.out.print("Masukkan kolom: ");
                            kolom = sc.nextInt();
                            sc.nextLine();
                            if ((baris - 1) >= penonton.length || (kolom - 1) >= penonton[baris - 1].length)
                                System.out.println("Baris atau Kolom tidak tersedia\nMembuang Inputan tadi. . .");
                            else if (penonton[baris - 1][kolom - 1] == null)
                                penonton[baris - 1][kolom - 1] = nama;
                            else {
                                System.out.println(
                                        "WARNING, kursi telah diisi.\nMohon masukkan kembali baris dan kolom. . .");
                                continue;
                            }
                            break;
                        }
                        System.out.print("Input penonton lainnya? (y/n): ");
                        next = sc.nextLine();
                        if (next.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < penonton.length; i++) {
                        System.out.print("Penonton baris ke-" + i + ": ");
                        Boolean isNext = false;
                        for (String j : penonton[i]) {
                            if (isNext)
                                System.out.print(", ");
                            System.out.print((j == null) ? "***" : j);
                            isNext = true;
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Menu tidak " + menuItem + " ada");
                    break;
            }
        }
        sc.close();
    }
}
