package br.com.lizze.Dao;

import br.com.lizze.modelo.Venda;
import br.com.lizze.conexao.Conexao;
import br.com.lizze.modelo.VendaProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lizze
 */
public class VendaDao {

    public void SalvarVenda(Venda v) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO venda (data,valor,desconto,valor_final,"
                    + "usuario_id,vendedor_id,dinheiro,cartao_debito,cartao_credito,feira_id, statu)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, v.getData());
            stmt.setDouble(2, v.getValor());
            stmt.setDouble(3, v.getDesconto());
            stmt.setDouble(4, v.getTotal());
            stmt.setInt(5, v.getUsuario().getId());
            stmt.setInt(6, v.getVendedor().getId());
            stmt.setString(7, v.getDinheiro());
            stmt.setString(8, v.getDebito());
            stmt.setString(9, v.getCredito());
            stmt.setInt(10, v.getFeira().getId());
            stmt.setString(11, v.getStatus());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Venda Salva com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void update(Venda v) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE venda SET statu =? WHERE id=?");

            stmt.setString(1, v.getStatus());
            stmt.setInt(2, v.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cancelado com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void delete(Venda v) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produtos WHERE id = ?");
            stmt.setInt(1, v.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public List<Venda> raed() {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Venda> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM venda");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();

                venda.setId(rs.getInt("id"));
                venda.setData(rs.getString("data"));
                venda.setValor(rs.getDouble("valor"));
                venda.setDesconto(rs.getDouble("desconto"));
                venda.setTotal(rs.getDouble("valor_final"));
                venda.getUsuario().setId(rs.getInt("usuario"));
                venda.getVendedor().setId(rs.getInt("vendedor_id"));
                venda.setPagamento(rs.getString("pagamento"));
                venda.getFeira().setId(rs.getInt("feira_id"));
                venda.setStatus(rs.getString("status"));

                vendas.add(venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return vendas;
    }

    public Venda last(Venda v) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        Venda vendas = new Venda();

        try {
            stmt = con.prepareStatement("SELECT * FROM venda where id = ?");
            stmt.setInt(1, v.getId());
            rs = stmt.executeQuery();

            if (rs.next()) {
                Venda venda = new Venda();

                venda.setId(rs.getInt("id"));
                venda.setData(rs.getString("data"));
                venda.setValor(rs.getDouble("valor"));
                venda.setDesconto(rs.getDouble("desconto"));
                venda.setTotal(rs.getDouble("valor_final"));
                venda.getUsuario().setId(rs.getInt("usuario"));
                venda.getVendedor().setId(rs.getInt("vendedor_id"));
                venda.setPagamento(rs.getString("pagamento"));
                venda.getFeira().setId(rs.getInt("feira_id"));
                venda.setStatus(rs.getString("status"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return vendas;
    }

    public List<Venda> pesquisa(String desc) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Venda> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM venda WHERE nome LIKE ? ");

            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();

                venda.setId(rs.getInt("id"));
                venda.setData(rs.getString("data"));
                venda.setValor(rs.getDouble("valor"));
                venda.setDesconto(rs.getDouble("desconto"));
                venda.setTotal(rs.getDouble("valor_final"));
                venda.getUsuario().setId(rs.getInt("usuario"));
                venda.getVendedor().setId(rs.getInt("vendedor_id"));
                venda.setPagamento(rs.getString("pagamento"));
                venda.getFeira().setId(rs.getInt("feira_id"));
                venda.setStatus(rs.getString("status"));

                vendas.add(venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return vendas;
    }

    public List<Venda> RetornaId() {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Venda> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT MAX(id) FROM venda");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();

                venda.setId(rs.getInt("MAX(id)"));

                vendas.add(venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return vendas;
    }

    public String ultimasequencia(String tabela, String atributo) throws SQLException {

        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        stmt = con.prepareStatement("SELECT COALESCE(MAX(" + atributo + "),0) AS ULTIMO FROM " + tabela);
        rs = stmt.executeQuery();
        try {
            rs.first();
            return rs.getString("ultimo");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao Buscar o numero da"
                    + "sequencia");
            return "";
        }

    }

    public Venda ConsultaVenda(Venda v) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        Venda vendas = new Venda();

        try {
            stmt = con.prepareStatement("select sum(valor_final)from venda where vendedor_id = ?");
            stmt.setInt(1, v.getId());
            rs = stmt.executeQuery();

            Venda venda = new Venda();

            venda.setValor(rs.getInt("sum(valor_final)"));

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return vendas;
    }

    public List<Venda> ProdutosVendidosTodos() {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Venda> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(
                    "SELECT venda.vendedor_id,vendedor.nome ,sum(venda.valor_final) as Tot\n"
                    + "	FROM venda\n"
                    + "	inner join vendedor on venda.vendedor_id = vendedor.id\n"
                    + "	group by vendedor.id; ");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda vp = new Venda();

                vp.getVendedor().setId(rs.getInt("venda.vendedor_id"));
                vp.getVendedor().setNome(rs.getString("vendedor.nome"));
                vp.setTotal(rs.getInt("Tot"));

                vendas.add(vp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return vendas;
    }
}
