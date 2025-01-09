/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;
import ngo2024.*;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.ImageIcon;
/**
 *
 * @author james
 */
public class LaggTillPartnerFonster extends javax.swing.JFrame {

    private Anvandare inloggadAnvandare;
    private InfDB idb;
    private StadRegister stadregister;
    private PartnerFonster forraFonstret;
    
    /**
     * Creates new form laggTillPartnerFonster
     */
    public LaggTillPartnerFonster(Anvandare inloggadAnvandare, PartnerFonster forraFonstret, InfDB idb) {
        stadregister = new StadRegister(idb);
        this.forraFonstret = forraFonstret;
        this.idb = idb;
        
        initComponents();
        initStadComboBox();
        initFelmeddelanden();
        partnerRegistreradLabel.setVisible(false);
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

        namnLabel = new javax.swing.JLabel();
        kontaktpersonLabel = new javax.swing.JLabel();
        kontaktepostLabel = new javax.swing.JLabel();
        telefonLabel = new javax.swing.JLabel();
        adressLabel = new javax.swing.JLabel();
        branchLabel = new javax.swing.JLabel();
        namnInput = new javax.swing.JTextField();
        kontaktpersonInput = new javax.swing.JTextField();
        kontaktepostInput = new javax.swing.JTextField();
        telefonnummerInput = new javax.swing.JTextField();
        adressInput = new javax.swing.JTextField();
        branschInput = new javax.swing.JTextField();
        tillbakaButton = new javax.swing.JButton();
        sparaButton = new javax.swing.JButton();
        namnError = new javax.swing.JLabel();
        kontaktpersonError = new javax.swing.JLabel();
        kontaktEpostError = new javax.swing.JLabel();
        telefonnummerError = new javax.swing.JLabel();
        adressError = new javax.swing.JLabel();
        branschError = new javax.swing.JLabel();
        stadLabel = new javax.swing.JLabel();
        stadComboBox = new javax.swing.JComboBox<>();
        stadError = new javax.swing.JLabel();
        partnerRegistreradLabel = new javax.swing.JLabel();

        setTitle("SDG - Lägg till partner");
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/appLogo.png")).getImage());
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        namnLabel.setText("Namn:");

        kontaktpersonLabel.setText("Kontaktperson:");

        kontaktepostLabel.setText("Kontaktepost:");

        telefonLabel.setText("Telefonnummer:");

        adressLabel.setText("Adress:");

        branchLabel.setText("Bransch:");

        namnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namnInputActionPerformed(evt);
            }
        });

        tillbakaButton.setText("Tillbaka");
        tillbakaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tillbakaButtonActionPerformed(evt);
            }
        });

        sparaButton.setText("Spara");
        sparaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sparaButtonMouseClicked(evt);
            }
        });
        sparaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sparaButtonActionPerformed(evt);
            }
        });

        namnError.setForeground(new java.awt.Color(255, 0, 0));
        namnError.setText("Kan inte vara tomt!");

        kontaktpersonError.setForeground(new java.awt.Color(255, 0, 0));
        kontaktpersonError.setText("Kan inte vara tomt!");

        kontaktEpostError.setForeground(new java.awt.Color(255, 0, 0));
        kontaktEpostError.setText("Kan inte vara tomt!");

        telefonnummerError.setForeground(new java.awt.Color(255, 0, 0));
        telefonnummerError.setText("Kan inte vara tomt!");

        adressError.setForeground(new java.awt.Color(255, 0, 0));
        adressError.setText("Kan inte vara tomt!");

        branschError.setForeground(new java.awt.Color(255, 0, 0));
        branschError.setText("Kan inte vara tomt!");

        stadLabel.setText("Stad:");

        stadError.setForeground(new java.awt.Color(255, 0, 0));
        stadError.setText("Kan inte vara tomt!");

        partnerRegistreradLabel.setForeground(new java.awt.Color(0, 204, 0));
        partnerRegistreradLabel.setText("Partner registrerad!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namnLabel)
                                    .addComponent(kontaktpersonLabel)
                                    .addComponent(kontaktepostLabel))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(namnInput)
                                    .addComponent(kontaktpersonInput)
                                    .addComponent(kontaktepostInput, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefonLabel)
                                    .addComponent(adressLabel)
                                    .addComponent(branchLabel)
                                    .addComponent(stadLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefonnummerInput, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(adressInput)
                                    .addComponent(branschInput)
                                    .addComponent(stadComboBox, 0, 163, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namnError)
                            .addComponent(kontaktpersonError)
                            .addComponent(kontaktEpostError)
                            .addComponent(telefonnummerError)
                            .addComponent(adressError)
                            .addComponent(branschError)
                            .addComponent(stadError)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tillbakaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sparaButton)
                        .addGap(18, 18, 18)
                        .addComponent(partnerRegistreradLabel)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namnLabel)
                    .addComponent(namnInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namnError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kontaktpersonLabel)
                    .addComponent(kontaktpersonInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kontaktpersonError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kontaktepostLabel)
                    .addComponent(kontaktepostInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kontaktEpostError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonLabel)
                    .addComponent(telefonnummerInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefonnummerError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adressLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adressInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(adressError)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(branchLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(branschInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(branschError)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stadLabel)
                    .addComponent(stadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stadError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tillbakaButton)
                    .addComponent(sparaButton)
                    .addComponent(partnerRegistreradLabel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(partnerRegistreradLabel.isVisible()){
            partnerRegistreradLabel.setVisible(false);
        }
    }//GEN-LAST:event_formMouseClicked

    private void sparaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sparaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sparaButtonActionPerformed

    private void tillbakaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillbakaButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_tillbakaButtonActionPerformed

    private void namnInputActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }

    private void sparaButtonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        resetFelmeddelanden();
        
        Partner nyPartner = new Partner(idb);
        boolean partnerOK = true;
        
        
        //Namn
        String namn = namnInput.getText();
        if(!namn.isEmpty() && Validerare.arBokstaver(namn)){
            nyPartner.setNamn(namn);
        }
        else{
            if(namn.isEmpty()){
                namnError.setText("Kan inte vara tomt!");
            }
            else if(!Validerare.formatNamnOK(namn)){
                namnError.setText("Namn får bara innehålla bokstäver!");
            }
            namnError.setVisible(true);
            partnerOK = false;
        }
        
        //Kontaktperson
        String kontaktperson = kontaktpersonInput.getText();
        if(!kontaktperson.isEmpty() && Validerare.arBokstaver(kontaktperson)){
            nyPartner.setKontaktperson(kontaktperson);
        }
        else{
            if(kontaktperson.isEmpty()){
                namnError.setText("Kan inte vara tomt!");
            }
            else if(!Validerare.formatNamnOK(kontaktperson)){
                namnError.setText("Kontaktpersonens namn får bara innehålla bokstäver!");
            }
            kontaktpersonError.setVisible(true);
            partnerOK = false;
        }
        
        //Kontaktepost
        String kontaktEpost = kontaktepostInput.getText();
        if(!kontaktEpost.isEmpty() && Validerare.arEpostAdress(kontaktEpost)){
            nyPartner.setKontaktepost(kontaktEpost);
        }
        else{
            if(kontaktEpost.isEmpty()){
                kontaktEpostError.setText("Kan inte vara tomt!");
            }
            else if(!Validerare.arEpostAdress(kontaktEpost)){
                kontaktEpostError.setText("Ogiltig epostadress");
            }
            kontaktEpostError.setVisible(true);
            partnerOK = false;
        }
        
        //Telefonnummer
        String telefonnummer = telefonnummerInput.getText();
        if(!telefonnummer.isEmpty() && Validerare.arTelefonnummer(telefonnummer)){
            nyPartner.setTelefonnummer(telefonnummer);
        }
        else{
            if(telefonnummer.isEmpty()){
                telefonnummerError.setText("Kan inte vara tomt!");
            }
            else if(!Validerare.arTelefonnummer(telefonnummer)){
                telefonnummerError.setText("Felaktigt format på numret, använd xxx-xxx-xxxx");
            }
            telefonnummerError.setVisible(true);
            partnerOK = false;
        }
        
        //Adress
        String adress = adressInput.getText();
        if(!adress.isEmpty() && Validerare.arAdress(adress)){
            nyPartner.setAdress(adress);
        }
        else{
            if(adress.isEmpty()){
                adressError.setText("Kan inte vara tomt!");
            }
            else if(!Validerare.arAdress(adress)){
                adressError.setText("Ogiltigt adressformat");
            }
            adressError.setVisible(true);
            partnerOK = false;
        }
        
        //Bransch
        String bransch = branschInput.getText();
        if(!bransch.isEmpty() && Validerare.arBokstaver(bransch)){
            nyPartner.setBransch(bransch);
        }
        else{
            if(bransch.isEmpty()){
                branschError.setText("Kan inte vara tomt!");
            }
            else if(!Validerare.arBokstaver(bransch)){
                branschError.setText("Får bara innehålla bokstäver!");
            }   
            branschError.setVisible(true);
            partnerOK = false;
        }
        
        //Stad
        if(!stadComboBox.getSelectedItem().equals("Välj stad...")){
            String stadID = stadregister.get(stadComboBox.getSelectedIndex()).getStadID();
            nyPartner.setStadID(stadID);
        }
        else{
            stadError.setText("Kan inte vara tomt!");
            stadError.setVisible(true);
            partnerOK = false;
        }
        
        //PartnerID
        if(partnerOK){
            nyPartner.setPartnerID();
            nyPartner.insertPartnerDB();
            partnerRegistreradLabel.setVisible(true);
            forraFonstret.uppdateraFonster();
        }        
    }

    private void initStadComboBox(){
        stadComboBox.addItem("Välj stad...");
        
        stadregister.hamtaAllaStader();
        
        for(Stad enStad : stadregister.getLista()){
            stadComboBox.addItem(enStad.getNamn());
        }
        stadComboBox.setSelectedIndex(0);
    }
    
    private void initFelmeddelanden(){
        namnError.setVisible(false);
        kontaktpersonError.setVisible(false);
        kontaktEpostError.setVisible(false);
        telefonnummerError.setVisible(false);
        adressError.setVisible(false);
        branschError.setVisible(false);
        stadError.setVisible(false);
    }
    
    private void resetFelmeddelanden(){
        namnError.setVisible(false);
        kontaktpersonError.setVisible(false);
        kontaktEpostError.setVisible(false);
        telefonnummerError.setVisible(false);
        adressError.setVisible(false);
        branschError.setVisible(false);
        stadError.setVisible(false);
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
            java.util.logging.Logger.getLogger(LaggTillPartnerFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaggTillPartnerFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaggTillPartnerFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaggTillPartnerFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new LaggTillPartnerFonster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adressError;
    private javax.swing.JTextField adressInput;
    private javax.swing.JLabel adressLabel;
    private javax.swing.JLabel branchLabel;
    private javax.swing.JLabel branschError;
    private javax.swing.JTextField branschInput;
    private javax.swing.JLabel kontaktEpostError;
    private javax.swing.JTextField kontaktepostInput;
    private javax.swing.JLabel kontaktepostLabel;
    private javax.swing.JLabel kontaktpersonError;
    private javax.swing.JTextField kontaktpersonInput;
    private javax.swing.JLabel kontaktpersonLabel;
    private javax.swing.JLabel namnError;
    private javax.swing.JTextField namnInput;
    private javax.swing.JLabel namnLabel;
    private javax.swing.JLabel partnerRegistreradLabel;
    private javax.swing.JButton sparaButton;
    private javax.swing.JComboBox<String> stadComboBox;
    private javax.swing.JLabel stadError;
    private javax.swing.JLabel stadLabel;
    private javax.swing.JLabel telefonLabel;
    private javax.swing.JLabel telefonnummerError;
    private javax.swing.JTextField telefonnummerInput;
    private javax.swing.JButton tillbakaButton;
    // End of variables declaration//GEN-END:variables
}
