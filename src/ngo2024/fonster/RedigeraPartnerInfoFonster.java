/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;
import ngo2024.*;
import oru.inf.InfDB;

/**
 *
 * @author Gastinlogg
 */
public class RedigeraPartnerInfoFonster extends javax.swing.JFrame {
    
    private InfDB idb;
    private Partner aktuellPartner;
    private Anvandare inloggadAnvandare;
    private String orginalNamn;
    private String orginalBransch;
    private String orginalStad;
    private String orginalAdress;
    private String orginalKontaktPerson;
    private String orginalTelNr;
    private String orginalEpost;
    
    
    /**
     * Creates new form RedigeraPartnerInfoFonster
     */
    public RedigeraPartnerInfoFonster(InfDB idb, Partner aktuellPartner, Anvandare inloggadAnvandare) {
        idb = idb;
        this.aktuellPartner = aktuellPartner;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("SDG Sweden - Redigera " + aktuellPartner.getNamn());
        
        setFalt();
        setUppgifter();
        doljFelmeddelanden();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAdressT = new javax.swing.JLabel();
        lblBranchR = new javax.swing.JLabel();
        lblStadR = new javax.swing.JLabel();
        tillbakaBtn = new javax.swing.JButton();
        lblKontaktPersonR = new javax.swing.JLabel();
        lblEpostR = new javax.swing.JLabel();
        btnSpara = new javax.swing.JButton();
        lblTfNr = new javax.swing.JLabel();
        tfBranch = new javax.swing.JTextField();
        tfAdress = new javax.swing.JTextField();
        tfKontaktPersonNamn = new javax.swing.JTextField();
        tfKontaktPersonTel = new javax.swing.JTextField();
        tfEpost = new javax.swing.JTextField();
        lblBranschFelM = new javax.swing.JLabel();
        lblStadFelM = new javax.swing.JLabel();
        lblAdressFelM = new javax.swing.JLabel();
        lblKontaktPersonFelM = new javax.swing.JLabel();
        lblTelefonFelM = new javax.swing.JLabel();
        lblEpostFelM = new javax.swing.JLabel();
        lblFelMTomtFalt = new javax.swing.JLabel();
        cbStad = new javax.swing.JComboBox<>();
        tfNamnPartner = new javax.swing.JTextField();
        lblBranchR1 = new javax.swing.JLabel();

        lblAdressT.setText("Adress:");

        lblBranchR.setText("Bransch:");

        lblStadR.setText("Stad:");

        tillbakaBtn.setText("Tillbaka");
        tillbakaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tillbakaBtnActionPerformed(evt);
            }
        });

        lblKontaktPersonR.setText("Kontaktperson:");

        lblEpostR.setText("Epost:");

        btnSpara.setText("Spara");
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        lblTfNr.setText("Telefon:");

        tfBranch.setText("jTextField1");

        tfAdress.setText("jTextField3");

        tfKontaktPersonNamn.setText("jTextField4");

        tfKontaktPersonTel.setText("jTextField5");

        tfEpost.setText("jTextField6");

        lblBranschFelM.setForeground(new java.awt.Color(255, 0, 51));
        lblBranschFelM.setText("Kan endast innehålla bokstäver!");

        lblStadFelM.setForeground(new java.awt.Color(255, 0, 51));
        lblStadFelM.setText("Ange en stad!");

        lblAdressFelM.setForeground(new java.awt.Color(255, 0, 51));
        lblAdressFelM.setText("Adressen måste innehålla minst en bokstav & en siffra!");

        lblKontaktPersonFelM.setForeground(new java.awt.Color(255, 0, 51));
        lblKontaktPersonFelM.setText("Ange: FORNAMN EFTERNAMN!");

        lblTelefonFelM.setForeground(new java.awt.Color(255, 0, 51));
        lblTelefonFelM.setText("Telefonnummer kan endast innehålla siffror, bindestreck och det kan börja med +!");

        lblEpostFelM.setForeground(new java.awt.Color(255, 0, 51));
        lblEpostFelM.setText("Epost bör följa format: exempel@domän.com");

        lblFelMTomtFalt.setForeground(new java.awt.Color(255, 0, 51));
        lblFelMTomtFalt.setText("Inget av fälten får vara tomt!");

        cbStad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj stad...", "Örebro", "Stockholm", "Horndal", "Stad 4", "Stad 5", "Stad 6" }));

        tfNamnPartner.setText("Namn");
        tfNamnPartner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamnPartnerActionPerformed(evt);
            }
        });

        lblBranchR1.setText("Namn:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tillbakaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFelMTomtFalt)
                        .addGap(39, 39, 39)
                        .addComponent(btnSpara)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAdressT)
                            .addComponent(lblStadR)
                            .addComponent(lblBranchR)
                            .addComponent(lblKontaktPersonR)
                            .addComponent(lblTfNr)
                            .addComponent(lblEpostR)
                            .addComponent(lblBranchR1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNamnPartner)
                            .addComponent(tfBranch, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(tfAdress)
                            .addComponent(tfKontaktPersonNamn)
                            .addComponent(tfKontaktPersonTel)
                            .addComponent(tfEpost)
                            .addComponent(cbStad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBranschFelM)
                            .addComponent(lblStadFelM)
                            .addComponent(lblAdressFelM)
                            .addComponent(lblKontaktPersonFelM)
                            .addComponent(lblTelefonFelM)
                            .addComponent(lblEpostFelM))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNamnPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBranchR1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBranchR)
                    .addComponent(tfBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBranschFelM))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStadR)
                    .addComponent(lblStadFelM)
                    .addComponent(cbStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdressT)
                    .addComponent(tfAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdressFelM))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKontaktPersonR)
                    .addComponent(tfKontaktPersonNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKontaktPersonFelM))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTfNr)
                    .addComponent(tfKontaktPersonTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefonFelM))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEpostR)
                    .addComponent(tfEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEpostFelM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tillbakaBtn)
                    .addComponent(btnSpara)
                    .addComponent(lblFelMTomtFalt))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setUppgifter(){
        tfNamnPartner.setText("Redigera uppgifter - " + aktuellPartner.getNamn());
        tfNamnPartner.setText(orginalNamn);
        tfBranch.setText(orginalBransch);
        tfAdress.setText(orginalAdress);
        tfKontaktPersonNamn.setText(orginalKontaktPerson);
        tfKontaktPersonTel.setText(orginalTelNr);
        tfEpost.setText(orginalEpost);
        
        
    }
    
    private void doljFelmeddelanden(){
        lblFelMTomtFalt.setVisible(false);
        lblBranschFelM.setVisible(false);
        lblAdressFelM.setVisible(false);
        lblStadFelM.setVisible(false);
        lblKontaktPersonFelM.setVisible(false);
        lblTelefonFelM.setVisible(false);
        lblEpostFelM.setVisible(false);
    }
    
    private void setFalt(){
        this.orginalNamn = aktuellPartner.getNamn();
        this.orginalBransch = aktuellPartner.getBransch();
        this.orginalStad = aktuellPartner.getStad().getNamn();
        this.orginalAdress = aktuellPartner.getAdress();
        this.orginalKontaktPerson = aktuellPartner.getKontaktperson();
        this.orginalTelNr = aktuellPartner.getTelefonnummer();
        this.orginalEpost = aktuellPartner.getKontaktepost();
    }
    
    public boolean harOsparadeAndringar(){
        if(!tfNamnPartner.equals(orginalNamn)){
            return true;
        } 
        if(!orginalBransch.equals(tfBranch.getText())){
            return true;
        }
        if(!cbStad.getSelectedItem().equals(orginalStad)){
            return true;
        }
        if(!orginalAdress.equals(tfAdress.getText())){
            return true;
        }
        if(!orginalKontaktPerson.equals(tfKontaktPersonNamn.getText())){
            return true;
        }
        if(!orginalTelNr.equals(tfKontaktPersonTel.getText())){
            return true;
        }
        if(!orginalEpost.equals(tfEpost.getText())){
            return true;
        }
        return false;
    
    }
    private void tillbakaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillbakaBtnActionPerformed
        if(harOsparadeAndringar()){
            new OsparadeAndringarFonster(idb, inloggadAnvandare, aktuellPartner, "Partner", this).setVisible(true);
        }
        else{ 
            this.setVisible(false);
        }
    }//GEN-LAST:event_tillbakaBtnActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        doljFelmeddelanden();
        boolean formatKorrekt = true;
        boolean faltIfyllda = true;
        
        String namn = tfNamnPartner.getText();
        String bransch = tfBranch.getText();
        String adress = tfAdress.getText();
        String stad = cbStad.getSelectedItem().toString();
        String kontaktpersonNamn = tfKontaktPersonNamn.getText();
        String telNr = tfKontaktPersonTel.getText();
        String epost = tfEpost.getText();
        
        
        if(namn.isEmpty() || bransch.isEmpty() || adress.isEmpty() || kontaktpersonNamn.isEmpty() || telNr.isEmpty() || epost.isEmpty()){
            formatKorrekt = false;
            faltIfyllda = false;
            lblFelMTomtFalt.setVisible(true);
        }
    
        if(faltIfyllda){
            if(!Validerare.arBokstaver(bransch)){
                formatKorrekt = false;
                lblBranschFelM.setVisible(true);
            }  
            
            if(!Validerare.arAdress(adress)){
                formatKorrekt = false;
                lblAdressFelM.setVisible(true);
            }
            
            if(cbStad.getSelectedItem().equals("Välj stad...")){
                formatKorrekt = false;
                lblStadFelM.setVisible(true);
            }
        
            if(!Validerare.formatNamnOK(kontaktpersonNamn)){
                formatKorrekt = false;
                lblKontaktPersonFelM.setVisible(true);
            }
            
            if(!Validerare.arTelefonnummer(telNr)){
                formatKorrekt = false;
                lblTelefonFelM.setVisible(true);
            }
            
            if(!Validerare.arEpostAdress(epost)){
                formatKorrekt = false;
                lblEpostFelM.setVisible(true);
            }
        }
        
       if(formatKorrekt){
           
           String stadID = "0";
           if (stad.equals("Örebro")){
               stadID = "1";
           }
           else if (stad.equals("Stockholm")){
               stadID = "2";
           }
           else if (stad.equals("Horndal")){
               stadID = "3";
           }
           else if (stad.equals("Stad 4")){
               stadID = "4";
           }
           else if (stad.equals("Stad 5")){
               stadID = "5";
           }
           else if (stad.equals("Stad 6")){
               stadID = "6";
           }
           
           aktuellPartner.setBransch(bransch);
           aktuellPartner.setNamn(namn);
           aktuellPartner.setKontaktperson(kontaktpersonNamn);
           aktuellPartner.setKontaktepost(epost);
           aktuellPartner.setTelefonnummer(telNr);
           aktuellPartner.setAdress(adress);
           aktuellPartner.setStadID(stadID);
           
           aktuellPartner.uppdateraPartnerDB();
           
           new PartnerInfoFonster(inloggadAnvandare, aktuellPartner,idb).setVisible(true);
           this.setVisible(false);
           
       }
    }//GEN-LAST:event_btnSparaActionPerformed

    private void tfNamnPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamnPartnerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamnPartnerActionPerformed

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
            java.util.logging.Logger.getLogger(RedigeraPartnerInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedigeraPartnerInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedigeraPartnerInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedigeraPartnerInfoFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new RedigeraPartnerInfoFonster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpara;
    private javax.swing.JComboBox<String> cbStad;
    private javax.swing.JLabel lblAdressFelM;
    private javax.swing.JLabel lblAdressT;
    private javax.swing.JLabel lblBranchR;
    private javax.swing.JLabel lblBranchR1;
    private javax.swing.JLabel lblBranschFelM;
    private javax.swing.JLabel lblEpostFelM;
    private javax.swing.JLabel lblEpostR;
    private javax.swing.JLabel lblFelMTomtFalt;
    private javax.swing.JLabel lblKontaktPersonFelM;
    private javax.swing.JLabel lblKontaktPersonR;
    private javax.swing.JLabel lblStadFelM;
    private javax.swing.JLabel lblStadR;
    private javax.swing.JLabel lblTelefonFelM;
    private javax.swing.JLabel lblTfNr;
    private javax.swing.JTextField tfAdress;
    private javax.swing.JTextField tfBranch;
    private javax.swing.JTextField tfEpost;
    private javax.swing.JTextField tfKontaktPersonNamn;
    private javax.swing.JTextField tfKontaktPersonTel;
    private javax.swing.JTextField tfNamnPartner;
    private javax.swing.JButton tillbakaBtn;
    // End of variables declaration//GEN-END:variables
}
