package tetris;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author JUNIOR SILVA
 */
public class StratupForm extends javax.swing.JFrame {

    public StratupForm(){
        initComponents();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        btnLeaderBoard = new javax.swing.JButton();
        btnStartGame = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage( new ImageIcon("src/imagenes/icon.png").getImage().getScaledInstance(800,800,Image.SCALE_FAST));
        setResizable(false);

        btnLeaderBoard.setText("LeaderBoad");
        btnLeaderBoard.setBorder(null);
        btnLeaderBoard.setBorderPainted(false);
        btnLeaderBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaderBoardActionPerformed(evt);
            }
        });

        btnStartGame.setText("Star Game!");
        btnStartGame.setBorder(null);
        btnStartGame.setBorderPainted(false);
        btnStartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartGameActionPerformed(evt);
            }
        });

        btnQuit.setText("QUIT GAME!");
        btnQuit.setBorder(null);
        btnQuit.setBorderPainted(false);
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLeaderBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(btnStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLeaderBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        Tetris.playBtn();
        System.exit(0);//salir del sistema
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartGameActionPerformed
        Tetris.playBtn();
        this.setVisible(false);
        Tetris.start();
    }//GEN-LAST:event_btnStartGameActionPerformed

    private void btnLeaderBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaderBoardActionPerformed
        Tetris.playBtn();
        Tetris.showLeaderBoard();
        this.setVisible(false);
    }//GEN-LAST:event_btnLeaderBoardActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(StratupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StratupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StratupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StratupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StratupForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLeaderBoard;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnStartGame;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
