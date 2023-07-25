package tetris;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author JUNIOR SILVA
 */
public class AudioPlayer {
    private String soundsFolder = "tetrissounds" + File.separator;
    //Dato curioso el file separetor es diferente en algunos sistemas operetivos asi que se usa de esta forma en ves de '/'
    private String clearLinePath= soundsFolder+"line-clear.wav" ;
    private String gameOverPath= soundsFolder+"success.wav" ;
    private String backgroundMusicPath= soundsFolder+"backgroundMusic.wav" ;
    private String rotatePath= soundsFolder+"rotate-piece.wav" ;
    private String movePath= soundsFolder+"move-piece.wav" ;
    private String fallPath= soundsFolder+"landed.wav" ;
    private String btnPath= soundsFolder+"menu-sound.wav" ;
    
    private Clip clearLineSound ,gameOverSound, backgroundMusicSound,rotateSound ,moveSound ,fallSound ,btnSound ;
    
    public AudioPlayer() 
    {
        try {
            clearLineSound = AudioSystem.getClip();
            gameOverSound = AudioSystem.getClip();
            backgroundMusicSound = AudioSystem.getClip();
            rotateSound = AudioSystem.getClip();
            moveSound = AudioSystem.getClip();
            fallSound = AudioSystem.getClip();
            btnSound = AudioSystem.getClip();
            
            clearLineSound.open(AudioSystem.getAudioInputStream(new File(clearLinePath).getAbsoluteFile()));
            
             
            gameOverSound.open(AudioSystem.getAudioInputStream(new File(gameOverPath).getAbsoluteFile()));
            
            backgroundMusicSound.open(AudioSystem.getAudioInputStream(new File(backgroundMusicPath).getAbsoluteFile()));
            FloatControl gainControl = (FloatControl) backgroundMusicSound.getControl(FloatControl.Type.MASTER_GAIN);
            // Disminuir el volumen a la mitad (reducir 10dB)
            gainControl.setValue(-15.0f);
            
            rotateSound.open(AudioSystem.getAudioInputStream(new File(rotatePath).getAbsoluteFile()));
            
            moveSound.open(AudioSystem.getAudioInputStream(new File(movePath).getAbsoluteFile()));
            
            fallSound.open(AudioSystem.getAudioInputStream(new File(fallPath).getAbsoluteFile()));
            
            btnSound.open(AudioSystem.getAudioInputStream(new File(btnPath).getAbsoluteFile()));
             
        } catch (LineUnavailableException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void playClearLineSound()
    {
       clearLineSound.setFramePosition(0);
       clearLineSound.start();
    }
    
    public void playRotateSound()
    {
       rotateSound.setFramePosition(0);
       rotateSound.start();
    }
    public void playMoveSound()
    {
       moveSound.setFramePosition(0);
       moveSound.start();
    }
    public void playFallSound()
    {
       fallSound.setFramePosition(0);
       fallSound.start();
    }
    public void playBtnSound()
    {
       btnSound.setFramePosition(0);
       btnSound.start();
    }
    
    public void playgameOverSound()
    {
        gameOverSound.setFramePosition(0);
        gameOverSound.start();
        
    }
    
    public void playbackgroundMusicSound()
    { 
        
        backgroundMusicSound.setFramePosition(0);
        backgroundMusicSound.loop(Clip.LOOP_CONTINUOUSLY);
        backgroundMusicSound.start();
    }
    public void stopBackgroundMusicSound()
    { 
        backgroundMusicSound.stop();
       
    }
    
    
    
    
    
    





/*
 los sonidos fueron sacados de este enlace   
https://www.101soundboards.com/boards/39833-sound-effects-tetris-miscellaneous-game-boy-gbc?sort=random
    
*/
}
