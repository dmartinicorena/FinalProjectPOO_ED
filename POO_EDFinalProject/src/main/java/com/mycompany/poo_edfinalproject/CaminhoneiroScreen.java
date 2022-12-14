/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.poo_edfinalproject;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author UTEC-5695
 */
public class CaminhoneiroScreen extends javax.swing.JFrame {

    File selPastaCargas = new File("cargas");
    File arquivosCarga[] = selPastaCargas.listFiles();
    Stack<Transportadora> fretesCarregados = new Stack();
    ArrayList<Transportadora> relatorioCargas = new ArrayList();
    Relatorio relatorio = new Relatorio();
    private static final SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

    /**
     * Creates new form CaminhoneiroScreen
     */
    public CaminhoneiroScreen() {
        initComponents();
        atualizarCargaSelector();
    }

    public void atualizarCargaSelector() {
        String aux;
        cargaSelector.removeAllItems();
        for (File file : arquivosCarga) {
            aux = file.toString();
            aux = aux.replace("cargas\\", "");
            cargaSelector.addItem(aux);
        }
    }

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
            fretesCarregados.clear();
            fr = new FileReader(caminhao);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                String[] t = br.readLine().split(",");
                Transportadora frete = new Transportadora();
                frete.setEnderecoClienteDestino(t[0]);
                frete.setDistancaoCidadeDestino(Float.parseFloat(t[1]));
                frete.setNomeClienteDestino(t[2]);
                frete.setNomeRemetente(t[3]);
                frete.setVolumeCarga(Float.parseFloat(t[4]));

