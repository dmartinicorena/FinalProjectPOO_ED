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
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class CargaDescargaScreen extends javax.swing.JFrame {

    ArrayList<Transportadora> listaFretes = new ArrayList();
    ArrayList<Transportadora> fretesACarregar = new ArrayList();
    Stack<Transportadora> fretesCarregados = new Stack();
    File cargasRecebidas = new File("cargasRecebidas.csv");
    File caminhao = new File("caminhao.csv");

    public void refreshTela() {
        String aux = "";
        for (int i = 0; i < listaFretes.size(); i++) {
            aux += "Cidade Destino: " + listaFretes.get(i).getEnderecoClienteDestino() + " ";
            aux += listaFretes.get(i).getDistancaoCidadeDestino() + " km" + "\n";
            aux += "Destinatario: " + listaFretes.get(i).getNomeClienteDestino() + "\n";
            aux += "Remetente: " + listaFretes.get(i).getNomeRemetente() + "\n";
            aux += "Volume da Carga: " + listaFretes.get(i).getVolumeCarga() + " M³" + "\n";
            aux += "Valor do Frete: " + listaFretes.get(i).getVolumeCarga()
                    * 1.17 * listaFretes.get(i).getDistancaoCidadeDestino() + "\n\n";
        }
        txtAreaVerFretes.setText(aux);

    }

    public void refreshTelaCaminhao() {
        String aux = "";

        for (Transportadora frete : fretesACarregar) {
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

    public final void leituraArquivoCargasRecebidas() {

        FileReader fr = null;
        try {
            boolean existe = cargasRecebidas.exists();
            if (!existe) {
                try {
                    FileWriter fw = new FileWriter(cargasRecebidas, true);
                } catch (IOException ex) {
                    Logger.getLogger(CadastroFreteScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            listaFretes.clear();
            fr = new FileReader(cargasRecebidas);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                String[] t = br.readLine().split(",");
                Transportadora frete = new Transportadora();
                frete.setEnderecoClienteDestino(t[0]);
                frete.setDistancaoCidadeDestino(Float.parseFloat(t[1]));
                frete.setNomeClienteDestino(t[2]);
                frete.setNomeRemetente(t[3]);
                frete.setVolumeCarga(Float.parseFloat(t[4]));

                listaFretes.add(frete);
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

    public final void leituraArquivoCaminhao() {

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
            fretesACarregar.clear();
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

                fretesACarregar.add(frete);
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
        refreshTelaCaminhao();
    }

    public void escreverArquivoCargasRecebidas() throws IOException {
        File cargasRecebidas = new File("cargasRecebidas.csv");
        boolean existe = cargasRecebidas.exists();
        if (existe) {
            cargasRecebidas.delete();
        }
        FileWriter fw = new FileWriter(cargasRecebidas, true);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Transportadora frete : listaFretes) {
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

    public void escreverArquivoCaminhao() throws IOException {
        File caminhao = new File("caminhao.csv");
        boolean existe = caminhao.exists();
        if (existe) {
            caminhao.delete();
        }
        FileWriter fw = new FileWriter(caminhao, true);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Transportadora frete : fretesACarregar) {
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

    public CargaDescargaScreen() {
        initComponents();
        leituraArquivoCargasRecebidas();
        leituraArquivoCaminhao();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaVerFretes = new javax.swing.JTextArea();
        lblTxtBoxTitulo = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaFretesCarregados = new javax.swing.JTextArea();
        lblFretesCarregados = new javax.swing.JLabel();
        bgCadastroButton = new javax.swing.JPanel();
        carregarCaminhaoButton = new javax.swing.JLabel();
        bgCadastrarFreteButton = new javax.swing.JPanel();
        descarregarCaminhaoButton = new javax.swing.JLabel();
        bgCargaDescargaCamiaoButton = new javax.swing.JPanel();
        voltarAoMenuButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 67, 86));

        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DS Solucoes Logisticas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 120));

        jScrollPane2.setBackground(new java.awt.Color(204, 204, 204));

        txtAreaVerFretes.setEditable(false);
        txtAreaVerFretes.setBackground(new java.awt.Color(204, 255, 255));
        txtAreaVerFretes.setColumns(20);
        txtAreaVerFretes.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        txtAreaVerFretes.setForeground(new java.awt.Color(0, 0, 0));
        txtAreaVerFretes.setLineWrap(true);
        txtAreaVerFretes.setRows(5);
        txtAreaVerFretes.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(txtAreaVerFretes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 230, 350));

        lblTxtBoxTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTxtBoxTitulo.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lblTxtBoxTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTxtBoxTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTxtBoxTitulo.setText("Fretes cadastrados pendentes");
        jPanel1.add(lblTxtBoxTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 136, 230, 30));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 630, 20));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 230, 350));

        lblFretesCarregados.setBackground(new java.awt.Color(255, 255, 255));
        lblFretesCarregados.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lblFretesCarregados.setForeground(new java.awt.Color(0, 0, 0));
        lblFretesCarregados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFretesCarregados.setText("Fretes carregados no caminhao");
        jPanel1.add(lblFretesCarregados, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 230, 30));

        bgCadastroButton.setBackground(new java.awt.Color(0, 67, 86));

        carregarCaminhaoButton.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        carregarCaminhaoButton.setForeground(new java.awt.Color(255, 255, 255));
        carregarCaminhaoButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        carregarCaminhaoButton.setText("Carregar Caminhao");
        carregarCaminhaoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        carregarCaminhaoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carregarCaminhaoButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                carregarCaminhaoButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                carregarCaminhaoButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgCadastroButtonLayout = new javax.swing.GroupLayout(bgCadastroButton);
        bgCadastroButton.setLayout(bgCadastroButtonLayout);
        bgCadastroButtonLayout.setHorizontalGroup(
            bgCadastroButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(carregarCaminhaoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        bgCadastroButtonLayout.setVerticalGroup(
            bgCadastroButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(carregarCaminhaoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.add(bgCadastroButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 250, 60));

        bgCadastrarFreteButton.setBackground(new java.awt.Color(0, 67, 86));

        descarregarCaminhaoButton.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        descarregarCaminhaoButton.setForeground(new java.awt.Color(255, 255, 255));
        descarregarCaminhaoButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descarregarCaminhaoButton.setText("Descarregar Caminhao");
        descarregarCaminhaoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        descarregarCaminhaoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                descarregarCaminhaoButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                descarregarCaminhaoButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgCadastrarFreteButtonLayout = new javax.swing.GroupLayout(bgCadastrarFreteButton);
        bgCadastrarFreteButton.setLayout(bgCadastrarFreteButtonLayout);
        bgCadastrarFreteButtonLayout.setHorizontalGroup(
            bgCadastrarFreteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(descarregarCaminhaoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        bgCadastrarFreteButtonLayout.setVerticalGroup(
            bgCadastrarFreteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(descarregarCaminhaoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.add(bgCadastrarFreteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        bgCargaDescargaCamiaoButton.setBackground(new java.awt.Color(0, 67, 86));

        voltarAoMenuButton.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        voltarAoMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        voltarAoMenuButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        voltarAoMenuButton.setText("Voltar ao menu");
        voltarAoMenuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltarAoMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarAoMenuButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                voltarAoMenuButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                voltarAoMenuButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgCargaDescargaCamiaoButtonLayout = new javax.swing.GroupLayout(bgCargaDescargaCamiaoButton);
        bgCargaDescargaCamiaoButton.setLayout(bgCargaDescargaCamiaoButtonLayout);
        bgCargaDescargaCamiaoButtonLayout.setHorizontalGroup(
            bgCargaDescargaCamiaoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(voltarAoMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );
        bgCargaDescargaCamiaoButtonLayout.setVerticalGroup(
            bgCargaDescargaCamiaoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(voltarAoMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.add(bgCargaDescargaCamiaoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarCaminhaoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carregarCaminhaoButtonMouseEntered
        bgCadastroButton.setBackground(new Color(127, 224, 251));
        carregarCaminhaoButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_carregarCaminhaoButtonMouseEntered

    private void carregarCaminhaoButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carregarCaminhaoButtonMouseExited
        bgCadastroButton.setBackground(new Color(0, 67, 86));
        carregarCaminhaoButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_carregarCaminhaoButtonMouseExited

    private void descarregarCaminhaoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descarregarCaminhaoButtonMouseEntered
        bgCadastrarFreteButton.setBackground(new Color(127, 224, 251));
        descarregarCaminhaoButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_descarregarCaminhaoButtonMouseEntered

    private void descarregarCaminhaoButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descarregarCaminhaoButtonMouseExited
        bgCadastrarFreteButton.setBackground(new Color(0, 67, 86));
        descarregarCaminhaoButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_descarregarCaminhaoButtonMouseExited

    private void voltarAoMenuButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarAoMenuButtonMouseEntered
        bgCargaDescargaCamiaoButton.setBackground(new Color(127, 224, 251));
        voltarAoMenuButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_voltarAoMenuButtonMouseEntered

    private void voltarAoMenuButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarAoMenuButtonMouseExited
        bgCargaDescargaCamiaoButton.setBackground(new Color(0, 67, 86));
        voltarAoMenuButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_voltarAoMenuButtonMouseExited

    private void carregarCaminhaoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carregarCaminhaoButtonMouseClicked

        float capacidadeCaminhao = 50;

        for (int i = 0; i < listaFretes.size(); i++) {
            if (listaFretes.get(i).getVolumeCarga() <= capacidadeCaminhao) {
                capacidadeCaminhao = capacidadeCaminhao - listaFretes.get(i).getVolumeCarga();
                fretesACarregar.add(listaFretes.get(i));
                listaFretes.remove(i);
                i--;
            }
        }

        for (Transportadora frete : fretesACarregar) {
            if (frete.getEnderecoClienteDestino().equals("Rio Grande")) {
                fretesCarregados.push(frete);
            }
        }
        for (Transportadora frete : fretesACarregar) {
            if (frete.getEnderecoClienteDestino().equals("Pelotas")) {
                fretesCarregados.push(frete);
            }
        }
        for (Transportadora frete : fretesACarregar) {
            if (frete.getEnderecoClienteDestino().equals("Bage")) {
                fretesCarregados.push(frete);
            }
        }

        try {
            escreverArquivoCaminhao();
            escreverArquivoCargasRecebidas();
        } catch (IOException ex) {
            Logger.getLogger(CargaDescargaScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        refreshTela();
        refreshTelaCaminhao();

    }//GEN-LAST:event_carregarCaminhaoButtonMouseClicked

    private void voltarAoMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarAoMenuButtonMouseClicked
        MenuScreen tela = new MenuScreen();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarAoMenuButtonMouseClicked

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
            java.util.logging.Logger.getLogger(CargaDescargaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaDescargaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaDescargaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaDescargaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaDescargaScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgCadastrarFreteButton;
    private javax.swing.JPanel bgCadastroButton;
    private javax.swing.JPanel bgCargaDescargaCamiaoButton;
    private javax.swing.JLabel carregarCaminhaoButton;
    private javax.swing.JLabel descarregarCaminhaoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblFretesCarregados;
    private javax.swing.JLabel lblTxtBoxTitulo;
    private javax.swing.JTextArea txtAreaFretesCarregados;
    private javax.swing.JTextArea txtAreaVerFretes;
    private javax.swing.JLabel voltarAoMenuButton;
    // End of variables declaration//GEN-END:variables
}
