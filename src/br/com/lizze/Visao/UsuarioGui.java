/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lizze.Visao;

import br.com.lizze.Dao.UsuarioDao;
import br.com.lizze.modelo.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laydi
 */
public class UsuarioGui extends javax.swing.JFrame {

    public UsuarioGui() {
        setTitle("Cadastro Usuário");
        initComponents();

        this.setLocationRelativeTo(null);

        tblUsuarios();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendedor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuarios");

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar_1.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remover.png"))); // NOI18N
        jButtonCancelar.setText("Excluir");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Localizar");

        jTextFieldPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jButton1.setText("Pesquisar");

        jTableVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVendedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVendedor);

        jLabel1.setText("Código");

        jTextFieldCodigo.setEditable(false);

        jLabel2.setText("Usuário");

        jLabel4.setText("Senha");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordFieldSenha)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonGravar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        Usuario p = new Usuario();
        UsuarioDao dao = new UsuarioDao();

        p.setLogin(jTextFieldUsuario.getText());
        p.setSenha(jPasswordFieldSenha.getText());
        dao.create(p);

        jTextFieldCodigo.setText("");
        jPasswordFieldSenha.setText("");
        jTextFieldUsuario.setText("");

        tblUsuarios();

    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        jTextFieldCodigo.setText("");
        jPasswordFieldSenha.setText("");
        jTextFieldUsuario.setText("");

    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jTableVendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVendedorMouseClicked
        if (jTableVendedor.getSelectedRow() != -1) {
            jTextFieldCodigo.setText(jTableVendedor.getValueAt(jTableVendedor.getSelectedRow(), 0).toString());
            jTextFieldUsuario.setText(jTableVendedor.getValueAt(jTableVendedor.getSelectedRow(), 1).toString());
        }
    }//GEN-LAST:event_jTableVendedorMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTableVendedor.getSelectedRow() != -1) {
            Usuario p = new Usuario();
            UsuarioDao dao = new UsuarioDao();

            p.setLogin(jTextFieldUsuario.getText());
            p.setSenha(jPasswordFieldSenha.getText());
            p.setId(Integer.parseInt(jTextFieldCodigo.getText()));
            dao.update(p);

            jTextFieldCodigo.setText("");
            jPasswordFieldSenha.setText("");
            jTextFieldUsuario.setText("");

            tblUsuarios();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um iten para Atualizar !!");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        if (jTableVendedor.getSelectedRow() != -1) {
            Usuario p = new Usuario();
            UsuarioDao dao = new UsuarioDao();

            p.setId((int) jTableVendedor.getValueAt(jTableVendedor.getSelectedRow(), 0));
            dao.delete(p);

            jTextFieldCodigo.setText("");
            jPasswordFieldSenha.setText("");
            jTextFieldUsuario.setText("");

            tblUsuarios();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um iten para Excluir !!");
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyReleased
        pesquisaUsuarios(jTextFieldPesquisar.getText());
    }//GEN-LAST:event_jTextFieldPesquisarKeyReleased
    private void tblUsuarios() {
        DefaultTableModel modelo = (DefaultTableModel) jTableVendedor.getModel();
        modelo.setNumRows(0);
        UsuarioDao pdao = new UsuarioDao();
        for (Usuario p : pdao.raed()) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getLogin(),
                p.getSenha()
            });
        }
    }

    private void pesquisaUsuarios(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jTableVendedor.getModel();
        modelo.setNumRows(0);
        UsuarioDao pdao = new UsuarioDao();
        for (Usuario p : pdao.pesquisa(desc)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getLogin(),
                p.getSenha()
            });
        }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsuarioGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVendedor;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

}
