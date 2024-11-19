/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SQLServerConnection {
    public static Connection connection = null;
    
    public static Connection connect2SQLServer(String username, String password) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=tatib;trustServerCertificate=true";
        try {
            connection = DriverManager.getConnection(url, username, password);
            //JOptionPane.showMessageDialog(null, "Koneksi ke SQL Server berhasil");
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi ke SQL Server gagal");            
        }
        return connection;
    }

    public static boolean closeConnection()  {
        try {
            if (connection != null) {
                connection.close();
                //JOptionPane.showMessageDialog(null, "Penutupan koneksi ke SQL Server berhasil");
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Penutupan koneksi ke SQL Server gagal "+ e.getMessage());
        }
        return false;
    }    
    
    /*--------------------------------------------------------------------------
    public static void main(String[] args) {
        if (connect2SQLServer("sa", "12345") != null) {
            JOptionPane.showMessageDialog(null, "Koneksi ke SQL Server berhasil");
        }
        
        if (closeConnection()==true) {
            JOptionPane.showMessageDialog(null, "Penutupan koneksi ke SQL Server berhasil");
        }
    }
    --------------------------------------------------------------------------*/
}
