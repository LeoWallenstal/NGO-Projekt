/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import oru.inf.InfDB;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import ngo2024.Anvandare;
import ngo2024.Projekt;
import ngo2024.Avdelning;
import ngo2024.AnvandarRegister;
import oru.inf.InfException;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import ngo2024.AvdelningsRegister;

/**
 *
 * @author Gastinlogg
 */
public class HanteraAnstalldaFonster extends javax.swing.JFrame {

    private InfDB idb;
    private Anvandare inloggadAnvandare;
    private AvdelningsRegister avdelningsRegister;

    private boolean taBort;
    private boolean bytRoll;
    private DefaultTableModel tabell;
    private AnvandarRegister anstallda;
    private JPanel glassPaneOverlay;
    private HashMap<String, Anvandare> anstalldaMap;

    /**
     * Creates new form HanteraAnstallda
     */
    public HanteraAnstalldaFonster(InfDB idb, Anvandare inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        avdelningsRegister = new AvdelningsRegister(idb);
        anstalldaMap = new HashMap<>();
        taBort = false;
        bytRoll = false;
        anstallda = new AnvandarRegister(idb);
        initComponents();
        tabell = (DefaultTableModel) tblAnstallda.getModel();
        setLocationRelativeTo(null);
        visaAnstallda();
        tblAnstallda.setDefaultEditor(Object.class, null);
        setLocationRelativeTo(null);
        initGlassPane();
        lblInfoTaBort.setVisible(false);
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
        tblAnstallda = new javax.swing.JTable();
        btnLaggTillAnstalld = new javax.swing.JButton();
        btnTaBortAnstalld = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();
        lblInfoTaBort = new javax.swing.JLabel();
        btnBytRoll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDG Sweden - Anställda");
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/appLogo.png")).getImage());
        setMaximumSize(new java.awt.Dimension(1020, 576));
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        tblAnstallda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AnställningsID", "Namn", "Roll", "Avdelning"
            }
        ));
        tblAnstallda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAnstalldaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAnstallda);

        btnLaggTillAnstalld.setText("Registrera anställd");
        btnLaggTillAnstalld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillAnstalldActionPerformed(evt);
            }
        });

        btnTaBortAnstalld.setText("Ta bort anställd");
        btnTaBortAnstalld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortAnstalldActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        btnBytRoll.setText("Byt roll");
        btnBytRoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBytRollActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTillbaka)
                        .addGap(18, 18, 18)
                        .addComponent(btnLaggTillAnstalld)
                        .addGap(18, 18, 18)
                        .addComponent(btnTaBortAnstalld)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInfoTaBort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBytRoll)))
                .addGap(49, 235, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTillbaka)
                    .addComponent(btnLaggTillAnstalld)
                    .addComponent(btnTaBortAnstalld)
                    .addComponent(lblInfoTaBort)
                    .addComponent(btnBytRoll))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void initGlassPane() {
        glassPaneOverlay = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g.create();

                // Rita halvgenomskinlig svart överlagring
                g2d.setColor(new Color(0, 0, 0, 150));
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Exkludera jScrollPane1
                paintExcludedComponent(g2d, jScrollPane1);
                g2d.dispose();
            }

            private void paintExcludedComponent(Graphics2D g2d, JComponent komponent) {
                // Spara aktuellt tillstånd
                Graphics2D gCopy = (Graphics2D) g2d.create();

                // Hämta komponentens position och bounds
                Point komponentPlats = SwingUtilities.convertPoint(komponent.getParent(), komponent.getLocation(), this);

                // Översätt grafikens kontext till komponentens position
                gCopy.translate(komponentPlats.x, komponentPlats.y);

                // Måla komponenten
                komponent.paint(gCopy);

                // Återställ grafikens kontext
                gCopy.dispose();
            }
        };

        // Säkerställ att glaspanelen är transparent
        glassPaneOverlay.setOpaque(false);

        // Vidarebefordra mus- och mushjulshändelser till exkluderade komponenter
        glassPaneOverlay.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                vidarebefordraMusHandelse(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                vidarebefordraMusHandelse(e);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                vidarebefordraMusHandelse(e);
            }
        });

        glassPaneOverlay.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                vidarebefordraMusHandelse(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                vidarebefordraMusHandelse(e);
            }
        });

        glassPaneOverlay.addMouseWheelListener(e -> vidarebefordraMusHjulHandelse(e));

        setGlassPane(glassPaneOverlay);
    }

    private void vidarebefordraMusHandelse(MouseEvent e) {
        // Lista över exkluderade komponenter
        JComponent[] exkluderadeKomponenter = {jScrollPane1};

        for (JComponent komponent : exkluderadeKomponenter) {
            if (komponent != null && komponent.isVisible()) {
                // Hämta komponentens bounds och position
                Rectangle komponentBounds = komponent.getBounds();
                Point komponentPlats = SwingUtilities.convertPoint(komponent.getParent(), komponent.getLocation(), glassPaneOverlay);
                komponentBounds.setLocation(komponentPlats);

                if (komponentBounds.contains(e.getPoint())) {
                    // Översätt musens händelse till komponentens koordinater
                    Point översattPunkt = SwingUtilities.convertPoint(glassPaneOverlay, e.getPoint(), komponent);

                    // Vidarebefordra händelsen
                    MouseEvent nyHandelse = new MouseEvent(
                            komponent,
                            e.getID(),
                            e.getWhen(),
                            e.getModifiersEx(),
                            översattPunkt.x,
                            översattPunkt.y,
                            e.getClickCount(),
                            e.isPopupTrigger(),
                            e.getButton()
                    );

                    komponent.dispatchEvent(nyHandelse);

                    // Hantera radval om JTable är i JScrollPane
                    if (komponent == jScrollPane1 && e.getID() == MouseEvent.MOUSE_CLICKED) {
                        // Översätt punkt till JTable-koordinater
                        Point tabellPunkt = SwingUtilities.convertPoint(glassPaneOverlay, e.getPoint(), tblAnstallda);
                        int valdRad = tblAnstallda.rowAtPoint(tabellPunkt);

                        if (valdRad != -1) {
                            // Säkerställ rätt kolumnindex (t.ex. 0 för namn)

                            if (valdRad >= 0 && valdRad < tblAnstallda.getRowCount()) {

                                // Hämta värdet från den första kolumnen (aid)
                                String aid = tblAnstallda.getValueAt(valdRad, 0).toString();

                                if (taBort) {
                                    // Skapa och öppna ett nytt fönster som skickar med aid
                                    new VarningJaNejFonster(anstalldaMap.get(aid), this).setVisible(true);
                                }
                             else if (bytRoll) {
                                    anstalldaMap.get(aid).bytRoll();
                                    reset();
                                    visaAnstallda();
                            }
                            }
                        }
                    }

                    return; // Sluta efter att händelsen skickats till första matchande komponent
                }
            }
        }

        // Om händelsen är utanför alla exkluderade komponenter
        if (e.getID() == MouseEvent.MOUSE_CLICKED) {
            glassPaneOverlay.setVisible(false);
            btnTaBortAnstalld.setEnabled(true);
            lblInfoTaBort.setVisible(false);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    private void vidarebefordraMusHjulHandelse(MouseWheelEvent e) {
        // Lista över exkluderade komponenter (fokusera på jScrollPane1 för scrollning)
        JComponent[] exkluderadeKomponenter = {jScrollPane1};

        for (JComponent komponent : exkluderadeKomponenter) {
            // Hämta komponentens bounds och position
            Rectangle komponentBounds = komponent.getBounds();
            Point komponentPlats = SwingUtilities.convertPoint(komponent.getParent(), komponent.getLocation(), glassPaneOverlay);
            komponentBounds.setLocation(komponentPlats);

            // Kontrollera om mushjulseventet är inom komponentens bounds
            if (komponentBounds.contains(e.getPoint())) {
                // Översätt mushjulsevent till komponentens koordinater
                MouseWheelEvent nyHandelse = new MouseWheelEvent(
                        komponent,
                        e.getID(),
                        e.getWhen(),
                        e.getModifiersEx(),
                        e.getX() - komponentPlats.x,
                        e.getY() - komponentPlats.y,
                        e.getClickCount(),
                        e.isPopupTrigger(),
                        e.getScrollType(),
                        e.getScrollAmount(),
                        e.getWheelRotation()
                );

                // Skicka händelsen till komponenten
                komponent.dispatchEvent(nyHandelse);
                return; // Sluta efter att händelsen skickats till första matchande komponent
            }
        }
    }

    private void btnLaggTillAnstalldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillAnstalldActionPerformed
        new RegistreraAnstalldFonster(idb, inloggadAnvandare, this).setVisible(true);
    }//GEN-LAST:event_btnLaggTillAnstalldActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        new MenyFonster(idb, inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTillbakaActionPerformed

    public void reset() {
        glassPaneOverlay.setVisible(false);
        btnTaBortAnstalld.setEnabled(true);
        lblInfoTaBort.setVisible(false);
        taBort = false;
        tabell.setRowCount(0);
        tblAnstallda.repaint();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void btnTaBortAnstalldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortAnstalldActionPerformed
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.taBort = true;
        btnTaBortAnstalld.setEnabled(false);
        glassPaneOverlay.setVisible(true);
        glassPaneOverlay.revalidate();
        glassPaneOverlay.repaint();
    }//GEN-LAST:event_btnTaBortAnstalldActionPerformed

    private void tblAnstalldaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAnstalldaMouseClicked
        // Hämta raden som är vald när musen klickar
    }//GEN-LAST:event_tblAnstalldaMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

    }//GEN-LAST:event_formWindowGainedFocus

    private void btnBytRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBytRollActionPerformed
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.bytRoll = true;
        btnTaBortAnstalld.setEnabled(false);
        lblInfoTaBort.setVisible(true);
        glassPaneOverlay.setVisible(true);
        glassPaneOverlay.revalidate();
        glassPaneOverlay.repaint();
    }//GEN-LAST:event_btnBytRollActionPerformed

    public void deleteAnstalld(Anvandare anvandareTaBort) {
        System.out.println(avdelningsRegister.getAvdelningFranId(anvandareTaBort.getAvdelningsID()).removeAnstalld(anvandareTaBort.getAnstallningsID()));
        anvandareTaBort.deleteAnvandareDb();
        reset();
        visaAnstallda();
    }

    public void visaAnstallda() {
        tblAnstallda.repaint();
        avdelningsRegister.hamtaAllaAvdelningar();
        for (Avdelning enAvdelning : avdelningsRegister.getLista()) {
            for (Anvandare enAnstalld : enAvdelning.getAvdelningensAnstallda()) {
                String roll = "";
                if (enAnstalld.isAdmin()) {
                    roll = "Administratör";
                } else {
                    roll = "Handläggare";
                }
                this.anstalldaMap.put(enAnstalld.getAnstallningsID(), enAnstalld);
                tabell.addRow(new Object[]{enAnstalld.getAnstallningsID(),
                    enAnstalld.getFullNamn(),
                    roll,
                    enAvdelning.getNamn()
                });
            }
        }
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
            java.util.logging.Logger.getLogger(HanteraAnstalldaFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HanteraAnstalldaFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HanteraAnstalldaFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HanteraAnstalldaFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new HanteraAnstallda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBytRoll;
    private javax.swing.JButton btnLaggTillAnstalld;
    private javax.swing.JButton btnTaBortAnstalld;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfoTaBort;
    private javax.swing.JTable tblAnstallda;
    // End of variables declaration//GEN-END:variables
}
