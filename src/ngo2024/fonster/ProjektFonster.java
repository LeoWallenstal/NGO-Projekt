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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ngo2024.Anvandare;
import ngo2024.Projekt;
import ngo2024.ProjektRegister;
import ngo2024.Projektstatus;
import ngo2024.SokKategori;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;

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
    private ArrayList<Projekt> attVisa;

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
        sokfalt.setEnabled(false);
        sokfalt.setText("Sök efter...");
        sokfalt.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        attVisa = projektregister.getAllaProjekt();

        setKnappar();   //Sätter visibility på knappar beroende på behörighet
        initKolumner(); //Skapar och namnsätter kolumner

        visaData(attVisa);
        setLocationRelativeTo(null);

        projektTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
                        && (columnName.equals("Projektnamn") || columnName.equals("Projektchef"))) {

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

        projektTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                int row = projektTable.rowAtPoint(evt.getPoint());
                int column = projektTable.columnAtPoint(evt.getPoint());

                if (row != hoveredRow || column != hoveredColumn) {
                    hoveredRow = row;
                    hoveredColumn = column;
                    projektTable.repaint();
                }
            }
        });

        projektTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                int row = projektTable.rowAtPoint(evt.getPoint());
                int column = projektTable.columnAtPoint(evt.getPoint());

                // Update hover state if inside the table
                if (row != hoveredRow || column != hoveredColumn) {
                    hoveredRow = row;
                    hoveredColumn = column;
                    projektTable.repaint();
                }
            }
        });

        projektTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                // Reset hover state when the mouse exits the table
                hoveredRow = -1;
                hoveredColumn = -1;
                projektTable.repaint();
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
        projektTable = new javax.swing.JTable();
        tillbakaButton = new javax.swing.JButton();
        sokLabel = new javax.swing.JLabel();
        sokfalt = new javax.swing.JTextField();
        sokEfterComboBox = new javax.swing.JComboBox<>();
        statusComboBox = new javax.swing.JComboBox<>();
        allaProjektButton = new javax.swing.JButton();
        avdelningensProjektButton = new javax.swing.JButton();
        minaProjektButton = new javax.swing.JButton();
        laggTillButton = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        dcStartDatum = new com.toedter.calendar.JDateChooser();
        dcSlutDatum = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDG Sweden - Projekt");
        setIconImage(new ImageIcon(getClass().getResource("/resources/icons/appLogo.png")).getImage());
        setResizable(false);

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

        lblStatus.setText("Status:");

        dcStartDatum.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcStartDatumPropertyChange(evt);
            }
        });

        dcSlutDatum.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcSlutDatumPropertyChange(evt);
            }
        });

        jLabel1.setText("Start datum:");

        jLabel2.setText("Slut datum:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(tillbakaButton))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(101, 101, 101)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(allaProjektButton, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(avdelningensProjektButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(minaProjektButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblStatus)
                                        .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(sokLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sokfalt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sokEfterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dcSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dcStartDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(laggTillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dcStartDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
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
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sokEfterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))))
                    .addComponent(laggTillButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(tillbakaButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setAttVisa(ArrayList<Projekt> attVisa) {
        this.attVisa = attVisa;
    }

    private void tillbakaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tillbakaButtonMouseClicked
        new MenyFonster(idb, inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tillbakaButtonMouseClicked

    private void sokfaltKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sokfaltKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //projektregister.refreshaAllaProjekt();
            filterStatus();
            if (sokfalt.getText().equals("")) {
                visaData(attVisa);
                return;
            }
            attVisa = projektregister.getSoktLista(kategori, sokfalt.getText(), attVisa);
            visaData(attVisa);
        }

    }//GEN-LAST:event_sokfaltKeyPressed

    private void allaProjektButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allaProjektButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allaProjektButtonActionPerformed

    private void laggTillButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laggTillButtonMouseClicked
        new LaggTillProjektFonster(inloggadAnvandare, this, projektregister, idb).setVisible(true);
    }//GEN-LAST:event_laggTillButtonMouseClicked

    private void avdelningensProjektButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avdelningensProjektButtonMouseClicked

        resetKnapparOchSokfalt();
        projektregister.refreshaAllaProjekt();
        vy = "Avdelningens projekt";
        attVisa = projektregister.getAvdelningensProjekt(inloggadAnvandare.getAvdelningsID());
        visaData(attVisa);

        allaProjektButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        avdelningensProjektButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        minaProjektButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_avdelningensProjektButtonMouseClicked

    private void allaProjektButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allaProjektButtonMouseClicked
        resetKnapparOchSokfalt();
        projektregister.refreshaAllaProjekt();
        vy = "Alla projekt";
        attVisa = projektregister.getAllaProjekt();
        visaData(attVisa);

        allaProjektButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        avdelningensProjektButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        minaProjektButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    }//GEN-LAST:event_allaProjektButtonMouseClicked

    private void minaProjektButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minaProjektButtonMouseClicked
        resetKnapparOchSokfalt();
        projektregister.refreshaAllaProjekt();

        vy = "Mina projekt";
        attVisa = projektregister.getMinaProjekt(inloggadAnvandare.getAnstallningsID());
        visaData(attVisa);

        allaProjektButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        avdelningensProjektButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        minaProjektButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
    }//GEN-LAST:event_minaProjektButtonMouseClicked

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        filterStatus();
        visaData(attVisa);
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void sokEfterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sokEfterComboBoxActionPerformed
        String status = sokEfterComboBox.getSelectedItem().toString();

        switch (status) {
            case "Sök efter..." -> {
                sokfalt.setEnabled(false);
                sokfalt.setText("Sök efter...");
                sokfalt.setFont(new Font("Segoe UI", Font.ITALIC, 12));
            }
            case "Projektchef" -> {
                kategori = SokKategori.PROJEKTCHEF;
                sokfalt.setEnabled(true);
                sokfalt.setText("Sök projektchef...");
                sokfalt.setFont(new Font("Segoe UI", Font.ITALIC, 12));
            }
            case "Projektnamn" -> {
                kategori = SokKategori.PROJEKTNAMN;
                sokfalt.setEnabled(true);
                sokfalt.setText("Sök projektnamn...");
                sokfalt.setFont(new Font("Segoe UI", Font.ITALIC, 12));
            }
        }
    }//GEN-LAST:event_sokEfterComboBoxActionPerformed

    private void projektTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projektTableMouseClicked
        int rad = projektTable.rowAtPoint(evt.getPoint());
        int kolumn = projektTable.columnAtPoint(evt.getPoint());

        String kolumnnamn = tabell.getColumnName(kolumn);

        if (kolumnnamn.equals("Projektnamn") && (rad >= 0 && rad < projektTable.getRowCount())) {
            Projekt aktuelltProjekt = attVisa.get(rad);

            //Öppnar nytt fönster som visar mer detaljerad information om ett projekt 
            new ProjektInfoFonster(inloggadAnvandare, aktuelltProjekt,
                    this, projektregister, idb).setVisible(true);
        } else if (kolumnnamn.equals("Projektchef") && (rad >= 0 && rad < projektTable.getRowCount())) {
            String cellKlickad = (String) tabell.getValueAt(rad, kolumn);

            //Om man t.ex klickat på ett projekt som inte har en projektchef, händer ingenting.
            if (cellKlickad.isEmpty()) {
                return;
            }

            Projekt aktuelltProjekt = attVisa.get(rad);

            //Öppnar nytt fönster som visar detaljerad information om en projektchef
            new ProjektchefInfoFonster(inloggadAnvandare,
                    aktuelltProjekt.getProjektchef(), idb).setVisible(true);
        }
    }//GEN-LAST:event_projektTableMouseClicked

    private void projektTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projektTableMouseMoved
        int row = projektTable.rowAtPoint(evt.getPoint());
        int column = projektTable.columnAtPoint(evt.getPoint());

        if (row >= 0 && column >= 0) {
            String columnNamn = projektTable.getColumnName(column);

            if (columnNamn.equals("Projektnamn") || columnNamn.equals("Projektchef")) {
                projektTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
                hoveredRow = row;
                hoveredColumn = column;
            } else {
                projektTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                hoveredRow = -1;
                hoveredColumn = -1;
            }
        } else {
            projektTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            hoveredRow = -1;
            hoveredColumn = -1;
        }
        projektTable.repaint();
    }//GEN-LAST:event_projektTableMouseMoved

    private void dcStartDatumPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcStartDatumPropertyChange
        if (dcStartDatum.getDate() != null) {
            String startdatum = new SimpleDateFormat("yyyy-MM-dd").format(dcStartDatum.getDate());
            dcSlutDatum.setMinSelectableDate(dcStartDatum.getDate());

            attVisa = projektregister.getListaStartdatum(startdatum, attVisa);
            visaData(attVisa);
        }
    }//GEN-LAST:event_dcStartDatumPropertyChange

    private void dcSlutDatumPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcSlutDatumPropertyChange
        if (dcSlutDatum.getDate() != null) {
            String slutdatum = new SimpleDateFormat("yyyy-MM-dd").format(dcSlutDatum.getDate());
            dcStartDatum.setMaxSelectableDate(dcSlutDatum.getDate());
            attVisa = projektregister.getListaSlutdatum(slutdatum, attVisa);
            visaData(attVisa);
        }
    }//GEN-LAST:event_dcSlutDatumPropertyChange

    private void sokfaltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sokfaltMouseClicked
        if (sokfalt.isEnabled()) {
            sokfalt.setText("");
            sokfalt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        }

    }//GEN-LAST:event_sokfaltMouseClicked

    private void sokfaltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sokfaltActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sokfaltActionPerformed

    private void filterStatus(){
        String status = statusComboBox.getSelectedItem().toString();
        projektregister.refreshaAllaProjekt();

        switch (status) {
            case "Alla": {
                if (vy.equals("Alla projekt")) {
                    attVisa = projektregister.getAllaProjekt();
                } else if (vy.equals("Avdelningens projekt")) {
                    attVisa = projektregister.getAvdelningensProjekt(inloggadAnvandare.getAvdelningsID());
                } else if (vy.equals("Mina projekt")) {
                    attVisa = projektregister.getMinaProjekt(inloggadAnvandare.getAnstallningsID());
                }
                break;
            }
            case "Pågående": {
                if (vy.equals("Alla projekt")) {
                    attVisa = projektregister.getAllaProjekt();
                } else if (vy.equals("Avdelningens projekt")) {
                    attVisa = projektregister.getAvdelningensProjekt(inloggadAnvandare.getAvdelningsID());
                } else if (vy.equals("Mina projekt")) {
                    attVisa = projektregister.getMinaProjekt(inloggadAnvandare.getAnstallningsID());
                }
                attVisa = projektregister.getListaStatus(Projektstatus.PÅGÅENDE, attVisa);
                break;
            }
            case "Planerat": {
                if (vy.equals("Alla projekt")) {
                    attVisa = projektregister.getAllaProjekt();
                } else if (vy.equals("Avdelningens projekt")) {
                    attVisa = projektregister.getAvdelningensProjekt(inloggadAnvandare.getAvdelningsID());
                } else if (vy.equals("Mina projekt")) {
                    attVisa = projektregister.getMinaProjekt(inloggadAnvandare.getAnstallningsID());
                }
                attVisa = projektregister.getListaStatus(Projektstatus.PLANERAT, attVisa);
                break;
            }
            case "Avslutat": {
                if (vy.equals("Alla projekt")) {
                    attVisa = projektregister.getAllaProjekt();
                } else if (vy.equals("Avdelningens projekt")) {
                    attVisa = projektregister.getAvdelningensProjekt(inloggadAnvandare.getAvdelningsID());
                } else if (vy.equals("Mina projekt")) {
                    attVisa = projektregister.getMinaProjekt(inloggadAnvandare.getAnstallningsID());
                }
                attVisa = projektregister.getListaStatus(Projektstatus.AVSLUTAT, attVisa);
                break;
            }
            default:
                break;
        }
    }
    
    private void initKolumner() {
        tabell.addColumn("Projektnamn");
        tabell.addColumn("Projektchef");
        tabell.addColumn("Prioritet");
        tabell.addColumn("Startdatum");

        //Förhindrar användaren från att editera cellerna direkt
        projektTable.setDefaultEditor(Object.class, null);
    }

    public void visaData(ArrayList<Projekt> attVisa) {
        rensaDataFonster();
        for (Projekt ettProjekt : attVisa) {
            if (ettProjekt.getProjektchefID() == null) {
                tabell.addRow(new Object[]{ettProjekt.getNamn(),
                    "", ettProjekt.getPrioritet(),
                    ettProjekt.getStartdatum()});
            } else {
                tabell.addRow(new Object[]{ettProjekt.getNamn(),
                    ettProjekt.getProjektchef().getFullNamn(), ettProjekt.getPrioritet(),
                    ettProjekt.getStartdatum()});
            }
        }
    }

    public void visaData() {
        rensaDataFonster();
        ArrayList<Projekt> attVisa = projektregister.hamtaAllaProjekt();

        for (Projekt ettProjekt : attVisa) {
            if (ettProjekt.getProjektchefID() == null) {
                tabell.addRow(new Object[]{ettProjekt.getNamn(),
                    "", ettProjekt.getPrioritet(),
                    ettProjekt.getStartdatum()});
            } else {
                tabell.addRow(new Object[]{ettProjekt.getNamn(),
                    ettProjekt.getProjektchef().getFullNamn(), ettProjekt.getPrioritet(),
                    ettProjekt.getStartdatum()});
            }
        }
    }

    private void rensaDataFonster() {
        //Tar bort datan
        tabell.getDataVector().clear();
        //Tar bort datan från fönstret också.
        projektTable.repaint();
    }

    ;
    
    
    private void setKnappar() {
        allaProjektButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        if (inloggadAnvandare.isAdmin()) {
            laggTillButton.setVisible(true);
        } else {
            laggTillButton.setVisible(false);
        }
    }

    private void resetKnapparOchSokfalt() {
        sokfalt.setText("Sök efter...");
        sokfalt.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        sokfalt.setEnabled(false);

        sokEfterComboBox.setSelectedIndex(0);
        statusComboBox.setSelectedIndex(0);
        dcStartDatum.setDate(null);
        dcSlutDatum.setDate(null);
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
    private com.toedter.calendar.JDateChooser dcSlutDatum;
    private com.toedter.calendar.JDateChooser dcStartDatum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton laggTillButton;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JButton minaProjektButton;
    private javax.swing.JTable projektTable;
    private javax.swing.JComboBox<String> sokEfterComboBox;
    private javax.swing.JLabel sokLabel;
    private javax.swing.JTextField sokfalt;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JButton tillbakaButton;
    // End of variables declaration//GEN-END:variables

    private void setDefaultRenderer(Class<Object> aClass, DefaultTableCellRenderer defaultTableCellRenderer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
