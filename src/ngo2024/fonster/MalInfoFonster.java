/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
/**
 *
 * @author leowa
 */
public class MalInfoFonster extends javax.swing.JFrame {
    
    private InfDB idb;
    private int malNr;
    /**
     * Creates new form MalInfo
     */
    public MalInfoFonster(InfDB idb, int malNr) {
        this.idb = idb;
        this.malNr = malNr;
        initComponents();
        setLocationRelativeTo(null);
        setMal();
    }
    
    private void setMal(){
        String[] sokVag = {
            "/resources/goals_icons/01-ingen-fattigdom.png",
            "/resources/goals_icons/02-ingen-hunger.png",
            "/resources/goals_icons/03-god-halsa-och-valbefinnande.png",
            "/resources/goals_icons/04-god-utbildning-for-alla-logo-1.png",
            "/resources/goals_icons/05-jamstalldhet.png",
            "/resources/goals_icons/06-rent-vatten-och-sanitet-for-alla.png",
            "/resources/goals_icons/07-hallbar-energi-for-alla.png",
            "/resources/goals_icons/08-anstandiga-arbetsvillkor-och-ekonomisk-tillvaxt.png",
            "/resources/goals_icons/09-hallbar-industri-innovationer-och-infrastruktur.png",
            "/resources/goals_icons/10-minskad-ojamnlikhet.png",
            "/resources/goals_icons/11-hallbara-stader-och-samhallen.png",
            "/resources/goals_icons/12-hallbar-konsumtion-och-produktion.png",
            "/resources/goals_icons/13-bekampa-klimatforandringarna.png",
            "/resources/goals_icons/14_hav_och_marina_resurser.png",
            "/resources/goals_icons/15_ekosystem.png",
            "/resources/goals_icons/Sustainable-Development-Goals_icons-16-1.png",
            "/resources/goals_icons/17_genomforande_och_partnerskap-logo.png"
        };
        
        String sqlFraga = "SELECT namn, beskrivning, prioritet FROM hallbarhetsmal " +
                "where hid = " + malNr;
        try{
            HashMap<String,String> dbMalInfo = idb.fetchRow(sqlFraga);
            
            String malNamn = dbMalInfo.get("namn");
            tpMalNamn.setText(malNamn);
            tpMalNamn.setOpaque(false);
            tpMalNamn.setFocusable(false);
            tpMalNamn.setForeground(Color.BLACK);
            
            String malBeskrivning = dbMalInfo.get("beskrivning");
            tpMalBeskrivning.setText(malBeskrivning);
            tpMalBeskrivning.setOpaque(false);
            tpMalBeskrivning.setFocusable(false);
            tpMalBeskrivning.setForeground(Color.BLACK);

            String prioritet = dbMalInfo.get("prioritet");
            switch(prioritet){
                case "Hög":
                    lblPrioritet.setText("Prioritet: Hög");
                    pbPrioritet.setValue(100);
                    pbPrioritet.setForeground(Color.RED);
                    break;
                case "Medel":
                    lblPrioritet.setText("Prioritet: Medel");
                    pbPrioritet.setValue(75);
                    pbPrioritet.setForeground(Color.YELLOW);
                    break;
                case "Låg":
                    lblPrioritet.setText("Prioritet: Låg");
                    pbPrioritet.setValue(25);
                    pbPrioritet.setForeground(Color.GREEN);
                    break;
            }
            this.setTitle("SDG Sweden - " + malNamn);
        }catch(InfException ex){
            System.out.println(ex.getMessage());
        }
        
        lblMalIkon.setIcon(new javax.swing.ImageIcon(getClass().getResource(sokVag[malNr-1])));
                
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMalIkon = new javax.swing.JLabel();
        btnStang = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tpMalBeskrivning = new javax.swing.JTextPane();
        tpMalNamn = new javax.swing.JTextPane();
        lblPrioritet = new javax.swing.JLabel();
        pbPrioritet = new javax.swing.JProgressBar();

        lblMalIkon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/01-ingen-fattigdom.png"))); // NOI18N

        btnStang.setText("Stäng");
        btnStang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStangActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Beskrivning:");

        tpMalBeskrivning.setEditable(false);
        tpMalBeskrivning.setBorder(null);
        tpMalBeskrivning.setText("Målets beskrivning");

        tpMalNamn.setEditable(false);
        tpMalNamn.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tpMalNamn.setText("Namn");

        lblPrioritet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrioritet.setText("Prioritet:");

        pbPrioritet.setForeground(new java.awt.Color(204, 204, 204));
        pbPrioritet.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pbPrioritet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrioritet)))
                    .addComponent(btnStang)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMalIkon)
                        .addGap(18, 18, 18)
                        .addComponent(tpMalNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(tpMalBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMalIkon)
                    .addComponent(tpMalNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpMalBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrioritet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pbPrioritet, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnStang)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStangActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnStangActionPerformed

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
            java.util.logging.Logger.getLogger(MalInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MalInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MalInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MalInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MalInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStang;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblMalIkon;
    private javax.swing.JLabel lblPrioritet;
    private javax.swing.JProgressBar pbPrioritet;
    private javax.swing.JTextPane tpMalBeskrivning;
    private javax.swing.JTextPane tpMalNamn;
    // End of variables declaration//GEN-END:variables
}
