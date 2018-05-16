/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhraseDAO;

import MODEL.PHRASEDAO.Phrase;
import MODEL.PHRASEDAO.PhraseDAO;
import java.util.Arrays;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ht3000052
 */
public class PhraseDAOTest {
    PhraseDAO phrase;
    Phrase phraseObject;
    
    public PhraseDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         phrase = new PhraseDAO();
         phraseObject = new Phrase();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getPhrasesTest() {
           
            Phrase[] phrases     = phrase.getPhrases(1);                                    
            assertNotNull(phrases);
     }
     
     @Test
     public void createPhraseTest()
     {
          
           phraseObject.setPhrase("Orange");
           phraseObject.setTranslation("Laranja");
           phraseObject.setTalkId(1);
           
           assertTrue(phrase.createPhrase(phraseObject));
     }
     
     @Test
     public void updatePhraseTest()
     {
          phraseObject.setPhrase("Maçã");
          phraseObject.setTranslation("apple");
          phraseObject.setId(1);
          
          assertTrue(phrase.updatePhrase(phraseObject));
     }
}
