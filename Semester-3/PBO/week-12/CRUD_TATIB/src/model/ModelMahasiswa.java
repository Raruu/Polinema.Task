/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class ModelMahasiswa {
    private String nim, nama, tmplahir, tgllahir, gender, alamat, desa, kecamatan, kabupatenkota, provinsi;
    
    //Set data method ---------------------
    public void setMahasiswa(String nim, String nama, String tmplahir, String tgllahir, String gender, String alamat, String desa, String kecamatan, String kabupatenkota, String provinsi) {
        this.nim  = nim; 
        this.nama = nama; 
        this.tmplahir = tmplahir; 
        this.tgllahir = tgllahir; 
        this.gender = gender;
        this.alamat = alamat;
        this.desa = desa;
        this.kecamatan = kecamatan;
        this.kabupatenkota = kabupatenkota;
        this.provinsi = provinsi;
    }
    
    public String getNim() {
        return this.nim;
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
    
    public String getDesa() {
        return this.desa;
    }
    
    public String getKecamatan() {
        return this.kecamatan;
    }
    
    public String getKabupatenKota() {
        return this.kabupatenkota;
    }
    
    public String getProvinsi() {
        return this.provinsi;
    }
    
}
