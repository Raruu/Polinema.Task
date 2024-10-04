public class Dosen extends AnggotaKampus{
    public String nip, departemen;

    public Dosen(String nama, String id, String nip, String departemen) {
        super(nama, id);
        this.nip = nip;
        this.departemen = departemen;
    }

    public String getNip() {
        return nip;
    }

    public String getDepartemen() {
        return departemen;
    }
}
