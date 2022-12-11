/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.poo_edfinalproject;

import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class MenuAdminScreen extends javax.swing.JFrame {

    /**
     * Creates new form MenuScreen
     */
    public MenuAdminScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        empName = new javax.swing.JLabel();
        bgCadastrarFreteButton = new javax.swing.JPanel();
        cadastrarFreteButton = new javax.swing.JLabel();
        bgCargaDescargaCamiaoButton = new javax.swing.JPanel();
        cargaDescargaCaminhaoButton = new javax.swing.JLabel();
        bgLogOutButton = new javax.swing.JPanel();
        logoutButton = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 67, 86));

        empName.setFont(new java.awt.Font("Eras Demi ITC", 1, 36)); // NOI18N
        empName.setForeground(new java.awt.Color(255, 255, 255));
        empName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empName.setText("DS Solucoes Logisticas");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(empName, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(empName, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 120));

        bgCadastrarFreteButton.setBackground(new java.awt.Color(0, 67, 86));

        cadastrarFreteButton.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        cadastrarFreteButton.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarFreteButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cadastrarFreteButton.setText("Cadastrar Fretes");
        cadastrarFreteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadastrarFreteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastrarFreteButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cadastrarFreteButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cadastrarFreteButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgCadastrarFreteButtonLayout = new javax.swing.GroupLayout(bgCadastrarFreteButton);
        bgCadastrarFreteButton.setLayout(bgCadastrarFreteButtonLayout);
        bgCadastrarFreteButtonLayout.setHorizontalGroup(
            bgCadastrarFreteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastrarFreteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        bgCadastrarFreteButtonLayout.setVerticalGroup(
            bgCadastrarFreteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastrarFreteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(bgCadastrarFreteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        bgCargaDescargaCamiaoButton.setBackground(new java.awt.Color(0, 67, 86));

        cargaDescargaCaminhaoButton.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        cargaDescargaCaminhaoButton.setForeground(new java.awt.Color(255, 255, 255));
        cargaDescargaCaminhaoButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cargaDescargaCaminhaoButton.setText("Separar / Fechar Cargas");
        cargaDescargaCaminhaoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargaDescargaCaminhaoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargaDescargaCaminhaoButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cargaDescargaCaminhaoButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cargaDescargaCaminhaoButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgCargaDescargaCamiaoButtonLayout = new javax.swing.GroupLayout(bgCargaDescargaCamiaoButton);
        bgCargaDescargaCamiaoButton.setLayout(bgCargaDescargaCamiaoButtonLayout);
        bgCargaDescargaCamiaoButtonLayout.setHorizontalGroup(
            bgCargaDescargaCamiaoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cargaDescargaCaminhaoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        bgCargaDescargaCamiaoButtonLayout.setVerticalGroup(
            bgCargaDescargaCamiaoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cargaDescargaCaminhaoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(bgCargaDescargaCamiaoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, 60));

        bgLogOutButton.setBackground(new java.awt.Color(0, 67, 86));

        logoutButton.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutButton.setText("Logout");
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgLogOutButtonLayout = new javax.swing.GroupLayout(bgLogOutButton);
        bgLogOutButton.setLayout(bgLogOutButtonLayout);
        bgLogOutButtonLayout.setHorizontalGroup(
            bgLogOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        bgLogOutButtonLayout.setVerticalGroup(
            bgLogOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        bg.add(bgLogOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, 60));

        lblMenu.setFont(new java.awt.Font("Eras Demi ITC", 0, 36)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(0, 67, 86));
        lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu.setText("Menu Principal");
        bg.add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 310, 50));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 450, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarFreteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastrarFreteButtonMouseEntered
        bgCadastrarFreteButton.setBackground(new Color(127, 224, 251));
        cadastrarFreteButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_cadastrarFreteButtonMouseEntered

    private void cadastrarFreteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastrarFreteButtonMouseExited
        bgCadastrarFreteButton.setBackground(new Color(0, 67, 86));
        cadastrarFreteButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_cadastrarFreteButtonMouseExited

    private void cargaDescargaCaminhaoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargaDescargaCaminhaoButtonMouseEntered
        bgCargaDescargaCamiaoButton.setBackground(new Color(127, 224, 251));
        cargaDescargaCaminhaoButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_cargaDescargaCaminhaoButtonMouseEntered

    private void cargaDescargaCaminhaoButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargaDescargaCaminhaoButtonMouseExited
        bgCargaDescargaCamiaoButton.setBackground(new Color(0, 67, 86));
        cargaDescargaCaminhaoButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_cargaDescargaCaminhaoButtonMouseExited

    private void logoutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseEntered
        bgLogOutButton.setBackground(new Color(127, 224, 251));
        logoutButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_logoutButtonMouseEntered

    private void logoutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseExited
        bgLogOutButton.setBackground(new Color(0, 67, 86));
        logoutButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_logoutButtonMouseExited

    private void cadastrarFreteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastrarFreteButtonMouseClicked
        CadastroFreteScreen cadastrarFrete = new CadastroFreteScreen();
        cadastrarFrete.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cadastrarFreteButtonMouseClicked

    private void cargaDescargaCaminhaoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargaDescargaCaminhaoButtonMouseClicked
        CargaDescargaScreen cargaDescarga = new CargaDescargaScreen();
        cargaDescarga.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cargaDescargaCaminhaoButtonMouseClicked

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        LogScreen login = new LogScreen();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutButtonMouseClicked

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
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel bgCadastrarFreteButton;
    private javax.swing.JPanel bgCargaDescargaCamiaoButton;
    private javax.swing.JPanel bgLogOutButton;
    private javax.swing.JLabel cadastrarFreteButton;
    private javax.swing.JLabel cargaDescargaCaminhaoButton;
    private javax.swing.JLabel empName;
    private javax.swing.JPanel header;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel logoutButton;
    // End of variables declaration//GEN-END:variables
}
