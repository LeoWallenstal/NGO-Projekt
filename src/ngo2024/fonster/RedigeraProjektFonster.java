/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import ngo2024.*;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.ImageIcon;
/**
 *
 * @author james
 */
public class RedigeraProjektFonster extends javax.swing.JFrame {

    /**
     * Creates new form RedigeraProjektFonster
     */
    
    private ArrayList<Anvandare> handlaggare;
    private AnvandarRegister anvandarregister;
    private PartnerRegister partnerregister;
    private final Anvandare inloggadAnvandare;
    private final ProjektInfoFonster forraFonstret;
    private final InfDB idb;
    private final Projekt attRedigera;
    
    public RedigeraProjektFonster(Anvandare inloggadAnvandare, Projekt attRedigera,
            ProjektInfoFonster forraFonstret, InfDB idb)    
    {
        initComponents();
        this.setSize(forraFonstret.getSize());
        this.setLocationRelativeTo(forraFonstret);
        this.forraFonstret = forraFonstret;
        
        this.idb = idb;
        anvandarregister = new AnvandarRegister(idb);
        partnerregister = new PartnerRegister(idb);
        handlaggare = new ArrayList<>();
        this.inloggadAnvandare = inloggadAnvandare;
        this.attRedigera = attRedigera;
        initProjektchefCB();
        initTillgangligaPartners();
        visaTillgangligaPartners();
        
        initFalt();
        
        for(Partner enPartner : partnerregister.getLista()){
            System.out.println(enPartner.getPartnerID());
        }
        
        System.out.println("\n\n");
        
        for(Partner enPartner : attRedigera.getPartners()){
            System.out.println(enPartner.getPartnerID());
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

        tillbakaButton = new javax.swing.JButton();
        projektnamnLabel = new javax.swing.JLabel();
        beskrivningLabel = new javax.swing.JLabel();
        projektchefLabel = new javax.swing.JLabel();
        prioritetLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        kostnadLabel = new javax.swing.JLabel();
        startdatumLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projektetsPartnersList = new javax.swing.JList<>();
        partnerLbl = new javax.swing.JLabel();
        projektnamnInput = new javax.swing.JTextField();
        beskrivningInput = new javax.swing.JTextField();
        statusCB = new javax.swing.JComboBox<>();
        prioritetCB = new javax.swing.JComboBox<>();
        kostnadInput = new javax.swing.JTextField();
        startdatumInput = new javax.swing.JTextField();
        projektchefCB = new javax.swing.JComboBox<>();
        sparaBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tillgangligaPartnersList = new javax.swing.JList<>();
        laggTillBtn = new javax.swing.JButton();
        taBortBtn = new javax.swing.JButton();

        setTitle("SDG Sweden - Redigera projekt");
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/appLogo.png")).getImage());
        setMinimumSize(new java.awt.Dimension(540, 357));
        setPreferredSize(new java.awt.Dimension(540, 357));
        setResizable(false);
        setSize(new java.awt.Dimension(540, 357));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        tillbakaButton.setText("Tillbaka");
        tillbakaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tillbakaButtonActionPerformed(evt);
            }
        });

        projektnamnLabel.setText("Projektnamn: ");

        beskrivningLabel.setText("Beskrivning: ");

        projektchefLabel.setText("Projektchef:");

        prioritetLabel.setText("Prioritet:");

        statusLabel.setText("Status:");

        kostnadLabel.setText("Kostnad:");

        startdatumLabel.setText("Startdatum: ");

        projektetsPartnersList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projektetsPartnersListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(projektetsPartnersList);

        partnerLbl.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        partnerLbl.setText("Partners kopplade till projektet");

        statusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj status...", "Planerat", "Pågående", "Avslutat" }));

        prioritetCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj prioritet...", "Låg", "Medel", "Hög" }));

        projektchefCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj projektchef..." }));

        sparaBtn.setText("Spara");

        tillgangligaPartnersList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tillgangligaPartnersListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tillgangligaPartnersList);

        laggTillBtn.setText("Lägg till");
        laggTillBtn.setEnabled(false);
        laggTillBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laggTillBtnMouseClicked(evt);
            }
        });

        taBortBtn.setText("Ta bort");
        taBortBtn.setEnabled(false);
        taBortBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taBortBtnMouseClicked(evt);
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
                        .addComponent(tillbakaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sparaBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(partnerLbl))
                            .addComponent(statusLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(beskrivningLabel)
                                    .addComponent(startdatumLabel)
                                    .addComponent(projektnamnLabel)
                                    .addComponent(projektchefLabel)
                                    .addComponent(prioritetLabel)
                                    .addComponent(kostnadLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(projektnamnInput)
                                    .addComponent(kostnadInput)
                                    .addComponent(statusCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(prioritetCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(beskrivningInput)
                                    .addComponent(startdatumInput)
                                    .addComponent(projektchefCB, 0, 140, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(laggTillBtn)
                                    .addComponent(taBortBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projektnamnLabel)
                    .addComponent(projektnamnInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beskrivningLabel)
                    .addComponent(beskrivningInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projektchefLabel)
                    .addComponent(projektchefCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prioritetLabel)
                    .addComponent(prioritetCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(statusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kostnadLabel)
                    .addComponent(kostnadInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startdatumLabel)
                    .addComponent(startdatumInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(partnerLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(laggTillBtn)
                                .addGap(9, 9, 9)
                                .addComponent(taBortBtn)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tillbakaButton)
                            .addComponent(sparaBtn)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tillbakaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tillbakaButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_tillbakaButtonActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        projektetsPartnersList.clearSelection();
        tillgangligaPartnersList.clearSelection();
        laggTillBtn.setEnabled(false);
        taBortBtn.setEnabled(false);
    }//GEN-LAST:event_formMouseClicked

    private void projektetsPartnersListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projektetsPartnersListMouseClicked
        taBortBtn.setEnabled(true);
        laggTillBtn.setEnabled(false);
    }//GEN-LAST:event_projektetsPartnersListMouseClicked

    private void tillgangligaPartnersListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tillgangligaPartnersListMouseClicked
        laggTillBtn.setEnabled(true);
        taBortBtn.setEnabled(false);
    }//GEN-LAST:event_tillgangligaPartnersListMouseClicked

    private void laggTillBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laggTillBtnMouseClicked
        int i = tillgangligaPartnersList.getSelectedIndex();
        attRedigera.getPartners().add(partnerregister.get(i));
        partnerregister.remove(i);
        refreshaListor();
    }//GEN-LAST:event_laggTillBtnMouseClicked

    private void taBortBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taBortBtnMouseClicked
        int i = tillgangligaPartnersList.getSelectedIndex();
        //partnerregister.add(attRedigera.getPartner(i));
        attRedigera.getPartners().remove(i);
        refreshaListor();
    }//GEN-LAST:event_taBortBtnMouseClicked

    private void initProjektchefCB(){
        projektchefCB.addItem("Ingen");
        
        anvandarregister.hamtaAvdelningensAnvandare(attRedigera.getProjektchef().getAvdelningsID());
        
        for(Anvandare enAnvandare : anvandarregister.getLista()){
            if(enAnvandare.isHandlaggare()){
                projektchefCB.addItem(enAnvandare.getFullNamn());
                handlaggare.add(enAnvandare);
            }
        }
        projektchefCB.setSelectedIndex(0);
    }
    
    private int getProjektchefIndex(){
        String projektchef = attRedigera.getProjektchef().getFullNamn();
        
        for(int i = 0; i<handlaggare.size(); i++){
            if(handlaggare.get(i).getFullNamn().equals(projektchef)){
                return i;
            }
        }
        System.out.println(projektchef + " finns inte... ojdå.");
        return -1;
    }
    
    private int getPrioritetIndex(){
        switch(attRedigera.getPrioritet()){
            case "Låg":
                return 1;
            case "Medel":
                return 2;
            case "Hög":
                return 3;
            default:
            {
                System.out.println("getPrioritetIndex() failed.");
                return -1;
            }   
        }
    }
    
    private int getStatusIndex(){
        switch(attRedigera.getStatus()){
            case "Planerat":
                return 1;
            case "Pågående":
                return 2;
            case "Avslutat":
                return 3;
            default:
            {
                System.out.println("getStatusIndex() failed.");
                return -1;
            }
        }
    }
    
    private void initTillgangligaPartners(){
        for(int i = 0; i < partnerregister.size(); i++){
            for(int j = 0; j < attRedigera.getPartners().size(); j++){
               // if(attRedigera.getPartner(j).equals(partnerregister.get(i))){
                    //partnerregister.remove(i);
              //  }
            }
        }
    }
    
    private void visaTillgangligaPartners(){
        DefaultListModel<String> listModell = new DefaultListModel<>();
        for(Partner enPartner : partnerregister.getLista()){
            listModell.addElement(enPartner.getNamn());
        }
        tillgangligaPartnersList.setModel(listModell);
    }
    
    private void initFalt(){
        projektnamnInput.setText(attRedigera.getNamn());
        beskrivningInput.setText(attRedigera.getBeskrivning());
        projektchefCB.setSelectedIndex(getProjektchefIndex() + 2); //För att skippa "välj" och "ingen"
        prioritetCB.setSelectedIndex(getPrioritetIndex());
        statusCB.setSelectedIndex(getStatusIndex());
        kostnadInput.setText(attRedigera.getKostnad());
        startdatumInput.setText(attRedigera.getStartdatum());
        initProjektetsPartnerLista();
    }
    
    private void initProjektetsPartnerLista(){
        DefaultListModel<String> listModell = new DefaultListModel<>();
        if(attRedigera.getPartners().isEmpty()){
            projektetsPartnersList.setEnabled(false);
            listModell.addElement("Inga partners kopplade till projektet.");
        }
        else{
            for(Partner enPartner : attRedigera.getPartners()){
                listModell.addElement(enPartner.getNamn());
            }
        }
        projektetsPartnersList.setModel(listModell);
    }
    
    private void rensaListor(){
        //Tar bort datan
        projektetsPartnersList.setModel(new DefaultListModel<>());
        tillgangligaPartnersList.setModel(new DefaultListModel<>());
        //Tar bort datan från fönstret också.
        projektetsPartnersList.repaint();
        tillgangligaPartnersList.repaint();
        
    };
    
    private void refreshaListor(){
        rensaListor();
        refreshPartnerLista();
        refreshTillgangligaLista();
    }
    
    private void refreshPartnerLista(){
        attRedigera.hamtaPartners();
        
        DefaultListModel<String> listModell = new DefaultListModel<>();
        if(attRedigera.getPartners().isEmpty()){
            projektetsPartnersList.setEnabled(false);
            listModell.addElement("Inga partners kopplade till projektet.");
        }
        else{
            for(Partner enPartner : attRedigera.getPartners()){
                listModell.addElement(enPartner.getNamn());
            }
        }
        projektetsPartnersList.setModel(listModell);
    }
    
    private void refreshTillgangligaLista(){
        
        DefaultListModel<String> listModell = new DefaultListModel<>();
        if(partnerregister.getLista().isEmpty()){
            tillgangligaPartnersList.setEnabled(false);
            listModell.addElement("");
        }
        else{
            for(Partner enPartner : partnerregister.getLista()){
                listModell.addElement(enPartner.getNamn());
            }
        }
        tillgangligaPartnersList.setModel(listModell);
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
            java.util.logging.Logger.getLogger(RedigeraProjektFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedigeraProjektFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedigeraProjektFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedigeraProjektFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new RedigeraProjektFonster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField beskrivningInput;
    private javax.swing.JLabel beskrivningLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kostnadInput;
    private javax.swing.JLabel kostnadLabel;
    private javax.swing.JButton laggTillBtn;
    private javax.swing.JLabel partnerLbl;
    private javax.swing.JComboBox<String> prioritetCB;
    private javax.swing.JLabel prioritetLabel;
    private javax.swing.JComboBox<String> projektchefCB;
    private javax.swing.JLabel projektchefLabel;
    private javax.swing.JList<String> projektetsPartnersList;
    private javax.swing.JTextField projektnamnInput;
    private javax.swing.JLabel projektnamnLabel;
    private javax.swing.JButton sparaBtn;
    private javax.swing.JTextField startdatumInput;
    private javax.swing.JLabel startdatumLabel;
    private javax.swing.JComboBox<String> statusCB;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton taBortBtn;
    private javax.swing.JButton tillbakaButton;
    private javax.swing.JList<String> tillgangligaPartnersList;
    // End of variables declaration//GEN-END:variables
}
