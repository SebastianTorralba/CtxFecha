/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria.simulador;

import ar.com.coder.objetos.tintoreria.Ruta;
import ar.com.coder.objetos.tintoreria.RutaBase;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author sysadmin
 */
public class ArticuloSimulado {
    private RutaBase ruta;
    private Integer metros;
    private Float kilos;
    private boolean activa=true;
    private ArrayList<ArticuloSimulado> variantes = new ArrayList<>();

    public void setVariantes(ArrayList<ArticuloSimulado> variantes) {
        this.variantes = variantes;
    }
    
    public ArticuloSimulado get(int index) {
        return variantes.get(index);
    }
    
    public int size() {
        return variantes.size();
    }

    public boolean add(ArticuloSimulado e) {
        return variantes.add(e);
    }

    public boolean remove(Object o) {
        return variantes.remove(o);
    }

    public ArticuloSimulado(RutaBase ruta, Integer metros, Float kilos) {
        this.ruta = ruta;
        this.metros = metros;
        this.kilos = kilos;
    }
    
    
    
    public ArticuloSimulado(Ruta ruta) {
        this.ruta = ruta;
        this.metros=0;
        this.kilos=metros * ruta.getArticulo().getGrml() / 1000;
    }

    public ArticuloSimulado() {
    }

    public Float getKilos() {
        return kilos;
    }

    public void setKilos(Float kilos) {
        this.kilos = kilos;
    }
    
    

    public RutaBase getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Integer getMetros() {
        return metros;
    }

    public void setMetros(Integer metros) {
        this.metros = metros;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.ruta);
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
        final ArticuloSimulado other = (ArticuloSimulado) obj;
        if (!Objects.equals(this.ruta, other.ruta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ruta.getArticulo().toString();
    }
    
    
    
}
