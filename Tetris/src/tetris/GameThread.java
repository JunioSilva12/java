package tetris;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUNIOR SILVA
 */
public class GameThread extends Thread
{// esta clase sera para hacer el hilo que actualize los frames del juego
   
  private GameArea ga; 
  private GameForm gf; 
  private int score=0 , level= 1; 
  private final int scorePerLevel = 5; 
  private int pause = 600;//el ritmo del juego 
  private final int speedForLevel=50;
          
  public GameThread(GameArea ga , GameForm gf) 
  {
    this.ga=ga;
    this.gf=gf;
    gf.updateGameLevel(level);
    gf.updateGameScore(score);
   
  }

    @Override
    public void run()
    {
      int score=0; 
      while(true) //se crea el ciclo infinito
      {     
            
            ga.spawnBlock();
            while(ga.moveBlockDown() == true)
            {
          
                try 
                {          
                Thread.sleep(pause);//cambia  cada 1000 milisegundos(1fps)
                //System.out.println("Hi , I love the Science");
                } 
                catch (InterruptedException ex) 
                {
               
                return; //si es interrumpido el hilo retorna
                }
            } 
             
            if(ga.isBlockOutOfBonds())
            {
                Tetris.gameOver( score);
                //System.out.println("Game Over!");
                break;
            }
            ga.moveBlockToBackground();
            score+=ga.clearLines();
            gf.updateGameScore(score);
            int lvl= score/scorePerLevel +1; //cada 3 puntos aumeta de nivel
            if(lvl>level) 
            {
                level=lvl;
                gf.updateGameLevel(level);
                if(this.pause>100) pause-=this.speedForLevel;
            }
            
            
      } 
    }   
}
