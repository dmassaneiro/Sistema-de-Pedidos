package br.com.lizze.ferramentas;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Massaneiro
 */
public class PreencherJbTableGenerico {

    public void PreencherJbTableGenerico(JTable tabela, ResultSet resultado) {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        try {
            int colunas = resultado.getMetaData().getColumnCount();

            while (resultado.next()) {
                Object[] row = new Object[colunas];
                for (int i = 0; i != colunas; i++) {
                    row[i] = resultado.getString(i + 1);
                }
                modelo.addRow(row);
            }
            if (!resultado.first()) {
                JOptionPane.showMessageDialog(null, "Registos nao Localizados!");
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Lista JTable " + erro);
        }

    }

    public void FormtarJtable(JTable tabela, int valores[]) {

        for (int x = 0; x < valores.length; x++) {
            tabela.getColumnModel().getColumn(x).setPreferredWidth(valores[x]);

        }

    }

    public void preencherCombo(JComboBox combo, ResultSet resultado, String valor) {
        combo.removeAllItems();
        try {
            while (resultado.next()) {
                combo.addItem(resultado.getString(valor));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Nao ha UF cadastrada " + ex);

        }
    }

    public int[] preecherComboretornox(JComboBox combo, ResultSet resultado, String primaria, String visao) {
        combo.removeAllItems();
        int[] chave = null;
        try {
            resultado.last();
            int linhas = resultado.getRow();
            chave = new int[linhas];
            int conta = 0;
            resultado.first();
            do {
                chave[conta] = resultado.getInt("CD_CIDADE");
                combo.addItem(resultado.getString("DS_CIDADE"));
                conta++;
            } while (resultado.next());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não ha Cidade Cadastrada!");
        }

        return chave;
    }

    public void limparJtable(JTable tabela) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
    }

 public void PreencherJtableGenericoSel(JTable tabela, String campos[], ResultSet resultSet) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        try {
            while (resultSet.next()) {
                int len = campos.length;
                Object[] row = new Object[len];
                for (int i = 0; i != len; i++) {
                    if(i == 0){
                        row[1] = false;
                    }
                    row[i] = resultSet.getString(i);
                }
                modelo.addRow(row);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar no JTable " + erro);
        }
    }

}
