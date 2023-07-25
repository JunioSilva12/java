package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import tetrisblocks.*;


/**
 *
 * @author JUNIOR SILVA
 */
//vamos a dibujar las figuras en este panel (este seera el tablero)
public class GameArea extends JPanel
{
    private int gridRows ; 
    private int gridColumns ; 
    private int gridCellSize;
    private Color previuosColor ;
    private TetrisBolck block;
    private Color [][] background ;
    //private int[][] block = {{1,0},{1,0},{1,1}} ; //creamos un loque de prueba
    private TetrisBolck[] tetrisBolcks;
    private Image imagen ;

    
    
    
    
    
    public GameArea(JPanel Placeholder,int columns)
    { //ahora podemos modificar el GameAre desde el Jframe Form     
        
        this.setLayout(null);
        //////
        this.gridColumns=columns;
        this.setBackground(Placeholder.getBackground());
        this.setBorder(Placeholder.getBorder());
       // Placeholder.setVisible(false);
        
        this.setBounds(Placeholder.getBounds());//le danos tamaño al JPanel probeniente del placeholder        
        gridCellSize=this.getBounds().width/gridColumns;
        gridRows=this.getBounds().height/gridCellSize;//sera entero
        //background= new Color [gridRows][gridColumns]; //crear una matriz para definir los colores
        //background[9][9]=Color.CYAN;
        tetrisBolcks = new TetrisBolck[]{new Lshape(),
                                         new Jshape(),
                                         new Zshape(),                                         
                                         new Sshape(),
                                         new Tshape(),
                                         new Oshape(),
                                         new Ishape(),    
                                        };// ESTO ES UN BUEN EJEMPLAR DE POLIMORFISMO
    }
    
    public void spawnBlock()
    { 
        
      Random r = new Random();//nos dara un numero ramdom 
      Color prevColor= null ;
      if(block != null){
          prevColor= block.getColor();
          this.previuosColor=prevColor;
          //System.out.println(".previous."+this.previuosColor);
          //System.out.println("actualizado");
      }
      this.previuosColor=prevColor;
      // se creara una clase por cada forma , asi e una buena practica
      block = tetrisBolcks[r.nextInt(tetrisBolcks.length)] ;   
      block.setPreviuosColor(this.previuosColor);     
      block.spawn(gridColumns);
      
    }
    public void initBackgroudarray()
    {
    background= new Color [gridRows][gridColumns]; //se inicializa de nuevo resetenado los valores que tenia
    }
            
    public int clearLines()  //eliminar lineas
    {   
        
        boolean lineFilled ; //para vir si una linea anda llena
        int clearedLines=0;
         for(int row= this.gridRows-1 ; row>=0;row--)
        {   
            lineFilled=true;
            for(int col= 0 ; col<this.gridColumns;col++)
            {
                if(background[row][col]==null) 
                {
                    lineFilled=false;
                    break;
                }
            }
            if(lineFilled)//procedera a eliminar la linea
            {
                clearedLines++;
                clearLine(row); //vacia la linea
                shiftDown(row);//bajar las casillas 
                clearLine(0); //vaviar la de la cima 
                row++;
                repaint();
                
            }
        } 
        if(clearedLines>0) Tetris.playclearLine(); 
        return clearedLines;//lineas limpiadas (para el scored)
    }
    
    public void clearLine(int row)  //eliminar lineas
    {
        for(int i= 0 ; i<this.gridColumns;i++)
        {
        background[row][i]=null;  
        }
        repaint();   
    }
    
    private void shiftDown(int row) {        
       for(int r= row ; r>0;r--){
            for(int c= 0 ; c<this.gridColumns;c++)
                  background[r][c]=background[r-1][c] ;       
       }
       Tetris.playFall();
        
    }
    
    
    public void moveBlockRight()
    {
        if(block == null) return;
         if(checkRight())
         {
            block.moveRigt();
            Tetris.playMove();
            repaint();
         }
        
    }
    
    public void moveBlockLeft()
    {
        if(block == null) return;
         if(checkLeft())
         {
           block.moveLeft();
           Tetris.playMove();
           repaint();  
         }
        
    }
    
    public void rotateBlock()
    {
        
        if(block == null) return;
     // if(block.getX()+block.getHeight()<=gridColumns){
        Tetris.playRotate();
        block.rotate();
        if(block.getLeftEdge() < 0) block.setX(0);
        if(block.getRightEdge() >= gridColumns) block.setX(gridColumns-block.getWidth());
        if(block.getBotomEdge()>= this.gridRows) block.setY(gridRows-block.getHeight());
        repaint(); 
      
          
        
      
     
    }
    
    public void dropBlock()
    {
        if(block == null) return;
        while(checkBottom())       
        {
        block.moveDown();               
        }//hace el efecto de teletransportarse hacia abajo
        repaint(); 
    }
    
    public boolean isBlockOutOfBonds()
    { 
        if(block.getY()<0)
        {
            block=null;
            return true;
        }  
        return false;
    }
    
    public boolean moveBlockDown()
    {        
      if(checkBottom()==false)
        {        
       
        return false;
        }
        
        block.moveDown();      
        repaint();//este metodo vuelve a pintar (actualiza) el gameArea y proviene de JComponent (el cual fue heredado a esta clase)
        return true; 
       
    }
     
