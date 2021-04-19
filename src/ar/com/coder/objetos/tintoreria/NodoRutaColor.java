/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria;


public class NodoRutaColor extends NodoRuta {
     private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public NodoRutaColor() {
        setMaquina(Maquina.getMaquinaVacia());
        this.color=Color.getColorVacio();
        
    }
     
}
