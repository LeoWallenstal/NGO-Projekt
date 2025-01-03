/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;
import javax.swing.table.DefaultTableModel;
import ngo2024.*;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author james
 */
public class PartnerFonster extends javax.swing.JFrame {

    /**
     * Creates new form PartnerFonster
     */
    
    private Anvandare inloggadAnvandare;
    private InfDB idb;
    private DefaultTableModel tabell;
    private PartnerRegister partnerregister;
    
    
    public PartnerFonster(Anvandare inloggadAnvandare, InfDB idb) {
        this.inloggadAnvandare = inloggadAnvandare;
        this.idb = idb;
        partnerregister = new PartnerRegister(idb);
        
        initComponents();
        tabell = (DefaultTableModel) partnerTable.getModel();
        initKolumner();
        visaData();
        setLocationRelativeTo(null);
        setKnappar();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        laggTillPartnerButton = new javax.swing.JButton();
        tillbakaButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        partnerTable = new javax.swing.JTable();

        setTitle("SDG Sweden - Partners");

        laggTillPartnerButton.setText("Lägg till partner");
        laggTillPartnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laggTillPartnerButtonActionPerformed(evt);
            }
        });

        tillbakaButton.setText("Tillbaka");
        tillbakaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tillbakaButtonMouseClicked(evt);
            }
        });

        partnerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        partnerTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        partnerTable.setMinimumSize(new java.awt.Dimension(600, 800));
        partnerTable.setShowHorizontalLines(true);
        partnerTable.setShowVerticalLines(true);
        partnerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partnerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(partnerTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tillbakaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 458, Short.MAX_VALUE)
                .addComponent(laggTillPartnerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laggTillPartnerButton)
                    .addComponent(tillbakaButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void laggTillPartnerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laggTillPartnerButtonActionPerformed
        new LaggTillPartnerFonster(inloggadAnvandare, idb).setVisible(true);
    }//GEN-LAST:event_laggTillPartnerButtonActionPerformed

    private void tillbakaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tillbakaButtonMouseClicked
        new MenyFonster(idb, inloggadAnvandare).setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_tillbakaButtonMouseClicked

    private void initKolumner(){
        tabell.addColumn("pid"); //denna ska gömmas senare
        tabell.addColumn("Namn");
        tabell.addColumn("Kontaktperson");
        tabell.addColumn("Kontaktepost");
        
        //Förhindrar användaren från att editera cellerna direkt
        partnerTable.setDefaultEditor(Object.class, null);
        
        //Gömmer pid kolumnen
        partnerTable.removeColumn(partnerTable.getColumnModel().getColumn(0));
    }
    
    private void visaData(){
        rensaDataFonster();
        for(Partner enPartner : partnerregister.getLista()){
            tabell.addRow(new Object[]{enPartner.getPartnerID(), enPartner.getNamn(), 
                enPartner.getKontaktperson(), enPartner.getKontaktepost()});
        }
    }
    
    private void rensaDataFonster(){
        //Tar bort datan
        tabell.getDataVector().clear();

        //Tar bort datan från fönstret också.
        partnerTable.repaint();
        
    };
    
    private void partnerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partnerTableMouseClicked
        int partnerIndex = partnerTable.rowAtPoint(evt.getPoint());

        String kolumnnamn = tabell.getColumnName(partnerTable.columnAtPoint(evt.getPoint()) + 1);

        if(kolumnnamn.equals("Namn") && (partnerIndex>= 0 && partnerIndex < partnerTable.getRowCount())){;
            Partner aktuellPartner = partnerregister.get(partnerIndex);

            //Öppnar nytt fönster som visar mer detaljerad information om en partner
            new PartnerInfoFonster(inloggadAnvandare, aktuellPartner, idb).setVisible(true);
        }
    }//GEN-LAST:event_partnerTableMouseClicked

    private void setKnappar(){
        if(inloggadAnvandare.isAdmin()){
            laggTillPartnerButton.setVisible(true);
        }
        else{
            laggTillPartnerButton.setVisible(false);
        }
        this.revalidate();
        this.repaint();
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
            java.util.logging.Logger.getLogger(PartnerFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartnerFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartnerFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartnerFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new PartnerFonster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton laggTillPartnerButton;
    private javax.swing.JTable partnerTable;
    private javax.swing.JButton tillbakaButton;
    // End of variables declaration//GEN-END:variables
}
