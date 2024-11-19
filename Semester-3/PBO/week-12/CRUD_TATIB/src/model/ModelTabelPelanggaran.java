package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelPelanggaran extends AbstractTableModel {

    private List<ModelPelanggaran> listPelanggaran;

    public ModelTabelPelanggaran(List<ModelPelanggaran> listPelanggaran) {
        this.listPelanggaran = listPelanggaran;
    }

    @Override
    public int getRowCount() {
        return listPelanggaran.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelPelanggaran modelPelanggaran = listPelanggaran.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return modelPelanggaran.getIdPelanggaran();
            case 1:
                return modelPelanggaran.getNamaPelanggaran();
            case 2:
                return modelPelanggaran.getLevelPelanggaran();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Pelanggaran";
            case 1:
                return "Jenis Pelanggaran";
            case 2:
                return "Level Pelanggaran";
        }
        return "";
    }
}
