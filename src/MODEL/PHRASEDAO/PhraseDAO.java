/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.PHRASEDAO;

import Services.SQLiteConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class PhraseDAO implements IPhraseDAO {
    Connection con         = null;
    PreparedStatement stm  = null;
    ResultSet        rs    = null;
    Phrase [] phrases      = null;
    Phrase    phrase       = null;

    @Override
    public Phrase[] getPhrases(int ID) {
        
        try{
            con = SQLiteConnection.getConnection();
            stm = con.prepareStatement("SELECT * FROM Phrases WHERE talk_id = "+ID);
            //stm.setInt(1, ID);            
            rs = stm.executeQuery();
            
            phrases = new Phrase[this.size(ID)];
            
            int i = 0;
            while(rs.next())
            {
                Phrase phrase = new Phrase();
                phrase.setId(rs.getInt("id"));
                phrase.setPhrase(rs.getString("phrase"));
                phrase.setTranslation(rs.getString("translation"));
                phrase.setTalkId(rs.getInt("talk_id"));
                
                phrases[i] = phrase;
                i++;
            }
            
            return phrases;                        
            
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean createPhrase(Phrase phrase) {         
        
        try{
            con = SQLiteConnection.getConnection();
            stm = con.prepareStatement("INSERT INTO Phrases(phrase,translation,talk_id) VALUES (?,?,?)");
            stm.setString(1, phrase.getPhrase());
            stm.setString(2, phrase.getTranslation());
            stm.setInt(3,phrase.getTalkId());
            stm.executeUpdate();            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PhraseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean deletePhrase(int phraseID) {
        try{
            con = SQLiteConnection.getConnection();
            stm = con.prepareStatement("DELETE FROM Phrases WHERE id = ?");
            stm.setInt(1, phraseID);
            stm.executeQuery();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(PhraseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean updatePhrase(Phrase phrase) {
        con = SQLiteConnection.getConnection();
        
        try {
            stm = con.prepareStatement("UPDATE Phrases SET phrase = ?, translation = ? WHERE id = ?");
            stm.setString(1, phrase.getPhrase());
            stm.setString(2, phrase.getTranslation());
            stm.setInt(3, phrase.getId());
            stm.executeUpdate();
            return true;
        
        } catch (SQLException ex) {
            Logger.getLogger(PhraseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }

    @Override
    public int size(int id) {
        int total = 0;
        try{
            Connection       con = SQLiteConnection.getConnection();
            PreparedStatement stm = con.prepareStatement("SELECT count(*) as qtd from Phrases WHERE talk_id = ?");
            stm.setInt(1, id);
            
            ResultSet rs = stm.executeQuery();
            
            
            while(rs.next())
            {
                total = rs.getInt("qtd");
            }
            
            return total;
            
        }catch(Exception e){
            System.out.println("Erro ao calcular total");
        }
        
        return total;
    }
    
}
