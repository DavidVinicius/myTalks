/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytalks;

import CONFIG.Setup;
import VIEW.Home;

/**
 *
 * @author David
 */
public class MyTalks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Setup setup = new Setup();
        setup.createDatabase();
        Home home = new Home();
        home.setVisible(true);
        
    }
    
}
