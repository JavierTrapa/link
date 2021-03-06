package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author Jorge Cisneros
 */
public class VentanaAnimacion extends javax.swing.JFrame {
    //buffer para pintar sobre el jPanel
    BufferedImage buffer = null;
    //ancho y alto de la pantalla
    int anchoPantalla = 700;
    int altoPantalla = 700;
    
    //temporizador para crear la animación
    Timer temporizador = new Timer( 30, new ActionListener(){
        public void actionPerformed(ActionEvent e){
            bucleJuego();
        }
    });
    
    boolean pulsadaDerecha = false;
    boolean pulsadaIzquierda = false;
    boolean pulsadaArriba = false;
    boolean pulsadaAbajo = false;
    
    int direccion=0;
    
    Link link=new Link();
    
    ArrayList <Esqueleto> listaEsqueletos=new ArrayList();
    Esqueleto esqueleto=new Esqueleto();
    /**
     * Creates new form VentanaAnimacion
     */
    public VentanaAnimacion() {
        initComponents();
        
        this.setSize(anchoPantalla, altoPantalla);
        buffer = (BufferedImage) jPanel1.createImage(anchoPantalla, altoPantalla);
        temporizador.start();
    }

    private void bucleJuego(){
        //primero apunto al buffer
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        //borro la pantalla
        g2.setColor(Color.black);
        g2.fillRect(0, 0, anchoPantalla, altoPantalla);
        ///////////////////// dibujo a link //////////////
        link.setDir(direccion);
        link.dibuja(g2);
        esqueleto.dibuja(g2);
        
        /*pintaLink(contador, pulsadaDerecha, pulsadaIzquierda, pulsadaArriba, pulsadaAbajo, g2);
        contador++;*/
        /////////////////////////////////////////////////
        //apunto al jPanel y repinto con el nuevo buffer
        g2 = (Graphics2D) jPanel1.getGraphics();
        g2.drawImage(buffer , 0, 0 , null);
        
        
    }
    
    /*private void pintaLink(int contador, boolean pulsadaDerecha, boolean pulsadaIzquierda, boolean pulsadaArriba, boolean pulsadaAbajo, Graphics2D g2){
        if(!pulsadaDerecha && !pulsadaIzquierda && !pulsadaArriba && !pulsadaAbajo){
            contador++;
            if(contador>=3){contador=0;}
            g2.drawImage(link,
                100,  //posición x dentro del buffer
                100,  //posición y dentro del buffer
                2*120,  //tamaño en el eje x del frame que quiero pintar
                2*130,  //tamaño en el eje y del frame que quiero pintar
                contador*120, //posicion inicial x dentro del SPRITESHEET
                0*130, // posicion inicial y dentro del spritesheet
                contador*120 + 120, //tamaño del tile (ancho)
                0*130 + 130, //tamaño del tile (alto)
                null
                );
            
        }
        if(!pulsadaDerecha && !pulsadaIzquierda && !pulsadaArriba && !pulsadaAbajo){
            
            if(contador>=3){contador=0;}
            g2.drawImage(link,
                100,  //posición x dentro del buffer
                100,  //posición y dentro del buffer
                2*120,  //tamaño en el eje x del frame que quiero pintar
                2*130,  //tamaño en el eje y del frame que quiero pintar
                contador*120, //posicion inicial x dentro del SPRITESHEET
                0*130, // posicion inicial y dentro del spritesheet
                contador*120 + 120, //tamaño del tile (ancho)
                0*130 + 130, //tamaño del tile (alto)
                null
                );
            contador++;
        }
        if(pulsadaDerecha){
            contador++;
            if(contador==10){contador=0;}
            g2.drawImage(link,
                100,  //posición x dentro del buffer
                100,  //posición y dentro del buffer
                2*120,  //tamaño en el eje x del frame que quiero pintar
                2*130,  //tamaño en el eje y del frame que quiero pintar
                contador*120, //posicion inicial x dentro del SPRITESHEET
                7*130, // posicion inicial y dentro del spritesheet
                contador*120 + 120, //tamaño del tile (ancho)
                7*130 + 130, //tamaño del tile (alto)
                null
                );
        }
        if(pulsadaIzquierda){
            contador++;
            if(contador==10){contador=0;}
            g2.drawImage(link,
                100,  //posición x dentro del buffer
                100,  //posición y dentro del buffer
                2*120,  //tamaño en el eje x del frame que quiero pintar
                2*130,  //tamaño en el eje y del frame que quiero pintar
                contador*120, //posicion inicial x dentro del SPRITESHEET
                5*130, // posicion inicial y dentro del spritesheet
                contador*120 + 120, //tamaño del tile (ancho)
                5*130 + 130, //tamaño del tile (alto)
                null
                );
        }
        if(pulsadaArriba){
            contador++;
            if(contador==10){contador=0;}
            g2.drawImage(link,
                100,  //posición x dentro del buffer
                100,  //posición y dentro del buffer
                2*120,  //tamaño en el eje x del frame que quiero pintar
                2*130,  //tamaño en el eje y del frame que quiero pintar
                contador*120, //posicion inicial x dentro del SPRITESHEET
                6*130, // posicion inicial y dentro del spritesheet
                contador*120 + 120, //tamaño del tile (ancho)
                6*130 + 130, //tamaño del tile (alto)
                null
                );
        }
        if(pulsadaAbajo){
            contador++;
            if(contador==10){contador=0;}
            g2.drawImage(link,
                100,  //posición x dentro del buffer
                100,  //posición y dentro del buffer
                2*120,  //tamaño en el eje x del frame que quiero pintar
                2*130,  //tamaño en el eje y del frame que quiero pintar
                contador*120, //posicion inicial x dentro del SPRITESHEET
                4*130, // posicion inicial y dentro del spritesheet
                contador*120 + 120, //tamaño del tile (ancho)
                4*130 + 130, //tamaño del tile (alto)
                null
                );
        }
        
    }*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch(evt.getKeyCode()){
            case KeyEvent.VK_LEFT: direccion=1; break;
            case KeyEvent.VK_RIGHT: direccion=2; break;
            case KeyEvent.VK_UP: direccion=3; break;
            case KeyEvent.VK_DOWN: direccion=4; break;
        }
        link.parado=false;
        /*if (evt.getKeyCode() == KeyEvent.VK_LEFT)
        {
           pulsadaIzquierda = true;
           pulsadaDerecha = false;
           pulsadaArriba=false;
           pulsadaAbajo=false;
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
           pulsadaIzquierda = false;
           pulsadaDerecha = true;
           pulsadaArriba=false;
           pulsadaAbajo=false;
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP)
        {
           pulsadaIzquierda = false;
           pulsadaDerecha = false;
           pulsadaArriba=true;
           pulsadaAbajo=false;
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN)
        {
           pulsadaIzquierda = false;
           pulsadaDerecha = false;
           pulsadaArriba=false;
           pulsadaAbajo=true;
        }*/
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
           /*pulsadaIzquierda = false;
           pulsadaDerecha = false;
           pulsadaArriba = false;
           pulsadaAbajo = false;*/
        link.parado=true;
    }//GEN-LAST:event_formKeyReleased

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
            java.util.logging.Logger.getLogger(VentanaAnimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAnimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAnimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAnimacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAnimacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
