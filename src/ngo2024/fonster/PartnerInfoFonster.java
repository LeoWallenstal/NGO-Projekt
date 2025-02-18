/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;
import javax.swing.table.DefaultTableModel;
import ngo2024.*;
import oru.inf.InfDB;
import oru.inf.InfException;
/**
 *
 * @author james
 */
public class PartnerInfoFonster extends javax.swing.JFrame {

    /**
     * Creates new form PartnerInfoFonster
     */
    
    private Anvandare inloggadAnvandare;
    private InfDB idb;
    private Partner aktuellPartner;
    
    public PartnerInfoFonster(Anvandare inloggadAnvandare, Partner aktuellPartner, InfDB idb) {
        initComponents();
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        this.aktuellPartner = aktuellPartner;
        
        //Centrerar fönstret
        this.setLocationRelativeTo(null);
        
        setText();
        
        if(!inloggadAnvandare.isAdmin()){
            btnRedigera.setVisible(false);
            btnTaBort.setVisible(false);
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

        tillbakaBtn = new javax.swing.JButton();
        btnTaBort = new javax.swing.JButton();
        lblNamnPartner = new javax.swing.JLabel();
        lblKontaktPersonR = new javax.swing.JLabel();
        lblEpostR = new javax.swing.JLabel();
        lblTfNr = new javax.swing.JLabel();
        lblAdressT = new javax.swing.JLabel();
        lblBranchR = new javax.swing.JLabel();
        lblStadR = new javax.swing.JLabel();
        lblBranch = new javax.swing.JLabel();
        lblStad = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblKontaktPersonNamn = new javax.swing.JLabel();
        lblTfnNr = new javax.swing.JLabel();
        lblEpost = new javax.swing.JLabel();
        btnRedigera = new javax.swing.JButton();

        tillbakaBtn.setText("Tillbaka");
        tillbakaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tillbakaBtnActionPerformed(evt);
            }
        });

        btnTaBort.setText("Ta bort");
        btnTaBort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortActionPerformed(evt);
            }
        });

        lblNamnPartner.setText("NamnPartner");

        lblKontaktPersonR.setText("Kontaktperson:");

        lblEpostR.setText("Epost:");

        lblTfNr.setText("Telefon:");

        lblAdressT.setText("Adress:");

        lblBranchR.setText("Bransch:");

        lblStadR.setText("Stad:");

        lblBranch.setText("Bransch");

        lblStad.setText("Stad");

        lblAdress.setText("Adress");

        lblKontaktPersonNamn.setText("Namn");

        lblTfnNr.setText("T-NR");

        lblEpost.setText("Epost");

        btnRedigera.setText("Redigera");
        btnRedigera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedigeraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(lblNamnPartner)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAdressT)
                            .addComponent(lblStadR)
                            .addComponent(lblBranchR)
                            .addComponent(lblKontaktPersonR)
                            .addComponent(lblTfNr)
                            .addComponent(lblEpostR))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBranch)
                            .addComponent(lblStad)
                            .addComponent(lblAdress)
                            .addComponent(lblKontaktPersonNamn)
                            .addComponent(lblTfnNr)
                            .addComponent(lblEpost))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tillbakaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(btnRedigera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTaBort)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblNamnPartner)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBranchR)
                    .addComponent(lblBranch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStadR)
                    .addComponent(lblStad))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdressT)
                    .addComponent(lblAdress))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKontaktPersonR)
                    .addComponent(lblKontaktPersonNamn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTfNr)
                    .addComponent(lblTfnNr))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEpostR)
                    .addComponent(lblEpost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tillbakaBtn)
                    .addComponent(btnTaBort)
                    .addComponent(btnRedigera))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tillbakaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillbakaBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_tillbakaBtnActionPerformed

    private void btnTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortActionPerformed
        new VarningJaNejFonster(aktuellPartner, this).setVisible(true);
    }//GEN-LAST:event_btnTaBortActionPerformed

    private void btnRedigeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigeraActionPerformed
        new RedigeraPartnerInfoFonster(idb, aktuellPartner, inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRedigeraActionPerformed
    
    private void setText(){
        
        this.setTitle("SDG Sweden - " + aktuellPartner.getNamn());
        
        lblNamnPartner.setText(aktuellPartner.getNamn());
        lblBranch.setText(aktuellPartner.getBransch());
        lblStad.setText(aktuellPartner.getStad().getNamn());
        lblAdress.setText(aktuellPartner.getAdress());
        lblKontaktPersonNamn.setText(aktuellPartner.getKontaktperson());
        lblTfnNr.setText(aktuellPartner.getTelefonnummer());
        lblEpost.setText(aktuellPartner.getKontaktepost());
    }
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
            java.util.logging.Logger.getLogger(PartnerInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartnerInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartnerInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartnerInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               //new PartnerInfoFonster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRedigera;
    private javax.swing.JButton btnTaBort;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblAdressT;
    private javax.swing.JLabel lblBranch;
    private javax.swing.JLabel lblBranchR;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblEpostR;
    private javax.swing.JLabel lblKontaktPersonNamn;
    private javax.swing.JLabel lblKontaktPersonR;
    private javax.swing.JLabel lblNamnPartner;
    private javax.swing.JLabel lblStad;
    private javax.swing.JLabel lblStadR;
    private javax.swing.JLabel lblTfNr;
    private javax.swing.JLabel lblTfnNr;
    private javax.swing.JButton tillbakaBtn;
    // End of variables declaration//GEN-END:variables
}
