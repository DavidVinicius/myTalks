/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 *
 * @author David
 */
public class Speaker {
    private static final String VOICENAME = "kevin16";
    private static Voice voice;    
    public static final VoiceManager vm = VoiceManager.getInstance();
    
    private Speaker()
    {        
       
    }
    
    public static void speak(String text)
    {
        voice = vm.getVoice(VOICENAME);
        voice.allocate();
        voice.speak(text);
    }
}
