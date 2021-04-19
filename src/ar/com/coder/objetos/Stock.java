/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos;

import ar.com.coder.objetos.ArticuloInsumo;

/**
 *
 * @author sysadmin
 */
public class Stock {
    private ArticuloInsumo articuloInsumo;    
    private float cantidad;

    public Stock(ArticuloInsumo articuloInsumo, float cantidad) {
        this.articuloInsumo = articuloInsumo;
        this.cantidad = cantidad;
    }
    
    public ArticuloInsumo getArticuloInsumo() {
        return articuloInsumo;
    }

    public void setArticuloInsumo(ArticuloInsumo articuloInsumo) {
        this.articuloInsumo = articuloInsumo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    
}
