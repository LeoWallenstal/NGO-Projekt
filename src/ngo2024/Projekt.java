/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author james
 */
public class Projekt extends javax.swing.JFrame {

    private Anvandare inloggadAnvandare;
    private InfDB idb;
    private String status;
    private String vy;
    
    /**
     * Creates new form Projekt
     */
    public Projekt(InfDB idb, Anvandare inloggadAnvandare) {
        initComponents();
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;   
        status = "Alla";
        vy = "Alla projekt";
        initKolumner(); //Skapar och namnsätter kolumner
        ArrayList<HashMap<String, String>> uppgifter = hamtaAllaProjekt();
        visaData(uppgifter);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        projektTable = new javax.swing.JTable();
        tillbakaButton = new javax.swing.JButton();
        sokLabel = new javax.swing.JLabel();
        sokfalt = new javax.swing.JTextField();
        sokEfterComboBox = new javax.swing.JComboBox<>();
        sokDatumButton = new javax.swing.JButton();
        statusComboBox = new javax.swing.JComboBox<>();
        allaProjektButton = new javax.swing.JButton();
        avdelningensProjektButton = new javax.swing.JButton();
        minaProjektButton = new javax.swing.JButton();
        laggTillButton = new javax.swing.JButton();
        taBortButton = new javax.swing.JButton();
        redigeraButton = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NGO Sweden - Projekt");

        projektTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        projektTable.setShowHorizontalLines(true);
        projektTable.setShowVerticalLines(true);
        jScrollPane1.setViewportView(projektTable);

        tillbakaButton.setText("Tillbaka");
        tillbakaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tillbakaButtonMouseClicked(evt);
            }
        });

        sokLabel.setText("Sök:");

        sokfalt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sokfaltKeyPressed(evt);
            }
        });

        sokEfterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sök efter...", "Projektnamn", "Projektchef" }));
        sokEfterComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sokEfterComboBoxMouseClicked(evt);
            }
        });

        sokDatumButton.setText("Sök datum");
        sokDatumButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sokDatumButtonMouseClicked(evt);
            }
        });
        sokDatumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sokDatumButtonActionPerformed(evt);
            }
        });

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alla", "Pågående", "Planerat", "Avslutat" }));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });
        statusComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                statusComboBoxPropertyChange(evt);
            }
        });

        allaProjektButton.setText("Alla projekt");
        allaProjektButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allaProjektButtonMouseClicked(evt);
            }
        });
        allaProjektButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allaProjektButtonActionPerformed(evt);
            }
        });

        avdelningensProjektButton.setText("Avdelningens projekt");
        avdelningensProjektButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avdelningensProjektButtonMouseClicked(evt);
            }
        });

        minaProjektButton.setText("Mina projekt");
        minaProjektButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minaProjektButtonMouseClicked(evt);
            }
        });

        laggTillButton.setText("Lägg till projekt");
        laggTillButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laggTillButtonMouseClicked(evt);
            }
        });

        taBortButton.setText("Ta bort projekt");
        taBortButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taBortButtonMouseClicked(evt);
            }
        });

        redigeraButton.setText("Redigera projekt");
        redigeraButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                redigeraButtonMouseClicked(evt);
            }
        });
        redigeraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redigeraButtonActionPerformed(evt);
            }
        });

        lblStatus.setText("Status:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(allaProjektButton, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(avdelningensProjektButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(minaProjektButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sokLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sokfalt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(redigeraButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sokEfterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(65, 65, 65)
                                        .addComponent(sokDatumButton)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(taBortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(laggTillButton, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tillbakaButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStatus)
                                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(allaProjektButton)
                    .addComponent(avdelningensProjektButton)
                    .addComponent(minaProjektButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sokLabel)
                    .addComponent(sokfalt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(laggTillButton)
                    .addComponent(redigeraButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sokEfterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sokDatumButton)
                            .addComponent(taBortButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(tillbakaButton)
                        .addGap(14, 14, 14))))
        );

        getAccessibleContext().setAccessibleName("SDG Sweden - Projekt");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tillbakaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tillbakaButtonMouseClicked
        new Meny(idb, inloggadAnvandare).setVisible(true);
                this.setVisible(false);
    }//GEN-LAST:event_tillbakaButtonMouseClicked

    private void sokEfterComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sokEfterComboBoxMouseClicked
            // TODO add your handling code here:
    }//GEN-LAST:event_sokEfterComboBoxMouseClicked

    private void sokfaltKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sokfaltKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
        }
    }//GEN-LAST:event_sokfaltKeyPressed

    private void sokDatumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sokDatumButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sokDatumButtonActionPerformed

    private void sokDatumButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sokDatumButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sokDatumButtonMouseClicked

    private void allaProjektButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allaProjektButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allaProjektButtonActionPerformed

    private void redigeraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redigeraButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redigeraButtonActionPerformed

    private void laggTillButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laggTillButtonMouseClicked
        //Den här ska bara vara enabled om man är administratör
    }//GEN-LAST:event_laggTillButtonMouseClicked

    private void taBortButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taBortButtonMouseClicked
        //Den här ska bara vara enabled om man är administratör
    }//GEN-LAST:event_taBortButtonMouseClicked

    private void redigeraButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redigeraButtonMouseClicked
        //Den här ska bara vara enabled om man är administratör
    }//GEN-LAST:event_redigeraButtonMouseClicked

    private void avdelningensProjektButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avdelningensProjektButtonMouseClicked
        rensaDataFonster();
        vy = "Avdelningens projekt";
        ArrayList<HashMap<String, String>> uppgifter = hamtaAvdelningensProjekt();
        visaData(uppgifter);
    }//GEN-LAST:event_avdelningensProjektButtonMouseClicked

    private void allaProjektButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allaProjektButtonMouseClicked
        rensaDataFonster();
        vy = "Alla projekt";
        ArrayList<HashMap<String, String>> uppgifter = hamtaAllaProjekt();
        visaData(uppgifter);
    }//GEN-LAST:event_allaProjektButtonMouseClicked

    private void minaProjektButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minaProjektButtonMouseClicked
        rensaDataFonster();
        vy = "Mina projekt";
        ArrayList<HashMap<String, String>> uppgifter = hamtaMinaProjekt();
        visaData(uppgifter);
    }//GEN-LAST:event_minaProjektButtonMouseClicked

 
    
    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        status = statusComboBox.getSelectedItem().toString();
        rensaDataFonster();
        if(vy.equals("Alla projekt")){
            ArrayList<HashMap<String, String>> uppgifter = hamtaAllaProjekt();
            visaData(uppgifter);
            
            }
        else if(vy.equals("Mina projekt")){
            ArrayList<HashMap<String, String>> uppgifter = hamtaMinaProjekt();
            visaData(uppgifter);
            }
        else if(vy.equals("Avdelningens projekt")){
           ArrayList<HashMap<String, String>> uppgifter = hamtaAvdelningensProjekt();
            visaData(uppgifter);
        }     
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void statusComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_statusComboBoxPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxPropertyChange

    private void initKolumner(){
        ArrayList<HashMap<String, String>> projektUppgifter = hamtaAllaProjekt();
        DefaultTableModel tabell = (DefaultTableModel) projektTable.getModel();
        
        // Skapa och namnsätta kolumnerna
        if (tabell.getColumnCount() == 0) {
            for (String kolumnNamn : projektUppgifter.getFirst().keySet()) {
                tabell.addColumn(kolumnNamn);
            }
        }
        //Flytta kolumnerna så de sitter rätt.
        projektTable.moveColumn(2, 0);
        projektTable.moveColumn(3, 1);
        
        projektTable.setDefaultEditor(Object.class, null);
    }
    
    private void visaData(ArrayList<HashMap<String, String>> projektUppgifter) {
        
        DefaultTableModel tabell = (DefaultTableModel) projektTable.getModel();
    
        // Populera raden med data
        for (HashMap<String, String> enRad : projektUppgifter) {
            String[] data = new String[tabell.getColumnCount()]; 

            for (int i = 0; i < tabell.getColumnCount(); i++) {
                String kolumnNamn = tabell.getColumnName(i); 
                
                if(tabell.getColumnName(i).equals("projektchef")){
                    int projektchefID = Integer.parseInt(enRad.get(kolumnNamn));
                    
                    String sqlFornamn = "SELECT fornamn from projekt "
                                      + "JOIN ans_proj on projektchef = aid "
                                      + "JOIN anstalld on ans_proj.aid = anstalld.aid "
                                      + "WHERE anstalld.aid = " + projektchefID;
                    
                    String sqlEfternamn = "SELECT efternamn from projekt "
                                      + "JOIN ans_proj on projektchef = aid "
                                      + "JOIN anstalld on ans_proj.aid = anstalld.aid "
                                      + "WHERE anstalld.aid = " + projektchefID;
                    try{
                        String fornamn = idb.fetchSingle(sqlFornamn);
                        String efternamn = idb.fetchSingle(sqlEfternamn);
                        if(fornamn != null && efternamn != null){
                            data[i] = fornamn + " " + efternamn;
                        }
                    } catch (InfException ex) {
                    System.out.println(ex.getMessage());
                    }
                }
                else{
                    data[i] = enRad.get(kolumnNamn); 
                }
            }
            tabell.addRow(data); 
        }
    }
    
    private ArrayList<HashMap<String, String>> hamtaAllaProjekt(){
        ArrayList<HashMap<String, String>> projektUppgifter = new ArrayList<>();
        
        try {
            
            String sqlFraga = "SELECT projektnamn, projektchef, prioritet, startdatum from projekt";
            
            if(!status.equals("Alla")){
                sqlFraga = "SELECT projektnamn, projektchef, prioritet, startdatum from projekt WHERE status = '" + status + "'";
            }
            
            projektUppgifter = idb.fetchRows(sqlFraga);
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        return projektUppgifter;
    }
    
    private ArrayList<HashMap<String, String>> hamtaAvdelningensProjekt(){
        ArrayList<HashMap<String, String>> projektUppgifter = new ArrayList<>();
        
        try {
            String sqlFraga = 
                  "SELECT projektnamn, projektchef, startdatum,  prioritet "
                + "FROM projekt "
                + "JOIN ans_proj ON projekt.pid = ans_proj.pid "
                + "JOIN anstalld ON ans_proj.aid = anstalld.aid "
                + "JOIN avdelning on anstalld.avdelning = avdelning.avdid "
                + "WHERE avdelning.avdid = " + inloggadAnvandare.getAvdelningsId() + " " 
                + "GROUP BY projektnamn, projektchef, startdatum, prioritet ";
            
            
            if(!status.equals("Alla")){
                sqlFraga = "SELECT projektnamn, projektchef, startdatum,  prioritet "
                + "FROM projekt "
                + "JOIN ans_proj ON projekt.pid = ans_proj.pid "
                + "JOIN anstalld ON ans_proj.aid = anstalld.aid "
                + "JOIN avdelning on anstalld.avdelning = avdelning.avdid "
                + "WHERE avdelning.avdid = " + inloggadAnvandare.getAvdelningsId() + " AND status = '"
                + status + "' "
                + "GROUP BY projektnamn, projektchef, startdatum, prioritet "; 
            }
            projektUppgifter = idb.fetchRows(sqlFraga);
            
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
        return projektUppgifter;
    }
    
    private ArrayList<HashMap<String, String>> hamtaMinaProjekt(){
        ArrayList<HashMap<String, String>> projektUppgifter = new ArrayList<>();
        
        try {
            
            String sqlFraga = 
                  "SELECT projektnamn, projektchef, startdatum, prioritet from projekt "
                + "JOIN ans_proj on projekt.pid = ans_proj.pid "
                + "JOIN anstalld on ans_proj.aid = anstalld.aid "
                + "WHERE ans_proj.aid = " + inloggadAnvandare.getAnstallningsId() + " "
                + "OR projektchef = " + inloggadAnvandare.getAnstallningsId() + " "
                + "GROUP BY projektnamn, projektchef, startdatum, prioritet";
            
            if(!status.equals("Alla")){
                sqlFraga = "SELECT projektnamn, projektchef, startdatum, prioritet from projekt "
                + "JOIN ans_proj on projekt.pid = ans_proj.pid "
                + "JOIN anstalld on ans_proj.aid = anstalld.aid "
                + "WHERE ans_proj.aid = " + inloggadAnvandare.getAnstallningsId()
                + " AND status = '" + status + "' " + "OR projektchef = " + inloggadAnvandare.getAnstallningsId() + " AND status = '" + status + "' " +
                 "GROUP BY projektnamn, projektchef, startdatum, prioritet";
            }
            
            projektUppgifter = idb.fetchRows(sqlFraga);     
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
        return projektUppgifter;
    }
    
    private void rensaDataFonster(){
        DefaultTableModel tabell = (DefaultTableModel) projektTable.getModel();
        
        //Tar bort datan............?
        tabell.getDataVector().clear();
        
        //Tar bort datan från fönstret också.
        projektTable.repaint();
        
    };
        
        
    
    
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
            java.util.logging.Logger.getLogger(Projekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Projekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Projekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Projekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Projekt().setVisible(true); utkommenterad, som leo sa
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allaProjektButton;
    private javax.swing.JButton avdelningensProjektButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton laggTillButton;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JButton minaProjektButton;
    private javax.swing.JTable projektTable;
    private javax.swing.JButton redigeraButton;
    private javax.swing.JButton sokDatumButton;
    private javax.swing.JComboBox<String> sokEfterComboBox;
    private javax.swing.JLabel sokLabel;
    private javax.swing.JTextField sokfalt;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JButton taBortButton;
    private javax.swing.JButton tillbakaButton;
    // End of variables declaration//GEN-END:variables
}
