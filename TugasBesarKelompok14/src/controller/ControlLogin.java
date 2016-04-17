/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author User
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.MenuPetugasGui;
import javax.swing.JOptionPane;
import model.Anggota;
import model.Aplication;
import model.Orang;
import model.Petugas;
import view.LoginGui;
import view.MenuAnggotaGui;

public class ControlLogin implements ActionListener {

    private LoginGui view;
    private Aplication app;

    public ControlLogin() {
        view = new LoginGui();
        app = new Aplication();
        view.setVisible(true);
        view.addlistener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnLogin())) {
            try {
                Orang org = (Orang) app.login(view.getUsername(), view.getPassword());
                if (org != null) {
                    if (org.getJabatan().equals("Anggota")) {
                        Anggota a = (Anggota) org;
                        MenuAnggotaGui.addAngota(a);
                        ControlMenuAnggota menuA = new ControlMenuAnggota();
                        view.dispose();
                    } else if (org.getJabatan().equals("Petugas")) {
                        Petugas p = (Petugas) org;
                        MenuPetugasGui.addPetugas(p);
                        ControlMenuPetugas menuP = new ControlMenuPetugas();
                        view.dispose();
                    } 
                    
                }else
                    JOptionPane.showMessageDialog(null, "Belum terdaftar");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else if (source.equals(view.getBtnBack())){
            ControlerMenuUtama home = new ControlerMenuUtama();
            view.dispose();
        }
            
    }
}
