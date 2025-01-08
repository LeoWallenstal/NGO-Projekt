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
    private Avdelning valdAvdelning;
    private AvdelningsRegister avdelningsRegister;
    private DefaultTableModel tabell;
    private JPanel glassPaneOverlay;
    private String vy;

    private String orginalNamn;
    private String orginalBeskrivning;
    private String orginalAdress;
    private String orginalStad;
    private String orginalEpost;
    private String orginalTelefonnummer;
    private String orginalChefNamn;
    private String orginalChefId;
    
    private String nyttChefId;

    /**
     * Creates new form Avdelning
     */
    public RedigeraAvdelningFonster(InfDB idb, Anvandare inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        avdelningsRegister = new AvdelningsRegister(idb);
        valdAvdelning = avdelningsRegister.getAvdelningFranId(inloggadAnvandare.getAvdelningsID());
        initComponents();
        btnSpara.setEnabled(false);
        btnAterstall.setEnabled(false);
        tabell = (DefaultTableModel) anstalldTable.getModel();
        initGlassPane();
        initKolumner();
        initCB();
        visaAnstallda();
        uppdateraAvdelningsInfo(valdAvdelning);
        vy = "Alla";
        setLocationRelativeTo(null);
    }

    
    private void uppdateraAnstallda(Avdelning avdelning) {
        tabell.setRowCount(0);
        for (Anvandare enAnstalld : avdelning.getAvdelningensAnstallda()) {
            String roll = "";
            if (!enAnstalld.isAdmin()) {
                roll = "Handläggare";
                tabell.addRow(new Object[]{enAnstalld.getAnstallningsID(),enAnstalld.getFullNamn(), enAnstalld.getEPost(), roll});
            }
        }
    }
    
    private void uppdateraAvdelningsInfo(Avdelning avdelning) {
    uppdateraAnstallda(avdelning);
    orginalNamn = avdelning.getNamn();
    orginalBeskrivning = avdelning.getBeskrivning();
    orginalAdress = avdelning.getAdress();
    orginalStad = avdelning.getStad().getNamn();
    orginalEpost = avdelning.getEpost();
    orginalTelefonnummer = avdelning.getTelefonnummer();
    orginalChefNamn = avdelning.getChef().getFullNamn();
    orginalChefId = avdelning.getChef().getAnstallningsID();
    nyttChefId = avdelning.getChef().getAnstallningsID();

    tfAvdelningsNamn.setText(orginalNamn);
    taBeskrivning.setText(orginalBeskrivning);
    tfAdress.setText(orginalAdress);
    tfStad.setText(orginalStad);
    tfEpost.setText(orginalEpost);
    tfTelefon.setText(orginalTelefonnummer);
    lblChef.setText(orginalChefNamn);
}

    private void uppdateraAvdelning(){
        //valdAvdelning = new Avdelning(valdAvdelning.getAvdelningsID(),idb);
        uppdateraAvdelningsInfo(valdAvdelning);
        initCB();
    }
    
    private void bytAvdelning(){
        String valdAvdelningNamn = (String) cbAvdelningar.getSelectedItem();
        for (Avdelning avdelning : avdelningsRegister.getLista()) {
            if (avdelning.getNamn().equals(valdAvdelningNamn)) {
                valdAvdelning = avdelning;
                uppdateraAvdelningsInfo(avdelning);
                break;
            }
        }
    }
    
    private void initCB(){
        cbAvdelningar.removeAllItems();
        for(Avdelning enAvdelning : avdelningsRegister.getLista()){
            cbAvdelningar.addItem(enAvdelning.getNamn());
        }
        cbAvdelningar.setSelectedItem(valdAvdelning.getNamn());
        
        cbAvdelningar.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (!cbAvdelningar.isEnabled()) { // Index -1 indicates the "selected" display
                label.setText("Du kan inte byta avdelning med osparade ändringar");
            }

            return label;
        }
    });
    }
    
    private boolean harOsparadeAndringar() {
        if (!orginalNamn.equals(tfAvdelningsNamn.getText())) {
            return true;
        }
        if (!orginalBeskrivning.equals(taBeskrivning.getText())) {
            return true;
        }
        if (!orginalAdress.equals(tfAdress.getText())) {
            return true;
        }
        if (!orginalStad.equals(tfStad.getText())) {
            return true;
        }
        if (!orginalEpost.equals(tfEpost.getText())) {
            return true;
        }
        if (!orginalTelefonnummer.equals(tfTelefon.getText())) {
            return true;
        }
        if (!orginalChefNamn.equals(lblChef.getText())) {
            return true;
        }
        return false;
    }

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

                // Exkludera sokfalt
                paintExcludedComponent(g2d, sokfalt);

                // Exkludera sokBtn
                paintExcludedComponent(g2d, sokBtn);

                // Exkludera sokCB
                paintExcludedComponent(g2d, sokCB);

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
        JComponent[] exkluderadeKomponenter = {jScrollPane1,sokfalt, sokBtn, sokCB};

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
                        Point tabellPunkt = SwingUtilities.convertPoint(glassPaneOverlay, e.getPoint(), anstalldTable);
                        int valdRad = anstalldTable.rowAtPoint(tabellPunkt);

                        if (valdRad != -1) {
                            // Säkerställ rätt kolumnindex (t.ex. 0 för namn)
                            String chefNamn = anstalldTable.getValueAt(valdRad, 1).toString();
                            nyttChefId = anstalldTable.getValueAt(valdRad, 0).toString();
                            glassPaneOverlay.setVisible(false);
                            lblChef.setText(chefNamn);
                        }
                    }

                    return; // Sluta efter att händelsen skickats till första matchande komponent
                }
            }
        }

        // Om händelsen är utanför alla exkluderade komponenter
        if (e.getID() == MouseEvent.MOUSE_CLICKED) {
            glassPaneOverlay.setVisible(false);
            System.out.println("Overlay dold.");
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
        lblChef = new javax.swing.JLabel();
        cbAvdelningar = new javax.swing.JComboBox<>();
        btnSpara = new javax.swing.JButton();
        btnAterstall = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDG Sweden - Redigera avdelning");
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/appLogo.png")).getImage());
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
        tfAvdelningsNamn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAvdelningsNamnKeyTyped(evt);
            }
        });

        tfAdress.setText("jTextField3");
        tfAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAdressActionPerformed(evt);
            }
        });
        tfAdress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAdressKeyTyped(evt);
            }
        });

        tfStad.setText("jTextField4");
        tfStad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStadActionPerformed(evt);
            }
        });
        tfStad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfStadKeyTyped(evt);
            }
        });

        tfEpost.setText("jTextField5");
        tfEpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEpostActionPerformed(evt);
            }
        });
        tfEpost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEpostKeyTyped(evt);
            }
        });

        tfTelefon.setText("jTextField6");
        tfTelefon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelefonKeyTyped(evt);
            }
        });

        jTextField7.setEditable(false);
        jTextField7.setText("Klicka här för att välja en ny chef");
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
        taBeskrivning.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                taBeskrivningKeyTyped(evt);
            }
        });

        lblChef.setText("jLabel7");
        lblChef.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblChefPropertyChange(evt);
            }
        });
        lblChef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblChefKeyTyped(evt);
            }
        });

        cbAvdelningar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAvdelningar.setName(""); // NOI18N
        cbAvdelningar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAvdelningarItemStateChanged(evt);
            }
        });
        cbAvdelningar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAvdelningarActionPerformed(evt);
            }
        });

        btnSpara.setText("Spara");
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        btnAterstall.setText("Återställ");
        btnAterstall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAterstallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfAvdelningsNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                            .addComponent(cbAvdelningar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(taBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(tfAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3)
                                    .addGap(29, 29, 29)
                                    .addComponent(tfStad, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(13, 13, 13)
                                            .addComponent(jLabel4))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)))
                                    .addGap(29, 29, 29)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfEpost)
                                        .addComponent(tfTelefon)
                                        .addComponent(lblChef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(sokCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sokfalt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(sokBtn))
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTillbaka)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSpara)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAterstall)))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfAvdelningsNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChef, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sokfalt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sokBtn)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sokCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cbAvdelningar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTillbaka)
                    .addComponent(btnSpara)
                    .addComponent(btnAterstall))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        if (harOsparadeAndringar()) {
            new OsparadeAndringarFonster(idb, inloggadAnvandare, "Avdelning", this).setVisible(true);
        } else {
            this.setVisible(false);
            new MenyFonster(idb, inloggadAnvandare).setVisible(true);
        }
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void anstalldTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anstalldTableMouseClicked
        int rad = anstalldTable.rowAtPoint(evt.getPoint());
        int kolumn = anstalldTable.columnAtPoint(evt.getPoint());

        String kolumnnamn = tabell.getColumnName(kolumn);

        if (kolumnnamn.equals("Namn") && (rad >= 0 && rad < anstalldTable.getRowCount())) {
            Anvandare aktuellAnstalld = valdAvdelning.getAnstalld(rad);

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
        if (!sokfalt.getText().isEmpty()) {
            if (sokCB.getSelectedItem().equals("Namn")) {
                valdAvdelning.hamtaSokNamn(sokfalt.getText());
                rensaDataFonster();
                visaAnstallda();
                vy = "Sökt";
            } else if (sokCB.getSelectedItem().equals("Epost")) {
                valdAvdelning.hamtaSokEpost(sokfalt.getText());
                rensaDataFonster();
                visaAnstallda();
                vy = "Sökt";
            } else {
                resetFonster();
            }
        } else {
            resetFonster();
        }
    }//GEN-LAST:event_sokBtnMouseClicked

    private void sokfaltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sokfaltMouseClicked
        sokfalt.setText("");
        sokfalt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_sokfaltMouseClicked

    private void sokCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sokCBActionPerformed
        if (sokCB.getSelectedItem().equals("Namn")) {
            sokfalt.setEnabled(true);
            sokfalt.setText("Sök namn...");
            if (vy.equals("Sökt")) {
                resetFonster();
                vy = "Alla";
            }
        } else if (sokCB.getSelectedItem().equals("Epost")) {
            sokfalt.setText("Sök epost...");
            sokfalt.setEnabled(true);
            if (vy.equals("Sökt")) {
                resetFonster();
                vy = "Alla";
            }
        } else if (sokCB.getSelectedItem().equals("Sök efter...")) {
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

    private void cbAvdelningarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAvdelningarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAvdelningarActionPerformed

    private void cbAvdelningarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAvdelningarItemStateChanged
        bytAvdelning();
    }//GEN-LAST:event_cbAvdelningarItemStateChanged

    private void tfAvdelningsNamnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAvdelningsNamnKeyTyped
        if(tfAvdelningsNamn.getText().equals(orginalNamn)){
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        }
        else{
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_tfAvdelningsNamnKeyTyped

    private void taBeskrivningKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taBeskrivningKeyTyped
        if(taBeskrivning.getText().equals(orginalBeskrivning)){
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        }
        else{
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_taBeskrivningKeyTyped

    private void tfAdressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAdressKeyTyped
        if(tfAdress.getText().equals(orginalAdress)){
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        }
        else{
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_tfAdressKeyTyped

    private void tfStadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfStadKeyTyped
        if(tfStad.getText().equals(orginalStad)){
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        }
        else{
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_tfStadKeyTyped

    private void tfEpostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEpostKeyTyped
        if(tfEpost.getText().equals(orginalEpost)){
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        }
        else{
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_tfEpostKeyTyped

    private void tfTelefonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonKeyTyped
        if(tfTelefon.getText().equals(orginalTelefonnummer)){
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        }
        else{
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_tfTelefonKeyTyped

    private void lblChefPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblChefPropertyChange
        if(nyttChefId != null && nyttChefId.equals(orginalChefId)&&!harOsparadeAndringar()){
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        }
        else{
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_lblChefPropertyChange

    private void lblChefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblChefKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lblChefKeyTyped

    private void btnAterstallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAterstallActionPerformed
        String valdAvdelningNamn = (String) cbAvdelningar.getSelectedItem();
        for (Avdelning avdelning : avdelningsRegister.getLista()) {
            if (avdelning.getNamn().equals(valdAvdelningNamn)) {
                valdAvdelning = avdelning;
                uppdateraAvdelningsInfo(avdelning);
                break;
            }
        }
    }//GEN-LAST:event_btnAterstallActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        boolean formatKorrekt = true;
        // Validering här
        if(formatKorrekt){
            boolean lyckadDbUpdate = valdAvdelning.updateUppgifter(tfAvdelningsNamn.getText(),taBeskrivning.getText(),
                    tfAdress.getText(),tfEpost.getText(),tfTelefon.getText(),nyttChefId);
            if(lyckadDbUpdate){
                uppdateraAvdelning();
                btnSpara.setEnabled(false);
                btnAterstall.setEnabled(false);
                cbAvdelningar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnSparaActionPerformed

    private void initKolumner() {
        tabell.addColumn("AID");
        tabell.addColumn("Namn"); //denna ska gömmas senare
        tabell.addColumn("Epost");
        tabell.addColumn("Roll");

        //Förhindrar användaren från att editera cellerna direkt
        anstalldTable.setDefaultEditor(Object.class, null);
        TableColumnModel columnModel = anstalldTable.getColumnModel();
        columnModel.getColumn(0).setMinWidth(0);
        columnModel.getColumn(0).setMaxWidth(0);
        columnModel.getColumn(0).setWidth(0);
    }

    /**
     * @param args the command line arguments
     */
    private void visaAnstallda() {
        for (Anvandare enAnstalld : valdAvdelning.getAvdelningensAnstallda()) {
            String roll = "";
            if (enAnstalld.isAdmin()) {
                roll = "Administratör";
            } else {
                roll = "Handläggare";
            }
            tabell.addRow(new Object[]{enAnstalld.getFullNamn(), enAnstalld.getEPost(), roll});
        }
    }

    private void rensaDataFonster() {
        //Tar bort datan
        tabell.getDataVector().clear();

        //Tar bort datan från fönstret också.
        anstalldTable.repaint();

    }

    ;
    
    public void resetFonster() {
        rensaDataFonster();
        valdAvdelning.hamtaAnstallda();
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
    private javax.swing.JButton btnAterstall;
    private javax.swing.JButton btnSpara;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JComboBox<String> cbAvdelningar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblChef;
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
