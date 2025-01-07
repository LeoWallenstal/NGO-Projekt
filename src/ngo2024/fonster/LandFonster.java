/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;

import ngo2024.*;
import oru.inf.InfDB;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.*;

/**
 *
 * @author annae
 */
public class LandFonster extends javax.swing.JFrame {

    /**
     * Creates new form LandFonster
     */
    private Anvandare inloggadAnvandare;
    private InfDB idb;
    private DefaultTableModel tabell;
    private LandRegister landRegister;
    private int hoveredRow = -1;
    private int hoveredColumn;
    
    public LandFonster(Anvandare inloggadAnvandare, InfDB idb){
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        landRegister = new LandRegister(idb);
        
        initComponents();
        tabell = (DefaultTableModel) landTable.getModel();
        initKolumner();
        visaData();
        checkBehorighet();
        setLocationRelativeTo(null);
        this.setTitle("SDG Sweden - Länder");
    }

    private void initKolumner(){
        tabell.addColumn("Namn");
        tabell.addColumn("Språk");
        tabell.addColumn("Valuta");
        tabell.addColumn("Tidszon");
        tabell.addColumn("Politisk struktur");
        tabell.addColumn("Ekonomi");
        
        landTable.setDefaultEditor(Object.class, null);
    }
    
    private void visaData(){
        rensaDataFonster();
        for(Land ettLand : landRegister.getLista()){
           tabell.addRow(new Object []{ettLand.getNamn(), 
           ettLand.getSprak(), ettLand.getValuta(), ettLand.getTidszon(),
           ettLand.getPolitiskStruktur(), ettLand.getEkonomi()});
        }
    }
    
    private void rensaDataFonster(){
        tabell.getDataVector().clear();
        landTable.repaint();
    }
    
    public void uppdateraFonster(){
        landRegister.hamtaAllaLand();
        visaData();
    }
    
    private void checkBehorighet()
    {
        if(!inloggadAnvandare.isAdmin())
        {
            btnLaggTillLand.setVisible(false);
            lblInstruktion.setVisible(false);
        }
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
        landTable = new javax.swing.JTable();
        btnTillbaka = new javax.swing.JButton();
        btnLaggTillLand = new javax.swing.JButton();
        lblInstruktion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/appLogo.png")).getImage());
        setResizable(false);

        landTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        landTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                landTableMouseMoved(evt);
            }
        });
        landTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                landTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(landTable);

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        btnLaggTillLand.setText("Lägg till land");
        btnLaggTillLand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillLandActionPerformed(evt);
            }
        });

        lblInstruktion.setText("Klicka på en rad för att ändra uppgifter!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTillbaka)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLaggTillLand, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInstruktion)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblInstruktion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTillbaka)
                    .addComponent(btnLaggTillLand))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new MenyFonster(idb, inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnLaggTillLandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillLandActionPerformed
        new LaggTillLandFonster(inloggadAnvandare, this, idb).setVisible(true);
    }//GEN-LAST:event_btnLaggTillLandActionPerformed

    private void landTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_landTableMouseClicked
        int landIndex = landTable.rowAtPoint(evt.getPoint());
        
        if(inloggadAnvandare.isAdmin() && landIndex>= 0 && landIndex < landTable.getRowCount()){
            Land aktuelltLand = landRegister.get(landIndex);
            new RedigeraLandFonster(inloggadAnvandare, aktuelltLand, idb, this).setVisible(true);
        }
    }//GEN-LAST:event_landTableMouseClicked

    private void landTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_landTableMouseMoved
        int row = landTable.rowAtPoint(evt.getPoint());
        int column = landTable.columnAtPoint(evt.getPoint());
        
        if(inloggadAnvandare.isAdmin() && row >= 0 && column >= 0)
        {
            {
                landTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
                hoveredRow = row;
                hoveredColumn = column;
            }
        }
        else
        {
            landTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            hoveredRow = -1;
            hoveredColumn = -1;
        }
        landTable.repaint();
    }//GEN-LAST:event_landTableMouseMoved

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LandFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LandFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LandFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LandFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new LandFonster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTillLand;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable landTable;
    private javax.swing.JLabel lblInstruktion;
    // End of variables declaration//GEN-END:variables
}
