/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;

import ngo2024.Partner;
import ngo2024.Land;
import ngo2024.Anvandare;
import oru.inf.InfDB;
import javax.swing.ImageIcon;
/**
 *
 * @author Gastinlogg
 */
public class OsparadeAndringarFonster extends javax.swing.JFrame {

    private InfDB idb;
    private Anvandare inloggadAnvandare;
    private String redigeringslage;
    
    private Partner aktuellPartner;
    private RedigeraPartnerInfoFonster redigeraPartnerFonstret;
    
    private RedigeraLandFonster redigeraLandFonstret;
    private LandFonster landFonstret;
    private Land aktuelltLand;
    private LaggTillLandFonster laggTillLandFonstret;
    
    private RedigeraMinaUppgifterFonster redigeraUppgifterFonstret;
    
    private RedigeraAvdelningFonster redigeraAvdelningFonstret;
    
    
    
    
    
    /**
     * Creates new form OsparadeAndringar
     */
    //Redigera Mina Uppgifter
    public OsparadeAndringarFonster(InfDB idb, Anvandare inloggadAnvandare, String redigeringslage, RedigeraMinaUppgifterFonster redigeraUppgifterFonstret) {
        this.redigeringslage = redigeringslage;
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        this.redigeraUppgifterFonstret = redigeraUppgifterFonstret;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    //Redigera Avdelning
    public OsparadeAndringarFonster(InfDB idb, Anvandare inloggadAnvandare, String redigeringslage, RedigeraAvdelningFonster redigeraAvdelningFonstret) {
        this.redigeringslage = redigeringslage;
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        this.redigeraAvdelningFonstret = redigeraAvdelningFonstret;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    //Redigera PartnerInfo
    public OsparadeAndringarFonster(InfDB idb, Anvandare inloggadAnvandare, Partner aktuellPartner, String redigeringslage, RedigeraPartnerInfoFonster redigeraPartnerFonstret){
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        this.redigeringslage = redigeringslage;
        this.aktuellPartner = aktuellPartner;
        this.redigeraPartnerFonstret = redigeraPartnerFonstret;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    //Redigera LandInfo
    public OsparadeAndringarFonster(InfDB idb, Anvandare inloggadAnvandare, Land aktuelltLand, LandFonster landFonstret, String redigeringslage, RedigeraLandFonster redigeraLandFonstret){
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        this.aktuelltLand = aktuelltLand;
        this.landFonstret = landFonstret;
        this.redigeringslage = redigeringslage;
        this.redigeraLandFonstret = redigeraLandFonstret;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    //Lägg till Land
    public OsparadeAndringarFonster(InfDB idb, Anvandare inloggadAnvandare, LandFonster landFonstret, String redigeringslage, LaggTillLandFonster laggTillLandFonstret){
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        this.landFonstret = landFonstret;
        this.redigeringslage = redigeringslage;
        this.laggTillLandFonstret = laggTillLandFonstret;
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
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/appLogo.png")).getImage());
        setResizable(false);

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
        if(redigeringslage.equals("Mina Uppgifter")){
            new MinaUppgifterFonster(idb,inloggadAnvandare).setVisible(true);
            redigeraUppgifterFonstret.setVisible(false);
        }
        else if(redigeringslage.equals("Avdelning")){
            new MenyFonster(idb,inloggadAnvandare).setVisible(true);
            redigeraAvdelningFonstret.setVisible(false);
        }
        else if(redigeringslage.equals("Partner")){
            new PartnerInfoFonster(inloggadAnvandare, aktuellPartner, idb).setVisible(true); 
            redigeraPartnerFonstret.setVisible(false);
        }
        else if(redigeringslage.equals("Redigera Land")){
            redigeraLandFonstret.setVisible(false);
        }
        else if(redigeringslage.equals("Lägg till Land")){
            laggTillLandFonstret.setVisible(false);
        }
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
