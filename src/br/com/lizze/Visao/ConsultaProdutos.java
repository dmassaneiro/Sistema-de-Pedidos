package br.com.lizze.Visao;

import br.com.lizze.Dao.ProdutoDao;
import br.com.lizze.ferramentas.PreencherJbTableGenerico;
import br.com.lizze.modelo.Produto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Massaneiro
 */
public class ConsultaProdutos extends javax.swing.JDialog {

    PreencherJbTableGenerico preencher = new PreencherJbTableGenerico();
    Produto centro = new Produto();

    public ConsultaProdutos(java.awt.Frame parent, boolean modal, Produto centro) {
        super(parent, modal);
        initComponents();
        tblProdutos();

        this.centro = centro;

        preencher.FormtarJtable(jTConsulta, new int[]{50, 300});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTFPesuisa = new javax.swing.JTextField();
        jBtPesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTConsulta = new javax.swing.JTable();
        jBtCancelar = new javax.swing.JButton();
        jBtSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Produto");

        jTFPesuisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFPesuisaKeyReleased(evt);
            }
        });

        jBtPesquisa.setText("Pesquisar");
        jBtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaActionPerformed(evt);
            }
        });

        jTConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Códgo", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTConsulta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTConsulta);

        jBtCancelar.setText("Cancelar");
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtSelecionar.setText("Selecionar");
        jBtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jTFPesuisa, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addGap(62, 62, 62))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                        .addGap(54, 54, 54))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPesuisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtSelecionar)
                    .addComponent(jBtCancelar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(546, 405));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaActionPerformed


    }//GEN-LAST:event_jBtPesquisaActionPerformed

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        if (jTConsulta.getSelectedRow() >= 0) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "A pesquisa nao retornou valores !");
        }

    }//GEN-LAST:event_jBtSelecionarActionPerformed

    private void jTConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTConsultaMouseClicked
        if (evt.getClickCount() == 2) {
            centro.setId(Integer.parseInt(jTConsulta.getValueAt(jTConsulta.getSelectedRow(), 0).toString()));
            centro.setNome(jTConsulta.getValueAt(jTConsulta.getSelectedRow(), 1).toString());
            dispose();
        } else {
            centro.setId(Integer.parseInt(jTConsulta.getValueAt(jTConsulta.getSelectedRow(), 0).toString()));
            centro.setNome(jTConsulta.getValueAt(jTConsulta.getSelectedRow(), 1).toString());

        }
    }//GEN-LAST:event_jTConsultaMouseClicked

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jTFPesuisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPesuisaKeyReleased
        pesquisaTblProdutos(jTFPesuisa.getText());


    }//GEN-LAST:event_jTFPesuisaKeyReleased

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
            java.util.logging.Logger.getLogger(ConsultaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtPesquisa;
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTConsulta;
    private javax.swing.JTextField jTFPesuisa;
    // End of variables declaration//GEN-END:variables

    private void tblProdutos() {
        DefaultTableModel modelo = (DefaultTableModel) jTConsulta.getModel();
        modelo.setNumRows(0);
        ProdutoDao pdao = new ProdutoDao();
        for (Produto p : pdao.raed()) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getValor(),
                p.getEmpresa()
            });
        }
    }

    private void pesquisaTblProdutos(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jTConsulta.getModel();
        modelo.setNumRows(0);
        ProdutoDao pdao = new ProdutoDao();
        for (Produto p : pdao.pesquisa(desc)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome()

            });
        }
    }

}
