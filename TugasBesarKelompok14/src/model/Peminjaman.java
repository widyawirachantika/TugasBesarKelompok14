/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class Peminjaman implements Serializable {

    ArrayList<Barang> barang = new ArrayList();
    private String nama;
    private int id;
    private static int count;
    private String tanggalPinjam;
    private static boolean statusPeminjaman = false;
    private int nPinjaman;

    public Peminjaman(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
        System.out.println("create pinjaman");
        id = count++;
    }

    public ArrayList<Barang> getBarang() {
        return barang;
    }

    public void setBarang(ArrayList<Barang> barang) {
        this.barang = barang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public boolean isStatusPeminjaman() {
        return statusPeminjaman;
    }
    
    public String statusPeminjama() {
        if (isStatusPeminjaman() == true) {
            return "Not Available";
        }
        return "Available";
    }

    public void setStatusPeminjaman(boolean statusPeminjaman) {
        Peminjaman.statusPeminjaman = statusPeminjaman;
    }

    //setnBarangDipinjam dari Barang blm ada
    //progress
    public void addBarangPinjaman(Barang b, int jumlahPinjam) {
        if (barang.get(barang.indexOf(b)).getnBarangDipinjam() + jumlahPinjam <= barang.get(barang.indexOf(b)).getnBarang()) {
            b.setnBarangDipinjam(jumlahPinjam);
            barang.add(nPinjaman, b);
            statusPeminjaman = false;
            nPinjaman++;
        }

        //b.setStatusBarang();
        //b.setJumPinjam(jumlahPinjam);
        //barang.remove(nPinjaman);
    }

    public void removeBarangPinjaman(Barang b, int jumlahDibalikkan) {

        Barang temp = barang.stream().filter((Barang br) -> br.equals(b)).findFirst().orElse(null);
        if (temp != null) {
            barang.get(barang.indexOf(temp)).setnBarangDipinjam(-(jumlahDibalikkan));
        }

//        b.setStatusBarang();
//        for (int i = 0; i < nPinjaman; i++) {
//            if (barang.get(i).getKodeBarang() == b.getKodeBarang()) {
//                b.setnBarangDipinjam(nPinjaman);
//                barang.remove(i);
//                barang.add(i, b);
//                if (barang.get(i).getnBarangDipinjam() == 0) {
//                    barang.remove(barang.get(i));
//                    nPinjaman--;
//                }
//            }
//        }
    }

    public Barang getBarangbyIndex(int x) {
        return barang.get(x);
    }

    //blm kelar, class Barang blm ada
    //progress
    public Barang getBarangbyID(int kodeBarang) {
        Barang temp = null;
        for (Barang b : barang) {
            if (b.getKodeBarang() == kodeBarang) {
                temp = b;
            }
        }
        return temp;
    }
}
