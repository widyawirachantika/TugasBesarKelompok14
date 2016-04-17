/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author User
 */
public abstract class Orang implements Serializable{
    private String nama;
    private String id;
    private String jabatan;
    //String username;
    private String password;
    
    public Orang(String nama, String id,String password) {
        this.nama = nama;
        this.id = id;
        this.password = password;
    }
    
    public Orang(String id, String password){
        this.id = id;
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNama(){
            return nama;
    }

    public String getId(){
            return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public abstract String getJabatan();
    
}
