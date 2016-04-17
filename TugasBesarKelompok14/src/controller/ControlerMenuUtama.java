/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MenuUtama;

/**
 *
 * @author User
 */
public class ControlerMenuUtama implements ActionListener {

    private MenuUtama view;

    public ControlerMenuUtama() {
        view = new MenuUtama();
        view.setVisible(true);
        view.addlistener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnLogin())) {
            ControlLogin login = new ControlLogin();
            view.dispose();
        } else if (source.equals(view.getBtnRegistA())) {
            ControlRegisterAnggota regA = new ControlRegisterAnggota();
            view.dispose();

        } else if (source.equals(view.getBtnRegistP())) {
            ControlRegisterPetugas regP = new ControlRegisterPetugas();
            view.dispose();
        } else if (source.equals(view.getBtnExit())) {
            System.exit(0);
        }
    }

}
