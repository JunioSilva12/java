package tetrisblocks;

import java.awt.Color;
import tetris.TetrisBolck;

/**
 *
 * @author JUNIOR SILVA
 */
public class Ishape extends TetrisBolck
{
    public Ishape() {
        super(new int[][]{{1,1,1,1}});
    }  
    @Override
    public void rotate(){
        super.rotate();
        if(this.getWidth()==1)
        {
        this.setX(this.getX()+1);
        this.setY(this.getY()-1);   
        }else{
        this.setX(this.getX()-1);
        this.setY(this.getY()+1);   
        }
        
    }

}
