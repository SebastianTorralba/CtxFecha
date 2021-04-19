/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria;

import ar.com.coder.objetos.ArticuloInsumo;
import ar.com.coder.objetos.tintoreria.Formula;
import ar.com.coder.objetos.tintoreria.Receta;

/**
 *
 * @author sysadmin
 */
public class NodoRutaDetalle {
    private NodoRuta nodoRuta;
    private Formula formula;
    private Integer orden;
    private ArticuloInsumo producto;
    private float concentracion;
    private String unidad;
    
    private float consumo;
    private float costoConsumo;

    public NodoRuta getNodoRuta() {
        return nodoRuta;
    }

    public void setNodoRuta(NodoRuta nodoRuta) {
        this.nodoRuta = nodoRuta;
    }

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public ArticuloInsumo getProducto() {
        return producto;
    }

    public void setProducto(ArticuloInsumo producto) {
        this.producto = producto;
    }

    public float getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(float concentracion) {
        this.concentracion = concentracion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }

    public float getCostoConsumo() {
        return costoConsumo;
    }

    public void setCostoConsumo(float costoConsumo) {
        this.costoConsumo = costoConsumo;
    }
    
}
