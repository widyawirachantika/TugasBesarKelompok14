/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class Anggota extends Orang implements Serializable {

    private ArrayList<Peminjaman> riwayatPinjaman = new ArrayList();
    private int jumPinjaman = 0;
    private String jabatan;
    private String date;

    SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

    public Anggota(String nama, String id, String password) {
        super(nama, id, password);
    }

    public Anggota(String id, String password) {
        super(id, password);
    }

    //belum kelar, peminjaman dicek statusnya dlu
    public void createPeminjaman(String tgl) {
        
        if ((riwayatPinjaman.isEmpty()) || (riwayatPinjaman.get(jumPinjaman-1).isStatusPeminjaman() == false)  ) {
            riwayatPinjaman.add(new Peminjaman(tgl));
            riwayatPinjaman.get(jumPinjaman).setStatusPeminjaman(true);
            jumPinjaman++;
        }

//        if (riwayatPinjaman.get(jumPinjaman).isStatusPeminjaman() == false) {
//            jumPinjaman++;
//            date = dateformat.parse(tgl);
//            riwayatPinjaman.add(new Peminjaman(tgl));
//            
//            riwayatPinjaman.get(jumPinjaman).setStatusPeminjaman(true);
//            System.out.println("lololol");
//        }
    }
    
    public List<Peminjaman> getPeminjaman(){
        return riwayatPinjaman;
    }
    public Peminjaman getPeminjamanByIndex(int indeks) {
        return riwayatPinjaman.get(indeks);
    }

    //belum kelar, getTanggal di peminjaman blm ada
    public Peminjaman getPeminjamanByDate(Date tanggal) {
        Peminjaman temp = null;
        for (Peminjaman peminjaman : riwayatPinjaman) {
            if (peminjaman.getTanggalPinjam().equals(tanggal)) {
                temp = peminjaman;
            }
        }
        return temp;
    }

    //belum kelar, getIdBarang blm ada
    public void kembalikanPinjaman(int idPeminjaman) {
        for (Peminjaman peminjaman : riwayatPinjaman) {
            if (peminjaman.isStatusPeminjaman() == true) {

            }
        }
    }

    @Override
    public String getJabatan() {
        return "Anggota";
    }

}
