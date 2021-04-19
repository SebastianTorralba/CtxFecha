/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import java.util.ArrayList;
import java.util.Date;
import ar.com.coder.objetos.tintoreria.Receta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecetaControlador implements IControlador<Receta, String> {

    private Connection conexion;
    private ColorControlador colorControlador;

    @Override
    public ArrayList<Receta> extrerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ArrayList<Receta> extrerTodoCabecera() {
     ArrayList<Receta> recetas = new ArrayList<Receta>();
          Receta receta = null;
        try {

            String sql = "Select  CDRECETA, DESCRIPCION,COLOR FROM MAESTRO.dbo.FRECETAS ";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                receta=new Receta();
                indice=1;
                receta.setCodigo(rs.getString(indice++));
                receta.setNombre(rs.getString(indice++));
                receta.setColor(colorControlador.extraer(rs.getString(indice++)));
                recetas.add(receta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecetaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
     return recetas;
    }
    public Boolean actualizarFechaEntrega(Receta partida, Date nuevaFecha) {

        return true;
    }
    
    public RecetaControlador(Connection conexion) {
        this.conexion = conexion;
        colorControlador=new ColorControlador(conexion);
    }

    @Override
    public Receta extraer(String id) {
        Receta receta = null;
        try {

            String sql = "Select  CDRECETA, DESCRIPCION,COLOR FROM MAESTRO.dbo.FRECETAS WHERE CDRECETA=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ps.setString(indice++, id);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                receta=new Receta();
                indice=1;
                receta.setCodigo(rs.getString(indice++));
                receta.setNombre(rs.getString(indice++));
                receta.setColor(colorControlador.extraer(rs.getString(indice++)));
                extraerFormulas(receta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecetaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receta;
    }
    private boolean extraerFormulas(Receta receta){
        FormulaControlador formulaControlador = new FormulaControlador(conexion);
        try {

            String sql = "Select  IDPROCESO FROM MAESTRO.dbo.FRECEPRO WHERE IDRECETA=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ps.setString(indice++, receta.getCodigo());
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                indice=1;
                receta.add(formulaControlador.extraer(rs.getString(indice++)));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecetaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean crear(Receta entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Receta entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Receta entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
