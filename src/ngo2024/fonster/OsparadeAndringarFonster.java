/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;

import ngo2024.Anvandare;
import oru.inf.InfDB;

/**
 *
 * @author Gastinlogg
 */
public class OsparadeAndringarFonster extends javax.swing.JFrame {

    private InfDB idb;
    private Anvandare inloggadAnvandare;
    
    /**
     * Creates new form OsparadeAndringar
     */
    public OsparadeAndringarFonster(InfDB idb, Anvandare inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
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

        lblOsparat = new javax.swing.JLabel();
        btnSparaAndringar = new javax.swing.JButton();
        btnFortsattTillMinaUppgifter = new javax.swing.JButton();
        lblFraga = new javax.swing.JLabel();

        setTitle("SDG Sweden - Osparade ändringar");

        lblOsparat.setText("Du har osparade ändringar!");

        btnSparaAndringar.setText("Redigera");
        btnSparaAndringar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaAndringarActionPerformed(evt);
            }
        });

        btnFortsattTillMinaUppgifter.setText("Fortsätt");
        btnFortsattTillMinaUppgifter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFortsattTillMinaUppgifterActionPerformed(evt);
            }
        });

        lblFraga.setText("Vill du fortsätta utan att spara?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(btnFortsattTillMinaUppgifter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(btnSparaAndringar)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFraga)
                    .addComponent(lblOsparat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lblOsparat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFraga)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSparaAndringar)
                    .addComponent(btnFortsattTillMinaUppgifter))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSparaAndringarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaAndringarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSparaAndringarActionPerformed

    private void btnFortsattTillMinaUppgifterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFortsattTillMinaUppgifterActionPerformed
        this.setVisible(false);
        new MinaUppgifterFonster(idb,inloggadAnvandare).setVisible(true);
    }//GEN-LAST:event_btnFortsattTillMinaUppgifterActionPerformed

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
            java.util.logging.Logger.getLogger(OsparadeAndringarFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OsparadeAndringarFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OsparadeAndringarFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OsparadeAndringarFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new OsparadeAndringar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFortsattTillMinaUppgifter;
    private javax.swing.JButton btnSparaAndringar;
    private javax.swing.JLabel lblFraga;
    private javax.swing.JLabel lblOsparat;
    // End of variables declaration//GEN-END:variables
}
