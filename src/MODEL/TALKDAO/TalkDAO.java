/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.TALKDAO;

import Services.SQLiteConnection;
import Services.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author David
 */
public class TalkDAO implements ITalkDAO{
    
    public Talk talk;
    private Connection con;
    private PreparedStatement stm;
    private Statement statement;
    private ResultSet         rs;
    
    public TalkDAO()
    {
          con        = null;
          stm        = null;
          statement  = null;
          rs         = null;
    }

    @Override
    public Talk getTalkWhere(String name) {
        
        Talk talk             = new Talk();
        this.con        = null;
        this.stm        = null;
        this.rs         = null;
        try{
            
            con = SQLiteConnection.getConnection();                        
            stm = con.prepareStatement("SELECT * FROM Talks WHERE name like '%"+name+"%' Limit 1");                        
            rs = stm.executeQuery();            
                       
            while(rs.next())
            {
                talk.setId(rs.getInt("id"));
                talk.setName(rs.getString("name"));            
            }
            
            return talk;
            
        }catch(Exception e){
                System.out.println("Erro 1: "+e);
        }finally{
            SQLiteConnection.closeConnection(con);
        }
        return talk;
    }

    @Override
    public Talk[] getTalks() {        
        Talk[]    talks       = null;      
        Connection con        = null;
        PreparedStatement stm = null;
        ResultSet         rs  = null;
        
        try {
            con = SQLiteConnection.getConnection();            
            stm = con.prepareStatement("SELECT * FROM Talks");
            rs  = stm.executeQuery();
            
            talks = new Talk[this.size()];
                        
            int i = 0;
            while(rs.next())
            {
                talk = new Talk();
                talk.setId(rs.getInt("id"));
                talk.setName(rs.getString("name"));
                talks[i] = talk;
                i++;
            }
            
            return talks;
        } catch (SQLException ex) {
            Logger.getLogger(TalkDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        finally{
            SQLiteConnection.closeConnection(con);
        }
        return null;
    }
        

    @Override
    public boolean createTalk(Talk talk) {
        con = SQLiteConnection.getConnection();
        
        try {
            stm = con.prepareStatement("INSERT INTO Talks (name) VALUES (?)");
            stm.setString(1, talk.getName());            
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TalkDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteTalk(int id) {
        con = SQLiteConnection.getConnection();
        
        try {            
            statement = con.createStatement();
            statement.execute("BEGIN TRANSACTION");
            
            stm = con.prepareStatement("DELETE FROM Talks WHERE id = ?");
            stm.setInt(1, id);            
            statement.execute("PRAGMA foreign_keys = ON");
            stm.executeUpdate();
            statement.execute("COMMIT");
            return true;
        } catch (SQLException ex) {
            try {
                statement.execute("ROLLBACK;");
            } catch (SQLException ex1) {
                Logger.getLogger(TalkDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(TalkDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
    public int size() throws SQLException
    {        
        int total             = 0;
        
        try{
            con = SQLiteConnection.getConnection();
            stm = con.prepareStatement("SELECT count(*) as rows FROM Talks");
            rs  = stm.executeQuery();
            
            
            while(rs.next())
            {
                total = rs.getInt("rows");
            }
            
            return total;
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return total;
    }

    @Override
    public boolean updateTalk(Talk talk) {
        con = SQLiteConnection.getConnection();
        try {
            stm = con.prepareStatement("UPDATE Talks SET name = ? WHERE id = ?");
            stm.setString(1,talk.getName());
            stm.setInt(2, talk.getId());
            
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TalkDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
