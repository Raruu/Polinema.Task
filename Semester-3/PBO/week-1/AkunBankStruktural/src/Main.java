public class Main {
    public static void setorTunai(double[] saldo, int indeksNasabah, double jumlah, String[] namaNasabah) {
        saldo[indeksNasabah] += jumlah;
        System.out.println("Setor tunai berhasil. Saldo " + namaNasabah[indeksNasabah] + " bertambah " + jumlah);
    }

    public static void tarikTunai(double[] saldo, int indeksNasabah, double jumlah, String[] namaNasabah) {
        if (saldo[indeksNasabah] >= jumlah) {
            saldo[indeksNasabah] -= jumlah;
            System.out.println("Tarik tunai berhasil. Saldo " + namaNasabah[indeksNasabah] + " berkurang " + jumlah);
        } else {
            System.out.println("Saldo " + namaNasabah[indeksNasabah] + " tidak mencukupi.");
        }
    }

    public static void cekSaldo(String[] namaNasabah, double[] saldo, int indeksNasabah) {
        System.out.println("Saldo " + namaNasabah[indeksNasabah] + ": " + saldo[indeksNasabah]);
    }

    public static void transfer(String[] namaNasabah, double[] saldo, int indeksPengirim, int indeksPenerima, double jumlah) {
        if (saldo[indeksPengirim] >= jumlah) {
            saldo[indeksPengirim] -= jumlah;
            saldo[indeksPenerima] += jumlah;
            System.out.println("Transfer berhasil. " + namaNasabah[indeksPengirim] + " mentransfer " + jumlah + " ke " + namaNasabah[indeksPenerima]);
        } else {
            System.out.println("Saldo " + namaNasabah[indeksPengirim] + " tidak mencukupi untuk transfer.");
        }
    }

    public static void main(String[] args) {
        String[] namaNasabah = {"Andi", "Budi"};
        double[] saldo = {1000000, 500000};

        // Contoh penggunaan fungsi-fungsi
        System.out.println("Saldo awal:");
        cekSaldo(namaNasabah, saldo, 0); // Cek saldo Andi
        cekSaldo(namaNasabah, saldo, 1); // Cek saldo Budi

        setorTunai(saldo, 0, 500000, namaNasabah); // Andi setor 500000
        tarikTunai(saldo, 1, 200000, namaNasabah); // Budi tarik 200000
        transfer(namaNasabah, saldo, 0, 1, 300000); // Andi transfer 300000 ke Budi

        System.out.println("\nSaldo setelah transaksi:");
        cekSaldo(namaNasabah, saldo, 0); // Cek saldo Andi
        cekSaldo(namaNasabah, saldo, 1); // Cek saldo Budi
    }
}