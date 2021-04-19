/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria;


public class RutaColor extends RutaBase {
      private Color color;
      private NodoRutaColor nodoRutaColor;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public NodoRutaColor getNodoRutaColor() {
        return nodoRutaColor;
    }

    public void setNodoRutaColor(NodoRutaColor nodoRutaColor) {
        this.nodoRutaColor = nodoRutaColor;
    }
      
}
