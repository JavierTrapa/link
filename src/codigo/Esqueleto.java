/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import codigo.VentanaAnimacion;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author xp
 */
public class Esqueleto {
    Image esqueleto;
    int contador=0;
    int dir=0;
    boolean parado=true;
    private int x=200;
    private int y=200;
    
    public Esqueleto(){
        try {
            esqueleto = ImageIO.read((getClass().getResource("/imagenes/esqueleto.png")));
        } catch (IOException ex) {
            Logger.getLogger(VentanaAnimacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void dibuja (Graphics2D g2){
        int fila=0;
        if(!parado){
            switch(dir){
                case 1:
                    fila=5;//izquierda
                    mueve(-6,0);
                    break;
                case 2:
                    fila=7;//derecha
                    mueve(6,0);
                    break;
                case 3:
                    fila=6;//arriba
                    mueve(0,-6);
                    break;
                case 4:
                    fila=4;//abajo
                    mueve(0,6);
                    break;
            }
            contador++;
        }else{
            switch(dir){
                case 1:
                    fila=1;//izquierda
                    break;
                case 2:
                    fila=3;//derecha
                    break;
                case 3:
                    fila=2;//arriba
                    break;
                case 4:
                    fila=0;//abajo
                    break;
            }
            contador=0;
        }
        g2.drawImage(esqueleto,
                x,  //posición x dentro del buffer
                y,  //posición y dentro del buffer
                x+120/3,  //tamaño en el eje x del frame que quiero pintar
                y+130/3,  //tamaño en el eje y del frame que quiero pintar
                contador*120, //posicion inicial x dentro del SPRITESHEET
                fila*130, // posicion inicial y dentro del spritesheet
                contador*120 + 120, //tamaño del tile (ancho)
                fila*130 + 130, //tamaño del tile (alto)
                null
                );
        
        if(contador==9){contador=0;}
        
    
    }
    /*public Link(boolean pulsadaDerecha, boolean pulsadaIzquierda, boolean pulsadaArriba, boolean pulsadaAbajo){
        int contador=0;
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
                
    }*/
    
    public void mueve(int dx, int dy){
        x=x+dx;
        if(x<0){
            x=0;
        }
        y=y+dy;
        if(y<0){
            y=0;
        }
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }
}
