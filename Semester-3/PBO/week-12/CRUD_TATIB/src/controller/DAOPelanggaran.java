package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelPelanggaran;
import config.Config;

public class DAOPelanggaran {
    Connection connection;
    final String insert = "insert into tatib.dbo.pelanggaran (idpelanggaran, jenispelanggaran, levelpelanggaran) VALUES (?, ?, ?)";
    final String update = "update tatib.dbo.pelanggaran set jenispelanggaran=?, levelpelanggaran=? where idpelanggaran=?";
    final String delete = "delete from tatib.dbo.pelanggaran where idpelanggaran=?";
    final String alldata = "select * from tatib.dbo.pelanggaran order by idpelanggaran asc";

    public DAOPelanggaran() {
        connection = SQLServerConnection.connect2SQLServer(Config.username, Config.password);
    }

    public void addPelanggaran(ModelPelanggaran model) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, model.getIdPelanggaran());
            statement.setString(2, model.getNamaPelanggaran());
            statement.setString(3, model.getLevelPelanggaran());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah data Pelanggaran gagal " + e.getMessage());
        }
    }

    public void updatePelanggaran(ModelPelanggaran model) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, model.getNamaPelanggaran());
            statement.setString(2, model.getLevelPelanggaran());
            statement.setString(3, model.getIdPelanggaran());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Rubah data Pelanggaran gagal " + e.getMessage());
        }
    }

    public void deletePelanggaran(String id) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hapus data Pelanggaran gagal " + e.getMessage());
        }
    }

    public boolean findPelanggaran(String id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("select * from tatib.dbo.pelanggaran where idpelanggaran='" + id + "'");
            rs.next();
            return rs.getRow() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pencarian data Pelanggaran gagal " + e.getMessage());
        }
        return false;
    }

    public List<ModelPelanggaran> listPelanggaran() {
        List<ModelPelanggaran> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(alldata);
            while (rs.next()) {
                ModelPelanggaran model = new ModelPelanggaran();
                model.setPelanggaran(rs.getString("idpelanggaran"), rs.getString("jenispelanggaran"), rs.getString("levelpelanggaran"));
                list.add(model);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data Pelanggaran " + e.getMessage());
        }
        return list;
    }
}
