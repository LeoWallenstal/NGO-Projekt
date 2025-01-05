/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;
import java.awt.Font;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import ngo2024.*;

/**
 *
 * @author walle
 */
public class RedigeraAvdelningFonster extends javax.swing.JFrame {

    private InfDB idb;
    private Anvandare inloggadAnvandare;
    private Avdelning anvandarensAvdelning; 
    private DefaultTableModel tabell;
     private JPanel glassPaneOverlay;
    private String vy;
    
    /**
     * Creates new form Avdelning
     */
    public RedigeraAvdelningFonster(InfDB idb,Anvandare inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        anvandarensAvdelning = new Avdelning(inloggadAnvandare.getAvdelningsID(), idb);
        
        initComponents();
        tabell = (DefaultTableModel) anstalldTable.getModel();
        
        setLocationRelativeTo(null);
        initKolumner();
        visaAnstallda();
        setAvdelningsUppgifter();
        initGlassPane();
        vy = "Alla";
        
        
    }

    private void initGlassPane() {
    glassPaneOverlay = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();

            // Draw semi-transparent black overlay
            g2d.setColor(new Color(0, 0, 0, 150));
            g2d.fillRect(0, 0, getWidth(), getHeight());

            // Exclude jScrollPane1
            paintExcludedComponent(g2d, jScrollPane1);

            // Exclude sokfalt
            paintExcludedComponent(g2d, sokfalt);

            // Exclude sokBtn
            paintExcludedComponent(g2d, sokBtn);

            // Exclude sokCB
            paintExcludedComponent(g2d, sokCB);

            g2d.dispose();
        }

