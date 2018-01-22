package br.com.lizze.Dao;

import br.com.lizze.conexao.Conexao;
import br.com.lizze.modelo.Produto;
import br.com.lizze.modelo.VendaProduto;
import java.sql.Connection;
import java.sql.Date;
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
public class VendaProdutoDao {

    public void SalvarVendaProduto(VendaProduto vp) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO venda_has_produtos (produtos_id,venda_id,quantidade,valor,data)"
                    + "VALUES(?,?,?,?,?)");

            stmt.setInt(1, vp.getProduto().getId());
            stmt.setInt(2, vp.getVenda().getId());
            stmt.setInt(3, vp.getQtd());
            stmt.setDouble(4, vp.getValor());
            stmt.setString(5, vp.getData());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public void update(VendaProduto vp) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE `venda_has_produtos` quantidade= ?, produtos_id= ?,"
                    + "venda_id= ?, valor = ? WHERE id = ?");
            stmt.setInt(1, vp.getQtd());
            stmt.setInt(2, vp.getProduto().getId());
            stmt.setInt(3, vp.getVenda().getId());
            stmt.setDouble(4, vp.getValor());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }

    public List<VendaProduto> raed() {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaProduto> vendasprodutos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM venda_has_produtos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaProduto vp = new VendaProduto();
                Produto p = new Produto();

                vp.getVenda().setId(rs.getInt("venda_id"));
                vp.getProduto().setId(rs.getInt("produtos_id"));
                vp.setQtd(rs.getInt("quantidade"));
                vp.setValor(rs.getDouble("valor"));

                vendasprodutos.add(vp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return vendasprodutos;
    }

    public List<VendaProduto> raedId(int desc) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaProduto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM venda_has_produtos WHERE venda_id = ? ");
            stmt.setInt(1, desc);
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaProduto produto = new VendaProduto();

                produto.getVenda().setId(rs.getInt("venda_id"));
                produto.getProduto().setId(rs.getInt("produtos_id"));
                produto.setQtd(rs.getInt("quantidade"));
                produto.setValor(rs.getDouble("total"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

    public List<VendaProduto> ProdutosVendidosTodos() {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaProduto> vendasprodutos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(
                    "SELECT venda_has_produtos.produtos_id,produtos.nome ,sum(quantidade) as Qtd\n"
                    + "FROM venda_has_produtos\n"
                    + "inner join produtos on venda_has_produtos.produtos_id = produtos.id\n"
                    + "where venda_has_produtos.produtos_id >= 0 "
                    + " GROUP BY venda_has_produtos.produtos_id ");
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaProduto vp = new VendaProduto();

                vp.getProduto().setId(rs.getInt("venda_has_produtos.produtos_id"));
                vp.getProduto().setNome(rs.getString("produtos.nome"));
                vp.setQtd(rs.getInt("Qtd"));

                vendasprodutos.add(vp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return vendasprodutos;
    }

    public List<VendaProduto> ProdutosVendidosData(String data) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaProduto> vendasprodutos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(
                    "SELECT venda_has_produtos.produtos_id,produtos.nome ,sum(quantidade) as Qtd"
                    + "FROM venda_has_produtos"
                    + "inner join produtos on venda_has_produtos.produtos_id = produtos.id"
                    + "where data >= ?  GROUP BY venda_has_produtos.produtos_id ;");

            stmt.setString(1, data);
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaProduto vp = new VendaProduto();

                vp.getProduto().setId(rs.getInt("venda_has_produtos.produtos_id"));
                vp.getProduto().setNome(rs.getString("produtos.nome"));
                vp.setQtd(rs.getInt("Qtd"));

                vendasprodutos.add(vp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return vendasprodutos;
    }

    public List<VendaProduto> ProdutosVendidosSomenteUm(String data) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaProduto> vendasprodutos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(
                    "sELECT venda_has_produtos.produtos_id,produtos.nome ,sum(quantidade) as Qtd\n"
                    + "FROM venda_has_produtos\n"
                    + "inner join produtos on venda_has_produtos.produtos_id = produtos.id\n"
                    + "where data = " + data
                    + "GROUP BY venda_has_produtos.produtos_id ;");
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaProduto vp = new VendaProduto();

                vp.getProduto().setId(rs.getInt("venda_has_produtos.produtos_id"));
                vp.getProduto().setNome(rs.getString("produtos.nome"));
                vp.setQtd(rs.getInt("Qtd"));

                vendasprodutos.add(vp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return vendasprodutos;
    }

    public List<VendaProduto> retornaProdutoPorData(String data) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaProduto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT venda_has_produtos.produtos_id,produtos.nome ,sum(quantidade) as Qtd\n"
                    + "FROM venda_has_produtos\n"
                    + "inner join produtos on venda_has_produtos.produtos_id = produtos.id\n"
                    + "where data = ?"
                    + "GROUP BY venda_has_produtos.produtos_id ;");
            stmt.setString(1, data);
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaProduto produto = new VendaProduto();

                produto.getProduto().setId(rs.getInt("venda_has_produtos.produtos_id"));
                produto.getProduto().setNome(rs.getString("produtos.nome"));
                produto.setQtd(rs.getInt("Qtd"));

                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

    public List<VendaProduto> retornaProdutoApartirdaData() {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaProduto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT venda_has_produtos.produtos_id,produtos.nome ,sum(quantidade) as Qtd\n"
                    + "FROM venda_has_produtos\n"
                    + "inner join produtos on venda_has_produtos.produtos_id = produtos.id\n"
                    + "where data  between \"09/04/2017\" and \"10/04/2017\"\n"
                    + "GROUP BY produtos_id;");
            //  stmt.setString(1, data1);

            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaProduto produto = new VendaProduto();

                produto.getProduto().setId(rs.getInt("venda_has_produtos.produtos_id"));
                produto.getProduto().setNome(rs.getString("produtos.nome"));
                produto.setQtd(rs.getInt("Qtd"));

                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

    public List<VendaProduto> produtoId(String desc) {
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaProduto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT venda_has_produtos.produtos_id,produtos.nome ,sum(quantidade) as Qtd\n"
                    + "FROM venda_has_produtos\n"
                    + "inner join produtos on venda_has_produtos.produtos_id = produtos.id\n"
                    + "where produtos.id= ?");
            
            stmt.setString(1, desc);
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaProduto produto = new VendaProduto();

                produto.getProduto().setId(rs.getInt("venda_has_produtos.produtos_id"));
                produto.getProduto().setNome(rs.getString("produtos.nome"));
                produto.setQtd(rs.getInt("Qtd"));
         

                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

}
