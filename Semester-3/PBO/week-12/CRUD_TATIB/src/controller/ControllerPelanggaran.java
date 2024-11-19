package controller;

import model.ModelPelanggaran;
import model.ModelTabelPelanggaran;
import view.Pelanggaran;
import javax.swing.JOptionPane;
import java.util.List;

public class ControllerPelanggaran {
    Pelanggaran pelanggaran;
    List<ModelPelanggaran> listPelanggaran;
    DAOPelanggaran daoPelanggaran = new DAOPelanggaran();
    ModelPelanggaran modelPelanggaran = new ModelPelanggaran();

    public ControllerPelanggaran(Pelanggaran pelanggaran) {
        this.pelanggaran = pelanggaran;
        listPelanggaran = daoPelanggaran.listPelanggaran();
    }

    public void viewListPelanggaran() {
        ModelTabelPelanggaran modelTablePelanggaran = new ModelTabelPelanggaran(listPelanggaran);
        pelanggaran.getTablePelanggaran().setModel(modelTablePelanggaran);
    }

    public void savePelanggaran() {
        modelPelanggaran.setPelanggaran(
            pelanggaran.getIdPelanggaran(),
            pelanggaran.getJenisPelanggaran(),
            pelanggaran.getLevelPelanggaran()
        );

        if (daoPelanggaran.findPelanggaran(modelPelanggaran.getIdPelanggaran())) {
            daoPelanggaran.updatePelanggaran(modelPelanggaran);
            JOptionPane.showMessageDialog(null, "Updating data was successful");
        } else {
            daoPelanggaran.addPelanggaran(modelPelanggaran);
            JOptionPane.showMessageDialog(null, "Adding data was successful");
        }
    }

    public void deletePelanggaran() {
        daoPelanggaran.deletePelanggaran(pelanggaran.getIdPelanggaran());
        JOptionPane.showMessageDialog(null, "Deleting data was successful");
    }
}
