/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import ar.com.coder.objetos.ArticuloInsumo;
import java.util.ArrayList;
import java.util.Date;
import ar.com.coder.objetos.tintoreria.Barcada;
import ar.com.coder.objetos.tintoreria.Formula;
import ar.com.coder.objetos.tintoreria.LineaFormula;
import ar.com.coder.objetos.tintoreria.Maquina;
import ar.com.coder.objetos.tintoreria.NodoRuta;
import ar.com.coder.objetos.tintoreria.NodoRutaDetalle;
import ar.com.coder.objetos.tintoreria.Receta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarcadaControlador implements IControlador<Barcada, String> {
    private Barcada barcada;
    private Connection conexion;
    private NodoRuta nodoRuta;
    public Barcada getBarcada() {
        return barcada;
    }

    public void setBarcada(Barcada barcada) {
        this.barcada = barcada;
    }
    public boolean convertirEnBarcada(NodoRuta nodoRuta,Float peso,Float metros){
        barcada=new Barcada();
        RecetaControlador recetaControlador=new RecetaControlador(conexion);
        barcada.setMaquina(nodoRuta.getMaquina());
        barcada.setReceta(recetaControlador.extraer(nodoRuta.getReceta().getCodigo()));
        barcada.setPeso(peso);
        barcada.setMetros(metros);
        barcada.setLitrosAgua(nodoRuta.getLitrosAgua());
        this.nodoRuta=nodoRuta;
        return false;
    }
    
    public static Float calcularLitrosAgua(Float peso,Maquina maquina){
        return peso * maquina.getFactor();
    }
    public NodoRuta retornaNodo(){
        nodoRuta.clear();
         Receta r = barcada.getReceta();
        for(Formula formula: r.getFormulas()){
            for(LineaFormula lineaFormula:formula.getLineas()){
                NodoRutaDetalle nrd = new NodoRutaDetalle();
                nrd.setNodoRuta(nodoRuta);
                nrd.setFormula(formula);
                nrd.setProducto(lineaFormula.getProducto());
                nrd.setConcentracion(lineaFormula.getConcentracion());
                nrd.setUnidad(lineaFormula.getUnidad());
                nrd.setConsumo(lineaFormula.getConsumo());
                nrd.setOrden(lineaFormula.getOrden());
                nrd.setCostoConsumo(lineaFormula.getProducto().getCosto()*lineaFormula.getConsumo());
                nodoRuta.add(nrd);
            }
        }
        return nodoRuta;
    }
    public boolean calcularConsumo(){
        Receta r = barcada.getReceta();
        for(Formula formula: r.getFormulas()){
            for(LineaFormula lineaFormula:formula.getLineas()){
                float consumo=0;
                if (lineaFormula.getUnidad().equals("%")){
                    consumo=barcada.getPeso() * lineaFormula.getConcentracion() * 10;
                }else{
                    consumo=barcada.getLitrosAgua() * lineaFormula.getConcentracion();
                }
                lineaFormula.setConsumo(consumo/1000);
            }
        }
        return true;
    }
    
    @Override
    public ArrayList<Barcada> extrerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean actualizarFechaEntrega(Barcada partida, Date nuevaFecha) {

        return true;
    }
    
    public BarcadaControlador(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public Barcada extraer(String id) {
        Barcada tf = null;
        try {

            String sql = "Select  CDPROCTIP, DESCRIPCION FROM MAESTRO.dbo.FPROCTIP WHERE CDPROCTIP=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ps.setString(indice++, id);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                tf=new Barcada();
                indice=1;
           //     tf.setCodigo(rs.getString(indice++));
             //   tf.setNombre(rs.getString(indice++));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarcadaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tf;
    }

    @Override
    public boolean crear(Barcada entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Barcada entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Barcada entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
