
package tetris;

import javax.swing.JOptionPane;

/**
 *
 * @author JUNIOR SILVA
 */
public class Tetris
{
private static GameForm gf;
private static StratupForm sf;
private static LeaderBoardForm lbf;
private static AudioPlayer ap = new AudioPlayer();
//estaticos quiere decir que para cada uso en esta clase no cambien 

    public static void playclearLine()         
    { 
        ap.playClearLineSound();
    }  
    public static void playgameOver()         
    { 
        ap.playgameOverSound();
    }  
    public static void playBackground()         
    { 
        ap.playbackgroundMusicSound();
    }
    
    public static void playRotate()    //sonido de rotar      
    { 
        ap.playRotateSound();
    }
    public static void playMove()     //sonido de mover    
    { 
        ap.playMoveSound();
    }
    public static void playFall()    //sonido de impacto      
    { 
        ap.playFallSound();
    }
    public static void playBtn()    //sonido del botones     
    { 
        ap.playBtnSound();
    }
    
    
    public static void shutBackgroundSound()         
    { 
        ap.stopBackgroundMusicSound();
    } 




    public static void start()         
    { 
         gf.setVisible(true);
         gf.startGame();
    }   
    
    public static void showLeaderBoard()         
    { 
         lbf.setVisible(true);      
    } 
    public static void showStratup()         
    { 
         sf.setVisible(true);      
    }
    
    public static void gameOver(int score)         
    {  
        shutBackgroundSound();
        playgameOver() ;
        String nickname = JOptionPane.showInputDialog("Game Over! \n Please Enter Your Name" ) ;
        playBtn();
        gf.setVisible(false);    
        lbf.addPlayer(nickname,score);
         
    }
    
    //falta hacer que si no se ingresa nombre no se guarde o se ponga un nombre por defecto
    //falta ponerle el icono 
    
    public static void main(String[] args)
    {  
     java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                sf = new StratupForm();    
                gf=new GameForm();  
                lbf=new LeaderBoardForm(); 
                sf.setVisible(true);  
               
            }
        });  
        
     
     //instanciamos todos los form en ves de uno por uno
     //y el hilos separados hacer cada intanciacion
        
    }    
}
