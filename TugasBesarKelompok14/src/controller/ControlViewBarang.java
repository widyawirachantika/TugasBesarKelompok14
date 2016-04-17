/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.Aplication;
import view.ViewBarang;

/**
 *
 * @author User
 */
public class ControlViewBarang implements ActionListener {

    private ViewBarang view;
    private Aplication app;

    public ControlViewBarang() throws IOException {
        view = new ViewBarang();
        app = new Aplication();
        view.setVisible(true);
        view.addlistener(this);
        view.inputData(app.getListBarang());
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        if (source.equals(view.getBtnBack())) {
            view.dispose();
            ControlMenuAnggota menuA = new ControlMenuAnggota();
        }
    }

}
