import java.util.Scanner;

public class UcapanTerimaKasih_13 {
    private static Scanner sc;

    public static String PenerimaUcapan() {
        System.out.println("Tuliskan NAMA orang yang ingin Anda beri ucapan:");
        String namaOrang = sc.nextLine();
        return namaOrang;
    }

    public static void UcapanTerimakasih() {
        String nama = PenerimaUcapan();
        System.out.println("Thank you " + nama + " for being the best teacher in the world.\n" +
                "You inspired in me a love for learning and made me feel like I could ask you anything.");
    }

    public static void UcapanTambahan(String tambahan) {
        System.out.println(tambahan);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        UcapanTerimakasih();
        System.out.print("Tuliskan ucapan tambahan: ");
        UcapanTambahan(sc.nextLine());
        sc.close();
    }
}
