/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import config.Config;
import model.ModelMahasiswa;


public class DAOMahasiswa {
    Connection connection;
    //---Konstanta untuk perintah SQL -----
    final String insert   = "insert into tatib.dbo.mahasiswa (nim, nama, tmplahir, tgllahir, gender, alamat, desa, kecamatan, kabupatenkota, provinsi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
    final String update   = "update tatib.dbo.mahasiswa set nama=?, tmplahir=?, tgllahir=?, gender=?, alamat=?, desa=?, kecamatan=?, kabupatenkota=?, provinsi=? where nim=?";
    final String delete   = "delete from tatib.dbo.mahasiswa where nim=?";
    final String alldata  = "select * from tatib.dbo.mahasiswa order by nim asc";

    //Constructor class --> create a connection to the database server
    public DAOMahasiswa() {
        connection = SQLServerConnection.connect2SQLServer(Config.username, Config.password);
    }
    
    public void addMahasiswa(ModelMahasiswa model) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, model.getNim());
            statement.setString(2, model.getNama());
            statement.setString(3, model.getTmpLahir());        
            statement.setString(4, model.getTglLahir());
            statement.setString(5, model.getGender());
            statement.setString(6, model.getAlamat());
            statement.setString(7, model.getDesa());
            statement.setString(8, model.getKecamatan());
            statement.setString(9, model.getKabupatenKota());
            statement.setString(10, model.getProvinsi());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Mahasiswa gagal " + e.getMessage());
        }
    }

    public void updateMahasiswa(ModelMahasiswa model) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, model.getNama());
            statement.setString(2, model.getTmpLahir());
            statement.setString(3, model.getTglLahir());
            statement.setString(4, model.getGender());
            statement.setString(5, model.getAlamat());
            statement.setString(6, model.getDesa());
            statement.setString(7, model.getKecamatan());
            statement.setString(8, model.getKabupatenKota());
            statement.setString(9, model.getProvinsi());
            statement.setString(10, model.getNim());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Rubah data Mahasiswa gagal " + e.getMessage());
        }
    }

    public void deleteMahasiswa(String nim) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, nim);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data Mahasiswa gagal " + e.getMessage());
        }
    }

    public boolean findMahasiswa(String nim) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("select * from tatib.dbo.mahasiswa where nim='"+nim+"'");
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
    public List<ModelMahasiswa> listMahasiswa() {
        List<ModelMahasiswa> arraylistMahasiswa = null;
        try {
            arraylistMahasiswa = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(alldata);
            while (rs.next()) {
                ModelMahasiswa model = new ModelMahasiswa();
                model.setMahasiswa(
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getString("tmplahir"),
                    rs.getString("tgllahir"),
                    rs.getString("gender"),
                    rs.getString("alamat"),
                    rs.getString("desa"),
                    rs.getString("kabupatenkota"),
                    rs.getString("kecamatan"),
                    rs.getString("provinsi")
                );
                arraylistMahasiswa.add(model);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylistMahasiswa;
    }    

}
