/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;

import java.awt.*;
import ngo2024.Anvandare;
import ngo2024.Validerare;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.ImageIcon;
/**
 *
 * @author walle
 */
public class RedigeraMinaUppgifterFonster extends javax.swing.JFrame {

    private InfDB idb;
    private Anvandare inloggadAnvandare;
    private String orginalFornamn;
    private String orginalEfternamn;
    private String orginalAdress;
    private String orginalEpost;
    private String orginalTelefonnummer;
    
    /**
     * Creates new form MinaUppgifterRedigera
     */
    public RedigeraMinaUppgifterFonster(InfDB idb, Anvandare inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
        setWindowSize();
        setUppgifter();
        btnSparaNyaUppgifter.setEnabled(false);
        orginalFornamn = tfFornamn.getText();
        orginalEfternamn = tfEfternamn.getText();
        orginalAdress = tfAdress.getText();
        orginalEpost = tfEpost.getText();
        orginalTelefonnummer = tfTelefonnr.getText();
        lblFornamnFelM.setVisible(false);
        lblEfternamnFelM.setVisible(false);
        lblAdressFelM.setVisible(false);
        lblEpostFelM.setVisible(false);
        lblTelefonNrFelM.setVisible(false);
        pfLosenord.setEchoChar('*');
    }
    
