/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria;

import ar.com.coder.objetos.Articulo;
import ar.com.coder.objetos.ArticuloProduccion;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author sysadmin
 */
public class Barcada {
    private Integer numero;
    private ArticuloProduccion articulo;
    private Receta receta;
    private Float metros;
    private Float peso;
    private Maquina maquina;
    private Date fechaCarga;
    private Date fechaEjecucion;
    private String partida;
    private String tipo;
    private Color color;
    private float litrosAgua;

    public float getLitrosAgua() {
        return litrosAgua;
    }

    public void setLitrosAgua(float litrosAgua) {
        this.litrosAgua = litrosAgua;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
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
        final Barcada other = (Barcada) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }
    
    
    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public ArticuloProduccion getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloProduccion articulo) {
        this.articulo = articulo;
    }

    public Float getMetros() {
        return metros;
    }

    public void setMetros(Float metros) {
        this.metros = metros;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    
    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }
    
}
