/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lizze.modelo;


import br.com.lizze.Dao.UsuarioDao;
import br.com.lizze.conexao.Conexao;
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
public class VendedoresDao {
   
    public void create(Vendedor p){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("INSERT INTO vendedor (nome)VALUES(?)");
            stmt.setString(1, p.getNome());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(Vendedor p){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("UPDATE vendedor SET `nome`=? WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar "+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void delete(Vendedor p){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("DELETE FROM vendedor WHERE id = ?");
            stmt.setInt(1, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir "+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public List<Vendedor> raed(){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Vendedor> Vendedores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM vendedor");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                
                vendedor.setId(rs.getInt("id"));
                vendedor.setNome(rs.getString("nome"));
                Vendedores.add(vendedor);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return Vendedores;
    }
    
    
    
    public List<Vendedor> pesquisa(String desc){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Vendedor> Vendedores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM vendedor WHERE nome LIKE ? ");
            
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                
                vendedor.setId(rs.getInt("id"));
                vendedor.setNome(rs.getString("nome"));
                Vendedores.add(vendedor);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return Vendedores;
    }
    
    
    
}
