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
public class Petugas extends Orang implements Serializable{

    
    public Petugas(String nama, String id, String password) {
        super(nama, id, password);
    }
    
    public Petugas(String id, String password) {
        super(id, password);
    }


    @Override
    public String getJabatan() {
        return "Petugas";
    }
    
}
