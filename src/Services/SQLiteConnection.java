/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class SQLiteConnection {
     private static Connection con;     
     private static final String URL    = "jdbc:sqlite:banco/DB.db";
     private static final String DRIVER = "org.sqlite.JDBC";       

    private SQLiteConnection()
    {
         
    }
                 
    public static Connection getConnection() {
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL);
            return con;
        }catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
        
    }                 
    
     public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
           Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stm) {
         closeConnection(con);
         try {
            if (stm != null) {
                stm.close();
            }
         }catch (SQLException ex){
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stm, ResultSet rs) {
     closeConnection(con, stm);
     try {
        if (rs != null) {
            rs.close();
        }
     } catch (SQLException ex){
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
