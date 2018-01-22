
package br.com.lizze.Dao;

import br.com.lizze.Visao.Vendas;
import br.com.lizze.conexao.Conexao;
import br.com.lizze.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author lizze
 */
public class UsuarioDao {
    
    public void create(Usuario p){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("INSERT INTO usuario (login,senha)VALUES(?,?)");
            stmt.setString(1, p.getLogin());
            stmt.setString(2, p.getSenha());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(Usuario p){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("UPDATE usuario SET login= ?, senha= ? WHERE id = ?");
            stmt.setString(1, p.getLogin());
            stmt.setString(2, p.getSenha());
            stmt.setInt(3, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar "+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void delete(Usuario p){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
            stmt.setInt(1, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir "+ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public List<Usuario> raed(){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> Usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                Usuarios.add(usuario);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return Usuarios;
    }
    
    public boolean consultaLogin(String login, String senha){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean consulta = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? AND senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                consulta = true;
            
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return consulta;
    }
    
    public List<Usuario> pesquisa(String desc){
        Connection con = br.com.lizze.conexao.Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login LIKE ? ");
            
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return usuarios;
    }
    
        public void FormtarJtable(JTable tabela, int valores[]) {

        for (int x = 0; x < valores.length; x++) {
            tabela.getColumnModel().getColumn(x).setPreferredWidth(valores[x]);

        }

    }
    
}
