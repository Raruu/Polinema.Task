/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableDosen extends AbstractTableModel  {
    List<ModelDosen> listDosen;         
    
    public ModelTableDosen(List<ModelDosen> listDosen) {
        this.listDosen = listDosen;     
    }

    @Override
    public int getRowCount() {
        return listDosen.size();            
    }

    @Override
    public int getColumnCount() {
        return 8;                               
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {                
            case 0 -> "NIP";
            case 1 -> "Nama Dosen";
            case 2 -> "Tempat lahir";   
            case 3 -> "Tgl. Lahir";
            case 4 -> "Jenis Kelamin";
            case 5 -> "Alamat";
            case 6 -> "Kabupaten/Kota";
            case 7 -> "Provinsi";
            default -> null;
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {           //ok
            case 0 -> listDosen.get(rowIndex).getNip();
            case 1 -> listDosen.get(rowIndex).getNama();
            case 2 -> listDosen.get(rowIndex).getTmpLahir();   
            case 3 -> listDosen.get(rowIndex).getTglLahir();
            case 4 -> listDosen.get(rowIndex).getGender();
            case 5 -> listDosen.get(rowIndex).getAlamat();
            case 6 -> listDosen.get(rowIndex).getKabupatenKota();
            case 7 -> listDosen.get(rowIndex).getProvinsi();
            default -> null;
        }; 
    }
}
