/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Anggota;

/**
 *
 * @author ac
 */
public class ViewPeminjaman extends javax.swing.JFrame {

    /**
     * Creates new form ViewPeminjaman
     */
    public ViewPeminjaman() {
        initComponents();
        setHeader();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListView = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblListView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblListView);

        jLabel1.setText("View List Barang");

        btnBack.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(558, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public Object getBtnBack(){
        return btnBack;
    }
    
    public void setHeader() {
        String[] header = {"Nama Anggota","Nama Barang","Jumlah Barang","Tanggal Pinjam"};
        DefaultTableModel model = new DefaultTableModel(null, header);
        tblListView.setModel(model);
    }
    
    public void inputData(List<Anggota> listAnggota) {
        DefaultTableModel model = (DefaultTableModel) tblListView.getModel();
        if (listAnggota != null) {
            for (int i = 0; i < listAnggota.size(); i++) {
                if (listAnggota.get(i).getPeminjaman() != null){
                    model.addRow(new String[] {listAnggota.get(i).getNama(),
                        listAnggota.get(i).getPeminjaman().get(i).getBarang().get(i).getNamaBarang(), 
                    listAnggota.get(i).getPeminjaman().get(i).getBarang().get(i).getnBarang()+"",
                    listAnggota.get(i).getPeminjaman().get(i).getTanggalPinjam()+""});
                }else {
                    model.addRow(new String[] {listAnggota.get(i).getNama(),"","",""});
                }
            }
        }
    }
    
    public void addlistener(ActionListener e) {
        btnBack.addActionListener(e);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListView;
    // End of variables declaration//GEN-END:variables
}
