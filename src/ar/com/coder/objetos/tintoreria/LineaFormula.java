/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria;

import ar.com.coder.objetos.ArticuloInsumo;
import java.util.Objects;

/**
 *
 * @author sysadmin
 */
public class LineaFormula {
    private Integer orden;
    private ArticuloInsumo producto;
    private float concentracion;
    private String unidad;
    private float consumo;

    public LineaFormula(Integer orden, ArticuloInsumo producto, float concentracion, String unidad) {
        this.orden = orden;
        this.producto = producto;
        this.concentracion = concentracion;
        this.unidad = unidad;
    }
    
    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.orden);
        hash = 17 * hash + Objects.hashCode(this.producto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LineaFormula other = (LineaFormula) obj;
        if (!Objects.equals(this.orden, other.orden)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }
    

}
