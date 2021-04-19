/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author sysadmin
 */
public class Receta implements Cloneable{
    private String codigo;
    private String nombre;
    private Color  color;
    private ArrayList<Formula> formulas=new ArrayList<Formula>();

    @Override
    public String toString() {
        return  codigo + "|" + nombre ;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.codigo);
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
        final Receta other = (Receta) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int size() {
        return formulas.size();
    }

    public ArrayList<Formula> getFormulas() {
        return formulas;
    }
    
    public boolean add(Formula e) {
        return formulas.add(e);
    }

    public Formula remove(int index) {
        return formulas.remove(index);
    }

    public boolean remove(Object o) {
        return formulas.remove(o);
    }

    public void clear() {
        formulas.clear();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
