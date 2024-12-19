/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024;

import java.awt.*;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Gastinlogg
 */
public class MinaUppgifter extends javax.swing.JFrame {

    private InfDB idb;
    private Anvandare inloggadAnvandare;
    /**
     * Creates new form MinaUppgifter
     */
    public MinaUppgifter(InfDB idb, Anvandare inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
        setWindowSize();
        setUppgifter();
        
    }
    
    private void setWindowSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int windowWidth = (int) (screenSize.width * 0.75);
        int windowHeight = (int) (screenSize.height * 0.75);
        int x = (screenSize.width - windowWidth) / 2;
        int y = (screenSize.height - windowHeight) / 2;
        setBounds(x, y, windowWidth, windowHeight);
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
        lblLosenordet.setText(losenord);
        lblLosenordet.enable(false);
        
        String telefonNr = inloggadAnvandare.getTelNr();
        lblTelefonnummer.setText(telefonNr);
        
        String anstallningsID = inloggadAnvandare.getAnstallningsId();
        lblAnsID.setText(anstallningsID);
        
        String anstallningsDatum = inloggadAnvandare.getAnstallningsDatum();
        lblAnstDatum.setText(anstallningsDatum);
        
        String avdelning = inloggadAnvandare.getAvdelningsId();
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
        lblLosenordet = new javax.swing.JPasswordField();
        lblTelefonnummer = new javax.swing.JLabel();
        lblAnsID = new javax.swing.JLabel();
        lblAnstDatum = new javax.swing.JLabel();
        lblAvdelningen = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        btnTillbaka.setText("Gå tillbaka");

        jLabel6.setText("Adress:");

        lblEfternamnet.setText("jLabel8");

        lblAdressen.setText("jLabel8");

        lblEposten.setText("jLabel8");

        lblLosenordet.setText("jPasswordField1");

        lblTelefonnummer.setText("jLabel8");

        lblAnsID.setText("jLabel8");

        lblAnstDatum.setText("jLabel8");

        lblAvdelningen.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnTillbaka)
                .addGap(28, 28, 28)
                .addComponent(btnAndraLosenord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnAndraUppgifter)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFornamnet, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(lblEfternamnet)
                    .addComponent(lblAdressen)
                    .addComponent(lblEposten)
                    .addComponent(lblLosenordet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefonnummer)
                    .addComponent(lblAnsID)
                    .addComponent(lblAnstDatum)
                    .addComponent(lblAvdelningen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFornamn)
                    .addComponent(jLabel7)
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
                    .addComponent(lblLosenordet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(lblAvdelningen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTillbaka)
                    .addComponent(btnAndraLosenord)
                    .addComponent(btnAndraUppgifter))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAndraUppgifterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraUppgifterActionPerformed
        new MinaUppgifterRedigera(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAndraUppgifterActionPerformed

    private void btnAndraLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraLosenordActionPerformed
        new AndraLosenord(idb, inloggadAnvandare).setVisible(true);
    }//GEN-LAST:event_btnAndraLosenordActionPerformed

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
            java.util.logging.Logger.getLogger(MinaUppgifter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinaUppgifter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinaUppgifter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinaUppgifter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JPasswordField lblLosenordet;
    private javax.swing.JLabel lblTelefonnummer;
    // End of variables declaration//GEN-END:variables
}
