public class Tabungan {
    private String norek, namaPemilik;
    private double saldo;

    private double hitungBunga(double bunga) {
        return saldo * bunga;
    }

    private double biayaTransfer(double jumlah){
        return 0.05 * jumlah;
    }

    public Tabungan(String norek, String namaPemilik, double saldo) {
        this.norek = norek;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    public void cekSaldo() {
        System.out.println("Saldo tabungan Anda Rp." + saldo);
    }

    public void simpanUang(double jumlah) {
        System.out.println("Saldo bertambah Rp." + jumlah);
        saldo += jumlah;
        System.out.println("Saldo akhir Rp." + saldo);
    }

    public void ambilUang(double jumlah) {
        if (jumlah > saldo) {
            System.out.println("Saldo tidak cukup");
            return;
        }
        System.out.println("Saldo berkurang Rp." + jumlah);
        saldo -= jumlah;
        System.out.println("Saldo akhir Rp." + saldo);
    }

    public void penyesuaianSaldo() {
        System.out.println("Saldo awal Rp." + saldo);
        double bunga = hitungBunga(0.01);
        System.out.println("Saldo bertambah Rp." + bunga);
        saldo += bunga;
        System.out.println("Saldo akhir Rp." + saldo);
    }

    public void kirimUang(double jumlah){
        System.out.println("Saldo awal Rp." + saldo);
        System.out.println("Jumlah transfer Rp." +jumlah);
        double biayaTransfer = biayaTransfer(jumlah);
        saldo -= (jumlah + biayaTransfer);
        System.out.println("Saldo akhir Rp." + saldo);
    }
}
