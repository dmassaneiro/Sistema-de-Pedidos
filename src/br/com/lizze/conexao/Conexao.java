/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lizze.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author allan
 */
public class Conexao {
    
    private static final String DRIVE = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://172.16.9.2:3306/sistema_feira";
    private static final String USER = "lizze";
    private static final String PASS = "123456";
    
    public static Connection getConnection(){
        
        try{
            Class.forName(DRIVE);
            return DriverManager.getConnection(URL, USER, PASS);
        
        }catch(ClassNotFoundException | SQLException ex){
            throw new RuntimeException("bugo",ex);
        }
        
    }
    
    public static void closeConnection(Connection con){
        try{
            if(con != null){
                con.close();
            }
        }catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try{
            if(stmt != null){
                con.close();
            }
        }catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try{
            if(rs != null){
                con.close();
            }
        }catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}   