/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;

import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;

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
import ngo2024.Anvandare;
import ngo2024.Projekt;
import ngo2024.ProjektRegister;
import ngo2024.Projektstatus;
import ngo2024.SokKategori;

/**
 *
 * @author james
 */
public class ProjektFonster extends javax.swing.JFrame {

    private Anvandare inloggadAnvandare;
    private InfDB idb;
    private String vy;
    private ProjektRegister projektregister;
    private SokKategori kategori;
    private DefaultTableModel tabell;
    private int hoveredRow = -1;
    private int hoveredColumn;
    
    /**
     * Creates new form Projekt
     */
    public ProjektFonster(InfDB idb, Anvandare inloggadAnvandare) {
        initComponents();
        
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        vy = "Alla projekt";
        projektregister = new ProjektRegister(idb);
        kategori = SokKategori.ALLA;
        tabell = (DefaultTableModel) projektTable.getModel();
        
        setKnappar();   //Sätter visibility på knappar beroende på behörighet
        initKolumner(); //Skapar och namnsätter kolumner
        
        visaData();
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
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDG Sweden - Projekt");

        projektTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        projektTable.setShowHorizontalLines(true);
        projektTable.setShowVerticalLines(true);
        projektTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                projektTableMouseMoved(evt);
            }
        });
        projektTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projektTableMouseClicked(evt);
            }
        });
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
        sokEfterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sokEfterComboBoxActionPerformed(evt);
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sokfalt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sokEfterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(65, 65, 65)
                                        .addComponent(sokDatumButton)))
                                .addGap(50, 50, 50)
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
                    .addComponent(laggTillButton))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tillbakaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tillbakaButtonMouseClicked
        new MenyFonster(idb, inloggadAnvandare).setVisible(true);
                this.setVisible(false);
    }//GEN-LAST:event_tillbakaButtonMouseClicked

    private void sokfaltKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sokfaltKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(sokfalt.getText().equals("")){
                projektregister.hamtaAllaProjekt();
                visaData();
                return;
            }
            projektregister.getSoktLista(kategori, sokfalt.getText());
            visaData();
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

    private void laggTillButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laggTillButtonMouseClicked
        new LaggTillProjektFonster(inloggadAnvandare, idb).setVisible(true);
    }//GEN-LAST:event_laggTillButtonMouseClicked

    private void taBortButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taBortButtonMouseClicked
        //Den här ska bara vara enabled om man är administratör
    }//GEN-LAST:event_taBortButtonMouseClicked

    private void avdelningensProjektButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avdelningensProjektButtonMouseClicked
        projektregister.tomLista();
        resetKnapparOchSokfalt();
        
        vy = "Avdelningens projekt";
        projektregister.hamtaAvdelningensProjekt(inloggadAnvandare.getAvdelningsID());
        visaData();
    }//GEN-LAST:event_avdelningensProjektButtonMouseClicked

    private void allaProjektButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allaProjektButtonMouseClicked
        projektregister.tomLista();
        resetKnapparOchSokfalt();
        
        vy = "Alla projekt";
        projektregister.hamtaAllaProjekt();
        visaData();
    }//GEN-LAST:event_allaProjektButtonMouseClicked

    private void minaProjektButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minaProjektButtonMouseClicked
        projektregister.tomLista();
        resetKnapparOchSokfalt();
        
        vy = "Mina projekt";
        projektregister.hamtaMinaProjekt(inloggadAnvandare.getAnstallningsID());
        visaData();
    }//GEN-LAST:event_minaProjektButtonMouseClicked
 
    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        String status = statusComboBox.getSelectedItem().toString();
        uppdateraFonster(vy);
        
        switch(status){
            case "Alla":
                projektregister.getListaStatus(Projektstatus.ALLA);
                break;
            case "Pågående":
                projektregister.getListaStatus(Projektstatus.PÅGÅENDE);
                break;
            case "Planerat":
                projektregister.getListaStatus(Projektstatus.PLANERAT);
                break;
            case "Avslutat":
                projektregister.getListaStatus(Projektstatus.AVSLUTAT);
                break;
            default:
                break;
        }
        visaData();
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void sokEfterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sokEfterComboBoxActionPerformed
        String status = sokEfterComboBox.getSelectedItem().toString();
        
        switch(status){
            case "Sök efter...":
                break;
            case "Projektchef":
                kategori = SokKategori.PROJEKTCHEF;
                break;
            case "Projektnamn":
                kategori = SokKategori.PROJEKTNAMN;
                break;
            default:
                break;
        }
    }//GEN-LAST:event_sokEfterComboBoxActionPerformed

    private void projektTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projektTableMouseClicked
        int rad = projektTable.rowAtPoint(evt.getPoint());
        int kolumn = projektTable.columnAtPoint(evt.getPoint()) + 1;

        String kolumnnamn = tabell.getColumnName(kolumn);
        
        if(kolumnnamn.equals("Projektnamn") && (rad >= 0 && rad < projektTable.getRowCount())){
            String pid = (String)tabell.getValueAt(rad, kolumn-1);  
            Projekt aktuelltProjekt = new Projekt(pid, idb);
            
            //Öppnar nytt fönster som visar mer detaljerad information om ett projekt 
            new ProjektInfoFonster(inloggadAnvandare, aktuelltProjekt, idb).setVisible(true);
        }
        else if(kolumnnamn.equals("Projektchef") && (rad >= 0 && rad < projektTable.getRowCount())){
            String pid = (String)tabell.getValueAt(rad, kolumn-2);
            String cellKlickad = (String)tabell.getValueAt(rad, kolumn);
            
            //Om man t.ex klickat på ett projekt som inte har en projektchef, händer ingenting.
            if(cellKlickad.isEmpty()){
                return;
            }
            
            /*Hämtar ut projektchefsIDt genom ett anonymt objekt av typen Projekt 
            (kopplat till den klickade projektchefen) */
            String projektchefID = new Projekt(pid, idb).getProjektchefID();
            
            //konverterar projektchefsIDt till ett anställningsID
            String aid = Projekt.getAnstalldID(idb, projektchefID);
            
            //skapar ett 'projektchef'-objekt att skicka med i fönstret
            Anvandare projektchef = new Anvandare(idb, aid);
            
            //Öppnar nytt fönster som visar detaljerad information om en projektchef
            new ProjektchefInfoFonster(inloggadAnvandare, projektchef, idb).setVisible(true);
        }
    }//GEN-LAST:event_projektTableMouseClicked

    private void projektTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projektTableMouseMoved
        int row = projektTable.rowAtPoint(evt.getPoint());
        int column = projektTable.columnAtPoint(evt.getPoint());
        
        if(row >= 0 && column >= 0)
        {
            String columnNamn = projektTable.getColumnName(column);
            
            if(columnNamn.equals("Projektnamn") || columnNamn.equals("Projektchef"))
            {
                projektTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
                hoveredRow = row;
                hoveredColumn = column;
            }
            else
            {
                projektTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                hoveredRow = -1;
                hoveredColumn = -1;
            } 
        }
        else
        {
            projektTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            hoveredRow = -1;
            hoveredColumn = -1;
        }
        projektTable.repaint();
    }//GEN-LAST:event_projektTableMouseMoved

    
    private void initKolumner(){
        tabell.addColumn("pid"); //denna ska gömmas senare
        tabell.addColumn("Projektnamn");
        tabell.addColumn("Projektchef");
        tabell.addColumn("Prioritet");
        tabell.addColumn("Startdatum");
        
        //Förhindrar användaren från att editera cellerna direkt
        projektTable.setDefaultEditor(Object.class, null);
        
        //Gömmer pid kolumnen
        projektTable.removeColumn(projektTable.getColumnModel().getColumn(0));
    }
    
    private void visaData(){
        rensaDataFonster();
        for(Projekt ettProjekt : projektregister.getLista()){
            tabell.addRow(new Object[]{ettProjekt.getProjektID(), ettProjekt.getProjektnamn(), 
                ettProjekt.getProjektchef().getFullNamn(), ettProjekt.getPrioritet(),
                ettProjekt.getStartdatum()} );
        }
    }
    
    private void rensaDataFonster(){
        //Tar bort datan
        tabell.getDataVector().clear();
        
        //Tar bort datan från fönstret också.
        projektTable.repaint();
        
    };
    
    private void uppdateraFonster(String vy){
        projektregister.tomLista();
        rensaDataFonster();
        
        switch(vy){
            case "Alla projekt":
                projektregister.hamtaAllaProjekt();
                break;
            case "Avdelningens projekt":
                projektregister.hamtaAvdelningensProjekt(inloggadAnvandare.getAvdelningsID());
                break;
            case "Mina projekt":
                projektregister.hamtaMinaProjekt(inloggadAnvandare.getAnstallningsID());
                break;
            default:
                break;
        }
        visaData();
    }
        
    private void setKnappar(){
        if(inloggadAnvandare.isAdmin()){
            laggTillButton.setVisible(true);
            taBortButton.setVisible(true);
        }
        else{
            laggTillButton.setVisible(false);
            taBortButton.setVisible(false);
        }
    }
    
    private void resetKnapparOchSokfalt(){
        sokfalt.setText("");
        sokEfterComboBox.setSelectedIndex(0);
        statusComboBox.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(ProjektFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjektFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjektFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjektFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
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
    private javax.swing.JButton sokDatumButton;
    private javax.swing.JComboBox<String> sokEfterComboBox;
    private javax.swing.JLabel sokLabel;
    private javax.swing.JTextField sokfalt;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JButton taBortButton;
    private javax.swing.JButton tillbakaButton;
    // End of variables declaration//GEN-END:variables
}
