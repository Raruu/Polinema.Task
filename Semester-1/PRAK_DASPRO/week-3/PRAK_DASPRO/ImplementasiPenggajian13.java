import java.util.Scanner;

public class ImplementasiPenggajian13 {
    public static void main(String[] args) {
        Scanner scInput = new Scanner(System.in);
        int tunjangan, lembur_Jam, poin_Potongan,
                gaji_pokok = 5000000, lembur_perjam = 200000, poin_perpotongan = 150000;
        long hasil_Gaji;
        System.out.print("Nama Karyawan: ");
        String nama_Karyawan = scInput.nextLine();
        System.out.print("Tunjangan: ");
        tunjangan = scInput.nextInt();
        System.out.print("Lama lembur per-jam: ");
        lembur_Jam = scInput.nextInt();
        System.out.print("Poin potongan: ");
        poin_Potongan = scInput.nextInt();

        int bonus_Gaji = lembur_Jam * lembur_perjam, potongan_Gaji = poin_Potongan * poin_perpotongan;
        hasil_Gaji = gaji_pokok + tunjangan + bonus_Gaji - potongan_Gaji;
        System.out.println("\n\n\n#####SLIP GAJI PT. MAJU MUNDUR#####");
        System.out.println("Nama Karyawan:\t " + nama_Karyawan);
        System.out.println("Gaji Pokok:\t Rp" + gaji_pokok);
        System.out.println("Tunjangan:\t Rp" + tunjangan);
        System.out.println("Bonus Gaji:\t Rp" + bonus_Gaji);
        System.out.println("Potongan Gaji:\t Rp" + potongan_Gaji);
        System.out.println("------------------------");
        System.out.println("Total Gaji:\t Rp" + hasil_Gaji);
        System.out.println("###################################\n\n");
        scInput.close();
    }
}
