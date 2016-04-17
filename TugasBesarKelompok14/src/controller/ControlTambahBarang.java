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
import view.TambahBarang;

/**
 *
 * @author User
 */
public class ControlTambahBarang implements ActionListener {

    TambahBarang view;
    Aplication app;

    public ControlTambahBarang() {
        view = new TambahBarang();
        app = new Aplication();
        view.setVisible(true);
        view.addlistener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnBack())) {
            ControlMenuPetugas menuP = new ControlMenuPetugas();
            view.dispose();
        } else if (source.equals(view.getBtnTambah())) {
            try {
                app.loadBarang();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error! Can't load data.");
                ControlMenuPetugas menu = new ControlMenuPetugas();
                view.dispose();
            }
            app.insertBarang(view.getTxtNama(), view.getTxtKode(), view.getTxJumlah());
            try {
                app.saveBarang();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error! Can't save data.");
                ControlMenuPetugas menu = new ControlMenuPetugas();
                view.dispose();
            }
            JOptionPane.showMessageDialog(null, "Added Barang.");
            ControlMenuPetugas menu = new ControlMenuPetugas();
            view.dispose();
        }
    }

}
