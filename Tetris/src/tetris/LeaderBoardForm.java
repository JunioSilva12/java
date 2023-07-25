package tetris;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author JUNIOR SILVA
 */
public class LeaderBoardForm extends javax.swing.JFrame {

    private DefaultTableModel tm ;
    private String leaderboardFile = "leaderBoard";
    
    private TableRowSorter<TableModel> sorter;
    
    
    
    public LeaderBoardForm()  {
        initComponents();
        initTableData();
        initTableSorter();
    }
    
    
    
    public void initTableSorter()
    {
    sorter = new TableRowSorter<>(tm) ;
    leaderBoard.setRowSorter(sorter);
    ArrayList<SortKey> keys = new ArrayList<>();
    keys.add(new SortKey(1,SortOrder.DESCENDING));//el 1 es el indice del score
    sorter.setSortKeys(keys);
    //DATO: PARA ORDENAR EN LA TABLA EL DATO DEBE SER INTEGER Y NO oBJECT
    }
    
    
    @SuppressWarnings("unchecked")///importante: agregar el Unchecked o no se crea ejecutabel bien
    public void initTableData()
    {
        Vector ci = new Vector() ;
        ci.add("Palyer");
        ci.add("Score");
        
          
        
        tm = (DefaultTableModel) leaderBoard.getModel();
       ///DATO INTERESANTEEEEEE .... java no asocia el TableModel con el DefaultTableModel asi que forzamos el casteo
       //super importante los datos de la tabla debes ser de tipo Object
        try {
            FileInputStream fis = new FileInputStream(leaderboardFile);//el lector de aschivos 
            ObjectInputStream os = new ObjectInputStream(fis); //el lector de Object en el archivo
            tm.setDataVector((Vector<Vector>) os.readObject(), ci); //importante castear de Object a vector vector


            os.close();
            fis.close();
       
        } catch (Exception ex) {/*System.out.println("no leyó");*/}
       
      
    }
    
    public void saveLeader() 
    {//serializaremos el vector 
        try{
            FileOutputStream fs = new FileOutputStream(leaderboardFile);
            ObjectOutputStream os = new ObjectOutputStream(fs);      
            os.writeObject(tm.getDataVector());
            os.close();
            fs.close();
        }catch(Exception e)
        {//para las dos excepciones que hay 
            System.out.println("fallo al guardar");    
        }
           
        
        
    }
    
    
       public void addPlayer(String playername , int score) {
           //System.out.println("playername"+playername+".......");
           if(!"".equals(playername))
           {
                tm.addRow(new Object[]{playername,score}); // super interesante esta forma de crear objetos puede ser super util
                sorter.sort();//ORGANIZA 
                saveLeader() ;
                //System.out.println("el jugador : "+playername+" obtuvo : "+score);
                this.setVisible(true);   
           }else{
               Tetris.showStratup();
           }
           
          
        
    } 


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        leaderBoard = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage( new ImageIcon("src/imagenes/icon.png").getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));
        setResizable(false);

        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnHome.setText("<html><p>Main</p><p>Menu</p></html>");
        btnHome.setBorder(null);
        btnHome.setBorderPainted(false);
        btnHome.setFocusable(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        leaderBoard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        leaderBoard.setOpaque(false);
        leaderBoard.setShowGrid(true);
        jScrollPane1.setViewportView(leaderBoard);
        if (leaderBoard.getColumnModel().getColumnCount() > 0) {
            leaderBoard.getColumnModel().getColumn(1).setPreferredWidth(150);
            leaderBoard.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Tetris.playBtn();
        Tetris.showStratup();
        this.setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

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
            java.util.logging.Logger.getLogger(LeaderBoardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeaderBoardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeaderBoardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeaderBoardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaderBoardForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable leaderBoard;
    // End of variables declaration//GEN-END:variables
}
