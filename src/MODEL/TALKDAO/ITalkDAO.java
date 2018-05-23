/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.TALKDAO;

/**
 *
 * @author David
 */
public interface ITalkDAO {
    
    public Talk getTalkWhere(String name);
    public Talk[] getTalks();
    public boolean createTalk(Talk talk);
    public boolean deleteTalk(int id);
    public boolean updateTalk(Talk talk);
    
}
