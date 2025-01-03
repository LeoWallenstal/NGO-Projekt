/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024.fonster;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.awt.*;
import ngo2024.Anvandare;
import ngo2024.Avdelning;

/**
 *
 * @author walle
 */
public class MenyFonster extends javax.swing.JFrame {

    private final InfDB idb;
    private Anvandare inloggadAnvandare;
    
    /**
     * Creates new form Meny
     */
    public MenyFonster(InfDB idb, Anvandare inloggadAnvandare) {
        this.idb = idb;
        this.inloggadAnvandare = inloggadAnvandare;
        String inloggadNamn = inloggadAnvandare.getFullNamn();
        initComponents();
        setLocationRelativeTo(null);
        checkBehorighet();
        lblInloggadAnvandare.setText(inloggadNamn);
    }
    
    private void checkBehorighet()
    {
        if(!inloggadAnvandare.isAdmin())
        {
            btnAnstallda.setVisible(false);
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

        lblInloggadAnvandare = new javax.swing.JLabel();
        lblValkommen = new javax.swing.JLabel();
        btnUppgifter = new javax.swing.JButton();
        btnAvdelning = new javax.swing.JButton();
        btnProjekt = new javax.swing.JButton();
        btnAnstallda = new javax.swing.JButton();
        btnMal_3 = new javax.swing.JButton();
        btnMal_4 = new javax.swing.JButton();
        btnMal_5 = new javax.swing.JButton();
        btnMal_8 = new javax.swing.JButton();
        btnMal_10 = new javax.swing.JButton();
        btnMal_9 = new javax.swing.JButton();
        btnMal_13 = new javax.swing.JButton();
        btnMal_14 = new javax.swing.JButton();
        btnMal_15 = new javax.swing.JButton();
        btnMal_1 = new javax.swing.JButton();
        btnMal_6 = new javax.swing.JButton();
        btnMal_11 = new javax.swing.JButton();
        btnMal_16 = new javax.swing.JButton();
        btnMal_2 = new javax.swing.JButton();
        btnMal_7 = new javax.swing.JButton();
        btnMal_12 = new javax.swing.JButton();
        btnMal_17 = new javax.swing.JButton();
        tpMalInfoText = new javax.swing.JTextPane();
        loggaUtButton = new javax.swing.JButton();
        partnersButton = new javax.swing.JButton();
        btnLander = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDG Sweden - Start");
        setMinimumSize(new java.awt.Dimension(1020, 576));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInloggadAnvandare.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblInloggadAnvandare.setText("namn");
        getContentPane().add(lblInloggadAnvandare, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        lblValkommen.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblValkommen.setText("Välkommen");
        getContentPane().add(lblValkommen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        btnUppgifter.setText("Mina uppgifter");
        btnUppgifter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUppgifterActionPerformed(evt);
            }
        });
        getContentPane().add(btnUppgifter, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 130, -1));

