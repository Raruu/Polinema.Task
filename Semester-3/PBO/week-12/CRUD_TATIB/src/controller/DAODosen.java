/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelDosen;


public class DAODosen {
    Connection connection;
    //---Konstanta untuk perintah SQL -----
    final String insert   = "insert into tatib.dbo.dosen (nip, nama, tmplahir, tgllahir, gender, alamat, sebagai, kabupatenkota, provinsi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
    final String update   = "update tatib.dbo.dosen set nama=?, tmplahir=?, tgllahir=?, gender=?, alamat=?, sebagai=?, kabupatenkota=?, provinsi=? where nip=?";
    final String delete   = "delete from tatib.dbo.dosen where nip=?";
    final String alldata  = "select * from tatib.dbo.dosen order by nip asc";

    //Constructor class --> create a connection to the database server
    public DAODosen() {
        connection = SQLServerConnection.connect2SQLServer(Config.username, Config.password);
    }
    
    public void addDosen(ModelDosen model) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, model.getNip());
            statement.setString(2, model.getNama());
            statement.setString(3, model.getTmpLahir());        
            statement.setString(4, model.getTglLahir());
            statement.setString(5, model.getGender());
            statement.setString(6, model.getAlamat());
            statement.setString(7, model.getSebagai());
            statement.setString(8, model.getKabupatenKota());
            statement.setString(9, model.getProvinsi());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Dosen gagal " + e.getMessage());
        }
    }

    public void updateDosen(ModelDosen model) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, model.getNama());
            statement.setString(2, model.getTmpLahir());
            statement.setString(3, model.getTglLahir());
            statement.setString(4, model.getGender());
            statement.setString(5, model.getAlamat());
            statement.setString(6, model.getSebagai());
            statement.setString(7, model.getKabupatenKota());
            statement.setString(8, model.getProvinsi());
            statement.setString(9, model.getNip());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Rubah data Dosen gagal " + e.getMessage());
        }
    }

    public void deleteDosen(String nip) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, nip);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data Dosen gagal " + e.getMessage());
        }
    }

    public boolean findDosen(String nip) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("select * from tatib.dbo.dosen where nip='"+nip+"'");
            rs.next();
            if (rs.getRow() > 0) {
                //JOptionPane.showMessageDialog(null, Id + " Found");
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pencarian data Customers gagal " + e.getMessage());
        }
        return false;
    }
    
    //Make a list customers method ----------------
    public List<ModelDosen> listDosen() {
        List<ModelDosen> arraylistDosen = null;
        try {
            arraylistDosen = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(alldata);
            while (rs.next()) {
                ModelDosen model = new ModelDosen();
                model.setDosen(
                    rs.getString("nip"),
                    rs.getString("nama"),
                    rs.getString("tmplahir"),
                    rs.getString("tgllahir"),
                    rs.getString("gender"),
                    rs.getString("alamat"),
                    rs.getString("sebagai"),
                    rs.getString("kabupatenkota"),
                    rs.getString("provinsi")
                );
                arraylistDosen.add(model);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylistDosen;
    }    

}
