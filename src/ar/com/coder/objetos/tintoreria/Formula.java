/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria;

import ar.com.coder.objetos.Articulo;
import ar.com.coder.objetos.ArticuloInsumo;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author sysadmin
 */
public class Formula {
    private String codigo;
    private String nombre;    
    private TipoFormula tipo;
    public ArrayList<LineaFormula> lineas = new ArrayList<LineaFormula>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoFormula getTipo() {
        return tipo;
    }

    public void setTipo(TipoFormula tipo) {
        this.tipo = tipo;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<LineaFormula> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaFormula> lineas) {
        this.lineas = lineas;
    }

    public int size() {
        return lineas.size();
    }

    public boolean addInsumo(Integer orden,ArticuloInsumo producto,float concentracion,String unidad) {
        LineaFormula e=new LineaFormula(orden, producto, concentracion, unidad);
        return lineas.add(e);
    }

    public void clear() {
        lineas.clear();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
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
        final Formula other = (Formula) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
        
    }

    @Override
    public String toString() {
        return codigo + "|" + nombre ;
    }
    
    
} 
