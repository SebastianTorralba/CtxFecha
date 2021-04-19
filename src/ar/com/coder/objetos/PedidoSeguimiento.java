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
public class PedidoSeguimiento {
        private Integer idPedido;
        private Date fechaIngreso;
        private String estado;
        private String cliente;
        private Integer prioridad;
        private String codArticulo;
        private String codArtBase;
        private String codDibujo;
        private String codVarianteColor;

    public String getCodDibujo() {
        return codDibujo;
    }

    public void setCodDibujo(String codDibujo) {
        this.codDibujo = codDibujo;
    }

    public String getCodVarianteColor() {
        return codVarianteColor;
    }

    public void setCodVarianteColor(String codVarianteColor) {
        this.codVarianteColor = codVarianteColor;
    }
        private Double cantidad;
        private Double saldo;
        private String nroLote;
        private Double cantidadLote;
        private boolean tieneFechaEntregaDeclarada;
        private Date fechaEntrega;
        private Date fechaIngresoProceso;
        private Date fechaEgresoProceso;
        private Date fechaCompromiso;
        private Date fechaUltimoDespacho; 
        private Double cantidadPrimeraLote;
        private Double cantidadSegundaLote;
        private Character terminado;
        private String observacion;
        private String codArticuloCrudo;

    public String getCodArticuloCrudo() {
        return codArticuloCrudo;
    }

    public void setCodArticuloCrudo(String codArticuloCrudo) {
        this.codArticuloCrudo = codArticuloCrudo;
    }
        
        

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
        
        
        
    public Character getTerminado() {
        return terminado;
    }

    public void setTerminado(Character terminado) {
        this.terminado = terminado;
    }
        
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getCodArtBase() {
        return codArtBase;
    }

    public void setCodArtBase(String codArtBase) {
        this.codArtBase = codArtBase;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNroLote() {
        return nroLote;
    }

    public void setNroLote(String nroLote) {
        this.nroLote = nroLote;
    }

    public Double getCantidadLote() {
        return cantidadLote;
    }

    public void setCantidadLote(Double cantidadLote) {
        this.cantidadLote = cantidadLote;
    }

    public boolean isTieneFechaEntregaDeclarada() {
        return tieneFechaEntregaDeclarada;
    }

    public void setTieneFechaEntregaDeclarada(boolean tieneFechaEntregaDeclarada) {
        this.tieneFechaEntregaDeclarada = tieneFechaEntregaDeclarada;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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

    public Date getFechaCompromiso() {
        return fechaCompromiso;
    }

    public void setFechaCompromiso(Date fechaCompromiso) {
        this.fechaCompromiso = fechaCompromiso;
    }

    public Date getFechaUltimoDespacho() {
        return fechaUltimoDespacho;
    }

    public void setFechaUltimoDespacho(Date fechaUltimoDespacho) {
        this.fechaUltimoDespacho = fechaUltimoDespacho;
    }

    public Double getCantidadPrimeraLote() {
        return cantidadPrimeraLote;
    }

    public void setCantidadPrimeraLote(Double cantidadPrimeraLote) {
        this.cantidadPrimeraLote = cantidadPrimeraLote;
    }

    public Double getCantidadSegundaLote() {
        return cantidadSegundaLote;
    }

    public void setCantidadSegundaLote(Double cantidadSegundaLote) {
        this.cantidadSegundaLote = cantidadSegundaLote;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.idPedido != null ? this.idPedido.hashCode() : 0);
        hash = 47 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 47 * hash + (this.nroLote != null ? this.nroLote.hashCode() : 0);
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
        final PedidoSeguimiento other = (PedidoSeguimiento) obj;
        if ((this.estado == null) ? (other.estado != null) : !this.estado.equals(other.estado)) {
            return false;
        }
        if ((this.nroLote == null) ? (other.nroLote != null) : !this.nroLote.equals(other.nroLote)) {
            return false;
        }
        if (this.idPedido != other.idPedido && (this.idPedido == null || !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    
        
}

