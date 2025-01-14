/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;

import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.table.DefaultTableModel;
import ngo2024.Anvandare;
import java.util.*;

/**
 *
 * @author Gastinlogg
 */
public class StatistikFonster extends javax.swing.JFrame {

    private Anvandare inloggadAnvandare;
    private InfDB idb;
    private DefaultTableModel tabell1;
    private DefaultTableModel tabell2;
    private DefaultTableModel tabell3;
    
    /**
     * Creates new form StatistikFonster
     */
    public StatistikFonster(InfDB idb, Anvandare inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
        this.tabell1 = (DefaultTableModel) tblProjektkostnadLand.getModel();
        this.tabell2 = (DefaultTableModel) tblPartners.getModel();
        this.tabell3 = (DefaultTableModel) tblLander.getModel();
        
        setLocationRelativeTo(null);
        
        lblRubrik.setText("STATISTIK - PROJEKTLEDARE " + inloggadAnvandare.getFullNamn().toUpperCase() + "!");
        
        setStatistik();
        setStatistikLandKostnad();
        setStatistikPartners();
        setStatistikLander();
    }
    
    public void setStatistik(){
        lblKonstadProText.setText("Kostnad för projekt där du varit projektledare:");
        
        String kostnad = "Du har ännu inga projekt!";
        try {
            String sqlFraga = "SELECT sum(kostnad) FROM projekt " +
                "WHERE projektchef = " + inloggadAnvandare.getAnstallningsID();
        
            ArrayList<String> resultat = idb.fetchColumn(sqlFraga);
            
            if(!resultat.isEmpty()){
                kostnad = resultat.get(0);
            }
        }
        catch(InfException ex){
            System.out.println(ex.getMessage());
        } 
        
        lblKostnad.setText(kostnad + "kr");
    }
    
    public void setStatistikLander(){
        try{
            String sqlFraga = "SELECT land.namn, count(projekt.pid) as antalproj FROM land " +
                    "JOIN projekt ON land.lid = projekt.land " +
                    " WHERE projekt.projektchef = " + inloggadAnvandare.getAnstallningsID() +
                    " GROUP BY land.lid " +
                    "ORDER BY antalproj DESC";
            
            ArrayList<HashMap<String, String>> landAntal = idb.fetchRows(sqlFraga);
            
            if(!landAntal.isEmpty()){
                for(HashMap<String, String> lander: landAntal){
                    String landNamn = lander.get("namn");
                    String antalProj = lander.get("antalproj");
                    if(antalProj == null){
                        antalProj = "0";
                    }
                    
                    tabell3.addRow(new Object[] {landNamn, antalProj});
                }
            }
        }
        catch(InfException ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    public void setStatistikPartners(){
        try{
            String sqlFraga = "SELECT partner.namn, COUNT(DISTINCT projekt.pid) AS antalproj FROM partner " +
            "JOIN projekt_partner ON partner.pid = projekt_partner.partner_pid " +
            "JOIN projekt ON projekt.pid = projekt_partner.pid " +
            " WHERE projekt.projektchef = " + inloggadAnvandare.getAnstallningsID() + 
            " GROUP BY partner.pid " +
            "ORDER BY antalproj DESC";
            
            System.out.println(sqlFraga);
            
            ArrayList<HashMap<String, String>> partnerAntal = idb.fetchRows(sqlFraga);
           
            if(!partnerAntal.isEmpty()){
                for(HashMap<String, String> partner: partnerAntal){
                    String namnPartner = partner.get("namn");
                    String antalProj = partner.get("antalproj");
                    if(antalProj == null){
                        antalProj = "0";
                    }
                    System.out.println(namnPartner+ ", " + antalProj);
                    tabell2.addRow(new Object[]{namnPartner, antalProj});
                }
            }
        }
        catch(InfException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void setStatistikLandKostnad(){
        try{
            String sqlFraga = "SELECT land.namn, sum(projekt.kostnad) as totKostnad FROM projekt " +
                    "JOIN land ON projekt.land = land.lid " +
                    "GROUP BY land.namn " +
                    "ORDER BY totKostnad DESC";
            ArrayList<HashMap<String, String>> landKostnad = idb.fetchRows(sqlFraga);
            
            
            for(HashMap<String, String> land: landKostnad){
                String landnamn = land.get("namn");
                String kostnad = land.get("totKostnad");
                
                if(kostnad == null){
                    kostnad = "0";
                }
                tabell1.addRow(new Object [] {landnamn, kostnad});
                
            }
                  
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

        lblKonstadProText = new javax.swing.JLabel();
        lblKostnad = new javax.swing.JLabel();
        lblLander = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProjektkostnadLand = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPartners = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLander = new javax.swing.JTable();
        lblRubrik = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        lblKonstadProText.setText("Kostnad för projekt där du varit projektledare:");

        lblKostnad.setText("KOSTNAD");

        lblLander.setText("Dina projekt har genomförts i dessa länder:");

        jLabel1.setText("Du har i dina projekt samarbetat med dessa partners:");

        jLabel2.setText("Totala kostnader av samtliga SDG Swedens projekt baserat på land:");

        tblProjektkostnadLand.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Land", "Total kostnad"
            }
        ));
        tblProjektkostnadLand.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblProjektkostnadLand);
        tblProjektkostnadLand.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        tblPartners.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Partners", "Antal projekt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPartners);

        tblLander.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Land", "Antal projekt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblLander);

        lblRubrik.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRubrik.setText("STATISTIK");

        jButton1.setText("Tillbaka");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblKonstadProText)
                        .addGap(18, 18, 18)
                        .addComponent(lblKostnad))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton1))
                    .addComponent(lblLander)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKonstadProText)
                    .addComponent(lblKostnad))
                .addGap(24, 24, 24)
                .addComponent(lblLander)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(StatistikFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatistikFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatistikFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatistikFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new StatistikFonster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblKonstadProText;
    private javax.swing.JLabel lblKostnad;
    private javax.swing.JLabel lblLander;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JTable tblLander;
    private javax.swing.JTable tblPartners;
    private javax.swing.JTable tblProjektkostnadLand;
    // End of variables declaration//GEN-END:variables
}
