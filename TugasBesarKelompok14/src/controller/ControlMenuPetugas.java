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
import view.MenuPetugasGui;

/**
 *
 * @author User
 */
public class ControlMenuPetugas implements ActionListener{

    private MenuPetugasGui view;
    private Aplication app;

    public ControlMenuPetugas() {
        view = new MenuPetugasGui();
        app = new Aplication();
        view.setVisible(true);
        view.addlistener(this);
        view.setTxUsername(MenuPetugasGui.getPetugas().getNama());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnBack())) {
            ControlerMenuUtama menu = new ControlerMenuUtama();
            view.dispose();
        }else if (source.equals(view.getBtnViewBrg())) {
            try {
                ControlViewBarangPetugas brg = new ControlViewBarangPetugas();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Can't view list Barang");
            }
            view.dispose();
        }else if (source.equals(view.getBtnAddBrg())) {
            ControlTambahBarang tmbh = new ControlTambahBarang();
            view.dispose();
        }
    }
}
