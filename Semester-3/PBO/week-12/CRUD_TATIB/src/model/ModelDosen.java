/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class ModelDosen {
    private String nip, nama, tmplahir, tgllahir, gender, alamat, sebagai, kabupatenkota, provinsi;
    
    //Set data method ---------------------
    public void setDosen(String nip, String nama, String tmplahir, String tgllahir, String gender, String alamat, String sebagai, String kabupatenkota, String provinsi) {
        this.nip  = nip; 
        this.nama = nama; 
        this.tmplahir = tmplahir; 
        this.tgllahir = tgllahir; 
        this.gender = gender;
        this.alamat = alamat;
        this.sebagai = sebagai;
        this.kabupatenkota = kabupatenkota;
        this.provinsi = provinsi;
    }
    
    public String getNip() {
        return this.nip;
    }
    
    public String getNama() {
        return this.nama;
    }
    
    public String getGender() {
        return this.gender;
    }
    
    public String getTmpLahir() {
        return this.tmplahir;
    }
    
    public String getTglLahir() {
        return this.tgllahir;
    }
    
    public String getAlamat() {
        return this.alamat;
    }

    public String getSebagai() {
        return this.sebagai;
    }
    
    public String getKabupatenKota() {
        return this.kabupatenkota;
    }
    
    public String getProvinsi() {
        return this.provinsi;
    }
    
}
