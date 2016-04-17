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
public class Barang implements Serializable{
    private String namaBarang;
    private int kodeBarang;
    private boolean statusBarang = true;
    private int nBarang=0;
    private int nBarangDipinjam=0;
    
    //private int jumPinjam;

    public Barang(String namaBarang, int kodeBarang, int nBarang) {
        this.namaBarang = namaBarang;
        this.kodeBarang = kodeBarang;
        this.nBarang = nBarang;
    }
    
    public Barang(String namaBarang, int kodeBarang) {
        this.namaBarang = namaBarang;
        this.kodeBarang = kodeBarang;
    }
    
    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = this.namaBarang+namaBarang;
    }

    public int getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(int kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public boolean isStatusBarang() {
        return statusBarang;
    }

    public void setStatusBarang() {
        if (nBarang == nBarangDipinjam) {
            statusBarang=false;
        }else{
            statusBarang = true;
        }
    }

    public int getnBarang() {
        return nBarang;
    }

    public void setnBarang(int nBarang) {
        this.nBarang = this.nBarang+nBarang;
    }

    public int getnBarangDipinjam() {
        return nBarangDipinjam;
    }

    public void setnBarangDipinjam(int nBarangDipinjam) {
        this.nBarangDipinjam = this.nBarangDipinjam + nBarangDipinjam;
    }

//    public int getJumPinjam() {
//        return jumPinjam;
//    }
//
//    public void setJumPinjam(int jumPinjam) {
//        this.jumPinjam = jumPinjam;
//    }
//    
    
}
