/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.TALKDAO;

import Services.SQLiteConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class TalkDAO implements ITalkDAO{
    
    public Talk talk;

    @Override
    public Talk getTalkWhere(String name) {
        Connection con        = null;
        PreparedStatement stm = null;
        ResultSet          rs = null;
        Talk talk             = new Talk();
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
        Connection con   = null;
        ResultSet  rs    = null;
        PreparedStatement stm    = null;
        Talk[]    talks  = null;
        
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteTalk(Talk talk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int size() throws SQLException
    {
        Connection        con = null;
        PreparedStatement stm = null;
        ResultSet         rs  = null;
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
    
}
