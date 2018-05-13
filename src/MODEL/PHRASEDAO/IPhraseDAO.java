/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.PHRASEDAO;

/**
 *
 * @author David
 */
public interface IPhraseDAO {
    
    public Phrase[] getPhrases(int ID);
    public boolean createPhrase(Phrase phrase);
    public boolean deletePhrase(int phraseID);
    public boolean updatePhrase(Phrase phrase);
    public int size(int id);
}
