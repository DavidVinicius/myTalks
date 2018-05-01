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

/**
 *
 * @author David
 */
public class TalkDAO implements ITalkDAO{

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createTalk(Talk talk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteTalk(Talk talk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
