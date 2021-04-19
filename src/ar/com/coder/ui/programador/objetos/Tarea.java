/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.programador.objetos;

import ar.com.coder.objetos.PedidoSeguimiento;
import ar.com.coder.ui.grillas.renders.PedidoGrillaRender;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author Torralba
 */
public class Tarea extends ComponenteProgramador {
    private String nombre="Tarea Generica";
    private int duracion=0;
    private Dia dia;
    private PedidoSeguimiento partida;

    public PedidoSeguimiento getPartida() {
        return partida;
    }

    public void setPartida(PedidoSeguimiento partida) {
        this.partida = partida;
    }
    
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
    public Tarea(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Tarea(Point p, String nombre) {
        super(p);
        this.nombre="Partida:" + nombre;
        inicializacion();
    }
    public Tarea(Point p, PedidoSeguimiento ps) {
        super(p);
        
        this.partida=ps;
        //setColorFondo(colorFondo);
    //    setAlto(ps.getCantidadLote().intValue());
        setAlto(30);
        inicializacion();
    }
 
    public Tarea(Point p, Color colorFondo, Integer alto) {
        super(p);
        setColorFondo(colorFondo);;
        setAlto(alto);
        inicializacion();
    }

    private void inicializacion() {
        if (this.getAlto() == null) {
            Random r = new Random();
            int alto = r.nextInt(90);
            this.setAlto(alto);
        }
        this.setAncho(100);
        this.setSize(this.getAncho(), this.getAlto());
        
//        if (this.getColorFondo() == null) {
//            this.setColorFondo(new Color(1, 1, 0, 0.60f));
//        }
        if (partida.getEstado().trim().toUpperCase().equals("EN PROCESO")) {
                this.setColorFondo(PedidoGrillaRender.COLOR_AZUL);
                this.nombre="Ped:" + partida.getIdPedido() ;
            }
            if (partida.getEstado().trim().toUpperCase().equals("CRUDO DSP+")) {
                this.setColorFondo(PedidoGrillaRender.COLOR_AMARILLO);
                this.nombre="Ped:" + partida.getIdPedido() ;
            }
        this.setColorLimites(Color.BLACK);
    }
}
