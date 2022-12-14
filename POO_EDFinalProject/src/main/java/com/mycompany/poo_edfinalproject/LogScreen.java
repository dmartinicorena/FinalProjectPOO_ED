package com.mycompany.poo_edfinalproject;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LogScreen extends javax.swing.JFrame {
    
    File arquivoUser = new File("Usuarios.csv");
    ArrayList<Usuario> listaUser = new ArrayList();
    
    public final void leituraArquivo(File caminhao) {
        
        FileReader fr = null;
        try {
            boolean existe = caminhao.exists();
            if (!existe) {
                try {
                    FileWriter fw = new FileWriter(caminhao, true);
                } catch (IOException ex) {
                    Logger.getLogger(CadastroFreteScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            listaUser.clear();
            fr = new FileReader(caminhao);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                String[] t = br.readLine().split(",");
                Usuario user = new Usuario();
                user.setName(t[0]);
                user.setCpf(Long.parseLong(t[1]));
                user.setUser(t[2]);
                user.setPassword(t[3]);
                user.setTipoFunc((t[4]));
                
                listaUser.add(user);
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CadastroFreteScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastroFreteScreen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(CadastroFreteScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public LogScreen() {
        initComponents();
        leituraArquivo(arquivoUser);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        empName = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        lblPass = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtPass = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        enterButtonBG = new javax.swing.JPanel();
        enterButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setToolTipText("");
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, -1));

        empName.setFont(new java.awt.Font("Eras Demi ITC", 1, 36)); // NOI18N
        empName.setForeground(new java.awt.Color(255, 255, 255));
        empName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empName.setText("DS Solucoes Logisticas");
        background.add(empName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 670, 50));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 480, 20));

        lblUser.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(60, 63, 65));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Usuario");
        background.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 80, 30));

        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(153, 153, 153));
        txtUser.setToolTipText("Insira aqui seu usuario");
        txtUser.setBorder(null);
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
        });
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserMouseClicked(evt);
            }
        });
        background.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 290, 30));
        background.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 330, 20));
        background.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 330, 20));

        lblPass.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        lblPass.setForeground(new java.awt.Color(60, 63, 65));
        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPass.setText("Senha");
        background.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 80, 30));
        background.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 330, 20));

        txtPass.setBackground(new java.awt.Color(255, 255, 255));
        txtPass.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        txtPass.setForeground(new java.awt.Color(153, 153, 153));
        txtPass.setToolTipText("Insira aqui sua senha");
        txtPass.setBorder(null);
        txtPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassMouseClicked(evt);
            }
        });
        background.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 310, 30));

        jPanel1.setBackground(new java.awt.Color(127, 224, 251));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 600));

        jPanel2.setBackground(new java.awt.Color(0, 67, 86));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 850, 140));

        enterButtonBG.setBackground(new java.awt.Color(0, 67, 86));

        enterButton.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        enterButton.setForeground(new java.awt.Color(255, 255, 255));
        enterButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enterButton.setText("Entrar");
        enterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enterButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                enterButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout enterButtonBGLayout = new javax.swing.GroupLayout(enterButtonBG);
        enterButtonBG.setLayout(enterButtonBGLayout);
        enterButtonBGLayout.setHorizontalGroup(
            enterButtonBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enterButtonBGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        enterButtonBGLayout.setVerticalGroup(
            enterButtonBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enterButtonBGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        background.add(enterButtonBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 130, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained
        
    }//GEN-LAST:event_txtUserFocusGained
    
    private void enterButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enterButtonMouseEntered
        enterButtonBG.setBackground(new Color(127, 224, 251));
        enterButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_enterButtonMouseEntered
    
    private void enterButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enterButtonMouseExited
        enterButtonBG.setBackground(new Color(0, 67, 86));
        enterButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_enterButtonMouseExited
    
    private void txtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseClicked
        txtUser.setText("");
    }//GEN-LAST:event_txtUserMouseClicked
    
    private void txtPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassMouseClicked
        txtPass.setText("");
    }//GEN-LAST:event_txtPassMouseClicked
    
    private void enterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enterButtonMouseClicked
        int cont = 0;
        for (int i = 0; i < listaUser.size(); i++) {
            
            if (txtUser.getText().equals(listaUser.get(i).getUser()) && txtPass.getText().equals(listaUser.get(i).getPassword())
                    && listaUser.get(i).getTipoFunc().equals("Gerente")) {
                MenuScreen tela = new MenuScreen();
                tela.setVisible(true);
                this.dispose();
                break;
            } else if (txtUser.getText().equals(listaUser.get(i).getUser()) && txtPass.getText().equals(listaUser.get(i).getPassword())
                    && listaUser.get(i).getTipoFunc().equals("Caminhoneiro")) {
                CaminhoneiroScreen tela = new CaminhoneiroScreen();
                tela.setVisible(true);
                this.dispose();
                break;
            } else if (txtUser.getText().equals(listaUser.get(i).getUser()) && txtPass.getText().equals(listaUser.get(i).getPassword())
                    && listaUser.get(i).getTipoFunc().equals("Atendente")) {
                MenuAdminScreen tela = new MenuAdminScreen();
                tela.setVisible(true);
                this.dispose();
                break;
            }  
            
        }
        if(cont != 0){
                JOptionPane.showMessageDialog(null, "Usuario/Senha Nao encontrado");
            }
    }//GEN-LAST:event_enterButtonMouseClicked

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
            java.util.logging.Logger.getLogger(LogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel empName;
    private javax.swing.JLabel enterButton;
    private javax.swing.JPanel enterButtonBG;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
