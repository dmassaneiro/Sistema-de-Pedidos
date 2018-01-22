/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lizze.Dao;

import br.com.lizze.conexao.Conexao;
import br.com.lizze.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lizze
 */
public class ProdutoDao {
    
    public void create(Produto p){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("INSERT INTO produtos (nome,valor,empresa_id)VALUES(?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getValor());
            stmt.setInt(3, p.getEmpresa().getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(Produto p){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("UPDATE `produtos` SET `nome`=?,`valor`=?,`empresa_id`=? WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getValor());
            stmt.setInt(3, p.getEmpresa().getId());
           
            stmt.setInt(4, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar "+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void delete(Produto p){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("DELETE FROM produtos WHERE id = ?");
            stmt.setInt(1, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir "+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public List<Produto> raed(){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));
                produto.getEmpresa().setId(rs.getInt("empresa_id"));
                
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    }
    
    public List<Produto> pesquisa(String desc){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ? ");
            
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));
                produto.getEmpresa().setId(rs.getInt("empresa_id"));
                
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    }
    public List<Produto> pesquisaid(String desc){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produtos WHERE id LIKE ? ");
            
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));
                produto.getEmpresa().setId(rs.getInt("empresa_id"));
               
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    }
    
    
}
