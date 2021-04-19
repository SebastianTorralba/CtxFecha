/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos;

import java.util.Date;

/**
 *
 * @author sysadmin
 */
public class Partida {
    private String nroLote;
    private String codArticulo;
    private Integer idPedido;
    private Double cantidad;
    private Date fechaIngresoProceso;
    private Date fechaEgresoProceso;

    public Partida() {
    }

    public Partida(String nroLote, Date fechaEgresoProceso) {
        this.nroLote = nroLote;
        this.fechaEgresoProceso = fechaEgresoProceso;
    }

    public String getNroLote() {
        return nroLote;
    }

    public void setNroLote(String nroLote) {
        this.nroLote = nroLote;
    }

    public String getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngresoProceso() {
        return fechaIngresoProceso;
    }

    public void setFechaIngresoProceso(Date fechaIngresoProceso) {
        this.fechaIngresoProceso = fechaIngresoProceso;
    }

    public Date getFechaEgresoProceso() {
        return fechaEgresoProceso;
    }

    public void setFechaEgresoProceso(Date fechaEgresoProceso) {
        this.fechaEgresoProceso = fechaEgresoProceso;
    }
    
}
