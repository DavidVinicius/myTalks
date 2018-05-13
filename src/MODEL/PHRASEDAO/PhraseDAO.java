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

/**
 *
 * @author David
 */
public class PhraseDAO implements IPhraseDAO {

    @Override
    public Phrase[] getPhrases(int ID) {
        Connection con         = null;
        PreparedStatement stm  = null;
        ResultSet        rs    = null;
        Phrase [] phrases      = null;
        try{
            con = SQLiteConnection.getConnection();
            stm = con.prepareStatement("SELECT * FROM Phrases WHERE talk_id = ?");
            stm.setInt(0, ID);
            rs = stm.executeQuery();
            
            phrases = new Phrase[this.size(ID)];
            
            int i = 0;
            while(rs.next())
            {
                Phrase phrase = new Phrase();
                phrase.setId(rs.getInt("id"));
                phrase.setPhrase(rs.getString("phrase"));
                phrase.setTranslation(rs.getString("translation"));
                
                phrases[i] = phrase;
            }
            
            return phrases;                        
            
        }catch(Exception e){}
        return null;
    }

    @Override
    public boolean createPhrase(Phrase phrase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletePhrase(int phraseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePhrase(Phrase phrase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size(int id) {
        int total = 0;
        try{
            Connection       con = SQLiteConnection.getConnection();
            PreparedStatement stm = con.prepareStatement("SELECT count(*) as qtd from Phrases WHERE talk_id =  ?");
            stm.setInt(0, id);
            
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
