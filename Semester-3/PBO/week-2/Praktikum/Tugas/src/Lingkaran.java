public class Lingkaran {
    double phi;
    double r;

    public Lingkaran(double phi, double r) {
        this.phi = phi;
        this.r = r;
    }

    public double hitungLuas() {
        return phi * r * r;
    }

    public double hitungKeliling() {
        return 2 * phi * r;
    }

}
