/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;
import java.awt.Component;
import java.awt.Font;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.*;
import javax.swing.table.*;
import ngo2024.*;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author walle
 */
public class AvdelningFonster extends javax.swing.JFrame {

    private InfDB idb;
    private Anvandare inloggadAnvandare;
    private AvdelningsRegister avdelningsRegister;
    private Avdelning anvandarensAvdelning; 
    private DefaultTableModel tabell;
    private String vy;
    
    private int hoveredRow = -1;
    private int hoveredColumn = -1;
    
    /**
     * Creates new form Avdelning
     */
    public AvdelningFonster(InfDB idb,Anvandare inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        avdelningsRegister = new AvdelningsRegister(idb);
        anvandarensAvdelning = avdelningsRegister.getAvdelningFranId(inloggadAnvandare.getAvdelningsID());
        initComponents();
        tabell = (DefaultTableModel) anstalldTable.getModel();
        anstalldTable.getTableHeader().setReorderingAllowed(false);
      
        setLocationRelativeTo(null);
        initKolumner();
        visaAnstallda();
        nySetAvdelningsUppgifter();
        vy = "Alla";
        
        anstalldTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component component = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                // Get the column name
                String columnName = table.getColumnName(column);

                // Check if the cell is hovered and belongs to Projektnamn or Projektchef
                if ((row == hoveredRow && column == hoveredColumn)
                        && (columnName.equals("Namn"))) {

                    // Apply HTML for underlined and bold text
                    if (value != null) {
                        setText("<html><b><u>" + value.toString() + "</u></b></html>");
                    }
                } else {
                    // Reset to plain text if not hovered
                    if (value != null) {
                        setText(value.toString());
                    }
                }

                return component;
            }
        });

        anstalldTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                int row = anstalldTable.rowAtPoint(evt.getPoint());
                int column = anstalldTable.columnAtPoint(evt.getPoint());

                if (row != hoveredRow || column != hoveredColumn) {
                    hoveredRow = row;
                    hoveredColumn = column;
                    anstalldTable.repaint();
                }
            }
        });

        anstalldTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                int row = anstalldTable.rowAtPoint(evt.getPoint());
                int column = anstalldTable.columnAtPoint(evt.getPoint());

                // Update hover state if inside the table
                if (row != hoveredRow || column != hoveredColumn) {
                    hoveredRow = row;
                    hoveredColumn = column;
                    anstalldTable.repaint();
                }
            }
        });

        anstalldTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Reset hover state when the mouse exits the table
                hoveredRow = -1;
                hoveredColumn = -1;
                anstalldTable.repaint();
            }
        });
        
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
        sokfalt = new javax.swing.JTextField();
        sokBtn = new javax.swing.JButton();
        sokCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDG Sweden - Min avdelning");
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/appLogo.png")).getImage());
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(1020, 576));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        anstalldTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        anstalldTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anstalldTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(anstalldTable);

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

        lblChef.setText("lblChef");

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        sokfalt.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        sokfalt.setText("Sök namn...");
        sokfalt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sokfaltMouseClicked(evt);
            }
        });
        sokfalt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sokfaltActionPerformed(evt);
            }
        });

        sokBtn.setText("Sök");
        sokBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sokBtnMouseClicked(evt);
            }
        });
        sokBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sokBtnActionPerformed(evt);
            }
        });

        sokCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Namn", "Epost" }));
        sokCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sokCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTillbaka)
                            .addComponent(lblAvdelningsNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 137, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(tpBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(sokCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sokfalt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel2)))
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblChef)
                                            .addComponent(lblTelefon)
                                            .addComponent(lblEpost)
                                            .addComponent(lblStad)
                                            .addComponent(lblAdress))))
                                .addGap(18, 18, 18)
                                .addComponent(sokBtn)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                            .addComponent(lblChef))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sokfalt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sokBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sokCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new MenyFonster(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void anstalldTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anstalldTableMouseClicked
        int rad = anstalldTable.rowAtPoint(evt.getPoint());
        int kolumn = anstalldTable.columnAtPoint(evt.getPoint());

        String kolumnnamn = tabell.getColumnName(kolumn);
        
        if(kolumnnamn.equals("Namn") && (rad >= 0 && rad < anstalldTable.getRowCount())){ 
            Anvandare aktuellAnstalld = anvandarensAvdelning.getAnstalld(rad);
            
            //Öppnar nytt fönster som visar mer detaljerad information om ett projekt 
            new MinaUppgifterFonster(idb, inloggadAnvandare, aktuellAnstalld).setVisible(true);
        }
    }//GEN-LAST:event_anstalldTableMouseClicked

    private void sokfaltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sokfaltMouseClicked
        sokfalt.setText("");
        sokfalt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_sokfaltMouseClicked

    private void sokBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sokBtnMouseClicked
        if(!sokfalt.getText().isEmpty()){
            if(sokCB.getSelectedItem().equals("Namn")){
                anvandarensAvdelning.hamtaAnstallda();
                anvandarensAvdelning.hamtaSokNamn(sokfalt.getText());
                rensaDataFonster();
                visaAnstallda();
                vy = "Sökt";
            }
            else if(sokCB.getSelectedItem().equals("Epost")){
                anvandarensAvdelning.hamtaAnstallda();
                anvandarensAvdelning.hamtaSokEpost(sokfalt.getText());
                rensaDataFonster();
                visaAnstallda();
                vy = "Sökt";
            }
            else {
                resetFonster();
            }
        }
        else{
            resetFonster();
        }
    }//GEN-LAST:event_sokBtnMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked

    private void sokCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sokCBActionPerformed
        if(sokCB.getSelectedItem().equals("Namn")){
            sokfalt.setEnabled(true);
            sokfalt.setText("Sök namn...");
            if(vy.equals("Sökt")){
                resetFonster();
                vy = "Alla";
            }
        }
        else if(sokCB.getSelectedItem().equals("Epost")){
            sokfalt.setText("Sök epost...");
            sokfalt.setEnabled(true);
            if(vy.equals("Sökt")){
                resetFonster();
                vy = "Alla";
            }
        } 
    }//GEN-LAST:event_sokCBActionPerformed

    private void sokBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sokBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sokBtnActionPerformed

    private void sokfaltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sokfaltActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sokfaltActionPerformed

    private void initKolumner(){
        tabell.addColumn("Namn"); //denna ska gömmas senare
        tabell.addColumn("Epost");
        tabell.addColumn("Roll");


        //Förhindrar användaren från att editera cellerna direkt
        anstalldTable.setDefaultEditor(Object.class, null);
    }
    
    /**
     * @param args the command line arguments
     */
    
    private void visaAnstallda(){
        for(Anvandare enAnstalld : anvandarensAvdelning.getAvdelningensAnstallda()){
            String roll = "";
            if(enAnstalld.isAdmin()){
                roll = "Administratör";
            }
            else{
                roll = "Handläggare";
            }
                tabell.addRow(new Object[]{enAnstalld.getFullNamn(), enAnstalld.getEPost(), roll});
        }
    }
      
    //Denna kan döpas om till ovan när den ovan tagits bort
    private void nySetAvdelningsUppgifter(){
        lblAvdelningsNamn.setText(anvandarensAvdelning.getNamn());
        tpBeskrivning.setText(anvandarensAvdelning.getBeskrivning());
        
        tpBeskrivning.setOpaque(false);
        tpBeskrivning.setFocusable(false);
        
        lblAdress.setText(anvandarensAvdelning.getAdress());
        
        lblStad.setText(anvandarensAvdelning.getStad().getNamn());
        
        lblEpost.setText(anvandarensAvdelning.getEpost());
        
        lblTelefon.setText(anvandarensAvdelning.getTelefonnummer());
        
        lblChef.setText(anvandarensAvdelning.getChef().getFullNamn());
    }
    
    private void rensaDataFonster(){
        //Tar bort datan
        tabell.getDataVector().clear();

        //Tar bort datan från fönstret också.
        anstalldTable.repaint();
        
    };
    
    public void resetFonster(){
        rensaDataFonster();
        anvandarensAvdelning.hamtaAnstallda();
        visaAnstallda();
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
            java.util.logging.Logger.getLogger(AvdelningFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AvdelningFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AvdelningFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AvdelningFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
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
    private javax.swing.JButton sokBtn;
    private javax.swing.JComboBox<String> sokCB;
    private javax.swing.JTextField sokfalt;
    private javax.swing.JTextPane tpBeskrivning;
    // End of variables declaration//GEN-END:variables
}
