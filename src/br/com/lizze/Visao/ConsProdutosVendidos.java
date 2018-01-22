/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lizze.Visao;

import br.com.lizze.Dao.VendaProdutoDao;
import br.com.lizze.ferramentas.MinhasDatas;
import br.com.lizze.ferramentas.PreencherJbTableGenerico;
import br.com.lizze.ferramentas.RetornaDescricao;
import br.com.lizze.modelo.Produto;
import br.com.lizze.modelo.VendaProduto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lizze
 */
public class ConsProdutosVendidos extends javax.swing.JFrame {

    PreencherJbTableGenerico preencher = new PreencherJbTableGenerico();
    MinhasDatas datas = new MinhasDatas();

    Date data = new Date();
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

    public ConsProdutosVendidos() {
        initComponents();

        txtNomeProduto.setEditable(false);
        txtData1.setText(formatador.format(data));
//        txtData2.setText(formatador.format(data));

        preencher.FormtarJtable(tabelaVenda, new int[]{50, 150});

        tblProdutos();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdProduto = new javax.swing.JTextField();
        txtNomeProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVenda = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtData1 = new javax.swing.JTextField();
        Pesquisar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        comboData = new javax.swing.JComboBox<>();
        txtPesquisaProduto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Venda Por Produto");

        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel1FocusLost(evt);
            }
        });

        jLabel1.setText("Cod. Produto");

        txtIdProduto.setBackground(new java.awt.Color(153, 255, 255));
        txtIdProduto.setName("id"); // NOI18N
        txtIdProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdProdutoFocusLost(evt);
            }
        });
        txtIdProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdProdutoMouseClicked(evt);
            }
        });

        txtNomeProduto.setName("nome"); // NOI18N

        tabelaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Quantidade Vendida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaVenda);

        jLabel2.setText("Data");

        Pesquisar.setText("Pesq. por Data");
        Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarActionPerformed(evt);
            }
        });

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        comboData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Apartir", "Somente" }));

        txtPesquisaProduto.setText("Pesq. por Produto");
        txtPesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNomeProduto))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(comboData, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Pesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPesquisaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaProduto))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdProdutoMouseClicked
        Produto v = new Produto();
        if (evt.getClickCount() == 2) {
            final ConsultaProdutos consultaprod = new ConsultaProdutos(this, true, v);
            consultaprod.setVisible(true);

            consultaprod.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    txtIdProduto.setText(Integer.toString(v.getId()));
                    txtNomeProduto.setText(v.getNome());
                }
            });
        }// TODO add your handling code here:
    }//GEN-LAST:event_txtIdProdutoMouseClicked

    private void txtIdProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdProdutoFocusLost
        RetornaDescricao retorna = new RetornaDescricao();
        txtNomeProduto.setText(retorna.retornadados(txtIdProduto, "produtos", "nome"));
    }//GEN-LAST:event_txtIdProdutoFocusLost

    private void jPanel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConsProdutosVendidos nomeVariavel = new ConsProdutosVendidos();
        nomeVariavel.setVisible(true);
        dispose();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaProdutoActionPerformed
        ConsultaPorProdutos();

    }//GEN-LAST:event_txtPesquisaProdutoActionPerformed

    private void PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarActionPerformed

        switch (comboData.getSelectedIndex()) {
            case 0: {
                tblProdutos();
                break;
            }
            case 1: {
                tblProdutosApartir();
            }

            case 2: {
                tblProdutosSomente();
                break;
            }
        }
    }//GEN-LAST:event_PesquisarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsProdutosVendidos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsProdutosVendidos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsProdutosVendidos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsProdutosVendidos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsProdutosVendidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pesquisar;
    private javax.swing.JComboBox<String> comboData;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVenda;
    private javax.swing.JTextField txtData1;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JButton txtPesquisaProduto;
    // End of variables declaration//GEN-END:variables

    private void tblProdutos() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVenda.getModel();
        modelo.setNumRows(0);
        VendaProdutoDao pdao = new VendaProdutoDao();

        for (VendaProduto p : pdao.ProdutosVendidosTodos()) {
            modelo.addRow(new Object[]{
                p.getProduto().getId(),
                p.getProduto().getNome(),
                p.getQtd(),});
        }
    }

    private void tblProdutosSomente() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVenda.getModel();
        modelo.setNumRows(0);

        try {

            VendaProdutoDao pdao = new VendaProdutoDao();

            for (VendaProduto p : pdao.retornaProdutoPorData(datas.formataDataRetornaBD(txtData1.getText()))) {
                modelo.addRow(new Object[]{
                    p.getProduto().getId(),
                    p.getProduto().getNome(),
                    p.getQtd(),});

            }
        } catch (ParseException ex) {
            Logger.getLogger(ConsProdutosVendidos.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tblProdutosApartir() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVenda.getModel();
        modelo.setNumRows(0);

        VendaProdutoDao pdao = new VendaProdutoDao();

        for (VendaProduto p : pdao.retornaProdutoApartirdaData()) {
            modelo.addRow(new Object[]{
                p.getProduto().getId(),
                p.getProduto().getNome(),
                p.getQtd(),});

        }
    }
    
    
    private void ConsultaPorProdutos() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVenda.getModel();
        modelo.setNumRows(0);

        VendaProdutoDao pdao = new VendaProdutoDao();

        for (VendaProduto p : pdao.produtoId(txtIdProduto.getText())) {
            modelo.addRow(new Object[]{
                p.getProduto().getId(),
                p.getProduto().getNome(),
                p.getQtd()});

        }
    }
    
}
