/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
