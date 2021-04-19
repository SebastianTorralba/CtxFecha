/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import ar.com.coder.Principal;
import ar.com.coder.objetos.ArticuloProduccion;
import ar.com.coder.objetos.TipoArticulo;
import ar.com.coder.objetos.tintoreria.NodoRuta;
import ar.com.coder.objetos.tintoreria.NodoRutaColor;
import ar.com.coder.objetos.tintoreria.Receta;
import java.util.ArrayList;
import java.util.Date;
import ar.com.coder.objetos.tintoreria.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RutaControlador implements IControlador<Ruta, String> {

    private Connection conexion;

    public Boolean actualizarFechaEntrega(Ruta partida, Date nuevaFecha) {

        return true;
    }

    public RutaControlador(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public Ruta extraer(String id) {
        Ruta ruta = null;
        try {

            String sql = "SELECT cod_artbase,orden,cdreceta,cod_maquina,litros_agua,costo"
                    + " FROM aux_articulos_ruta"
                    + " WHERE cod_artbase=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            Integer indice = 1;
            ps.setString(indice++, id);
            ResultSet rs = ps.executeQuery();
            ruta = new Ruta();
            ArticuloControlador ac = new ArticuloControlador(Principal.conexionInfotint);
            ruta.setArticulo((ArticuloProduccion) ac.extraer(id, TipoArticulo.PRODUCCION));
            while (rs.next()) {
                indice = 1;
                NodoRuta nodoRuta = new NodoRuta();
                nodoRuta.setReceta(new RecetaControlador(Principal.conexionInfotint).extraer(rs.getString(3)));
                nodoRuta.setMaquina(new MaquinaControlador(Principal.conexionInfotint).extraer(rs.getString(4)));
                nodoRuta.setLitrosAgua(rs.getFloat(5));
                nodoRuta.setCostoReceta(rs.getFloat(6));
                ruta.agregarNodo(rs.getInt(2), nodoRuta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RutaControlador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return ruta;
    }

    @Override
    public ArrayList<Ruta> extrerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crear(Ruta entidad) {
        for (int i = 0; i < entidad.sizeNodos(); i++) {
            NodoRuta nodo = entidad.getNodo(i);

            try {

                String sql = "INSERT INTO  aux_articulos_ruta "
                        + "VALUES (?,?,?,?,?,?)";
                // "cod_artbase,orden,cdreceta,cod_maquina,litros_agua,costo"

                PreparedStatement ps = conexion.prepareStatement(sql);
                Integer indice = 1;
                ps.setString(indice++, entidad.getArticulo().getCodigo());
                ps.setInt(indice++, i);
                ps.setString(indice++, nodo.getReceta().getCodigo());
                ps.setString(indice++, nodo.getMaquina().getCodigo());
                ps.setFloat(indice++, nodo.getLitrosAgua());
                ps.setFloat(indice++, nodo.getCostoReceta());
                int rtn = ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(RutaControlador.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        for (int i = 0; i < entidad.sizeNodoColor(); i++) {
            NodoRutaColor nodo = entidad.getNodoColor(i);

            try {

                String sql = "INSERT INTO  aux_articulos_ruta_color "
                        + "VALUES (?,?,?,?,?,?,?,?)";
                // "cod_artbase,orden,cdreceta,cod_maquina,litros_agua,costo"

                PreparedStatement ps = conexion.prepareStatement(sql);
                Integer indice = 1;
                ps.setString(indice++, entidad.getArticulo().getCodigo());
                ps.setString(indice++, nodo.getColor().getCodigo());
                ps.setString(indice++, entidad.getArticulo().getCodigo());
                ps.setInt(indice++, i);
                ps.setString(indice++, nodo.getReceta().getCodigo());
                ps.setString(indice++, nodo.getMaquina().getCodigo());
                ps.setFloat(indice++, nodo.getLitrosAgua());
                ps.setFloat(indice++, nodo.getCostoReceta());
                int rtn = ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(RutaControlador.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean modificar(Ruta entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Ruta entidad) {
        try {

                String sql = "DELETE FROM  aux_articulos_ruta "
                        + "WHERE cod_artbase=?";
                

                PreparedStatement ps = conexion.prepareStatement(sql);
                Integer indice = 1;
                ps.setString(indice++, entidad.getArticulo().getCodigo());
                int rtn = ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(RutaControlador.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
         try {

                String sql = "DELETE FROM  aux_articulos_ruta_color "
                        + "WHERE cod_artbase=?";
                

                PreparedStatement ps = conexion.prepareStatement(sql);
                Integer indice = 1;
                ps.setString(indice++, entidad.getArticulo().getCodigo());
                int rtn = ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(RutaControlador.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        return true;
    }
}
