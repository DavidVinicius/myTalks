/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONFIG;

import Services.SQLiteConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author David
 */
public class Setup {
    
    public void createDatabase()
    {
        createTalkTable();
        createPhrasesTable();
        createViews();
        //this.InsertsDefault();
    }        
    
    private void createTalkTable()
    {
         String sql = "CREATE TABLE IF NOT EXISTS Talks("
                      + "id INTEGER primary key AUTOINCREMENT not null,"
                      + "name varchar(100) not null);";                                                                  
        
        //Executando SQL
        
        Connection con = null;
        Statement stm = null;
        try{
            con = SQLiteConnection.getConnection();                        
            stm = con.createStatement();            
            stm.execute(sql);
            stm.closeOnCompletion();            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{            
            SQLiteConnection.closeConnection(con);              
        }
    }
    
    private void createPhrasesTable()
    {
         String sql = "CREATE TABLE IF NOT EXISTS Phrases("
                      + "id INTEGER primary key AUTOINCREMENT not null,"
                      + "phrase varchar(255) not null,"
                      + "translation varchar(255),"
                 + "     talk_id INTEGER not null,"
                 + "     FOREIGN KEY(talk_id) REFERENCES Talks(id) ON DELETE CASCADE);";                                                                  
        
        //Executando SQL
        
        Connection con = null;            
        Statement stm = null;
        Statement stm2 = null;
        try{                  
            con = SQLiteConnection.getConnection();
            stm2 = con.createStatement();
            stm = con.createStatement();
            stm2.execute("PRAGMA foreign_keys=on;");
            stm.execute(sql);                        
            stm.closeOnCompletion();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{            
            SQLiteConnection.closeConnection(con);
        }
    }
    
    public void createViews()
    {
        String SQL[] = new String[2];
        SQL[0] = "CREATE VIEW IF NOT EXISTS vw_phrases as SELECT * FROM Phrases";        
        
         Connection con = null;
        Statement stm = null;
                
        try{
            
            con = SQLiteConnection.getConnection();
            stm = con.createStatement();                        
            
            for (int i = 0; i < 1; i++) {
                stm.execute(SQL[i]);
            }
            stm.closeOnCompletion();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{
            SQLiteConnection.closeConnection(con);
        }
    }
    
    public void InsertsDefault()
    {
        String SQL[] = new String[2];
        SQL[0] = "INSERT INTO Talks(name) VALUES ('Saudações'),('Frutas');";
        SQL[1] = "INSERT INTO Phrases(phrase,translation,talk_id) VALUES('Hello','Olá',1);";
        
         
        Connection con = null;
        Statement stm = null;
                
        try{
            
            con = SQLiteConnection.getConnection();
            stm = con.createStatement();                        
            
            for (int i = 0; i < 2; i++) {
                stm.execute(SQL[i]);
            }
            stm.closeOnCompletion();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{
            SQLiteConnection.closeConnection(con);
        }
    }
}
