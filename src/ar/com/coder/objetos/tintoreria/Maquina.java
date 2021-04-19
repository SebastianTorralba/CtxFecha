/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria;

import java.util.Objects;
import java.util.Set;

/**
 *
 * @author sysadmin
 */
public class Maquina {
    private String codigo;
    private String nombre;
    private float litroAgua;
    private float factor;
    public static final int LITROS_FONDO=150;
    public float velocidadNominal;
    public float rendimiento;
    public float velocidadReal;
    
    public Set<RecursoNoAlmacenado> recursos;

    public Set<RecursoNoAlmacenado> getRecursos() {
        return recursos;
    }

    public int size() {
        return recursos.size();
    }

    public boolean add(RecursoNoAlmacenado e) {
        return recursos.add(e);
    }

    public boolean remove(Object o) {
        return recursos.remove(o);
    }
    
   
    public float getVelocidadNominal() {
        return velocidadNominal;
    }

    public void setVelocidadNominal(float velocidadNominal) {
        this.velocidadNominal = velocidadNominal;
    }

    public float getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(float rendimiento) {
        this.rendimiento = rendimiento;
    }

    public float getVelocidadReal() {
        return velocidadReal;
    }

    public void setVelocidadReal(float velocidadReal) {
        this.velocidadReal = velocidadReal;
    }
    public static Maquina getMaquinaVacia(){
        Maquina m = new Maquina();
        m.setCodigo("NINGUNA");
        m.setNombre("NINGUNA");
        m.setFactor(0);
        m.setLitroAgua(0);
        return m;
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

    public float getLitroAgua() {
        return litroAgua;
    }

    public void setLitroAgua(float litroAgua) {
        this.litroAgua = litroAgua;
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.codigo);
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
        final Maquina other = (Maquina) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  codigo + "|" + nombre ;
    }
    
    
}
