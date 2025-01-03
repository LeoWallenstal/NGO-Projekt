/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ngo2024.AnvandarRegister;
import ngo2024.Anvandare;
import ngo2024.Land;
import ngo2024.LandRegister;
import ngo2024.Partner;
import ngo2024.PartnerRegister;
import ngo2024.Projekt;
import ngo2024.Validerare;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author james
 * 
 * Tankar:
 * - Ska man kunna sätta ett startdatum, eller ska det vara datumet då projektet skapas
 *   (registreras) i databasen?
 * 
 * 
 */
public class LaggTillProjektFonster extends javax.swing.JFrame {

    private Anvandare inloggadAnvandare;
    private InfDB idb;
    private AnvandarRegister anvandarregister;
    private LandRegister landregister;
    private PartnerRegister partnerregister;
    private ArrayList<Anvandare> handlaggare;
    private ProjektFonster forraFonstret;
    
    /**
     * Creates new form LaggTillFonster
     */
    public LaggTillProjektFonster(Anvandare inloggadAnvandare, ProjektFonster forraFonstret, InfDB idb) {
        this.forraFonstret = forraFonstret;
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        anvandarregister = new AnvandarRegister(idb);
        landregister = new LandRegister(idb);
        partnerregister = new PartnerRegister(idb);
        handlaggare = new ArrayList<>();
        
        
        
        initComponents();
        initFelmeddelanden();
        initProjektchefComboBox();   
        initLandComboBox();
        initPartnerList();
        projektRegistreradLabel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tillbakaButton = new javax.swing.JButton();
        projektnamnLabel = new javax.swing.JLabel();
        projektnamnInput = new javax.swing.JTextField();
        projektchefLabel = new javax.swing.JLabel();
        projektchefComboBox = new javax.swing.JComboBox<>();
        beskrivningLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        beskrivningInput = new javax.swing.JTextArea();
        kostnadLabel = new javax.swing.JLabel();
        kostnadInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        prioritetLabel = new javax.swing.JLabel();
        prioritetComboBox = new javax.swing.JComboBox<>();
        statusComboBox = new javax.swing.JComboBox<>();
        landLabel = new javax.swing.JLabel();
        landComboBox = new javax.swing.JComboBox<>();
        partnerLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        partnerList = new javax.swing.JList<>();
        projektnamnError = new javax.swing.JLabel();
        kostnadError = new javax.swing.JLabel();
        statusError = new javax.swing.JLabel();
        prioritetError = new javax.swing.JLabel();
        landError = new javax.swing.JLabel();
        sparaButton = new javax.swing.JButton();
        startdatumLabel = new javax.swing.JLabel();
        startdatumInput = new javax.swing.JTextField();
        startdatumError = new javax.swing.JLabel();
        projektRegistreradLabel = new javax.swing.JLabel();

        setTitle("SDG Sweden - Lägg till projekt");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        tillbakaButton.setText("Tillbaka");
        tillbakaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tillbakaButtonMouseClicked(evt);
            }
        });

        projektnamnLabel.setText("Projektnamn:");

        projektchefLabel.setText("Projektchef:");

        beskrivningLabel.setText("Beskrivning:");

        beskrivningInput.setColumns(5);
        beskrivningInput.setLineWrap(true);
        beskrivningInput.setRows(5);
        beskrivningInput.setMinimumSize(new java.awt.Dimension(252, 30));
        jScrollPane1.setViewportView(beskrivningInput);

        kostnadLabel.setText("Kostnad: ");

        jLabel1.setText("Status:");

        prioritetLabel.setText("Prioritet:");

        prioritetComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj prioritet...", "Låg", "Medel", "Hög" }));

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj status...", "Planerat", "Pågående", "Avslutat" }));

        landLabel.setText("Land:");

        partnerLabel.setText("Partner:");

        partnerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partnerListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(partnerList);

        projektnamnError.setForeground(new java.awt.Color(255, 0, 0));
        projektnamnError.setText("Kan inte vara tomt!");

        kostnadError.setForeground(new java.awt.Color(255, 0, 0));
        kostnadError.setText("Kan inte vara tomt!");

        statusError.setForeground(new java.awt.Color(255, 0, 0));
        statusError.setText("Kan inte vara tomt!");

        prioritetError.setForeground(new java.awt.Color(255, 0, 0));
        prioritetError.setText("Kan inte vara tomt!");

        landError.setForeground(new java.awt.Color(255, 0, 0));
        landError.setText("Kan inte vara tomt!");

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

        startdatumLabel.setText("Startdatum:");

        startdatumError.setForeground(new java.awt.Color(255, 0, 0));
        startdatumError.setText("Kan inte vara tomt!");

        projektRegistreradLabel.setForeground(new java.awt.Color(0, 204, 0));
        projektRegistreradLabel.setText("Projekt registrerat!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tillbakaButton)
                .addGap(8, 8, 8)
                .addComponent(sparaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(projektRegistreradLabel)
                .addGap(285, 285, 285))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(beskrivningLabel)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(projektnamnLabel)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(projektnamnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(projektnamnError, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(projektchefComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(projektchefLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startdatumLabel)
                            .addComponent(kostnadLabel))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kostnadInput, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startdatumInput, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(partnerLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(prioritetLabel)
                            .addComponent(landLabel))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(prioritetComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(landComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(statusComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kostnadError, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusError)
                                    .addComponent(prioritetError)
                                    .addComponent(landError)
                                    .addComponent(startdatumError)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projektnamnLabel)
                    .addComponent(projektnamnInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projektnamnError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projektchefLabel)
                    .addComponent(projektchefComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(beskrivningLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startdatumInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startdatumLabel)
                    .addComponent(startdatumError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kostnadInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kostnadError))
                    .addComponent(kostnadLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusError))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prioritetLabel)
                    .addComponent(prioritetComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prioritetError))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(landLabel)
                    .addComponent(landComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(landError))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partnerLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tillbakaButton)
                    .addComponent(sparaButton)
                    .addComponent(projektRegistreradLabel))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tillbakaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tillbakaButtonMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_tillbakaButtonMouseClicked

    private void sparaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sparaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sparaButtonActionPerformed

    private void partnerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partnerListMouseClicked
        if(partnerList.getSelectedIndices().length > 0){
            sparaButton.setEnabled(true);
        }
        else{
            sparaButton.setEnabled(false);
        }
    }//GEN-LAST:event_partnerListMouseClicked

    private void sparaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sparaButtonMouseClicked
        resetFelmeddelanden();
        
        Projekt nyttProjekt = new Projekt(idb);
        boolean projektOK = true;
        
        //Projektnamn
        if(!projektnamnInput.getText().isEmpty()){ 
            nyttProjekt.setProjektnamn(projektnamnInput.getText());
        }
        else{
            projektnamnError.setVisible(true);
            projektOK = false;
        }
        
        //Projektchef
        if(!projektchefComboBox.getSelectedItem().equals("Välj projektchef...")){
            Anvandare enHandlaggare = handlaggare.get(projektchefComboBox.getSelectedIndex() + 1);
            nyttProjekt.setProjektchef(enHandlaggare.getAnstallningsID());
        }
        
        //Beskrivning
        if(!beskrivningInput.getText().isEmpty()){
            nyttProjekt.setBeskrivning(beskrivningInput.getText());
        }
       
        //Startdatum
        if(!startdatumInput.getText().isEmpty() && Validerare.arDatum(startdatumInput.getText())){
            nyttProjekt.setStartdatum(startdatumInput.getText());
        }
        else{
            if(startdatumInput.getText().isEmpty()){
                startdatumError.setText("Kan inte vara tomt!");
                startdatumError.setVisible(true);
            }
            else if(!Validerare.arDatum(startdatumInput.getText())){
                startdatumError.setText("Felaktigt format! Använd yyyy-mm-dd.");
                startdatumError.setVisible(true);
            }
            projektOK = false;
        }
        
        //Kostnad
        if(!kostnadInput.getText().isEmpty() && Validerare.formatProjektKostnadOK(kostnadInput.getText()))
        {
            nyttProjekt.setKostnad(kostnadInput.getText());
        }
        else{
            if(kostnadInput.getText().isEmpty()){
                kostnadError.setText("Kan inte vara tomt!");
                kostnadError.setVisible(true);
            }
            else if(!Validerare.formatProjektKostnadOK(kostnadInput.getText())){
                kostnadError.setText("Får bara innehålla siffror och två decimaler.");
                kostnadError.setVisible(true);
            }
            projektOK = false;
        }
        
        //Status
        if(!statusComboBox.getSelectedItem().equals("Välj status...")){
            nyttProjekt.setStatus((String)statusComboBox.getSelectedItem());
        }
        else{
            statusError.setVisible(true);
            projektOK = false;
        }
        
        //Prioritet
        if(!prioritetComboBox.getSelectedItem().equals("Välj prioritet...")){
            nyttProjekt.setPrioritet((String)prioritetComboBox.getSelectedItem());
        }
        else{
            prioritetError.setVisible(true);
            projektOK = false;
        }
        
        //Land
        if(!landComboBox.getSelectedItem().equals("Välj land...")){
            landregister.hamtaAllaLand();
            Land ettLand = landregister.get(landComboBox.getSelectedIndex());
            nyttProjekt.setLandID(ettLand.getLandID());
            nyttProjekt.setLandNamn();
        }
        else{
            landError.setVisible(true);
            projektOK = false;
        }
        
        //Partners
        ArrayList <Partner> valdaPartners = sparaPartners();
        
        partnerregister.hamtaAllaPartners();
        for(Partner enPartner : valdaPartners){
            if(!partnerregister.harID(enPartner.getPartnerID())){
                projektOK = false;
            }
        }
        nyttProjekt.setPartners(valdaPartners);
        
        if(projektOK){
            nyttProjekt.setProjektchefsID();
            nyttProjekt.setProjektID();
            
            nyttProjekt.insertProjektDB();
            projektRegistreradLabel.setVisible(true);
            forraFonstret.uppdateraFonster();
            
        }
        
        System.out.println(nyttProjekt); //DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG    
    }//GEN-LAST:event_sparaButtonMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        partnerList.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    private void initProjektchefComboBox(){
        projektchefComboBox.addItem("Välj projektchef...");
        projektchefComboBox.addItem("Ingen");
        
        anvandarregister.hamtaAvdelningensAnvandare(inloggadAnvandare.getAvdelningsID());
        
        for(Anvandare enAnvandare : anvandarregister.getLista()){
            if(enAnvandare.isHandlaggare()){
                projektchefComboBox.addItem(enAnvandare.getFullNamn());
                handlaggare.add(enAnvandare);
            }
        }
        projektchefComboBox.setSelectedIndex(0);
    }
    
    private void initLandComboBox(){
        landComboBox.addItem("Välj land...");
        
        landregister.hamtaAllaLand();
        
        for(Land ettLand : landregister.getLista()){
            landComboBox.addItem(ettLand.getNamn());
        }
        landComboBox.setSelectedIndex(0);
    }
    
    private void initPartnerList(){
        partnerregister.hamtaAllaPartners();
        partnerList.setListData(partnerregister.getListData());
        
        partnerList.getSelectedIndices();
    }

    private void initFelmeddelanden(){
        projektnamnError.setVisible(false);
        startdatumError.setVisible(false);
        kostnadError.setVisible(false);
        statusError.setVisible(false);
        prioritetError.setVisible(false);
        landError.setVisible(false);
    }
    
    private void resetFelmeddelanden(){
        projektnamnError.setVisible(false);
        startdatumError.setVisible(false);
        kostnadError.setVisible(false);
        statusError.setVisible(false);
        prioritetError.setVisible(false);
        landError.setVisible(false);
    }
    
    private ArrayList<Partner> sparaPartners(){
        int[] partnerIndex = partnerList.getSelectedIndices();
        ArrayList<Partner> valdaPartners = new ArrayList<>();
        
        for(int i = 0; i < partnerIndex.length; i++){
            valdaPartners.add(partnerregister.get(partnerIndex[i]));
        }   
        return valdaPartners;
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
            java.util.logging.Logger.getLogger(LaggTillProjektFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaggTillProjektFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaggTillProjektFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaggTillProjektFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new LaggTillProjektFonster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea beskrivningInput;
    private javax.swing.JLabel beskrivningLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kostnadError;
    private javax.swing.JTextField kostnadInput;
    private javax.swing.JLabel kostnadLabel;
    private javax.swing.JComboBox<String> landComboBox;
    private javax.swing.JLabel landError;
    private javax.swing.JLabel landLabel;
    private javax.swing.JLabel partnerLabel;
    private javax.swing.JList<String> partnerList;
    private javax.swing.JComboBox<String> prioritetComboBox;
    private javax.swing.JLabel prioritetError;
    private javax.swing.JLabel prioritetLabel;
    private javax.swing.JLabel projektRegistreradLabel;
    private javax.swing.JComboBox<String> projektchefComboBox;
    private javax.swing.JLabel projektchefLabel;
    private javax.swing.JLabel projektnamnError;
    private javax.swing.JTextField projektnamnInput;
    private javax.swing.JLabel projektnamnLabel;
    private javax.swing.JButton sparaButton;
    private javax.swing.JLabel startdatumError;
    private javax.swing.JTextField startdatumInput;
    private javax.swing.JLabel startdatumLabel;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JLabel statusError;
    private javax.swing.JButton tillbakaButton;
    // End of variables declaration//GEN-END:variables
}
