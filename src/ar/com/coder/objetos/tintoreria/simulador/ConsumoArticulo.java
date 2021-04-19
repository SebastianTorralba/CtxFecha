/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria.simulador;

import ar.com.coder.objetos.ArticuloInsumo;
import java.util.Objects;

/**
 *
 * @author sysadmin
 */
public class ConsumoArticulo implements Comparable<ConsumoArticulo>{

    private ArticuloInsumo producto;
    private String unidad;
    private float consumo;
    private float costoConsumo;

    public ConsumoArticulo() {
    }
    
    public ConsumoArticulo(ArticuloInsumo producto, String unidad, float consumo, float costoConsumo) {
        this.producto = producto;
        this.unidad = unidad;
        this.consumo = consumo;
        this.costoConsumo = costoConsumo;
    }

         
    public ArticuloInsumo getProducto() {
        return producto;
    }

    public void setProducto(ArticuloInsumo producto) {
        this.producto = producto;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.producto);
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
        final ConsumoArticulo other = (ConsumoArticulo) obj;
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(ConsumoArticulo ca) {
        return (int) ((int) this.getConsumo()-ca.getConsumo());
    }
    
    
}
