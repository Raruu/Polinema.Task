package model;

public class ModelPelanggaran {
    private String idPelanggaran, namaPelanggaran, levelPelanggaran;

    public void setPelanggaran(String idPelanggaran, String namaPelanggaran, String levelPelanggaran) {
        this.idPelanggaran = idPelanggaran;
        this.namaPelanggaran = namaPelanggaran;
        this.levelPelanggaran = levelPelanggaran;
    }

    public String getIdPelanggaran() {
        return idPelanggaran;
    }

    public String getNamaPelanggaran() {
        return namaPelanggaran;
    }

    public String getLevelPelanggaran() {
        return levelPelanggaran;
    }

}
