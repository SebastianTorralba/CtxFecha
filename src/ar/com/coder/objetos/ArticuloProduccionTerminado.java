/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos;

import ar.com.coder.objetos.tintoreria.Color;


public class ArticuloProduccionTerminado extends ArticuloProduccion {
    private Color color;
    private String codArticuloNodum;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getCodArticuloNodum() {
        return codArticuloNodum;
    }

    public void setCodArticuloNodum(String codArticuloNodum) {
        this.codArticuloNodum = codArticuloNodum;
    }
    
}
