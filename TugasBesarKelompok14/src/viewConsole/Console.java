/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewConsole;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import model.Anggota;
import model.Aplication;
import model.Barang;
import model.Orang;
import model.Petugas;

/**
 *
 * @author User
 */
public class Console implements Serializable {

    private Scanner sInt;
    private Scanner sStr;
    private Scanner sStr2;
    private Aplication model;

    public Console() {
        model = new Aplication();
        sInt = new Scanner(System.in);
        sStr = new Scanner(System.in);
        sStr2 = new Scanner(System.in);
    }

    public int inputInteger() {
        try {
            return sInt.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("input must be Integer");
        } finally {
            sInt = new Scanner(System.in);
        }

    }

    public void mainMenu() {
        int pil = 1;
        while (pil != 0) {
            try {
//                Date tanggal = new Date();
//                SimpleDateFormat df = new SimpleDateFormat("d/mm/yyyy") {};
//                tanggal = df.parse("1/11/2011");
//                System.out.println(tanggal.toString());
                model.loadAnggota();
                model.loadPetugas();
                model.loadBarang();
                System.out.println("Menu");
                System.out.println("1. Load Data Anggota & Petugass");
                System.out.println("2. Register Anggota");
                System.out.println("3. Register Petugas");
                System.out.println("4. Login"); //blm
                System.out.println("5. Save data");
                System.out.println("6. Tambah Barang");
                System.out.println("7. Tampilkan data anggota");
                System.out.println("8. Tampilkan data barang");
                System.out.println("9. Tampilkan data petugas");
                System.out.println("");
                System.out.print("Input Menu :");
                pil = inputInteger();
                switch (pil) {
                    case 1:
                        System.out.println("load data anggota, petugas, & barang");
                        model.loadAnggota();
                        model.loadPetugas();
                        model.loadBarang();
                        //model.showList();
                        break;
                    case 2:
                        boolean temp = true;
                        boolean temp2 = true;
                        do {
                            System.out.println("Register Anggota");
                            System.out.println("----------------");
                            System.out.print("Nama    : ");
                            String nama = sStr.nextLine();
                            System.out.print("Username: ");
                            String username = sStr.nextLine();
                            System.out.print("Password: ");
                            String password = sStr.nextLine();
                            temp = model.isAnggotaAvailable(username);
                            temp2 = model.isPetugasAvailable(username);
                            if (temp == true && temp2 == true) {
                                model.insertAnggota(nama, username, password);
                            } else {
                                System.out.println("Username " + username + " sudah digunakan.");
                                System.out.println("Masukkan username lain.");
                            }

                        } while (!temp || !temp2);
                        break;
                    case 3:
                        temp = true;
                        temp2 = true;
                        do {
                            System.out.println("Register Petugas");
                            System.out.println("----------------");
                            System.out.print("Nama    : ");
                            String namaPetugas = sStr.nextLine();
                            System.out.print("Username: ");
                            String usernamePetugas = sStr.nextLine();
                            System.out.print("Password: ");
                            String passwordPetugas = sStr.nextLine();
                            temp = model.isPetugasAvailable(usernamePetugas);
                            temp2 = model.isAnggotaAvailable(usernamePetugas);
                            if (temp == true && temp2 == true) {
                                model.insertPetugas(namaPetugas, usernamePetugas, passwordPetugas);
                            } else {
                                System.out.println("Username " + usernamePetugas + " sudah digunakan.");
                                System.out.println("Masukkan username lain.");
                            }
                        } while (!temp || !temp2);

                        break;
                    case 4:
                        System.out.println("Login");
                        System.out.println("------------");
                        System.out.print("Username : ");
                        String username = sStr.nextLine();
                        System.out.print("Password : ");
                        String password = sStr.nextLine();
                        model.loadAnggota();
                        model.loadPetugas();
                        Orang org = (Orang) model.login(username, password);
                        System.out.println(org.getJabatan());
                        if ("Anggota".equals(org.getJabatan())) {
                            Anggota a = (Anggota) org;
                            int menuAnggota;
                            do {
                                System.out.println("                   Selamat datang " + org.getNama());
                                System.out.println("Menu Anggota");
                                System.out.println("------------");
                                System.out.println("1. View Daftar Pinjaman");
                                System.out.println("2. View Daftar Barang Pinjaman");
                                System.out.println("3. View Daftar Barang");
                                System.out.print("Pilih menu : ");
                                menuAnggota = inputInteger();
                                switch (menuAnggota) {
                                        
                                    case 1:
                                        for (int i = 0; i < a.getPeminjaman().size(); i++) {
                                            System.out.println("Daftar ke-" + (i+1));
                                            System.out.println("ID Peminjaman : " + a.getPeminjaman().get(i).getId());
                                            System.out.println("Tanggal Peminjaman : " + a.getPeminjaman().get(i).getTanggalPinjam());
                                            System.out.println("Status Peminjaman : " + a.getPeminjaman().get(i).statusPeminjama());
                                            System.out.println();
                                        }
                                        break;
                                        
                                    case 2:
                                        System.out.print("Masukkan ID Peminjaman : "); int id = sInt.nextInt();
                                        int index = model.getIndexPeminjaman(id, a);
                                        for (int i = 0; i < a.getPeminjaman().get(index).getBarang().size(); i++) {
                                            System.out.println("ID Barang : " + a.getPeminjaman().get(index).getBarang().get(i).getKodeBarang());
                                            System.out.println("Nama Barang : " + a.getPeminjaman().get(index).getBarang().get(i).getNamaBarang());
                                            System.out.println("Stok Barang : " + ((a.getPeminjaman().get(index).getBarang().get(i).getnBarang())-
                                                    (a.getPeminjaman().get(index).getBarang().get(i).getnBarangDipinjam())));
                                            System.out.println();
                                        }
                                        break;
                                        
                                    case 3:
                                        model.loadBarang();
                                        System.out.println("List Barang");
                                        System.out.println("------------");
                                        System.out.println("Kode | Nama Barang|Jumlah Tersedia");
                                        for (Barang b : model.getListBarang()) {
                                            System.out.print(b.getKodeBarang()+"   "+b.getNamaBarang()+"               "+(b.getnBarang()-b.getnBarangDipinjam()));
                                            System.out.println("");
                                        }
//                                        for (int i = 0; i < model.getListBarang().size(); i++) {
//                                            System.out.println("ID Barang : " + a.getPeminjaman().get(i).getBarang().get(i).getKodeBarang());
//                                            System.out.println("Nama Barang : " + a.getPeminjaman().get(i).getBarang().get(i).getNamaBarang());
//                                            System.out.println("Stok Barang : " + ((a.getPeminjaman().get(i).getBarang().get(i).getnBarang())-
//                                                    (a.getPeminjaman().get(i).getBarang().get(i).getnBarangDipinjam())));
//                                            System.out.println();
//                                        }
                                        break;

                                    default:
                                        break;
                                }
                            } while (menuAnggota != 0);
                        } else if ("Petugas".equals(org.getJabatan())) {
                            int menuPetugas;
                            do {
                                System.out.println("                   Selamat datang " + org.getNama());
                                System.out.println("Menu Petugas");
                                System.out.println("------------");
                                System.out.println("1. Tambah Daftar Pinjaman");
                                System.out.println("2. Tambah Barang Ke Peminjaman");
                                System.out.println("3. View Daftar Peminjaman");
                                System.out.println("4. Remove Daftar Pinjaman");
                                System.out.println("5. Tambah Barang Baru");
                                System.out.println("6. View Daftar Barang");
                                System.out.print("Pilih menu : ");
                                menuPetugas = inputInteger();
                                switch (menuPetugas) {
                                    case 1:
                                        model.loadAnggota();
                                        System.out.print("username : ");
                                        String user = sStr.nextLine();
                                        System.out.print("tanggal(dd/mm/yyyy) : ");
                                        String date = sStr.nextLine();
                                        model.tambahPeminjaman(user, date);
                                        model.saveAnggota();
                                        break;
                                    case 2:

                                        break;
                                    case 3:
                                        model.loadAnggota();
                                        System.out.print("username : ");
                                        user = sStr.nextLine();
                                        for (int i = 0; i < model.viewPeminjaman(user).size(); i++) {
                                            System.out.println(model.viewPeminjaman(user).get(i).getId() + " " + model.viewPeminjaman(user).get(i).getTanggalPinjam() + " " + model.viewPeminjaman(user).get(i).isStatusPeminjaman());

                                        }

                                        break;
                                    default:
                                        break;
                                }
                            } while (menuPetugas != 0);

                        }
                        break;
                    case 5:
                        System.out.println("save data anggota & petugas");
                        model.savePetugas();
                        model.saveAnggota();
                        model.saveBarang();
                        break;

                    case 6:
                        System.out.println("Tambah Barang");
                        System.out.println("----------------");
                        System.out.print("Nama Barang   : ");
                        String nama = sStr.nextLine();
                        System.out.print("Kode Barang   : ");
                        int kode = inputInteger();
                        System.out.print("Jumlah Barang : ");
                        int jum = inputInteger();
                        model.insertBarang(nama, kode, jum);

                        break;
                    case 7:
                        System.out.println("List anggota");
                        System.out.println("------------");
                        for (Anggota a : model.getListAnggota()) {
                            System.out.println(a.getId() + "  " + a.getPassword());
                        }
                        break;
                    case 8:
                        System.out.println("List barang");
                        System.out.println("-----------");
                        for (Barang a : model.getListBarang()) {
                            System.out.println(a.getKodeBarang()+" "+a.getNamaBarang());
                        }

                        break;
                    case 9:
                        System.out.println("List petugas");
                        System.out.println("------------");
                        for (Petugas a : model.getListPetugas()) {
                            System.out.println(a.getId() + "  " + a.getPassword());
                        }
                        break;
                    default:

                }

            } catch (Exception e) {
            }
        }

//        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy, MMD dd");
//
//        Anggota a1 = new Anggota("Maman", "123", "passsword");
//        Anggota a2 = new Anggota("Memen", "124", "katasandi");
//        Anggota a3 = new Anggota("Mumun", "125", "mumun12");
//        Petugas p1 = new Petugas("Mimin", "234", "pass");
//
//        //barang yg akan dipinjam
//        Barang b1 = new Barang("Mic", 10001, 10);
//        Barang b2 = new Barang("Sound System", 10002, 8);
//        Barang b3 = new Barang("Gitar ", 10003, 10);
//
//        //Barang pinjam1 = new Barang(10001,5);
//        Date d1 = new Date();
    }
}
