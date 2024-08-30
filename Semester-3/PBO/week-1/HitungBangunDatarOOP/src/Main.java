public class Main {
    public static void main(String[] args) {
        double panjangPersegiPanjang = 5;
        double lebarPersegiPanjang = 3;
        double jariJariLingkaran = 3.5;
        double alasSegitiga = 6.5;
        double tinggiSegitiga = 5;

        PersegiPanjang persegiPanjang = new PersegiPanjang(panjangPersegiPanjang, lebarPersegiPanjang);
        Segitiga segitiga = new Segitiga(alasSegitiga, tinggiSegitiga);
        Lingkaran lingkaran = new Lingkaran(jariJariLingkaran);

        // Tampilkan hasil perhitungan
        System.out.println("Luas Persegi Panjang: " + persegiPanjang.hitungLuas());
        System.out.println("Keliling Persegi Panjang: " + persegiPanjang.hitungKeliling());
        System.out.println("Keliling Segitiga: " + segitiga.luasSegitiga());
        System.out.println("Luas Lingkaran: " + lingkaran.hitungLuas());
        System.out.println("Keliling Lingkaran: " + lingkaran.hitungKeliling());
    }
}