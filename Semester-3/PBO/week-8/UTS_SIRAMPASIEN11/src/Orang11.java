public class Orang11 {
    private String nama11;
    private boolean jenisKelamin11;
    private String alamat11;
    private String noTelp11;


    // Constructor Overloading
    public Orang11() {
    }

    public Orang11(String nama11) {
        this.nama11 = nama11;
    }

    public Orang11(String nama11, boolean jenisKelamin11) {
        this.nama11 = nama11;
        this.jenisKelamin11 = jenisKelamin11;
    }

    public Orang11(String nama11, boolean jenisKelamin11, String alamat11) {
        this.nama11 = nama11;
        this.jenisKelamin11 = jenisKelamin11;
        this.alamat11 = alamat11;
    }

    public Orang11(String nama11, boolean jenisKelamin11, String alamat11, String noTelp11) {
        this.nama11 = nama11;
        this.jenisKelamin11 = jenisKelamin11;
        this.alamat11 = alamat11;
        this.noTelp11 = noTelp11;
    }

    public String getNama11() {
        return nama11;
    }

    public void setNama11(String nama11) {
        this.nama11 = nama11;
    }

    public boolean getJenisKelamin11() {
        return jenisKelamin11;
    }

    public String getJenisKelamin(boolean returnKataPenuh) {
        if (returnKataPenuh) {
            return jenisKelamin11 ? "Laki-Laki" : "Perempuan";

        } else {
            return jenisKelamin11 ? "L" : "P";
        }

    }

    // Ini Overloading
    public void setJenisKelamin11(boolean jenisKelamin11) {
        this.jenisKelamin11 = jenisKelamin11;
    }

    public void setJenisKelamin11(String jenisKelamin11) {
        if (jenisKelamin11.length() > 1) {
            this.jenisKelamin11 = jenisKelamin11.equalsIgnoreCase("Laki-Laki");
        } else {
            this.jenisKelamin11 = jenisKelamin11.equalsIgnoreCase("L");
        }
    }

    public String getAlamat11() {
        return alamat11;
    }

    public void setAlamat11(String alamat11) {
        this.alamat11 = alamat11;
    }

    public String getNoTelp11() {
        return noTelp11;
    }

    public void setNoTelp11(String noTelp11) {
        this.noTelp11 = noTelp11;
    }

    public void printInfo11() {
        System.out.println("Nama: " + nama11);
        System.out.println("Jenis Kelamin: " + getJenisKelamin(true));
        System.out.println("Alamat: " + alamat11);
        System.out.println("NO Telp: " + noTelp11);
    }
}
