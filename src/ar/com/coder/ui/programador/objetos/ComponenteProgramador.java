/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.programador.objetos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;

/**
 *
 * @author Torralba
 */
public class ComponenteProgramador extends Rectangle {

    private Integer ancho;
    private Integer alto;
    private Color colorFondo;
    private Color colorLimites;
    private Stroke trazoLimites = new BasicStroke(2);

    public ComponenteProgramador(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public ComponenteProgramador(Point p) {
        super(p);
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

    public Color getColorLimites() {
        return colorLimites;
    }

    public void setColorLimites(Color colorLimites) {
        this.colorLimites = colorLimites;
    }

    public Stroke getTrazoLimites() {
        return trazoLimites;
    }

    public void setTrazoLimites(Stroke trazoLimites) {
        this.trazoLimites = trazoLimites;
    }
}
