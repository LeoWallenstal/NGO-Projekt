/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package ngo2024.fonster;

import ngo2024.Anvandare;
import ngo2024.Projekt;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author james
 */
public class ProjektInfoFonster extends javax.swing.JFrame {
    
    private Anvandare inloggadAnvandare;
    private InfDB idb;
    private Projekt aktuelltProjekt;
    private ProjektFonster forraFonstret;
    
    public ProjektInfoFonster(Anvandare inloggadAnvandare, Projekt ettProjekt, InfDB idb) {
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        aktuelltProjekt = ettProjekt;
        initComponents();
        setProjektInfo();
        
        if(inloggadAnvandare.isAdmin() || inloggadAnvandare.isProjektchef(aktuelltProjekt)){
            redigeraButton.setVisible(true);
            taBortButton.setVisible(true);
        }
        else{
            redigeraButton.setVisible(false);
            taBortButton.setVisible(false);
        }
        
        setLocationRelativeTo(null);
    }   
    
    public ProjektInfoFonster(Anvandare inloggadAnvandare, Projekt ettProjekt, ProjektFonster forraFonstret, InfDB idb) {
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        this.forraFonstret = forraFonstret;
        aktuelltProjekt = ettProjekt;
        initComponents();
        setProjektInfo();
        
        if(inloggadAnvandare.isAdmin() || inloggadAnvandare.isProjektchef(aktuelltProjekt)){
            redigeraButton.setVisible(true);
            taBortButton.setVisible(true);
        }
        else{
            redigeraButton.setVisible(false);
            taBortButton.setVisible(false);
        }
        
        setLocationRelativeTo(null);
    }   

    private void setProjektInfo(){
        this.setTitle("SDG Sweden - " + aktuelltProjekt.getProjektnamn());
        
        projektnamnLabel.setText("Projektnamn: " + aktuelltProjekt.getProjektnamn());
        beskrivningLabel.setText("Beskrivning: " + aktuelltProjekt.getBeskrivning());
        projektchefLabel.setText("Projektchef: " + aktuelltProjekt.getProjektchef().getFullNamn());
        prioritetLabel.setText("Prioritet: " + aktuelltProjekt.getPrioritet());
        statusLabel.setText("Status: " + aktuelltProjekt.getStatus());
        kostnadLabel.setText("Kostnad: " + aktuelltProjekt.getKostnad());
        startdatumLabel.setText("Startdatum: " + aktuelltProjekt.getStartdatum());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projektnamnLabel = new javax.swing.JLabel();
        beskrivningLabel = new javax.swing.JLabel();
        projektchefLabel = new javax.swing.JLabel();
        prioritetLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        kostnadLabel = new javax.swing.JLabel();
        startdatumLabel = new javax.swing.JLabel();
        redigeraButton = new javax.swing.JButton();
        tillbakaButton = new javax.swing.JButton();
        taBortButton = new javax.swing.JButton();

        projektnamnLabel.setText("Projektnamn: ");

        beskrivningLabel.setText("Beskrivning: ");

        projektchefLabel.setText("Projektchef:");

        prioritetLabel.setText("Prioritet:");

        statusLabel.setText("Status:");

        kostnadLabel.setText("Kostnad:");

        startdatumLabel.setText("Startdatum: ");

        redigeraButton.setText("Redigera");
        redigeraButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                redigeraButtonMouseClicked(evt);
            }
        });

        tillbakaButton.setText("Tillbaka");
        tillbakaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tillbakaButtonActionPerformed(evt);
            }
        });

        taBortButton.setText("Ta bort");
        taBortButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taBortButtonMouseClicked(evt);
            }
        });
        taBortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taBortButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(projektnamnLabel)
                            .addComponent(beskrivningLabel)
                            .addComponent(projektchefLabel)
                            .addComponent(prioritetLabel)
                            .addComponent(statusLabel)
                            .addComponent(kostnadLabel)
                            .addComponent(startdatumLabel))
                        .addContainerGap(321, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tillbakaButton)
                        .addGap(85, 85, 85)
                        .addComponent(redigeraButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(taBortButton)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(projektnamnLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(beskrivningLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projektchefLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prioritetLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kostnadLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startdatumLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(redigeraButton)
                    .addComponent(tillbakaButton)
                    .addComponent(taBortButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void redigeraButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redigeraButtonMouseClicked
        new RedigeraProjektInfoFonster(aktuelltProjekt, inloggadAnvandare, idb).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_redigeraButtonMouseClicked

    private void tillbakaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillbakaButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_tillbakaButtonActionPerformed

    private void taBortButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taBortButtonMouseClicked
        new VarningJaNejFonster(aktuelltProjekt, this).setVisible(true);
    }//GEN-LAST:event_taBortButtonMouseClicked

    private void taBortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taBortButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taBortButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ProjektInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjektInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjektInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjektInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ProjektInfoFonster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel beskrivningLabel;
    private javax.swing.JLabel kostnadLabel;
    private javax.swing.JLabel prioritetLabel;
    private javax.swing.JLabel projektchefLabel;
    private javax.swing.JLabel projektnamnLabel;
    private javax.swing.JButton redigeraButton;
    private javax.swing.JLabel startdatumLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton taBortButton;
    private javax.swing.JButton tillbakaButton;
    // End of variables declaration//GEN-END:variables
}
