/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;

import java.awt.*;
import ngo2024.Anvandare;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.ImageIcon;
/**
 *
 * @author Gastinlogg
 */
public class MinaUppgifterFonster extends javax.swing.JFrame {

    private InfDB idb;
    private Anvandare inloggadAnvandare;
    /**
     * Creates new form MinaUppgifter
     */
    public MinaUppgifterFonster(InfDB idb, Anvandare inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
        setWindowSize();
        setUppgifter();
        pfLosenordet.setEchoChar('*');
    }
    
    private void setWindowSize(){
        setPreferredSize(new Dimension(850, 350));
        setMinimumSize(new Dimension(800, 328));
        setLocationRelativeTo(null);
    }
    
    private void setUppgifter(){
        String fornamn = inloggadAnvandare.getFornamn();
        lblFornamnet.setText(fornamn);
        
        String efternamn = inloggadAnvandare.getEfternamn();
        lblEfternamnet.setText(efternamn);
        
        String adress = inloggadAnvandare.getAdress();
        lblAdressen.setText(adress);
        
        String Epost = inloggadAnvandare.getEPost();
        lblEposten.setText(Epost);
        
        String losenord = inloggadAnvandare.getLosenord();
        pfLosenordet.setText(losenord);
        pfLosenordet.enable(false);
        
        String telefonNr = inloggadAnvandare.getTelNr();
        lblTelefonnummer.setText(telefonNr);
        
        String anstallningsID = inloggadAnvandare.getAnstallningsID();
        lblAnsID.setText(anstallningsID);
        
        String anstallningsDatum = inloggadAnvandare.getAnstallningsDatum();
        lblAnstDatum.setText(anstallningsDatum);
        
        String avdelning = inloggadAnvandare.getAvdelningsID();
        String sqlFraga = "SELECT namn FROM avdelning WHERE avdid =" + avdelning;
        try{
            String avdelningsNamn = idb.fetchSingle(sqlFraga);
            lblAvdelningen.setText(avdelningsNamn);
        }
        catch(InfException ex){
            System.out.println(ex.getMessage()); 
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

        jLabel5 = new javax.swing.JLabel();
        lblFornamn = new javax.swing.JLabel();
        lblEfternamn = new javax.swing.JLabel();
        lblEpost = new javax.swing.JLabel();
        lblLosenord = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAndraUppgifter = new javax.swing.JButton();
        btnAndraLosenord = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblFornamnet = new javax.swing.JLabel();
        lblEfternamnet = new javax.swing.JLabel();
        lblAdressen = new javax.swing.JLabel();
        lblEposten = new javax.swing.JLabel();
        pfLosenordet = new javax.swing.JPasswordField();
        lblTelefonnummer = new javax.swing.JLabel();
        lblAnsID = new javax.swing.JLabel();
        lblAnstDatum = new javax.swing.JLabel();
        lblAvdelningen = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tbtnVisaLosenordet = new javax.swing.JToggleButton();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDG Sweden - Mina uppgifter");
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/appLogo.png")).getImage());
        setResizable(false);

        lblFornamn.setText("Förnamn:");

        lblEfternamn.setText("Efternamn:");

        lblEpost.setText("Epost:");

        lblLosenord.setText("Lösenord:");

        jLabel1.setText("Telefonnummer:");

        jLabel2.setText("AnställningsID:");

        jLabel3.setText("Anställningsdatum:");

        jLabel4.setText("Avdelning:");

        btnAndraUppgifter.setText("Ändra uppgifter");
        btnAndraUppgifter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraUppgifterActionPerformed(evt);
            }
        });

        btnAndraLosenord.setText("Ändra lösenord");
        btnAndraLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraLosenordActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTillbakaMouseClicked(evt);
            }
        });
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        jLabel6.setText("Adress:");

        lblEfternamnet.setText("jLabel8");

        lblAdressen.setText("jLabel8");

        lblEposten.setText("jLabel8");

        pfLosenordet.setText("jPasswordField1");
        pfLosenordet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfLosenordetActionPerformed(evt);
            }
        });

        lblTelefonnummer.setText("jLabel8");

        lblAnsID.setText("jLabel8");

        lblAnstDatum.setText("jLabel8");

        lblAvdelningen.setText("jLabel8");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/vecteezy_user-icon-on-transparent-background_19879186.png"))); // NOI18N
        jLabel8.setText("jLabel3");

        tbtnVisaLosenordet.setText("Visa");
        tbtnVisaLosenordet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnVisaLosenordetActionPerformed(evt);
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
                        .addComponent(btnTillbaka)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAndraLosenord))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(lblLosenord)
                                    .addComponent(lblEpost)
                                    .addComponent(jLabel6)
                                    .addComponent(lblEfternamn)
                                    .addComponent(lblFornamn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFornamnet, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEfternamnet)
                                    .addComponent(lblAdressen)
                                    .addComponent(lblEposten)
                                    .addComponent(lblTelefonnummer)
                                    .addComponent(lblAnsID)
                                    .addComponent(lblAnstDatum)
                                    .addComponent(lblAvdelningen)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pfLosenordet, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tbtnVisaLosenordet)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAndraUppgifter)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFornamn)
                            .addComponent(lblFornamnet, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEfternamn)
                            .addComponent(lblEfternamnet))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblAdressen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEpost)
                            .addComponent(lblEposten))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLosenord)
                            .addComponent(pfLosenordet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbtnVisaLosenordet))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblTelefonnummer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblAnsID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblAnstDatum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblAvdelningen)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAndraLosenord)
                    .addComponent(btnAndraUppgifter)
                    .addComponent(btnTillbaka))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAndraUppgifterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraUppgifterActionPerformed
        new RedigeraMinaUppgifterFonster(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAndraUppgifterActionPerformed

    private void btnAndraLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraLosenordActionPerformed
        new AndraLosenordFonster(idb, inloggadAnvandare, this).setVisible(true);
    }//GEN-LAST:event_btnAndraLosenordActionPerformed

    private void btnTillbakaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTillbakaMouseClicked
    
    }//GEN-LAST:event_btnTillbakaMouseClicked

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new MenyFonster(idb, inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void pfLosenordetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfLosenordetActionPerformed
        
    }//GEN-LAST:event_pfLosenordetActionPerformed

    private void tbtnVisaLosenordetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnVisaLosenordetActionPerformed
        if (pfLosenordet.getEchoChar() == '*') {
            pfLosenordet.setEchoChar((char) 0);
            tbtnVisaLosenordet.setText("Dölj");
        }       
        else {
            pfLosenordet.setEchoChar('*'); 
            tbtnVisaLosenordet.setText("Visa");
        }
    }//GEN-LAST:event_tbtnVisaLosenordetActionPerformed

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
            java.util.logging.Logger.getLogger(MinaUppgifterFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinaUppgifterFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinaUppgifterFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinaUppgifterFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MinaUppgifter(InfDB idb).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndraLosenord;
    private javax.swing.JButton btnAndraUppgifter;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAdressen;
    private javax.swing.JLabel lblAnsID;
    private javax.swing.JLabel lblAnstDatum;
    private javax.swing.JLabel lblAvdelningen;
    private javax.swing.JLabel lblEfternamn;
    private javax.swing.JLabel lblEfternamnet;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblEposten;
    private javax.swing.JLabel lblFornamn;
    private javax.swing.JLabel lblFornamnet;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JLabel lblTelefonnummer;
    private javax.swing.JPasswordField pfLosenordet;
    private javax.swing.JToggleButton tbtnVisaLosenordet;
    // End of variables declaration//GEN-END:variables
}