    private void updateDB(){
        String nyttFornamn = tfFornamn.getText();
        String nyttEfternamn = tfEfternamn.getText();
        String nyAdress = tfAdress.getText();
        String nyEpost = tfEpost.getText();
        String nyttTelefonnummer = tfTelefonnr.getText();
        
        String sqlFraga = "UPDATE anstalld SET "
                + "fornamn = '"+nyttFornamn+"', "
                + "efternamn = '"+nyttEfternamn+"', "
                +"adress = '"+nyAdress+"', "
                +"epost = '"+nyEpost+"', "
                +"telefon = '"+nyttTelefonnummer+"' "
                +"WHERE aid = "+inloggadAnvandare.getAnstallningsID();
        try{
            idb.update(sqlFraga);
            inloggadAnvandare = new Anvandare(idb, inloggadAnvandare.getAnstallningsID());
        }catch(InfException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void setWindowSize(){
        setPreferredSize(new Dimension(850, 350));
        setMinimumSize(new Dimension(800, 328));
        setLocationRelativeTo(null);
    }
    
    private void setUppgifter(){
        String fornamn = inloggadAnvandare.getFornamn();
        tfFornamn.setText(fornamn);
        String efternamn = inloggadAnvandare.getEfternamn();
        tfEfternamn.setText(efternamn);
        String adress = inloggadAnvandare.getAdress();
        tfAdress.setText(adress);
        String ePost = inloggadAnvandare.getEPost();
        tfEpost.setText(ePost);
        String losenord = inloggadAnvandare.getLosenord();
        pfLosenord.setText(losenord);
        pfLosenord.enable(false);
        String telNr = inloggadAnvandare.getTelNr();
        tfTelefonnr.setText(telNr);
        String AID = inloggadAnvandare.getAnstallningsID();
        tfAID.setText(AID);
        tfAID.enable(false);
        String anstallningsDatum = inloggadAnvandare.getAnstallningsDatum();
        tfAnstallningsdatum.setText(anstallningsDatum);
        tfAnstallningsdatum.enable(false);
        String avdelningsId = inloggadAnvandare.getAvdelningsID();
        String sqlFraga = "SELECT namn FROM avdelning where avdid = " + avdelningsId;
        try{
        String avdelningsNamn = idb.fetchSingle(sqlFraga);
        tfAvdelning.setText(avdelningsNamn);
        tfAvdelning.enable(false);
        }catch(InfException ex){
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

        jLabel2 = new javax.swing.JLabel();
        pfLosenord = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        tfTelefonnr = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfAID = new javax.swing.JTextField();
        btnSparaNyaUppgifter = new javax.swing.JButton();
        tfAnstallningsdatum = new javax.swing.JTextField();
        tfAvdelning = new javax.swing.JTextField();
        btnTillbaka = new javax.swing.JButton();
        lblFornamn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblEfternamn = new javax.swing.JLabel();
        tfFornamn = new javax.swing.JTextField();
        lblEpost = new javax.swing.JLabel();
        tfEfternamn = new javax.swing.JTextField();
        lblLosenord = new javax.swing.JLabel();
        tfAdress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfEpost = new javax.swing.JTextField();
        lblFornamnFelM = new javax.swing.JLabel();
        lblEfternamnFelM = new javax.swing.JLabel();
        lblAdressFelM = new javax.swing.JLabel();
        lblEpostFelM = new javax.swing.JLabel();
        lblTelefonNrFelM = new javax.swing.JLabel();
        tbtnVisaLosenord = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDG Sweden - Ändra uppgifter");
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/appLogo.png")).getImage());
        setResizable(false);

        jLabel2.setText("AnställningsID:");

        pfLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfLosenordActionPerformed(evt);
            }
        });

        jLabel3.setText("Anställningsdatum:");

        tfTelefonnr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelefonnrKeyTyped(evt);
            }
        });

        jLabel4.setText("Avdelning:");

        btnSparaNyaUppgifter.setText("Spara uppgifter");
        btnSparaNyaUppgifter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaNyaUppgifterActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Gå tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        lblFornamn.setText("Förnamn:");

        jLabel6.setText("Adress:");

        lblEfternamn.setText("Efternamn:");

        tfFornamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFornamnActionPerformed(evt);
            }
        });
        tfFornamn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFornamnKeyTyped(evt);
            }
        });

        lblEpost.setText("Epost:");

        tfEfternamn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEfternamnKeyTyped(evt);
            }
        });

        lblLosenord.setText("Lösenord:");

        tfAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAdressActionPerformed(evt);
            }
        });
        tfAdress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAdressKeyTyped(evt);
            }
        });

        jLabel1.setText("Telefonnummer:");

        tfEpost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEpostKeyTyped(evt);
            }
        });

        lblFornamnFelM.setForeground(new java.awt.Color(255, 0, 51));
        lblFornamnFelM.setText("Kan endast innehålla bokstäver!");

        lblEfternamnFelM.setForeground(new java.awt.Color(255, 0, 51));
        lblEfternamnFelM.setText("Kan endast innehålla bokstäver!");

        lblAdressFelM.setForeground(new java.awt.Color(255, 0, 51));
        lblAdressFelM.setText("Adressen måste anges i formatet \"Nummer Gatuadress, Platsnamn\"!");

        lblEpostFelM.setForeground(new java.awt.Color(255, 0, 51));
        lblEpostFelM.setText("Epost bör följa format: exempel@domän.com");

        lblTelefonNrFelM.setForeground(new java.awt.Color(255, 0, 51));
        lblTelefonNrFelM.setText("Telefonnumret måste anges i formatet xxx-xxx-xxxx, där x är en siffra.");

        tbtnVisaLosenord.setText("Visa");
        tbtnVisaLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnVisaLosenordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTillbaka)
                        .addGap(18, 18, 18)
                        .addComponent(btnSparaNyaUppgifter))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pfLosenord)
                            .addComponent(tfTelefonnr)
                            .addComponent(tfAID)
                            .addComponent(tfAnstallningsdatum)
                            .addComponent(tfAvdelning)
                            .addComponent(tfEpost)
                            .addComponent(tfAdress)
                            .addComponent(tfEfternamn)
                            .addComponent(tfFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFornamnFelM)
                            .addComponent(lblEfternamnFelM)
                            .addComponent(lblAdressFelM)
                            .addComponent(lblEpostFelM)
                            .addComponent(lblTelefonNrFelM)
                            .addComponent(tbtnVisaLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFornamn)
                    .addComponent(tfFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFornamnFelM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEfternamn)
                    .addComponent(tfEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEfternamnFelM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdressFelM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEpost)
                    .addComponent(tfEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEpostFelM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLosenord)
                    .addComponent(pfLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtnVisaLosenord))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTelefonnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefonNrFelM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfAID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfAnstallningsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfAvdelning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTillbaka)
                    .addComponent(btnSparaNyaUppgifter))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pfLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfLosenordActionPerformed
        
    }//GEN-LAST:event_pfLosenordActionPerformed

    private void btnSparaNyaUppgifterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaNyaUppgifterActionPerformed

        boolean formatKorrekt = true;
        lblFornamnFelM.setVisible(false);
        lblEfternamnFelM.setVisible(false);
        lblAdressFelM.setVisible(false);   
        lblEpostFelM.setVisible(false);  
        
        if(!Validerare.formatEnkeltNamnOK(tfFornamn.getText())){
            formatKorrekt = false;
            lblFornamnFelM.setVisible(true);
        }
        if(!Validerare.formatEnkeltNamnOK(tfEfternamn.getText())){
            formatKorrekt = false;
            lblEfternamnFelM.setVisible(true);
        }
        if(!Validerare.arAdress(tfAdress.getText())){
            formatKorrekt = false;
            lblAdressFelM.setVisible(true);   
        }
        if(!Validerare.arEpostAdress(tfEpost.getText())){
            formatKorrekt = false;
            lblEpostFelM.setVisible(true);  
        }
        if(!Validerare.arTelefonnummer(tfTelefonnr.getText())){
            formatKorrekt = false;
            lblTelefonNrFelM.setVisible(true);  
        }
    
    if(formatKorrekt){
        //ÄNDRA SAMTLIGA I DB
        updateDB();
        this.setVisible(false);
        new MinaUppgifterFonster(idb, inloggadAnvandare).setVisible(true);
    }    
    }//GEN-LAST:event_btnSparaNyaUppgifterActionPerformed

    private void tfFornamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFornamnActionPerformed
   
    }//GEN-LAST:event_tfFornamnActionPerformed

    private void tfAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAdressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAdressActionPerformed

    private boolean harOsparadeAndringar(){
        if(!orginalFornamn.equals(tfFornamn.getText())){
            return true;
        }
        if(!orginalEfternamn.equals(tfEfternamn.getText())){
            return true;
        }
        if(!orginalAdress.equals(tfAdress.getText())){
            return true;
        }
        if(!orginalEpost.equals(tfEpost.getText())){
            return true;
        }
        if(!orginalTelefonnummer.equals(tfTelefonnr.getText())){
            return true;
        }
        return false;
    }
    
    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed

        if(harOsparadeAndringar()){
            new OsparadeAndringarFonster(idb, inloggadAnvandare, "Mina Uppgifter", this).setVisible(true);
        }
        else {
            this.setVisible(false);
            new MinaUppgifterFonster(idb,inloggadAnvandare).setVisible(true);
        }
        
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void tfFornamnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFornamnKeyTyped
        btnSparaNyaUppgifter.setEnabled(true);
    }//GEN-LAST:event_tfFornamnKeyTyped

    private void tfEfternamnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEfternamnKeyTyped
        btnSparaNyaUppgifter.setEnabled(true);
    }//GEN-LAST:event_tfEfternamnKeyTyped

    private void tfAdressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAdressKeyTyped
        btnSparaNyaUppgifter.setEnabled(true);
    }//GEN-LAST:event_tfAdressKeyTyped

    private void tfEpostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEpostKeyTyped
        btnSparaNyaUppgifter.setEnabled(true);
    }//GEN-LAST:event_tfEpostKeyTyped

    private void tfTelefonnrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonnrKeyTyped
        btnSparaNyaUppgifter.setEnabled(true);
    }//GEN-LAST:event_tfTelefonnrKeyTyped

    private void tbtnVisaLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnVisaLosenordActionPerformed
        if (pfLosenord.getEchoChar() == '*') {
            pfLosenord.setEchoChar((char) 0);
            tbtnVisaLosenord.setText("Dölj");
        }       
        else {
            pfLosenord.setEchoChar('*'); 
            tbtnVisaLosenord.setText("Visa");
        }
    }//GEN-LAST:event_tbtnVisaLosenordActionPerformed

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
            java.util.logging.Logger.getLogger(RedigeraMinaUppgifterFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedigeraMinaUppgifterFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedigeraMinaUppgifterFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedigeraMinaUppgifterFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MinaUppgifterRedigera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSparaNyaUppgifter;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblAdressFelM;
    private javax.swing.JLabel lblEfternamn;
    private javax.swing.JLabel lblEfternamnFelM;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblEpostFelM;
    private javax.swing.JLabel lblFornamn;
    private javax.swing.JLabel lblFornamnFelM;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JLabel lblTelefonNrFelM;
    private javax.swing.JPasswordField pfLosenord;
    private javax.swing.JToggleButton tbtnVisaLosenord;
    private javax.swing.JTextField tfAID;
    private javax.swing.JTextField tfAdress;
    private javax.swing.JTextField tfAnstallningsdatum;
    private javax.swing.JTextField tfAvdelning;
    private javax.swing.JTextField tfEfternamn;
    private javax.swing.JTextField tfEpost;
    private javax.swing.JTextField tfFornamn;
    private javax.swing.JTextField tfTelefonnr;
    // End of variables declaration//GEN-END:variables
}
