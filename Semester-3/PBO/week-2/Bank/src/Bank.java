public class Bank {
    String norek;
    String namaPemilik;
    double saldo;

    public Bank(String norek, String namaPemilik, double saldo) {
        this.norek = norek;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    public void cekSaldo() {
        System.out.println("Saldo tabungan Anda sejumlah Rp." + saldo);
    }

    public void simpanUang(double jumlah) {
        saldo += jumlah;
        System.out.println("Anda menyimpan uang sejumlah Rp." + jumlah);
        cekSaldo();
    }

    public void ambilUang(double jumlah) {
        if (jumlah > saldo) {
            System.out.println("Uang tidak cukup");
            return;
        }
        saldo -= jumlah;
        System.out.println("Anda mengambil uang sejumlah Rp." + jumlah);
        cekSaldo();
    }
}
