/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria;

import java.util.Objects;

/**
 *
 * @author Administrador
 */
public class RecursoNoAlmacenado {
    private String codigo;
    private String nombre;
    private String unidad;
    private String tipo;
    private float ultimoMontoMn;
    private float ultimoMontoTr;

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getUltimoMontoMn() {
        return ultimoMontoMn;
    }

    public void setUltimoMontoMn(float ultimoMontoMn) {
        this.ultimoMontoMn = ultimoMontoMn;
    }

    public float getUltimoMontoTr() {
        return ultimoMontoTr;
    }

    public void setUltimoMontoTr(float ultimoMontoTr) {
        this.ultimoMontoTr = ultimoMontoTr;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigo);
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
        final RecursoNoAlmacenado other = (RecursoNoAlmacenado) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    
}
