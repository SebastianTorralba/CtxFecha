/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import java.util.ArrayList;
import java.util.Date;
import ar.com.coder.objetos.Partida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartidaControlador implements IControlador<Partida, String> {

    private Connection conexion;

    @Override
    public ArrayList<Partida> extrerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean actualizarFechaEntrega(Partida partida, Date nuevaFecha) {

        return true;
    }
    
    public PartidaControlador(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public Partida extraer(String id) {
        Partida p = null;
        try {

            String sql = "Select i.nro_lote,i.cod_articulo,l.nro_pedido,i.cantidad,i.fecha_ingreso,i.Fecha_Egreso FROM cpt_iniordenprod i "
                    + "INNER JOIN cpt_lote l ON i.nro_trans=l.nro_trans and i.cod_articulo=l.cod_articulo "
                    + " WHERE i.nro_lote=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ps.setString(indice++, id);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                p=new Partida();
                indice=1;
                p.setNroLote(rs.getString(indice++));
                p.setCodArticulo(rs.getString(indice++));
                p.setIdPedido(rs.getInt(indice++));
                p.setCantidad(rs.getDouble(indice++));
                p.setFechaIngresoProceso(rs.getDate(indice++));
                p.setFechaEgresoProceso(rs.getDate(indice++));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PartidaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public boolean crear(Partida entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Partida entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Partida entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
