
package tetris;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author JUNIOR SILVA
 */
public class TetrisBolck
{
 private int[][] shape;  // la forma del bloque  
 private Color color;
 private Color previuosColor ;
 private int x,y ;
 private int[][][] shapes; 
 private int currentRotation; //guarda la rotacion actual
 private final Color[] coloresMate = {
            new Color(128, 128, 128),   // Gris mate                 
            new Color(245, 222, 94),     // Amarillo mate                              
            new Color(209, 123, 198),     // Púrpura mate
            new Color(25, 195, 125),    // Verde  
            new Color(208, 69, 70)       // Rojo mate
        }; //colores pedidos a ChatGPT
 private Color[] avalibleColor = coloresMate ; //pasa poner los colores disponibles 
 
 
 
    public TetrisBolck(int[][] shape) 
    {
        this.shape = shape;      
        initShapes();
        
        
    }
    
    public void initShapes()
    {
      shapes = new int[4][][] ;  
      
      for(int i=0 ;i<4;i++)
      {
         int r = shape[0].length; //aqie se invierten
         int c = shape.length;
         shapes[i]=new int[r][c] ;
         for(int y=0 ; y<r ;y++) 
         {
            for(int x=0 ; x<c ;x++)
            {
               shapes[i][y][x] = shape[c-x-1] [y] ; //el rompecabezas para girar las pociciones de la matriz    
            }
         
         }
         shape=shapes[i]; //para cambiar a la nueve figura rotada y rotarla de nuevo
      }
      
    }
    
    public void spawn(int gridWidth)
    {//da las coodenadas de donde spawnea
      
       Random r = new Random();//nos dara un numero ramdom   
       this.currentRotation=r.nextInt(shapes.length);//get un numero ramdom del 0 al 3 
       this.y=0-getHeight();
       this.x = r.nextInt((gridWidth-getWidth())); //spawnear blocke en una pocicion entera ramdom Integer(int) 
       //this.x= (gridWidth-getWidth())/2;//aqui hace que el bloque spawnwee en el centro 
       
       this.color=this.avalibleColor[r.nextInt(avalibleColor.length)] ;
        //System.out.println(".current..."+this.color.toString());
        //System.out.println(".previous..."+this.previuosColor);
       if(this.previuosColor != null) 
       {
            //System.out.println(".previous."+this.previuosColor.toString());
            //System.out.println("lllll.."+this.color+"llllll"+this.previuosColor);
            while( this.color.toString().equals(this.previuosColor.toString()))
                {
                this.color=this.avalibleColor[r.nextInt(avalibleColor.length)] ;
                //System.out.println(".change."+this.color.toString());
                }
       }
       
       
    }

    public int[][] getShape() {return this.shape;}

    public Color getColor() {return this.color;}
    
    public int getHeight() {return shape.length;}//retorna la altura(obviamente en numero de cuadros)
    
    public int getWidth() {return shape[0].length;} //retorna el ancho

    public int getX() {return this.x;}

    public int getY() {return this.y;}
    
    public int getBotomEdge() {return this.getY()+this.getHeight();}//para obtene la distancia en y recorrida mas la altura
    
    public int getRightEdge() {return this.getX()+this.getWidth();}
     
    public int getLeftEdge() {return this.getX();}
    
    public int getCurrentShape() {return this.currentRotation;}

    public void setPreviuosColor(Color previuosColor) {
        this.previuosColor = previuosColor;
    }

    
    public void setX(int x) { this.x = x;}
    public void setY(int y) { this.y = y;}
    
    public void moveDown()
    {
     y++; //aumenta la pocicion hacia abajo   
    }
    
    public void moveLeft()
    {
     x--; //aumenta la pocicion hacia abajo   
    }
    
    public void moveRigt()
    {
     x++; //aumenta la pocicion hacia abajo   
    }
    
    
    public void rotate()
    {
       currentRotation++;
       if(currentRotation>3) currentRotation=0 ; //para que vuelva a la posicion inicial
       shape=shapes[currentRotation];
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
}
