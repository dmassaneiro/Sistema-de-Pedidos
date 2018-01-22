package br.com.lizze.ferramentas;

import br.com.lizze.conexao.Conexao;
import br.com.lizze.modelo.Produto;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RetornaDescricao {

    public String retornadados(JTextField campo, String tabela, String retorno) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            if (!campo.getText().equals("")) {
                stmt = con.prepareStatement("SELECT " + retorno + " AS RETORNO FROM " + tabela + " WHERE " + campo.getName()
                        + " = " + campo.getText());
                rs = stmt.executeQuery();

                try {
                    rs.first();
                    return rs.getString("RETORNO");
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Dados não encontrados\n" + erro);
                    campo.setText("");
                    campo.grabFocus();
                    //return "";
                }
            }
            return "";
        } catch (Exception e) {

        }
        return "";
    }
}