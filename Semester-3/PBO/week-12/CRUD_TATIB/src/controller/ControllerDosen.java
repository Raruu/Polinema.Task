/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package controller;
import model.ModelDosen;
import model.ModelTableDosen;
import view.Dosen;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerDosen {
    Dosen dosen;
    List<ModelDosen> listDosen;                     
    DAODosen daoDosen = new DAODosen();         
    ModelDosen modelDosen = new ModelDosen();   
    
    public ControllerDosen(Dosen dosen) {
        this.dosen = dosen;                 
        listDosen = daoDosen.listDosen();       
    }
    
    public void viewListDosen(){
        ModelTableDosen modelTableDosen = new ModelTableDosen(listDosen);
        dosen.getTableDosen().setModel(modelTableDosen);
    }

    public void saveDosen(){
        modelDosen.setDosen(
            dosen.gettfNip(), 
            dosen.gettfNama(),
            dosen.gettfTmpLahir(),
            dosen.getspTglLahir(), 
            dosen.getcbGender(), 
            dosen.gettfAlamat(), 
            dosen.gettfSebagai(),
            dosen.gettfKabupatenKota(), 
            dosen.gettfProvinsi()
        );
        if (daoDosen.findDosen(modelDosen.getNip()) == true){
            //if id customers exists then update data
            daoDosen.updateDosen(modelDosen);
            JOptionPane.showMessageDialog(null, "Updating data was successful");
        } else {
            daoDosen.addDosen(modelDosen);
            JOptionPane.showMessageDialog(null, "Adding data was successful");
        }
    }
    
    public void deleteDosen(){
        daoDosen.deleteDosen(dosen.gettfNip());
        JOptionPane.showMessageDialog(null, "Deleting data was successful");
    }
    
}
