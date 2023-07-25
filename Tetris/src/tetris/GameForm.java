package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author JUNIOR SILVA
 */
public class GameForm extends JFrame
{
    private GameArea ga ;
    private GameThread gt;

    public GameForm() 
    {   
        
        initComponents();// primero habia que inicializar los componentes              
        this.ga = new GameArea(GameAreaPlaceholder,10);        
        this.add(this.ga);//agregamos el componente JPanel
        initControls();
        
        
         //startGame(); //hilo
    }
    class FondoPanel extends JPanel
    {
        private Image imagen ;
        @Override
       public void paint(Graphics g)
       {
       String rutaImagenFondo = "/imagenes/fondo2.jpg";   
       this.imagen =  new ImageIcon(getClass().getResource(rutaImagenFondo)).getImage();
       g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this) ;
       this.setSize(800, 450);
       this.setOpaque(false);
      // g.setColor(new Color(0, 0, 0, 128));
       //g.drawRect(0,0, 50, 50);  
       super.paint(g);
       }
        
    }
    public class JPanelOpaco extends JPanel 
    {
    public JPanelOpaco() 
    {  
        super();
        setOpaque(false);
    }
      

    @Override
    protected void paintComponent(Graphics g) {
        // Llama al método paintComponent de la clase padre para realizar el dibujado predeterminado
        super.paintComponent(g);

        // Establece el color de fondo con un valor de transparencia
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    }

    public void startGame() 
    {// este metodo sera el responsable de crear e iniciar el hilo de juego
        Tetris.playBackground();
        ga.initBackgroudarray();
        gt = new GameThread(ga,this);
        gt.start();
    }
    
    public void updateGameScore(int Score)
    {
       scoreDisplay.setText("Score : "+Score);
    }
    
    public void updateGameLevel(int level)
    {
        levelDisplay.setText("Level "+level);
    }
    
    public void initControls()
    { //para que esto funcione siempre quitenle la propiedad focusable a los botones
      //System.out.println("EN iNIT");
      InputMap im = this.getRootPane().getInputMap(); 
      ActionMap am = this.getRootPane().getActionMap(); 
      // obtenemos el inputmap y el actionmaps del Jframe (especificamente del rootpane) 
      
     im.put(KeyStroke.getKeyStroke("RIGHT"), "right");
     im.put(KeyStroke.getKeyStroke("LEFT"), "left");
     im.put(KeyStroke.getKeyStroke("UP"), "up");
     im.put(KeyStroke.getKeyStroke("DOWN"), "down");
     

     
     am.put("right", new AbstractAction(){      
          @Override
          public void actionPerformed(ActionEvent e) {
              //System.out.println("Right");
              ga.moveBlockRight();
          } 
     });
     am.put("left",new AbstractAction(){
          @Override
          public void actionPerformed(ActionEvent e) {
                //System.out.println("Left");
                ga.moveBlockLeft();
          } 
     });
     am.put("up", new AbstractAction(){
          @Override
          public void actionPerformed(ActionEvent e) {
                //System.out.println("Up");
                ga.rotateBlock();
          } 
     });
     am.put("down", new AbstractAction(){
          @Override
          public void actionPerformed(ActionEvent e) {
                //System.out.println("Down");
                ga.dropBlock();
          } 
     });
     
     
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FondoPanel = new FondoPanel();
        GameAreaPlaceholder = new javax.swing.JPanel();
        scoreDisplay = new javax.swing.JLabel();
        levelDisplay = new javax.swing.JLabel();
        btnQuit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tetris2");
        setIconImage( new ImageIcon("src/imagenes/icon.png").getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        setResizable(false);

        FondoPanel.setPreferredSize(new java.awt.Dimension(800, 450));

        GameAreaPlaceholder.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        GameAreaPlaceholder.setOpaque(false);
        GameAreaPlaceholder.setPreferredSize(new java.awt.Dimension(220, 400));

        javax.swing.GroupLayout GameAreaPlaceholderLayout = new javax.swing.GroupLayout(GameAreaPlaceholder);
        GameAreaPlaceholder.setLayout(GameAreaPlaceholderLayout);
        GameAreaPlaceholderLayout.setHorizontalGroup(
            GameAreaPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );
        GameAreaPlaceholderLayout.setVerticalGroup(
            GameAreaPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        scoreDisplay.setBackground(java.awt.Color.darkGray);
        scoreDisplay.setFont(new java.awt.Font("Showcard Gothic", 3, 36)); // NOI18N
        scoreDisplay.setForeground(new java.awt.Color(0, 0, 0));
        scoreDisplay.setText("Score ");

        levelDisplay.setBackground(java.awt.Color.darkGray);
        levelDisplay.setFont(new java.awt.Font("Showcard Gothic", 3, 36)); // NOI18N
        levelDisplay.setForeground(new java.awt.Color(0, 0, 0));
        levelDisplay.setText("Level : 1");

        btnQuit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnQuit.setText("<html><p>Main</p><p>Menu</p></html>");
        btnQuit.setBorder(null);
        btnQuit.setBorderPainted(false);
        btnQuit.setFocusable(false);
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FondoPanelLayout = new javax.swing.GroupLayout(FondoPanel);
        FondoPanel.setLayout(FondoPanelLayout);
        FondoPanelLayout.setHorizontalGroup(
            FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(GameAreaPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addGroup(FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoPanelLayout.createSequentialGroup()
                        .addGroup(FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(levelDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoPanelLayout.createSequentialGroup()
                        .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        FondoPanelLayout.setVerticalGroup(
            FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FondoPanelLayout.createSequentialGroup()
                        .addComponent(scoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(levelDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199)
                        .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(GameAreaPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
         Tetris.playBtn();
        Tetris.shutBackgroundSound();
        gt.interrupt();
        Tetris.showStratup();
        this.setVisible(false);
        
        
    }//GEN-LAST:event_btnQuitActionPerformed

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FondoPanel;
    private javax.swing.JPanel GameAreaPlaceholder;
    private javax.swing.JButton btnQuit;
    private javax.swing.JLabel levelDisplay;
    private javax.swing.JLabel scoreDisplay;
    // End of variables declaration//GEN-END:variables
}
