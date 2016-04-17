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
import view.MenuAnggotaGui;

/**
 *
 * @author User
 */
public class ControlMenuAnggota implements ActionListener{
    private MenuAnggotaGui view;
    private Aplication app;

    public ControlMenuAnggota() {
        view = new MenuAnggotaGui();
        app = new Aplication();
        view.setVisible(true);
        view.addlistener(this);
        view.setTxUsername(MenuAnggotaGui.getAnggota().getNama());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnLogout())) {
            ControlerMenuUtama menu = new ControlerMenuUtama();
            view.dispose();
        }else if (source.equals(view.getBtnViewBarang())) {
            try {
                ControlViewBarang viewB = new ControlViewBarang();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Can't view list Barang");
            }
            view.dispose();
        }else if (source.equals(view.getBtnViewList())) {
            
        }
    }
    
    
}