    private boolean checkBottom()
    {   
        if(block.getBotomEdge()==gridRows)
        {
        return false;  
        }
        int[][] shape =block.getShape(); 
        int h= block.getHeight();  
        int w= block.getWidth();
         for(int c= 0 ; c<w;c++)
         {
            for(int r=(h-1) ; r>=0 ;r--)
            {
                if(shape[r][c]!=0)
                {
                    int x=c+block.getX();//la posicion en x al bloque evaluado
                    int y=r+block.getY()+1;//la posicion siguiente al bloque evaluado
                    if(y<0) break;
                    if(background[y][x] != null) return false; // no confundir el x y el y
                    break;    
                
                
                }      
            }
         }
        return true;  
    }
    
    private boolean checkRight()
    {   
        if(block.getRightEdge()==gridColumns)
        {
        return false;  
        }
        
        
        
        int[][] shape =block.getShape(); 
        int h= block.getHeight();  
        int w= block.getWidth();
        for(int r= 0 ; r<h;r++)
        {
            for(int c=w-1 ; c>=0 ;c--)
            {   
                //System.out.println("....current.."+ block.getCurrentShape());
                //System.out.println(".m...shape["+r+"]["+c+"]"+shape[r][c]); 
                if(shape[r][c]!=0)
                {
                    int x=c+block.getX()+1;//la posicion siguiente al bloque evaluado
                    int y=r+block.getY();
                    if(y<0) break;
                    if(background[y][x] != null) return false; // no confundir el x y el y
                    break;    
                
                
                }      
            }
        }
         
         
        return true;  
    }
    
    private boolean checkLeft()
    {   
        if(block.getLeftEdge()==0)
        {
        return false;  
        }
        
        int[][] shape =block.getShape(); 
        int h= block.getHeight();  
        int w= block.getWidth();
        for(int r= 0 ; r<h;r++)
        {
            for(int c=0 ; c<w ;c++)
            {
                if(shape[r][c]!=0)
                {
                    int x=c+block.getX()-1;
                    int y=r+block.getY();
                    if(y<0) break;
                    if(background[y][x] != null) return false; // no confundir el x y el y
                    break;    
                
                
                }      
            }
        }
        
        
        return true;  
    }
    
    
    private void drawBackground(Graphics g) //dibujar el fondo (colores del tablero)
    {
        
        Color  color;
        for(int r= 0 ; r<this.gridRows;r++)
        {
            for(int c= 0 ; c<this.gridColumns;c++)
            {
               color=background[r][c] ;
                 if(color != null)
                 {
                    int x = c*gridCellSize ; 
                    int y = r*gridCellSize ;  
                    drawGridSqure( g,  color,  x, y);                          
                 }
                 
            }  
        } 
    }
    
    
    public void moveBlockToBackground() //dibujar un cuadrado en el tablero
    { 
       int[][] shape =block.getShape(); 
       int h= block.getHeight();  
       int w= block.getWidth();
       Color color =block.getColor();
       int xPos=block.getX();
       int yPos=block.getY();
       for(int r= 0 ; r<h;r++)
        {
            for(int c= 0 ; c<w;c++)
            {             
                 if(shape[r][c] == 1)
                 {
                   background[r+yPos][c+xPos]=color;
    
                 }
            }  
        }
      
    }
    
    
    private void drawGridSqure(Graphics g,Color  color, int x, int y) //dibujar un cuadrado en el tablero
    {
         g.setColor(color);//seleccionar el color del blocke
         g.fillRect(x, y, gridCellSize, gridCellSize);
         g.setColor(Color.BLACK);
         g.drawRect(x, y, gridCellSize, gridCellSize);   
      } 
    private void drawBlock(Graphics g) //dibujar el bloque en el en la posicion tablero
    {
     int h= block.getHeight();  
     int w= block.getWidth();
     Color c =block.getColor();
     int[][] shape =block.getShape();
     
     for(int row= 0 ; row<h;row++)
     {
        for(int col= 0 ; col<w;col++)
        {
         if(shape[row][col]==1)
           { 
             int x = (block.getX()+col)*gridCellSize ; //define la posicio del bloque a pintar a partir de una pocicion dada
             int y = (block.getY()+row)*gridCellSize ; 
              drawGridSqure( g,  c,  x, y);
           }
        }  
     }
    }
    
 //usando el famoso metodo  paintComponent dibujaremos las figuras  
    @Override
    protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);// permite dibujar el JPanel(superclase) 
       String rutaImagenFondo = "/imagenes/fondo.JPG";   
       this.imagen =  new ImageIcon(getClass().getResource(rutaImagenFondo)).getImage();
       g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this) ;
      
                
     //g.fillRect(0, 0, 50, 50);// (posicioen X,pos en Y ,ancho ,alto) se crea un cuadrado deltro del Jpanel
     
     for(int x=0 ; x<gridColumns ;x++)
      {
         for(int y=0 ; y<gridRows ;y++)
          {
              //g.setColor(new Color(0, 0, 0, 128)); // R, G, B, Alpha
               g.setColor(new Color(0, 0, 0));
               // Dibujar un cuadrado transparente
             //g.fillRect(x*gridCellSize, y*gridCellSize, gridCellSize, gridCellSize);   
             g.drawRect(x*gridCellSize, y*gridCellSize, gridCellSize, gridCellSize);            
          }
         
      } 
     drawBackground(g);
    if(block !=null)
    {
     drawBlock(g);   
    } 
     
     
    }
    

  /*  @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        String rutaImagenFondo = "/imagenes/fondo.JPG";   
       this.imagen =  new ImageIcon(getClass().getResource(rutaImagenFondo)).getImage();
       g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this) ;
       
    }*/


    
    
    
}
