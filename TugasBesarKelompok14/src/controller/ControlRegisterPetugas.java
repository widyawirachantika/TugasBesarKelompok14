/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Aplication;
import view.RegistrasiPetugas;

/**
 *
 * @author User
 */
public class ControlRegisterPetugas implements ActionListener {

    private RegistrasiPetugas view;
    private Aplication app;

    public ControlRegisterPetugas() {
        view = new RegistrasiPetugas();
        app = new Aplication();
        view.setVisible(true);
        view.addlistener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            app.loadPetugas();
            app.loadAnggota();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Can't Load Data From File");
        }
        
        if (source.equals(view.getBtnSignUp())) {
            if ((app.isAnggotaAvailable(view.getUsername()) == true) && (app.isPetugasAvailable(view.getUsername()) == true)) {
                app.insertPetugas(view.getNama(), view.getUsername(), view.getPassword());
                try {
                    app.savePetugas();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error! Can't save data");
                }
                JOptionPane.showMessageDialog(null, "Registration Done");
                ControlerMenuUtama menu = new ControlerMenuUtama();;
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username " + view.getUsername() + " not Available");
            }

        } else if (source.equals(view.getBtnBack())) {
            ControlerMenuUtama menu = new ControlerMenuUtama();
            view.dispose();
        }
    }

}
