/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.objetos.tintoreria;

import java.util.ArrayList;

/**
 *
 * @author sysadmin
 */
public class NodoRuta {
    private Receta receta;
    private Maquina maquina;
    private EtapaProductiva etapaProductiva;
    private float tiempo;
    private float litrosAgua=0;
    private float costoReceta=0;
    private ArrayList<NodoRutaDetalle> detalle=new ArrayList<>();

    public NodoRuta() {
        this.maquina=Maquina.getMaquinaVacia();
        this.etapaProductiva=EtapaProductiva.getEtapaVacia();
        this.tiempo=0;
    }

    public EtapaProductiva getEtapaProductiva() {
        return etapaProductiva;
    }

    public void setEtapaProductiva(EtapaProductiva etapaProductiva) {
        this.etapaProductiva = etapaProductiva;
    }
    
    public float getTiempo() {
        return tiempo;
    }
    
    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }
    
    public ArrayList<NodoRutaDetalle> getDetalle() {
        return detalle;
    }

    public boolean add(NodoRutaDetalle e) {
        e.setNodoRuta(this);
        return detalle.add(e);
    }

    public void clear() {
        detalle.clear();
    }
    
    

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public float getLitrosAgua() {
        return litrosAgua;
    }

    public void setLitrosAgua(float litrosAgua) {
        this.litrosAgua = litrosAgua;
    }

    public float getCostoReceta() {
        return costoReceta;
    }

    public void setCostoReceta(float costoReceta) {
        this.costoReceta = costoReceta;
    }
    
}
