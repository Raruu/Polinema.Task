import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AkunBank akunAndi = new AkunBank("Andi", 1000000);
        AkunBank akunBudi = new AkunBank("Budi", 500000);

        System.out.println("Saldo awal:");
        akunAndi.cekSaldo();
        akunBudi.cekSaldo();

        akunAndi.setorTunai(500000);
        akunBudi.tarikTunai(200000);
        akunAndi.transfer(akunBudi, 300000);

        System.out.println("\nSaldo setelah transaksi:");
        akunAndi.cekSaldo();
        akunBudi.cekSaldo();
    }
}