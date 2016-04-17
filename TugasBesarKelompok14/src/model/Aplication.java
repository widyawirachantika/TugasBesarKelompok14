/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.FileIO;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author User
 */
public class Aplication implements Serializable {

    private ArrayList<Anggota> listAnggota;
    private ArrayList<Petugas> listPetugas;
    private ArrayList<Barang> listBarang;
    private FileIO save;

    public Aplication() {
        listAnggota = new ArrayList();
        listBarang = new ArrayList();
        listPetugas = new ArrayList();
        save = new FileIO();
    }

    public void insertAnggota(String nama, String username, String password) {
        listAnggota.add(new Anggota(nama, username, password));
    }

    public boolean isAnggotaAvailable(String username) {
        boolean temp = true;
        for (Anggota anggota : listAnggota) {
            if (anggota.getId().equals(username)) {
                temp = false;
            }
        }
        return temp;
    }

    public void insertPetugas(String nama, String username, String password) {
        Petugas p = new Petugas(nama, username, password);
        listPetugas.add(p);

    }

    public boolean isPetugasAvailable(String username) {

        for (Petugas petugas : listPetugas) {
            if (petugas.getId().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public void insertBarang(String namaBarang, int kodeBarang, int nBarang) {

        Barang temp = listBarang.stream().filter(e -> e.equals(kodeBarang)).findFirst().orElse(null);
        if (temp != null) {
            System.out.println("barang dah ada");
            listBarang.get(listBarang.indexOf(temp)).setnBarang(nBarang);
            System.out.println("");
        } else {
            System.out.println("masuk");
            listBarang.add(new Barang(namaBarang, kodeBarang, nBarang));
            System.out.println("added");
        }

    }

    public void loadAnggota() throws FileNotFoundException, IOException {
        try {
            listAnggota = (ArrayList<Anggota>) save.getObject("DataAnggota.txt");

        } catch (FileNotFoundException e) {
            File f = new File("DataAnggota.txt");
            f.createNewFile();
        } catch (EOFException ex) {
            //listAnggota = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error" + ex.getMessage());
        }
    }

    public void loadPetugas() throws FileNotFoundException, IOException {
        try {
            listPetugas = (ArrayList<Petugas>) save.getObject("DataPetugas.txt");
        } catch (FileNotFoundException e) {
            File f = new File("DataPetugas.txt");
            f.createNewFile();
        } catch (EOFException ex) {
            listPetugas = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error" + ex.getMessage());
        }
    }

    public void loadBarang() throws FileNotFoundException, IOException {
        try {
            listBarang = (ArrayList<Barang>) save.getObject("DataBarang.txt");
        } catch (FileNotFoundException e) {
            File f = new File("DataPetugas.txt");
            f.createNewFile();
        } catch (EOFException ex) {
            listBarang = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error" + ex.getMessage());
        }
    }

    public void saveAnggota() throws FileNotFoundException, IOException {
        try {
            save.saveObject(listAnggota, "DataAnggota.txt");
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public void savePetugas() throws FileNotFoundException, IOException {
        try {
            save.saveObject(listPetugas, "DataPetugas.txt");
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public void saveBarang() throws FileNotFoundException, IOException {
        try {
            save.saveObject(listBarang, "DataBarang.txt");
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public List<Anggota> getListAnggota() {
        List<Anggota> list = new ArrayList<>();
//        listAnggota.stream().map(e -> e.getId()).collect(Collectors.toList());
        listAnggota.stream().forEach((Anggota a) -> {
            list.add(a);
        });
        return list;
    }

//    public String[] getListBarang() {
//        List<String> list = listBarang.stream().map(e->e.getKodeBarang()).collect(Collectors.toList());
//        return (String[])list.stream().toArray(size -> new String[size]);
////        return list.toArray(new String[list.size()]);
//    }
//    public Barang[] getListBarang(){
//        //List<Barang> list = listBarang.stream().map(e->e.getKodeBarang()).collect(Collectors.toList());
//        return List<Barang>.toArray(new Barang[list.size()]);
//    }
    public List<Petugas> getListPetugas() {
        List<Petugas> daft = new ArrayList<>();
        listPetugas.stream().forEach((p) -> {
            daft.add(p);
        });
        return daft;
    }

    public List<Barang> getListBarang() throws IOException {
        List<Barang> daft = new ArrayList<>();
        listBarang.stream().forEach((p) -> {
            daft.add(p);
        });
        return daft;
    }

    public ArrayList<Anggota> getAnggotaFromFile() {
        try {
            FileInputStream fis = new FileInputStream("DataAnggota.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Anggota> a = (ArrayList<Anggota>) ois.readObject();
            return a;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void showList() {
        System.out.println(listAnggota.toString());
    }

    public Object login(String username, String password) throws IOException {
        loadAnggota();
        loadPetugas();
        for (int i = 0; i < listPetugas.size(); i++) {

            if (listPetugas.get(i).getId().equals(username)
                    && listPetugas.get(i).getPassword().equals(password)) {
                return listPetugas.get(i);
            }
        }
        for (int i = 0; i < listAnggota.size(); i++) {
            if (listAnggota.get(i).getId().equals(username)
                    && listAnggota.get(i).getPassword().equals(password)) {
                return listAnggota.get(i);
            }
        }

//        listPetugas.get(listPetugas.indexOf());
//        Petugas p = new Petugas(username,password); 
//        
////        p.setNama(listPetugas.stream().filter(e->e.equals(p.getId())).findFirst().orElse(null).toString());
//        Petugas temp1 = listPetugas.stream().filter(e->e.equals(p)).findFirst().orElse(null);
//        Anggota a = new Anggota(username,password);
////        a.setNama(listAnggota.stream().filter(e->e.equals(a.getId())).findFirst().orElse(null).toString());
//        Anggota temp2 = listAnggota.stream().filter(e->e.equals(a)).findFirst().orElse(null);
//        if (temp1 != null) {
//            System.out.println("PETUGAS");
//        }else if(temp2 != null){
//            System.out.println("ANGGOTA");
//        }else 
//            System.out.println("tidak terdaftar");
//        
        return null;
    }

    public void tambahPeminjaman(String username, String date) throws IOException {
        loadAnggota();
        for (Anggota a : listAnggota) {
            if (a.getId().equals(username)) {

                try {
                    listAnggota.get(listAnggota.indexOf(a)).createPeminjaman(date);
                    System.out.println("lol");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }
    
    public void tambahBarangtoPemimjaman( List<Peminjaman> listPeminjaman ) throws IOException{
 
    }
            
    public List<Peminjaman> viewPeminjaman(String username) {
        for (int i = 0; i < listAnggota.size(); i++) {
            if (listAnggota.get(i).getId().equals(username)) {
                return listAnggota.get(i).getPeminjaman();

            } else {
                return null;
            }
        }
        return null;
    }

    public void tambahBarangPinjaman(String username, Barang b) throws IOException {
        loadAnggota();
    }
    
    public int getIndexPeminjaman(int id, Anggota a) {
        for (int i = 0; i < a.getPeminjaman().size(); i++) {
            if (a.getPeminjaman().get(i).getId() == id) {
                return i;
            }
        }
        return 0;
    }

}


