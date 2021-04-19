/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos;

import ar.com.coder.objetos.tintoreria.Barcada;
import ar.com.coder.objetos.tintoreria.Maquina;
import java.util.Date;

/**
 *
 * @author sysadmin
 */
public class ReporteQuimico {
    private ArticuloInsumo producto;
    private Date fecha;
    private float cantidad;
    private String unidad;
    private Maquina maquina;
    private String modo;
    private Barcada barcada;

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }
   
    
    public ArticuloInsumo getProducto() {
        return producto;
    }

    public void setProducto(ArticuloInsumo producto) {
        this.producto = producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Barcada getBarcada() {
        return barcada;
    }

    public void setBarcada(Barcada barcada) {
        this.barcada = barcada;
    }
    
}
