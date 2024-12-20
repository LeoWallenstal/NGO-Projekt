/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.*;
import javax.swing.table.*;

/**
 *
 * @author walle
 */
public class Avdelning extends javax.swing.JFrame {

    private InfDB idb;
    private Anvandare inloggadAnvandare;
    
    /**
     * Creates new form Avdelning
     */
    public Avdelning(InfDB idb,Anvandare inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        initComponents();
        setLocationRelativeTo(null);
        displayAnstallda();
        setAvdelningsUppgifter();
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
        anstalldTable = new javax.swing.JTable();
        lblAvdelningsNamn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tpBeskrivning = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblStad = new javax.swing.JLabel();
        lblEpost = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblChef = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 576));
        setPreferredSize(new java.awt.Dimension(1020, 576));

        anstalldTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Namn", "Roll"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(anstalldTable);
        if (anstalldTable.getColumnModel().getColumnCount() > 0) {
            anstalldTable.getColumnModel().getColumn(0).setResizable(false);
            anstalldTable.getColumnModel().getColumn(1).setResizable(false);
        }

        lblAvdelningsNamn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAvdelningsNamn.setText("AvdelningsNamn");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Avdelnings beskrivning:");

        tpBeskrivning.setEditable(false);
        tpBeskrivning.setText("Test");
        tpBeskrivning.setFocusable(false);
        tpBeskrivning.setMaximumSize(new java.awt.Dimension(225, 100));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Adress:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Stad:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Epost:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Telefon:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Chef:");

        lblAdress.setText("jLabel7");

        lblStad.setText("jLabel8");

        lblEpost.setText("jLabel9");

        lblTelefon.setText("jLabel10");

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAvdelningsNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(tpBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblChef)
                                    .addComponent(lblTelefon)
                                    .addComponent(lblEpost)
                                    .addComponent(lblStad)
                                    .addComponent(lblAdress)))))
                    .addComponent(btnTillbaka))
                .addContainerGap(431, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAvdelningsNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tpBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblAdress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblStad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblEpost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblTelefon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblChef))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new Meny(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTillbakaActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private void displayAnstallda(){
        try{
            HashMap<String,String> anstalldRows = new HashMap<>();
            
            String sqlFraga = "SELECT aid FROM anstalld "
                    + "WHERE avdelning = " + inloggadAnvandare.getAvdelningsId();

            ArrayList<HashMap<String,String>> anstallda = idb.fetchRows(sqlFraga);
            
            sqlFraga = "SELECT aid FROM handlaggare";
            ArrayList<String> aidHandlaggare = idb.fetchColumn(sqlFraga);
            
            sqlFraga = "SELECT aid FROM admin";
            ArrayList<String> aidAdmin = idb.fetchColumn(sqlFraga);
                       
            for(HashMap<String,String> anstalld : anstallda){
                anstalldRows.put(anstalld.get("aid"),"Anställd");
            }
            
            for(HashMap<String,String> anstalld : anstallda){
               String aid = anstalld.get("aid");
               if(aidHandlaggare.contains(aid)){
                   anstalldRows.put(aid, "Handläggare");
               }else if(aidAdmin.contains(aid)){
                   anstalldRows.put(aid,"Administratör");
               }else{
                   anstalldRows.put(aid,"Anställd");
               }
            }
           
            for(String aid : anstalldRows.keySet()){
              String  sqlFraga1 = "SELECT fornamn FROM anstalld " +
                        "WHERE aid = "+aid;
                String sqlFraga2 = "SELECT efternamn FROM anstalld " +
                        "WHERE aid = "+aid;
                String namn = idb.fetchSingle(sqlFraga1)+" "+idb.fetchSingle(sqlFraga2);
                DefaultTableModel model = (DefaultTableModel) anstalldTable.getModel();
                model.addRow(new Object[]{namn, anstalldRows.get(aid)} );
            }
        }catch(InfException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void setAvdelningsUppgifter(){
    try{
        String sqlFraga = "SELECT namn, beskrivning, adress, epost, telefon, stad, chef from avdelning "+
                "where avdid = "+ inloggadAnvandare.getAvdelningsId();
        HashMap<String,String> avdelningsUppgifter = idb.fetchRow(sqlFraga);
        lblAvdelningsNamn.setText(avdelningsUppgifter.get("namn"));
        
        tpBeskrivning.setText(avdelningsUppgifter.get("beskrivning"));
        tpBeskrivning.setOpaque(false);
        tpBeskrivning.setFocusable(false);
        
        lblAdress.setText(avdelningsUppgifter.get("adress"));
        
        sqlFraga = "SELECT namn FROM stad "+
                "where sid = "+avdelningsUppgifter.get("stad");
        String stad = idb.fetchSingle(sqlFraga);
        lblStad.setText(stad);
        
        lblEpost.setText(avdelningsUppgifter.get("epost"));
        
        lblTelefon.setText(avdelningsUppgifter.get("telefon"));
        
        sqlFraga = "SELECT namn FROM anstalld "+
                "where aid = "+avdelningsUppgifter.get("chef");
        String chef = idb.fetchSingle(sqlFraga);
        lblChef.setText(chef);
        
    }catch(InfException ex){
        System.out.println(ex.getMessage());
    }
}
    
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
            java.util.logging.Logger.getLogger(Avdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Avdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Avdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Avdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Avdelning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable anstalldTable;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblAvdelningsNamn;
    private javax.swing.JLabel lblChef;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblStad;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JTextPane tpBeskrivning;
    // End of variables declaration//GEN-END:variables
}
