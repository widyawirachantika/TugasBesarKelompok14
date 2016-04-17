/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
