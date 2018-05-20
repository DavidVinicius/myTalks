/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.PHRASEDAO;
import Services.SQLiteConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author David
 */
public class Phrase {
    private String phrase;
    private String translation;
    private int id;
    private int talkId;

    public int getTalkId() {
        return talkId;
    }

    public void setTalkId(int talkId) {
        this.talkId = talkId;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /*
        public void insertPhrase (){
        Connection con = null;
        Statement stm = null;    
        
        String sql = "INSERT INTO Phrases (id, phrase, translation) VALUES (?, ?, ?)";
            try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, sql);
            }
            catch(SQLException u){
            
            }
    }
    */
}
