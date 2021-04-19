/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import java.util.ArrayList;
import java.util.Date;
import ar.com.coder.objetos.tintoreria.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColorControlador implements IControlador<Color, String> {

    private Connection conexion;

    @Override
    public ArrayList<Color> extrerTodo() {
        ArrayList<Color> colores = new ArrayList<>();
        try {

            String sql = "Select  CDCOLOR, DESCRIPCION,COORDRGB FROM MAESTRO.dbo.FCOLORES ";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            
            ResultSet rs=ps.executeQuery();
            Color color = null;
            while(rs.next()){
                color=new Color();
                indice=1;
                color.setCodigo(rs.getString(indice++));
                color.setNombre(rs.getString(indice++));
                color.setRgb(rs.getInt(indice++));
                colores.add(color);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ColorControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return colores;
    }

    
    
    public Boolean actualizarFechaEntrega(Color partida, Date nuevaFecha) {

        return true;
    }
    
    public ColorControlador(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public Color extraer(String id) {
        Color color = null;
        try {

            String sql = "Select  CDCOLOR, DESCRIPCION,COORDRGB FROM MAESTRO.dbo.FCOLORES WHERE CDCOLOR=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ps.setString(indice++, id);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                color=new Color();
                indice=1;
                color.setCodigo(rs.getString(indice++));
                color.setNombre(rs.getString(indice++));
                color.setRgb(rs.getInt(indice++));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ColorControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return color;
    }

    @Override
    public boolean crear(Color entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Color entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Color entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
