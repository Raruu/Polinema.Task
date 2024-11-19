/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableMahasiswa extends AbstractTableModel  {
    List<ModelMahasiswa> listMahasiswa;         
    
    public ModelTableMahasiswa(List<ModelMahasiswa> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;     
    }

    @Override
    public int getRowCount() {
        return listMahasiswa.size();            
    }

    @Override
    public int getColumnCount() {
        return 10;                               
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {                
            case 0 -> "NIM";
            case 1 -> "Nama Mahasiswa";
            case 2 -> "Tempat lahir";   
            case 3 -> "Tgl. Lahir";
            case 4 -> "Jenis Kelamin";
            case 5 -> "Alamat";
            case 6 -> "Desa/Kelurahan";
            case 7 -> "Kecamatan";
            case 8 -> "Kabupaten/Kota";
            case 9 -> "Provinsi";
            default -> null;
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {           //ok
            case 0 -> listMahasiswa.get(rowIndex).getNim();
            case 1 -> listMahasiswa.get(rowIndex).getNama();
            case 2 -> listMahasiswa.get(rowIndex).getTmpLahir();   
            case 3 -> listMahasiswa.get(rowIndex).getTglLahir();
            case 4 -> listMahasiswa.get(rowIndex).getGender();
            case 5 -> listMahasiswa.get(rowIndex).getAlamat();
            case 6 -> listMahasiswa.get(rowIndex).getDesa();
            case 7 -> listMahasiswa.get(rowIndex).getKecamatan();
            case 8 -> listMahasiswa.get(rowIndex).getKabupatenKota();
            case 9 -> listMahasiswa.get(rowIndex).getProvinsi();
            default -> null;
        }; 
    }
}
