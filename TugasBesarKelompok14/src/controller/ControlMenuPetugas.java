/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