                fretesCarregados.push(frete);
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
        refreshTela();
    }
    
    public final void LerArquivoRelatorio(File caminhao) {

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
            relatorioCargas.clear();
            fr = new FileReader(caminhao);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                String[] t = br.readLine().split(",");
                Transportadora frete = new Transportadora();
                frete.setEnderecoClienteDestino(t[0]);
                frete.setDistancaoCidadeDestino(Float.parseFloat(t[1]));
                frete.setNomeClienteDestino(t[2]);
                frete.setNomeRemetente(t[3]);
                frete.setVolumeCarga(Float.parseFloat(t[4]));

                relatorioCargas.add(frete);
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
        refreshTela();
    }

    public void refreshTela() {
        String aux = "";

        for (Transportadora frete : fretesCarregados) {
            aux += "Cidade Destino: " + frete.getEnderecoClienteDestino() + " ";
            aux += frete.getDistancaoCidadeDestino() + " km" + "\n";
            aux += "Destinatario: " + frete.getNomeClienteDestino() + "\n";
            aux += "Remetente: " + frete.getNomeRemetente() + "\n";
            aux += "Volume da Carga: " + frete.getVolumeCarga() + " M³" + "\n";
            aux += "Valor do Frete: " + frete.getVolumeCarga()
                    * 1.17 * frete.getDistancaoCidadeDestino() + "\n\n";
        }
        txtAreaFretesCarregados.setText(aux);
    }


    public void escreverArquivo(File caminhao, List<Transportadora>fretesCarregados) throws IOException {
        boolean existe = caminhao.exists();
        if (existe) {
            caminhao.delete();
        }
        FileWriter fw = new FileWriter(caminhao, true);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Transportadora frete : fretesCarregados) {
            bw.write(frete.getEnderecoClienteDestino() + ",");
            bw.write(frete.getDistancaoCidadeDestino() + ",");
            bw.write(frete.getNomeClienteDestino() + ",");
            bw.write(frete.getNomeRemetente() + ",");
            bw.write(frete.getVolumeCarga() + ",");
            bw.newLine();
        }
        bw.close();
        fw.close();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        empName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cargaSelector = new javax.swing.JComboBox<>();
        bgLogOutButton = new javax.swing.JPanel();
        carregarArquivoButton = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaFretesCarregados = new javax.swing.JTextArea();
        lblFretesCarregados = new javax.swing.JLabel();
        citySelector = new javax.swing.JComboBox<>();
        lblFretesCarregados1 = new javax.swing.JLabel();
        bgCargaDescargaCamiaoButton = new javax.swing.JPanel();
        descargaItemButton = new javax.swing.JLabel();
        bgLogOutButton1 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 67, 86));

        empName.setFont(new java.awt.Font("Eras Demi ITC", 1, 36)); // NOI18N
        empName.setForeground(new java.awt.Color(255, 255, 255));
        empName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empName.setText("DS Solucoes Logisticas");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(empName, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(empName, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
        );

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 120));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Selecione a carga");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        cargaSelector.setBackground(new java.awt.Color(255, 255, 255));
        cargaSelector.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        cargaSelector.setForeground(new java.awt.Color(102, 102, 102));
        cargaSelector.setBorder(null);
        cargaSelector.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cargaSelectorKeyPressed(evt);
            }
        });
        jPanel1.add(cargaSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 260, 30));

        bgLogOutButton.setBackground(new java.awt.Color(0, 67, 86));

        carregarArquivoButton.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        carregarArquivoButton.setForeground(new java.awt.Color(255, 255, 255));
        carregarArquivoButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        carregarArquivoButton.setText("Carregar");
        carregarArquivoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        carregarArquivoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carregarArquivoButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                carregarArquivoButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                carregarArquivoButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgLogOutButtonLayout = new javax.swing.GroupLayout(bgLogOutButton);
        bgLogOutButton.setLayout(bgLogOutButtonLayout);
        bgLogOutButtonLayout.setHorizontalGroup(
            bgLogOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(carregarArquivoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        bgLogOutButtonLayout.setVerticalGroup(
            bgLogOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(carregarArquivoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(bgLogOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 130, 40));

        jScrollPane3.setBackground(new java.awt.Color(204, 204, 204));

        txtAreaFretesCarregados.setEditable(false);
        txtAreaFretesCarregados.setBackground(new java.awt.Color(204, 255, 255));
        txtAreaFretesCarregados.setColumns(20);
        txtAreaFretesCarregados.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        txtAreaFretesCarregados.setForeground(new java.awt.Color(0, 0, 0));
        txtAreaFretesCarregados.setLineWrap(true);
        txtAreaFretesCarregados.setRows(5);
        txtAreaFretesCarregados.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(txtAreaFretesCarregados);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 230, 290));

        lblFretesCarregados.setBackground(new java.awt.Color(255, 255, 255));
        lblFretesCarregados.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lblFretesCarregados.setForeground(new java.awt.Color(0, 0, 0));
        lblFretesCarregados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFretesCarregados.setText("Selecione cidade atual");
        jPanel1.add(lblFretesCarregados, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 160, 30));

        citySelector.setBackground(new java.awt.Color(255, 255, 255));
        citySelector.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        citySelector.setForeground(new java.awt.Color(102, 102, 102));
        citySelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bage", "Pelotas", "Rio Grande" }));
        citySelector.setBorder(null);
        citySelector.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                citySelectorKeyPressed(evt);
            }
        });
        jPanel1.add(citySelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 140, 30));

        lblFretesCarregados1.setBackground(new java.awt.Color(255, 255, 255));
        lblFretesCarregados1.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lblFretesCarregados1.setForeground(new java.awt.Color(0, 0, 0));
        lblFretesCarregados1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFretesCarregados1.setText("Fretes carregados no caminhao");
        jPanel1.add(lblFretesCarregados1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 230, 30));

        bgCargaDescargaCamiaoButton.setBackground(new java.awt.Color(0, 67, 86));

        descargaItemButton.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        descargaItemButton.setForeground(new java.awt.Color(255, 255, 255));
        descargaItemButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descargaItemButton.setText("Descarregar Item");
        descargaItemButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        descargaItemButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descargaItemButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                descargaItemButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                descargaItemButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgCargaDescargaCamiaoButtonLayout = new javax.swing.GroupLayout(bgCargaDescargaCamiaoButton);
        bgCargaDescargaCamiaoButton.setLayout(bgCargaDescargaCamiaoButtonLayout);
        bgCargaDescargaCamiaoButtonLayout.setHorizontalGroup(
            bgCargaDescargaCamiaoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(descargaItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        bgCargaDescargaCamiaoButtonLayout.setVerticalGroup(
            bgCargaDescargaCamiaoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(descargaItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.add(bgCargaDescargaCamiaoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, 60));

        bgLogOutButton1.setBackground(new java.awt.Color(0, 67, 86));

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

        javax.swing.GroupLayout bgLogOutButton1Layout = new javax.swing.GroupLayout(bgLogOutButton1);
        bgLogOutButton1.setLayout(bgLogOutButton1Layout);
        bgLogOutButton1Layout.setHorizontalGroup(
            bgLogOutButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        bgLogOutButton1Layout.setVerticalGroup(
            bgLogOutButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.add(bgLogOutButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, -1, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargaSelectorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cargaSelectorKeyPressed
        // JOptionPane.showMessageDialog(rootPane, "selected");
    }//GEN-LAST:event_cargaSelectorKeyPressed

    private void carregarArquivoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carregarArquivoButtonMouseClicked
        File arquivo = new File("cargas/" + cargaSelector.getSelectedItem().toString());
        leituraArquivo(arquivo);
        cargaSelector.setEnabled(false);
        carregarArquivoButton.setEnabled(false);
        relatorio.setNomeArquivo(cargaSelector.getSelectedItem().toString());
        try {
            relatorio.abrirArquivoPDF();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaminhoneiroScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        relatorio.criarCabecalho();
        
    }//GEN-LAST:event_carregarArquivoButtonMouseClicked

    private void carregarArquivoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carregarArquivoButtonMouseEntered
        bgLogOutButton.setBackground(new Color(127, 224, 251));
        carregarArquivoButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_carregarArquivoButtonMouseEntered

    private void carregarArquivoButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carregarArquivoButtonMouseExited
        bgLogOutButton.setBackground(new Color(0, 67, 86));
        carregarArquivoButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_carregarArquivoButtonMouseExited

    private void citySelectorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_citySelectorKeyPressed
        // JOptionPane.showMessageDialog(rootPane, "selected");
    }//GEN-LAST:event_citySelectorKeyPressed

    private void descargaItemButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descargaItemButtonMouseClicked
        File arquivo = new File("cargas/" + cargaSelector.getSelectedItem().toString());
        File entregados = new File("entregados.txt");
        LerArquivoRelatorio(entregados);
        if (citySelector.getSelectedItem().toString().equalsIgnoreCase(fretesCarregados.peek().getEnderecoClienteDestino())) {
            int resp = JOptionPane.showConfirmDialog(null, "Certeza que quer descarregar o item?");
            if (resp == JOptionPane.YES_OPTION) {
                relatorioCargas.add(fretesCarregados.peek());
                try {
                    escreverArquivo(entregados,relatorioCargas);
                } catch (IOException ex) {
                    Logger.getLogger(CaminhoneiroScreen.class.getName()).log(Level.SEVERE, null, ex);
                }                
                fretesCarregados.pop();
                try {
                    escreverArquivo(arquivo,fretesCarregados);
                } catch (IOException ex) {
                    Logger.getLogger(CaminhoneiroScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                refreshTela();

            }

        } else {
            JOptionPane.showMessageDialog(null, "Deve estar na cidade de destino da encomenda");
        }
        if (fretesCarregados.isEmpty()) {
            cargaSelector.setEnabled(true);
            carregarArquivoButton.setEnabled(true);
            arquivo.delete();
            entregados.delete();
            relatorio.setEntregas(relatorioCargas);
            relatorio.criarCorpo();
            relatorio.fecharPDF();
            atualizarCargaSelector();
        }
    }//GEN-LAST:event_descargaItemButtonMouseClicked

    private void descargaItemButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descargaItemButtonMouseEntered
        bgCargaDescargaCamiaoButton.setBackground(new Color(127, 224, 251));
        descargaItemButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_descargaItemButtonMouseEntered

    private void descargaItemButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descargaItemButtonMouseExited
        bgCargaDescargaCamiaoButton.setBackground(new Color(0, 67, 86));
        descargaItemButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_descargaItemButtonMouseExited

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        LogScreen login = new LogScreen();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void logoutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseEntered
        bgLogOutButton1.setBackground(new Color(127, 224, 251));
        logoutButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_logoutButtonMouseEntered

    private void logoutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseExited
        bgLogOutButton1.setBackground(new Color(0, 67, 86));
        logoutButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_logoutButtonMouseExited

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
            java.util.logging.Logger.getLogger(CaminhoneiroScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaminhoneiroScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaminhoneiroScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaminhoneiroScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaminhoneiroScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgCargaDescargaCamiaoButton;
    private javax.swing.JPanel bgLogOutButton;
    private javax.swing.JPanel bgLogOutButton1;
    private javax.swing.JComboBox<String> cargaSelector;
    private javax.swing.JLabel carregarArquivoButton;
    private javax.swing.JComboBox<String> citySelector;
    private javax.swing.JLabel descargaItemButton;
    private javax.swing.JLabel empName;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFretesCarregados;
    private javax.swing.JLabel lblFretesCarregados1;
    private javax.swing.JLabel logoutButton;
    private javax.swing.JTextArea txtAreaFretesCarregados;
    // End of variables declaration//GEN-END:variables
}
