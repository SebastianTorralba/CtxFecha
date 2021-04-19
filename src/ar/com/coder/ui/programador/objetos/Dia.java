/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.programador.objetos;
import ar.com.coder.util.Util;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 *
 * @author Torralba
 */
public class Dia extends ComponenteProgramador implements Comparable<Dia>{
    private List<Tarea> tareas = new ArrayList();
    private Date fecha;
    public static final int ANCHO=100;
    public static final int ALTO=1440;
    public static final int OFFSET=20;
    public Date getFecha() {
        return fecha;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        for(Tarea t:tareas){
            t.setDia(this);
        }
        this.tareas = tareas;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Dia(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Dia(Point p) {
        super(p);
        inicializacion();
    }
    private void inicializacion (){
        this.setAlto(ALTO);
        this.setAncho(ANCHO);
        this.setSize(this.getAncho(), this.getAlto());
        this.setColorFondo(Color.WHITE);
        this.setColorLimites(Color.GRAY);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.fecha != null ? this.fecha.hashCode() : 0);
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
        final Dia other = (Dia) obj;
        if (this.fecha != other.fecha && (this.fecha == null || !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    

    @Override
    public int compareTo(Dia dia) {
            return (int) Util.diffFecha(dia.getFecha(), this.getFecha());
    }

    public boolean addTarea(Tarea e) {
        e.setDia(this);
        return tareas.add(e);
    }

    public boolean removeTarea(Tarea o) {
        o.setDia(null);
        return tareas.remove(o);
    }
    
}

