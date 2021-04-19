/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos;


public class ArticuloProduccion extends Articulo {
    private float ancho;
    private float grml;

    public ArticuloProduccion() {
    }

    public ArticuloProduccion(String codigo, String nombre) {
        super(codigo, nombre);
    }
    
    
    @Override
    public String toString() {
        return getCodigo();
    }
    
    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getGrml() {
        return grml;
    }

    public void setGrml(float grml) {
        this.grml = grml;
    }
    
    
    
}