        btnAvdelning.setText("Min avdelning");
        btnAvdelning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvdelningActionPerformed(evt);
            }
        });
        getContentPane().add(btnAvdelning, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 130, -1));

        btnProjekt.setText("Projekt");
        btnProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjektActionPerformed(evt);
            }
        });
        getContentPane().add(btnProjekt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, -1));

        btnAnstallda.setText("Hantera anställda");
        btnAnstallda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnstalldaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnstallda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, -1));

        btnMal_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/03-god-halsa-och-valbefinnande.png"))); // NOI18N
        btnMal_3.setBorderPainted(false);
        btnMal_3.setContentAreaFilled(false);
        btnMal_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, -1));

        btnMal_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/04-god-utbildning-for-alla-logo-1.png"))); // NOI18N
        btnMal_4.setBorderPainted(false);
        btnMal_4.setContentAreaFilled(false);
        btnMal_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_4ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, -1));

        btnMal_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/05-jamstalldhet.png"))); // NOI18N
        btnMal_5.setBorderPainted(false);
        btnMal_5.setContentAreaFilled(false);
        btnMal_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_5ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));

        btnMal_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/08-anstandiga-arbetsvillkor-och-ekonomisk-tillvaxt.png"))); // NOI18N
        btnMal_8.setBorderPainted(false);
        btnMal_8.setContentAreaFilled(false);
        btnMal_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_8ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, -1, -1));

        btnMal_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/10-minskad-ojamnlikhet.png"))); // NOI18N
        btnMal_10.setBorderPainted(false);
        btnMal_10.setContentAreaFilled(false);
        btnMal_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_10ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, -1, -1));

        btnMal_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/09-hallbar-industri-innovationer-och-infrastruktur.png"))); // NOI18N
        btnMal_9.setBorderPainted(false);
        btnMal_9.setContentAreaFilled(false);
        btnMal_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_9ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, -1, -1));

        btnMal_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/13-bekampa-klimatforandringarna.png"))); // NOI18N
        btnMal_13.setBorderPainted(false);
        btnMal_13.setContentAreaFilled(false);
        btnMal_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_13ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, -1, -1));

        btnMal_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/14_hav_och_marina_resurser.png"))); // NOI18N
        btnMal_14.setBorderPainted(false);
        btnMal_14.setContentAreaFilled(false);
        btnMal_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_14ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, -1, -1));

        btnMal_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/15_ekosystem.png"))); // NOI18N
        btnMal_15.setBorderPainted(false);
        btnMal_15.setContentAreaFilled(false);
        btnMal_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_15ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, -1, -1));

        btnMal_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/01-ingen-fattigdom.png"))); // NOI18N
        btnMal_1.setBorderPainted(false);
        btnMal_1.setContentAreaFilled(false);
        btnMal_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, -1, -1));

        btnMal_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/06-rent-vatten-och-sanitet-for-alla.png"))); // NOI18N
        btnMal_6.setBorderPainted(false);
        btnMal_6.setContentAreaFilled(false);
        btnMal_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_6ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, -1, -1));

        btnMal_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/11-hallbara-stader-och-samhallen.png"))); // NOI18N
        btnMal_11.setBorderPainted(false);
        btnMal_11.setContentAreaFilled(false);
        btnMal_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_11ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 340, -1, -1));

        btnMal_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/Sustainable-Development-Goals_icons-16-1.png"))); // NOI18N
        btnMal_16.setBorderPainted(false);
        btnMal_16.setContentAreaFilled(false);
        btnMal_16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_16ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 450, -1, -1));

        btnMal_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/02-ingen-hunger.png"))); // NOI18N
        btnMal_2.setBorderPainted(false);
        btnMal_2.setContentAreaFilled(false);
        btnMal_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 120, -1, -1));

        btnMal_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/07-hallbar-energi-for-alla.png"))); // NOI18N
        btnMal_7.setBorderPainted(false);
        btnMal_7.setContentAreaFilled(false);
        btnMal_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_7ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 230, -1, -1));

        btnMal_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/12-hallbar-konsumtion-och-produktion.png"))); // NOI18N
        btnMal_12.setBorderPainted(false);
        btnMal_12.setContentAreaFilled(false);
        btnMal_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_12ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 340, -1, -1));

        btnMal_17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/goals_icons/17_genomforande_och_partnerskap-logo.png"))); // NOI18N
        btnMal_17.setBorderPainted(false);
        btnMal_17.setContentAreaFilled(false);
        btnMal_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMal_17ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMal_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 450, -1, -1));

        tpMalInfoText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tpMalInfoText.setText("Klicka på ett utav målen för att läsa mer!");
        tpMalInfoText.setFocusable(false);
        tpMalInfoText.setOpaque(false);
        getContentPane().add(tpMalInfoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 320, 90));

        loggaUtButton.setText("Logga ut");
        loggaUtButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loggaUtButtonMouseClicked(evt);
            }
        });
        loggaUtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loggaUtButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loggaUtButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        partnersButton.setText("Partners");
        partnersButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partnersButtonMouseClicked(evt);
            }
        });
        partnersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partnersButtonActionPerformed(evt);
            }
        });
        getContentPane().add(partnersButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 130, -1));

        btnLander.setText("Länder");
        btnLander.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanderActionPerformed(evt);
            }
        });
        getContentPane().add(btnLander, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUppgifterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUppgifterActionPerformed
        new MinaUppgifterFonster(idb, inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnUppgifterActionPerformed

    private void btnProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProjektActionPerformed
        new ProjektFonster(idb, inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnProjektActionPerformed

    private void btnMal_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_3ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,3).setVisible(true);
    }//GEN-LAST:event_btnMal_3ActionPerformed

    private void btnMal_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_4ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,4).setVisible(true);
    }//GEN-LAST:event_btnMal_4ActionPerformed

    private void btnMal_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_5ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,5).setVisible(true);
    }//GEN-LAST:event_btnMal_5ActionPerformed

    private void btnMal_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_8ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,8).setVisible(true);
    }//GEN-LAST:event_btnMal_8ActionPerformed

    private void btnMal_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_10ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,10).setVisible(true);
    }//GEN-LAST:event_btnMal_10ActionPerformed

    private void btnMal_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_9ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,9).setVisible(true);
    }//GEN-LAST:event_btnMal_9ActionPerformed

    private void btnMal_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_13ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,13).setVisible(true);
    }//GEN-LAST:event_btnMal_13ActionPerformed

    private void btnMal_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_14ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,14).setVisible(true);
    }//GEN-LAST:event_btnMal_14ActionPerformed

    private void btnMal_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_15ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,15).setVisible(true);
    }//GEN-LAST:event_btnMal_15ActionPerformed

    private void btnMal_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_1ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,1).setVisible(true);
    }//GEN-LAST:event_btnMal_1ActionPerformed

    private void btnMal_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_6ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,6).setVisible(true);
    }//GEN-LAST:event_btnMal_6ActionPerformed

    private void btnMal_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_11ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,11).setVisible(true);
    }//GEN-LAST:event_btnMal_11ActionPerformed

    private void btnMal_16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_16ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,16).setVisible(true);
    }//GEN-LAST:event_btnMal_16ActionPerformed

    private void btnMal_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_2ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,2).setVisible(true);
    }//GEN-LAST:event_btnMal_2ActionPerformed

    private void btnMal_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_7ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,7).setVisible(true);
    }//GEN-LAST:event_btnMal_7ActionPerformed

    private void btnMal_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_12ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,12).setVisible(true);
    }//GEN-LAST:event_btnMal_12ActionPerformed

    private void btnMal_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMal_17ActionPerformed
        // TODO add your handling code here:
        new MalInfoFonster(idb,17).setVisible(true);
    }//GEN-LAST:event_btnMal_17ActionPerformed

    private void btnAvdelningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvdelningActionPerformed
        // TODO add your handling code here:
        new AvdelningFonster(idb,inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAvdelningActionPerformed

    private void loggaUtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loggaUtButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loggaUtButtonActionPerformed

    private void loggaUtButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loggaUtButtonMouseClicked
        new InloggningFonster(idb).setVisible(true);
                this.setVisible(false);
    }//GEN-LAST:event_loggaUtButtonMouseClicked

    private void btnAnstalldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnstalldaActionPerformed
        new HanteraAnstalldaFonster(idb, inloggadAnvandare).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAnstalldaActionPerformed

    private void partnersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partnersButtonActionPerformed
        new PartnerFonster(inloggadAnvandare, idb).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_partnersButtonActionPerformed

    private void partnersButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partnersButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_partnersButtonMouseClicked

    private void btnLanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanderActionPerformed
        new LandFonster(inloggadAnvandare, idb).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLanderActionPerformed

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
            java.util.logging.Logger.getLogger(MenyFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenyFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenyFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenyFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Meny().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnstallda;
    private javax.swing.JButton btnAvdelning;
    private javax.swing.JButton btnLander;
    private javax.swing.JButton btnMal_1;
    private javax.swing.JButton btnMal_10;
    private javax.swing.JButton btnMal_11;
    private javax.swing.JButton btnMal_12;
    private javax.swing.JButton btnMal_13;
    private javax.swing.JButton btnMal_14;
    private javax.swing.JButton btnMal_15;
    private javax.swing.JButton btnMal_16;
    private javax.swing.JButton btnMal_17;
    private javax.swing.JButton btnMal_2;
    private javax.swing.JButton btnMal_3;
    private javax.swing.JButton btnMal_4;
    private javax.swing.JButton btnMal_5;
    private javax.swing.JButton btnMal_6;
    private javax.swing.JButton btnMal_7;
    private javax.swing.JButton btnMal_8;
    private javax.swing.JButton btnMal_9;
    private javax.swing.JButton btnProjekt;
    private javax.swing.JButton btnUppgifter;
    private javax.swing.JLabel lblInloggadAnvandare;
    private javax.swing.JLabel lblValkommen;
    private javax.swing.JButton loggaUtButton;
    private javax.swing.JButton partnersButton;
    private javax.swing.JTextPane tpMalInfoText;
    // End of variables declaration//GEN-END:variables
}
