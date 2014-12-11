/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
   
// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class AudioPlayer {
   
   Clip clip;
   myJFrame parentFrame;
   // Constructor
   public AudioPlayer(myJFrame frame) 
   {
       parentFrame = frame;
   }
   
   void play(String fileName)
   {
        try {
            if (isSoundEnabled())
            {
                // Open an audio input stream.
                URL url = this.getClass().getResource("/sounds/" + fileName);            
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                // Get a sound clip resource.
                clip = AudioSystem.getClip();
                // Open audio clip and load samples from the audio input stream.
                clip.open(audioIn);
                clip.start();
            }
        } 
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("AudioPlayer caugher exception");
        }       
   }
   
   public boolean isSoundEnabled()
   {
       return parentFrame.isSoundEnabled();
   }
}
