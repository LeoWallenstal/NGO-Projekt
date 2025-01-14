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
    private StadRegister stadRegister;
    private HashMap<String, Stad> stadMap;
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
        stadMap = new HashMap<>();
        avdelningsRegister = new AvdelningsRegister(idb);
        stadRegister = new StadRegister(idb);
        valdAvdelning = avdelningsRegister.getAvdelningFranId(inloggadAnvandare.getAvdelningsID());
        initComponents();
        anstalldTable.getTableHeader().setReorderingAllowed(false);
        btnSpara.setEnabled(false);
        btnAterstall.setEnabled(false);
        tabell = (DefaultTableModel) anstalldTable.getModel();
        initGlassPane();
        initStadCB();
        initKolumner();
        initAvdelningCB();
        uppdateraAvdelningsInfo();
        vy = "Alla";
        setLocationRelativeTo(null);
        doljFelMeddelanden();
    }

    private void doljFelMeddelanden() {

        taFelMNamn.setVisible(false);
        lblFelMEpost.setVisible(false);
        lblFelMTelefon.setVisible(false);
        lblFelMTomt.setVisible(false);
    }

    private void uppdateraAnstallda() {
        tabell.setRowCount(0);
        for (Anvandare enAnstalld : valdAvdelning.getAvdelningensAnstallda()) {
            String roll = "";
            if (!enAnstalld.isAdmin()) {
                roll = "Handläggare";
                tabell.addRow(new Object[]{enAnstalld.getAnstallningsID(), enAnstalld.getFullNamn(), enAnstalld.getEPost(), roll});
            }
        }
    }

    private void uppdateraAvdelningsInfo() {
        uppdateraAnstallda();
        orginalNamn = valdAvdelning.getNamn();
        orginalBeskrivning = valdAvdelning.getBeskrivning();
        orginalAdress = valdAvdelning.getAdress();
        orginalStad = valdAvdelning.getStad().getNamn();
        orginalEpost = valdAvdelning.getEpost();
        orginalTelefonnummer = valdAvdelning.getTelefonnummer();
        orginalChefNamn = valdAvdelning.getChef().getFullNamn();
        orginalChefId = valdAvdelning.getChef().getAnstallningsID();
        nyttChefId = valdAvdelning.getChef().getAnstallningsID();

        tfAvdelningsNamn.setText(orginalNamn);
        taBeskrivning.setText(orginalBeskrivning);
        tfAdress.setText(orginalAdress);
        cbStad.setSelectedItem(orginalStad);
        tfEpost.setText(orginalEpost);
        tfTelefon.setText(orginalTelefonnummer);
        lblChef.setText(orginalChefNamn);
    }

    private void uppdateraAvdelning() {
        //valdAvdelning = new Avdelning(valdAvdelning.getAvdelningsID(),idb);
        uppdateraAvdelningsInfo();
        initAvdelningCB();
    }

    private void bytAvdelning() {
        String valdAvdelningNamn = (String) cbAvdelningar.getSelectedItem();
        for (Avdelning avdelning : avdelningsRegister.getLista()) {
            if (avdelning.getNamn().equals(valdAvdelningNamn)) {
                valdAvdelning = avdelning;
                uppdateraAvdelningsInfo();
                break;
            }
        }
    }

    private void initAvdelningCB() {
        cbAvdelningar.removeAllItems();
        for (Avdelning enAvdelning : avdelningsRegister.getLista()) {
            cbAvdelningar.addItem(enAvdelning.getNamn());
        }
        cbAvdelningar.setSelectedItem(valdAvdelning.getNamn());

        cbAvdelningar.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (!cbAvdelningar.isEnabled()) {
                    label.setText("Du kan inte byta avdelning med osparade ändringar");
                }

                return label;
            }
        });
    }

    private void initStadCB() {
        cbStad.removeAllItems();
        for (Stad enStad : stadRegister.getLista()) {
            String stadNamn = enStad.getNamn();
            stadMap.put(stadNamn, enStad);
            cbStad.addItem(stadNamn);
        }

        cbStad.setSelectedItem(valdAvdelning.getStad().getNamn());
    }

    private boolean harOsparadeAndringar() {
        if (orginalNamn != null && !orginalNamn.equals(tfAvdelningsNamn.getText())) {
            return true;
        }
        if (orginalBeskrivning != null && !orginalBeskrivning.equals(taBeskrivning.getText())) {
            return true;
        }
        if (orginalAdress != null && !orginalAdress.equals(tfAdress.getText())) {
            return true;
        }
        if (orginalStad != null && !orginalStad.equals(cbStad.getSelectedItem())) {
            return true;
        }
        if (orginalEpost != null && !orginalEpost.equals(tfEpost.getText())) {
            return true;
        }
        if (orginalTelefonnummer != null && !orginalTelefonnummer.equals(tfTelefon.getText())) {
            return true;
        }
        if (orginalChefNamn != null && !orginalChefNamn.equals(lblChef.getText())) {
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
        JComponent[] exkluderadeKomponenter = {jScrollPane1, sokfalt, sokBtn, sokCB};

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
        tfEpost = new javax.swing.JTextField();
        tfTelefon = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        taBeskrivning = new javax.swing.JTextArea();
        lblChef = new javax.swing.JLabel();
        cbAvdelningar = new javax.swing.JComboBox<>();
        btnSpara = new javax.swing.JButton();
        btnAterstall = new javax.swing.JButton();
        cbStad = new javax.swing.JComboBox<>();
        lblFelMTelefon = new javax.swing.JLabel();
        lblFelMTomt = new javax.swing.JLabel();
        taFelMNamn = new javax.swing.JTextArea();
        lblFelMEpost = new javax.swing.JLabel();

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

        lblChef.setText("lblChef");
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

        cbStad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbStad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbStadItemStateChanged(evt);
            }
        });

        lblFelMTelefon.setForeground(new java.awt.Color(255, 0, 51));
        lblFelMTelefon.setText("Telefonnumret är skrivet i felaktigt format!");

        lblFelMTomt.setForeground(new java.awt.Color(255, 0, 51));
        lblFelMTomt.setText("Inget av fälten får vara tomt!");

        taFelMNamn.setEditable(false);
        taFelMNamn.setColumns(20);
        taFelMNamn.setForeground(new java.awt.Color(255, 0, 51));
        taFelMNamn.setLineWrap(true);
        taFelMNamn.setRows(5);
        taFelMNamn.setText("Avdelningens namn måste\nanges i endast bokstäver!");
        taFelMNamn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblFelMEpost.setForeground(new java.awt.Color(255, 0, 51));
        lblFelMEpost.setText("Epost bör följa format: exempel@domän.com!");

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTillbaka)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSpara)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAterstall)
                                .addGap(18, 18, 18)
                                .addComponent(lblFelMTomt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAvdelningar, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(89, 89, 89)
                                .addComponent(taFelMNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(sokCB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sokfalt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(sokBtn))
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(taBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblFelMTelefon))
                                    .addComponent(tfAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbStad, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblChef, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblFelMEpost)))))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tfAvdelningsNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(taFelMNamn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(taBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(cbStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFelMEpost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFelMTelefon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChef, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sokfalt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sokBtn))))
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
                    .addComponent(btnAterstall)
                    .addComponent(lblFelMTomt))
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
        
    }//GEN-LAST:event_anstalldTableMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void tfAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAdressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAdressActionPerformed

    private void tfEpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEpostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEpostActionPerformed

    private void tfAvdelningsNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAvdelningsNamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAvdelningsNamnActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed

    }//GEN-LAST:event_jTextField7ActionPerformed

    private void sokBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sokBtnMouseClicked
        if (!sokfalt.getText().isEmpty()) {
            if (sokCB.getSelectedItem().equals("Namn")) {
                valdAvdelning.hamtaAnstallda();
                valdAvdelning.hamtaSokNamn(sokfalt.getText());
                rensaDataFonster();
                uppdateraAnstallda();
                vy = "Sökt";
            } else if (sokCB.getSelectedItem().equals("Epost")) {
                valdAvdelning.hamtaAnstallda();
                valdAvdelning.hamtaSokEpost(sokfalt.getText());
                rensaDataFonster();
                uppdateraAnstallda();
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
        if (!harOsparadeAndringar()) {
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        } else {
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_tfAvdelningsNamnKeyTyped

    private void taBeskrivningKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taBeskrivningKeyTyped
        if (!harOsparadeAndringar()) {
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        } else {
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_taBeskrivningKeyTyped

    private void tfAdressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAdressKeyTyped
        if (!harOsparadeAndringar()) {
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        } else {
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_tfAdressKeyTyped

    private void tfEpostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEpostKeyTyped
        if (!harOsparadeAndringar()) {
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        } else {
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_tfEpostKeyTyped

    private void tfTelefonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonKeyTyped
        if (!harOsparadeAndringar()) {
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        } else {
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_tfTelefonKeyTyped

    private void lblChefPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblChefPropertyChange
        if (!harOsparadeAndringar()) {
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        } else {
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
                uppdateraAvdelningsInfo();
                break;
            }
        }
    }//GEN-LAST:event_btnAterstallActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        boolean formatKorrekt = true;
        String namn = tfAvdelningsNamn.getText();
        String beskrivning = taBeskrivning.getText();
        String adress = tfAdress.getText();
        String epost = tfEpost.getText();
        String telefon = tfTelefon.getText();

        //Om något/alla textfält är tomma skrivs ett felmeddelande ut
        if (namn.isEmpty() || beskrivning.isEmpty() || adress.isEmpty() || epost.isEmpty() || telefon.isEmpty()) {
            formatKorrekt = false;
            lblFelMTomt.setVisible(true);
        }

        //Validerar om avdelningens namn är skrivet i bokstäver
        if (!Validerare.arBokstaver(namn)) {
            formatKorrekt = false;
            taFelMNamn.setVisible(true);
        }

        //Validerar formatet på epostadressen
        if (!Validerare.arEpostAdress(epost)) {
            formatKorrekt = false;
            lblFelMEpost.setVisible(true);
        }

        //Validerar formatet på telefonnumret
        if (!Validerare.arTelefonnummer(telefon)) {
            formatKorrekt = false;
            lblFelMTelefon.setVisible(true);
        }

        if (formatKorrekt) {
            String stadId = stadMap.get(cbStad.getSelectedItem().toString()).getStadID();
            boolean lyckadDbUpdate = valdAvdelning.updateUppgifter(tfAvdelningsNamn.getText(), taBeskrivning.getText(),
                    tfAdress.getText(), stadId, tfEpost.getText(), tfTelefon.getText(), nyttChefId);
            if (lyckadDbUpdate) {
                uppdateraAvdelning();
                btnSpara.setEnabled(false);
                btnAterstall.setEnabled(false);
                cbAvdelningar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnSparaActionPerformed

    private void cbStadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbStadItemStateChanged
        if (!harOsparadeAndringar()) {
            btnSpara.setEnabled(false);
            btnAterstall.setEnabled(false);
            cbAvdelningar.setEnabled(true);
        } else {
            btnSpara.setEnabled(true);
            btnAterstall.setEnabled(true);
            cbAvdelningar.setEnabled(false);
        }
    }//GEN-LAST:event_cbStadItemStateChanged

    private void sokBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sokBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sokBtnActionPerformed

    private void initKolumner() {
        tabell.addColumn("AID");
        tabell.addColumn("Namn");
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
        uppdateraAnstallda();
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
    private javax.swing.JComboBox<String> cbStad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblChef;
    private javax.swing.JLabel lblFelMEpost;
    private javax.swing.JLabel lblFelMTelefon;
    private javax.swing.JLabel lblFelMTomt;
    private javax.swing.JButton sokBtn;
    private javax.swing.JComboBox<String> sokCB;
    private javax.swing.JTextField sokfalt;
    private javax.swing.JTextArea taBeskrivning;
    private javax.swing.JTextArea taFelMNamn;
    private javax.swing.JTextField tfAdress;
    private javax.swing.JTextField tfAvdelningsNamn;
    private javax.swing.JTextField tfEpost;
    private javax.swing.JTextField tfTelefon;
    // End of variables declaration//GEN-END:variables
}
