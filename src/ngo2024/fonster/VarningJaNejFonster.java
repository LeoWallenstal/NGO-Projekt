/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;

import java.awt.Dimension;
import ngo2024.*;
import javax.swing.ImageIcon;
/**
 *
 * @author james
 */
public class VarningJaNejFonster extends javax.swing.JFrame {

    /**
     * Creates new form JaNejFonster
     */
    
    private ProjektRegister projektregister;
    private ProjektFonster forstaFonstretProjekt;
    private ProjektInfoFonster forraFonstretProjekt;
    private Projekt projektTaBort;
    
    private PartnerInfoFonster forraFonstretPartner;
    private Partner partnerTaBort;
    
    private HanteraAnstalldaFonster forraFonstretAnstallda;
    private Anvandare anvandareTaBort;
    
    private String taBortVad;
    
    //Ta bort Projekt
    public VarningJaNejFonster(Projekt attTaBort, ProjektFonster forstaFonstret, ProjektInfoFonster forraFonstretProjekt, 
        ProjektRegister projektregister) 
    {
        initComponents();
        this.projektregister = projektregister;
        this.forstaFonstretProjekt = forstaFonstret;
        this.forraFonstretProjekt = forraFonstretProjekt;
        this.projektTaBort = attTaBort;
        taBortVad = "Projekt";
        
        this.anvandareTaBort = null;
        this.forraFonstretAnstallda = null;
        
        this.setTitle("SDG Sweden - Ta bort " + attTaBort.getNamn());
        varningRubrik.setText("Du håller på att ta bort " + attTaBort.getNamn() + ".");
        varningUndertext.setText("Vill du fortsätta?");
        
        int bredd = varningRubrik.getWidth();
        
        this.setLocationRelativeTo(forraFonstretProjekt);
        this.setMinimumSize(new Dimension(bredd * 2, 170));
        
    }
    
    //Ta bort Anvandare
    public VarningJaNejFonster(Anvandare attTaBort, HanteraAnstalldaFonster forraFonstret){
        initComponents();
        this.anvandareTaBort = attTaBort;
        this.forraFonstretAnstallda = forraFonstret;
        taBortVad = "Anställd";
        
        this.forraFonstretProjekt = null;
        this.projektTaBort = null;
        
        this.setTitle("SDG Sweden - Ta bort " + attTaBort.getFullNamn());
        
        varningRubrik.setText("Du håller på att ta bort anställd " + attTaBort.getFullNamn() + ".");
        varningUndertext.setText("Vill du fortsätta?");
        
        int bredd = varningRubrik.getWidth();
        
        this.setLocationRelativeTo(forraFonstret);
        this.setMinimumSize(new Dimension(bredd * 2, 170));
    }
    
    //Ta bort Partner
    public VarningJaNejFonster(Partner attTaBort, PartnerInfoFonster forraFonstret){
        initComponents();
        this.forraFonstretProjekt = null;
        this.projektTaBort = null;
        
        this.forraFonstretPartner = forraFonstret;
        this.partnerTaBort = attTaBort;
        taBortVad = "Partner";
        
        this.anvandareTaBort = null;
        this.forraFonstretAnstallda = null;
        
        this.setTitle("SDG Sweden - Ta bort " + attTaBort.getNamn());
        
        varningRubrik.setText("Du håller på att ta bort partner " + attTaBort.getNamn() + ".");
        varningUndertext.setText("Vill du fortsätta?");
        
        int bredd = varningRubrik.getWidth();
        
        this.setLocationRelativeTo(forraFonstret);
        this.setMinimumSize(new Dimension(bredd * 2, 170));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jaButton = new javax.swing.JButton();
        nejButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        varningRubrik = new javax.swing.JLabel();
        varningUndertext = new javax.swing.JLabel();

        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/appLogo.png")).getImage());
        setMaximumSize(null);
        setMinimumSize(null);
        setResizable(false);

        jaButton.setText("Ja");
        jaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jaButtonMouseClicked(evt);
            }
        });

        nejButton.setText("Nej");
        nejButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nejButtonMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/icons8-warning-48.png"))); // NOI18N

        varningRubrik.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        varningRubrik.setText("jLabel2");

        varningUndertext.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addComponent(nejButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(varningUndertext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varningRubrik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(varningRubrik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varningUndertext)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jaButton)
                    .addComponent(nejButton))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jaButtonMouseClicked
        //Eftersom fönstret används vid flera olika ställen används 
        //stringen "taBortVad" för att identifiera vart man kommer ifrån
        if(taBortVad.equals("Projekt")){
            projektTaBort.deleteProjektDB();
            projektregister.remove(projektTaBort.getProjektID());
            forstaFonstretProjekt.visaData(projektregister.getAllaProjekt());
            forraFonstretProjekt.setVisible(false);
            this.setVisible(false);
        }
        if(taBortVad.equals("Anställd")){
            forraFonstretAnstallda.deleteAnstalld(anvandareTaBort);
            this.setVisible(false);
        }
        if(taBortVad.equals("Partner")){
            partnerTaBort.deletePartnerDB();
            forraFonstretPartner.setVisible(false);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jaButtonMouseClicked

    private void nejButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nejButtonMouseClicked
        if(taBortVad.equals("Anställd")){
            forraFonstretAnstallda.andraFranTaBortLage();
        }
        this.setVisible(false);
        
    }//GEN-LAST:event_nejButtonMouseClicked

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
            java.util.logging.Logger.getLogger(VarningJaNejFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VarningJaNejFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VarningJaNejFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VarningJaNejFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new VarningJaNejFonster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jaButton;
    private javax.swing.JButton nejButton;
    private javax.swing.JLabel varningRubrik;
    private javax.swing.JLabel varningUndertext;
    // End of variables declaration//GEN-END:variables
}
