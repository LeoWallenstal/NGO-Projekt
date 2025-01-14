/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package ngo2024.fonster;

import javax.swing.DefaultListModel;
import ngo2024.*;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.ImageIcon;
/**
 *
 * @author james
 */
public class ProjektInfoFonster extends javax.swing.JFrame {
    
    private final Anvandare inloggadAnvandare;
    private final InfDB idb;
    private final Projekt aktuelltProjekt;
    private final ProjektRegister projektregister;
    private final ProjektFonster forraFonstret; 
    
    public ProjektInfoFonster(Anvandare inloggadAnvandare, Projekt ettProjekt, 
            ProjektFonster forraFonstret, ProjektRegister projektregister, InfDB idb) {
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        this.forraFonstret = forraFonstret;
        this.projektregister = projektregister;
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

    private void initPartnerLista(){
        DefaultListModel<String> listModell = new DefaultListModel<>();
        if(aktuelltProjekt.getPartners().isEmpty()){
            partnerList.setEnabled(false);
            listModell.addElement("Inga partners kopplade till projektet.");
        }
        else{
            for(Partner enPartner : aktuelltProjekt.getPartners()){
                listModell.addElement(enPartner.getNamn());
            }
        }
        partnerList.setModel(listModell);
    }
    
    private void initHandlaggareLista(){
        DefaultListModel<String> listModell = new DefaultListModel<>();
        if(aktuelltProjekt.getHandlaggare().isEmpty()){
            handlaggareList.setEnabled(false);
            listModell.addElement("Inga handläggare kopplade till projektet.");
        }
        else{
            for(Anvandare enHandlaggare : aktuelltProjekt.getHandlaggare()){
                handlaggareList.setEnabled(true);
                listModell.addElement(enHandlaggare.getFullNamn());
            }
        }
        handlaggareList.setModel(listModell);
    }
    
    private void setProjektInfo(){
        initPartnerLista();
        initHandlaggareLista();
        this.setTitle("SDG Sweden - " + aktuelltProjekt.getNamn());
        
        projektnamnLabel.setText("Projektnamn: " + aktuelltProjekt.getNamn());
        beskrivningLabel.setText("Beskrivning: " + aktuelltProjekt.getBeskrivning());
        projektchefLabel.setText("Projektchef: " + aktuelltProjekt.getProjektchef().getFullNamn());
        prioritetLabel.setText("Prioritet: " + aktuelltProjekt.getPrioritet());
        statusLabel.setText("Status: " + aktuelltProjekt.getStatus());
        kostnadLabel.setText("Kostnad: " + aktuelltProjekt.getKostnad());
        startdatumLabel.setText("Startdatum: " + aktuelltProjekt.getStartdatum());
        if(aktuelltProjekt.getSlutdatum() == null){
            slutdatumLabel.setVisible(false);
        }
        else{
            slutdatumLabel.setVisible(true);
            slutdatumLabel.setText("Slutdatum: " + aktuelltProjekt.getSlutdatum());
        }
        landLbl.setText("Land: " + aktuelltProjekt.getLand().getNamn());
    }
    
    public void refreshProjektInfo(){
        initPartnerLista();
        initHandlaggareLista();
        this.setTitle("SDG Sweden - " + aktuelltProjekt.getNamn());
        
        projektnamnLabel.setText("Projektnamn: " + aktuelltProjekt.getNamn());
        beskrivningLabel.setText("Beskrivning: " + aktuelltProjekt.getBeskrivning());
        projektchefLabel.setText("Projektchef: " + aktuelltProjekt.getProjektchef().getFullNamn());
        prioritetLabel.setText("Prioritet: " + aktuelltProjekt.getPrioritet());
        statusLabel.setText("Status: " + aktuelltProjekt.getStatus());
        kostnadLabel.setText("Kostnad: " + aktuelltProjekt.getKostnad());
        startdatumLabel.setText("Startdatum: " + aktuelltProjekt.getStartdatum());
        if(aktuelltProjekt.getSlutdatum() == null){
            slutdatumLabel.setVisible(false);
        }
        else{
            slutdatumLabel.setVisible(true);
            slutdatumLabel.setText("Slutdatum: " + aktuelltProjekt.getSlutdatum());
        }
        landLbl.setText("Land : " + aktuelltProjekt.getLand().getNamn());
        
    }
    
    private void rensaLista(){
        //Tar bort datan
        partnerList.setModel(new DefaultListModel<>());
        //Tar bort datan från fönstret också.
        partnerList.repaint();
        
    };
    
    public ProjektRegister getProjektRegister(){
        return projektregister;
    }
    
    private void refreshaLista(){
        rensaLista();
        aktuelltProjekt.hamtaPartners();
        
        DefaultListModel<String> listModell = new DefaultListModel<>();
        if(aktuelltProjekt.getPartners().isEmpty()){
            partnerList.setEnabled(false);
            listModell.addElement("Inga partners kopplade till projektet.");
        }
        else{
            for(Partner enPartner : aktuelltProjekt.getPartners()){
                listModell.addElement(enPartner.getNamn());
            }
        }
        partnerList.setModel(listModell);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        partnerList = new javax.swing.JList<>();
        partnerLbl = new javax.swing.JLabel();
        slutdatumLabel = new javax.swing.JLabel();
        handlaggareLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        handlaggareList = new javax.swing.JList<>();
        landLbl = new javax.swing.JLabel();

        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/appLogo.png")).getImage());
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

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

        partnerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partnerListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(partnerList);

        partnerLbl.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        partnerLbl.setText("Partners kopplade till projektet");

        slutdatumLabel.setText("Slutdatum:");

        handlaggareLbl.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        handlaggareLbl.setText("Handlaggare kopplade till projektet");

        handlaggareList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handlaggareListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(handlaggareList);

        landLbl.setText("Land: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                                .addGap(0, 403, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tillbakaButton)
                                .addGap(85, 85, 85)
                                .addComponent(redigeraButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(taBortButton)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(slutdatumLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(partnerLbl)
                                    .addComponent(handlaggareLbl)))
                            .addComponent(landLbl))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slutdatumLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(landLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(partnerLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(handlaggareLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(redigeraButton)
                    .addComponent(tillbakaButton)
                    .addComponent(taBortButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void redigeraButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redigeraButtonMouseClicked
        new RedigeraProjektFonster(inloggadAnvandare, aktuelltProjekt, this, forraFonstret, idb).setVisible(true);
    }//GEN-LAST:event_redigeraButtonMouseClicked

    private void tillbakaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillbakaButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_tillbakaButtonActionPerformed

    private void taBortButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taBortButtonMouseClicked
        new VarningJaNejFonster(aktuelltProjekt, forraFonstret, this, projektregister).setVisible(true);
    }//GEN-LAST:event_taBortButtonMouseClicked

    private void taBortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taBortButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taBortButtonActionPerformed

    private void partnerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partnerListMouseClicked
        Partner aktuellPartner = aktuelltProjekt.getPartners().get(partnerList.getSelectedIndex());
        new PartnerInfoFonster(inloggadAnvandare, aktuellPartner, idb).setVisible(true);
    }//GEN-LAST:event_partnerListMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        refreshaLista();
    }//GEN-LAST:event_formWindowGainedFocus

    private void handlaggareListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_handlaggareListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_handlaggareListMouseClicked

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
    private javax.swing.JLabel handlaggareLbl;
    private javax.swing.JList<String> handlaggareList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kostnadLabel;
    private javax.swing.JLabel landLbl;
    private javax.swing.JLabel partnerLbl;
    private javax.swing.JList<String> partnerList;
    private javax.swing.JLabel prioritetLabel;
    private javax.swing.JLabel projektchefLabel;
    private javax.swing.JLabel projektnamnLabel;
    private javax.swing.JButton redigeraButton;
    private javax.swing.JLabel slutdatumLabel;
    private javax.swing.JLabel startdatumLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton taBortButton;
    private javax.swing.JButton tillbakaButton;
    // End of variables declaration//GEN-END:variables
}
