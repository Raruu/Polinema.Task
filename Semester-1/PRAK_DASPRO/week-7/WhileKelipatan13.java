import java.util.Scanner;

public class WhileKelipatan13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int kelipatan, jumlah = 0, couter = 0;
        float rataKelipatan = 0f;
        System.out.print("Masukkan bilangan kelipatan (1-9): ");
        kelipatan = scan.nextInt();
        int i = 1;
        while (i <= 50) {
            if (i % kelipatan == 0) {
                jumlah += i;
                couter++;
                rataKelipatan++;
            }
            i++;
        }
        rataKelipatan = jumlah / rataKelipatan;
        System.out.printf("Banyaknya bilangan %d dari 1 sampai 50 adalah %d\n", kelipatan, couter);
        System.out.printf("Total bilangan kelipatan %d dari 1 sampai 50 adalah %d\n", kelipatan, jumlah);
        System.out.printf("Rata-rata bilangan kelipatan %d dari 1 sampai 50 adalah %f\n", kelipatan, rataKelipatan);
        scan.close();
    }
}