        private void paintExcludedComponent(Graphics2D g2d, JComponent component) {
            // Save the current state
            Graphics2D gCopy = (Graphics2D) g2d.create();

            // Get the bounds and location of the component
            Point componentLocation = SwingUtilities.convertPoint(component.getParent(), component.getLocation(), this);

            // Translate graphics context to the component's position
            gCopy.translate(componentLocation.x, componentLocation.y);

            // Paint the component
            component.paint(gCopy);

            // Dispose the copied graphics context
            gCopy.dispose();
        }
    };

    // Ensure the glass pane is transparent
    glassPaneOverlay.setOpaque(false);

    // Forward mouse and mouse wheel events to excluded components
    glassPaneOverlay.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            forwardMouseEvent(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            forwardMouseEvent(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            forwardMouseEvent(e);
        }
    });

    glassPaneOverlay.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseMoved(MouseEvent e) {
            forwardMouseEvent(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            forwardMouseEvent(e);
        }
    });

    glassPaneOverlay.addMouseWheelListener(e -> forwardMouseWheelEvent(e));

    setGlassPane(glassPaneOverlay);
}

    private void forwardMouseEvent(MouseEvent e) {
    // List of excluded components
    JComponent[] excludedComponents = {jScrollPane1, sokfalt, sokBtn, sokCB};

    boolean clickedInsideExcluded = false;

    for (JComponent component : excludedComponents) {
        // Get the component's bounds and location
        Rectangle componentBounds = component.getBounds();
        Point componentLocation = SwingUtilities.convertPoint(component.getParent(), component.getLocation(), glassPaneOverlay);
        componentBounds.setLocation(componentLocation);

        // Check if the mouse event is within the component's bounds
        if (componentBounds.contains(e.getPoint())) {
            // Translate the mouse event to the component's coordinates
            MouseEvent newEvent = SwingUtilities.convertMouseEvent(glassPaneOverlay, e, component);

            // Dispatch the event to the component
            component.dispatchEvent(newEvent);

            // Indicate that the click was inside an excluded component
            clickedInsideExcluded = true;
            break; // Stop checking further components
        }
    }

    // If the click was outside all excluded components, hide the overlay
    if (!clickedInsideExcluded && e.getID() == MouseEvent.MOUSE_CLICKED) {
        glassPaneOverlay.setVisible(false);
    }
}

    private void forwardMouseWheelEvent(MouseWheelEvent e) {
    // List of excluded components (focus on jScrollPane1 for scrolling)
    JComponent[] excludedComponents = {jScrollPane1};

    for (JComponent component : excludedComponents) {
        // Get the component's bounds and location
        Rectangle componentBounds = component.getBounds();
        Point componentLocation = SwingUtilities.convertPoint(component.getParent(), component.getLocation(), glassPaneOverlay);
        componentBounds.setLocation(componentLocation);

        // Check if the mouse wheel event is within the component's bounds
        if (componentBounds.contains(e.getPoint())) {
            // Translate the mouse wheel event to the component's coordinates
            MouseWheelEvent newEvent = new MouseWheelEvent(
                component,
                e.getID(),
                e.getWhen(),
                e.getModifiersEx(),
                e.getX() - componentLocation.x,
                e.getY() - componentLocation.y,
                e.getClickCount(),
                e.isPopupTrigger(),
                e.getScrollType(),
                e.getScrollAmount(),
                e.getWheelRotation()
            );

            // Dispatch the event to the component
            component.dispatchEvent(newEvent);
            return; // Stop after dispatching to the first matching component
        }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        anstalldTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JButton();
        sokfalt = new javax.swing.JTextField();
        sokBtn = new javax.swing.JButton();
        sokCB = new javax.swing.JComboBox<>();
        tfAvdelningsNamn = new javax.swing.JTextField();
        tfAdress = new javax.swing.JTextField();
        tfStad = new javax.swing.JTextField();
        tfEpost = new javax.swing.JTextField();
        tfTelefon = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        taBeskrivning = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDG Sweden - Min avdelning");
        setMinimumSize(new java.awt.Dimension(1020, 576));
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Avdelnings beskrivning:");

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

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        sokfalt.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        sokfalt.setText("Sök anställd...");
        sokfalt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sokfaltMouseClicked(evt);
            }
        });

        sokBtn.setText("Sök");
        sokBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sokBtnMouseClicked(evt);
            }
        });

        sokCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sök efter...", "Namn", "Epost" }));
        sokCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sokCBActionPerformed(evt);
            }
        });

        tfAvdelningsNamn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tfAvdelningsNamn.setText("jTextField1");
        tfAvdelningsNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAvdelningsNamnActionPerformed(evt);
            }
        });

        tfAdress.setText("jTextField3");
        tfAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAdressActionPerformed(evt);
            }
        });

        tfStad.setText("jTextField4");
        tfStad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStadActionPerformed(evt);
            }
        });

        tfEpost.setText("jTextField5");
        tfEpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEpostActionPerformed(evt);
            }
        });

        tfTelefon.setText("jTextField6");

        jTextField7.setEditable(false);
        jTextField7.setText("Klicka här för att välja en anställd");
        jTextField7.setFocusable(false);
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });

        taBeskrivning.setColumns(20);
        taBeskrivning.setLineWrap(true);
        taBeskrivning.setRows(5);
        taBeskrivning.setWrapStyleWord(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(sokCB, javax.swing.GroupLayout.Alignment.LEADING, 0, 112, Short.MAX_VALUE)
                                    .addComponent(sokfalt, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(29, 29, 29)
                                .addComponent(sokBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfTelefon)
                                        .addGap(88, 88, 88))))
                            .addComponent(taBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfStad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(jLabel4)
                                    .addGap(29, 29, 29)
                                    .addComponent(tfEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(tfAvdelningsNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTillbaka))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfAvdelningsNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sokfalt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sokBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sokCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
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
            new AnstalldInfoFonster(inloggadAnvandare, aktuellAnstalld).setVisible(true);
        }
    }//GEN-LAST:event_anstalldTableMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void tfAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAdressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAdressActionPerformed

    private void tfEpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEpostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEpostActionPerformed

    private void tfStadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfStadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfStadActionPerformed

    private void tfAvdelningsNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAvdelningsNamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAvdelningsNamnActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void sokBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sokBtnMouseClicked
        if(!sokfalt.getText().isEmpty()){
            if(sokCB.getSelectedItem().equals("Namn")){
                anvandarensAvdelning.hamtaSokNamn(sokfalt.getText());
                rensaDataFonster();
                visaAnstallda();
                vy = "Sökt";
            }
            else if(sokCB.getSelectedItem().equals("Epost")){
                anvandarensAvdelning.hamtaSokEpost(sokfalt.getText());
                rensaDataFonster();
                visaAnstallda();
                vy = "Sökt";
            }
            else{
                resetFonster();
            }
        }
        else{
            resetFonster();
        }
    }//GEN-LAST:event_sokBtnMouseClicked

    private void sokfaltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sokfaltMouseClicked
        sokfalt.setText("");
        sokfalt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_sokfaltMouseClicked

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
        else if(sokCB.getSelectedItem().equals("Sök efter...")){
            sokfalt.setEnabled(false);
            sokfalt.setText("Sök anställd...");
        }
    }//GEN-LAST:event_sokCBActionPerformed

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        glassPaneOverlay.setVisible(true);
        glassPaneOverlay.revalidate();
        glassPaneOverlay.repaint();
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyPressed

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
    private void setAvdelningsUppgifter(){
        tfAvdelningsNamn.setText(anvandarensAvdelning.getNamn());
        taBeskrivning.setText(anvandarensAvdelning.getBeskrivning());
   
        tfAdress.setText(anvandarensAvdelning.getAdress());
        
        tfStad.setText(anvandarensAvdelning.getStad().getNamn());
        
        tfEpost.setText(anvandarensAvdelning.getEpost());
        
        tfTelefon.setText(anvandarensAvdelning.getTelefonnummer());
        
        //lblChef.setText(anvandarensAvdelning.getChef().getFullNamn());
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
            java.util.logging.Logger.getLogger(RedigeraAvdelningFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedigeraAvdelningFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedigeraAvdelningFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedigeraAvdelningFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton sokBtn;
    private javax.swing.JComboBox<String> sokCB;
    private javax.swing.JTextField sokfalt;
    private javax.swing.JTextArea taBeskrivning;
    private javax.swing.JTextField tfAdress;
    private javax.swing.JTextField tfAvdelningsNamn;
    private javax.swing.JTextField tfEpost;
    private javax.swing.JTextField tfStad;
    private javax.swing.JTextField tfTelefon;
    // End of variables declaration//GEN-END:variables
}
