/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;
import model.ModelMahasiswa;
import model.ModelTableMahasiswa;
import view.Mahasiswa;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerMahasiswa {
    Mahasiswa mahasiswa;
    List<ModelMahasiswa> listMahasiswa;                     
    DAOMahasiswa daoMahasiswa = new DAOMahasiswa();         
    ModelMahasiswa modelMahasiswa = new ModelMahasiswa();   
    
    public ControllerMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;                 
        listMahasiswa = daoMahasiswa.listMahasiswa();       
    }
    
    public void viewListMahasiswa(){
        ModelTableMahasiswa modelTableMahasiswa = new ModelTableMahasiswa(listMahasiswa);
        mahasiswa.getTableMahasiwa().setModel(modelTableMahasiswa);
    }

    public void saveMahasiswa(){
        modelMahasiswa.setMahasiswa(
            mahasiswa.gettfNim(), 
            mahasiswa.gettfNama(),
            mahasiswa.gettfTmpLahir(),
            mahasiswa.getspTglLahir(), 
            mahasiswa.getcbGender(), 
            mahasiswa.gettfAlamat(), 
            mahasiswa.gettfDesaKelurahan(), 
            mahasiswa.gettfKecamatan(), 
            mahasiswa.gettfKabupatenKota(), 
            mahasiswa.gettfProvinsi()
        );
        if (daoMahasiswa.findMahasiswa(modelMahasiswa.getNim()) == true){
            //if id customers exists then update data
            daoMahasiswa.updateMahasiswa(modelMahasiswa);
            JOptionPane.showMessageDialog(null, "Updating data was successful");
        } else {
            daoMahasiswa.addMahasiswa(modelMahasiswa);
            JOptionPane.showMessageDialog(null, "Adding data was successful");
        }
    }
    
    public void deleteMahasiswa(){
        daoMahasiswa.deleteMahasiswa(mahasiswa.gettfNim());
        JOptionPane.showMessageDialog(null, "Deleting data was successful");
    }
    
}
