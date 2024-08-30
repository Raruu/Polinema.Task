public class Main {
    public static double hitungLuasPersegiPanjang(double panjang, double lebar) {
        return panjang * lebar;
    }

    public static double hitungKelilingPersegiPanjang(double panjang, double lebar) {
        return 2 * (panjang + lebar);
    }

    public static double hitungLuasLingkaran(double jariJari) {
        return Math.PI * jariJari * jariJari;
    }

    public static double hitungKelilingLingkaran(double jariJari) {
        return 2 * Math.PI * jariJari;
    }

    public static void main(String[] args) {
        double panjangPersegiPanjang = 5;
        double lebarPersegiPanjang = 3;
        double jariJariLingkaran = 3.5;

        double luasPersegiPanjang = hitungLuasPersegiPanjang(panjangPersegiPanjang, lebarPersegiPanjang);
        double kelilingPersegiPanjang = hitungKelilingPersegiPanjang(panjangPersegiPanjang, lebarPersegiPanjang);

        double luasLingkaran = hitungLuasLingkaran(jariJariLingkaran);
        double kelilingLingkaran = hitungKelilingLingkaran(jariJariLingkaran);

        // Tampilkan hasil perhitungan
        System.out.println("Luas Persegi Panjang: " + luasPersegiPanjang);
        System.out.println("Keliling Persegi Panjang: " + kelilingPersegiPanjang);
        System.out.println("Luas Lingkaran: " + luasLingkaran);
        System.out.println("Keliling Lingkaran: " + kelilingLingkaran);
    }
}