/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import java.util.ArrayList;
import java.util.Date;
import ar.com.coder.objetos.Articulo;
import ar.com.coder.objetos.ArticuloInsumo;
import ar.com.coder.objetos.ArticuloProduccion;
import ar.com.coder.objetos.TipoArticulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticuloControlador implements IControlador<Articulo, String> {

    private Connection conexion;

    @Override
    public ArrayList<Articulo> extrerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Articulo> extrerTodo(TipoArticulo tipoArticulo) {
         ArrayList<Articulo> articulos=new ArrayList<Articulo>();
    switch (tipoArticulo) {
            case PRODUCCION:
                try {

                    String sql = "SELECT    CDARTICULO, DESCRIPCION,"
                            + "(SELECT VALOR FROM MAESTRO.dbo.FARTCOMP WHERE IDARTICULO=CDARTICULO and IDCOMPONE='ANCHO') as  ancho,"
                            + "(SELECT VALOR FROM MAESTRO.dbo.FARTCOMP WHERE IDARTICULO=CDARTICULO and IDCOMPONE='GRA') as  grml "
                            + "FROM         MAESTRO.dbo.FARTICLE ";
                    PreparedStatement ps = conexion.prepareStatement(sql);
                    int indice = 1;
                    ResultSet rs = ps.executeQuery();
                            
                    while (rs.next()) {
                        indice = 1;
                        ArticuloProduccion articuloProduccion = new ArticuloProduccion();                   
                        articuloProduccion.setCodigo(rs.getString(indice++));
                        articuloProduccion.setNombre(rs.getString(indice++));
                        try{
                        articuloProduccion.setAncho(rs.getFloat(indice++));
                        }catch(SQLException e){
                        articuloProduccion.setAncho(0);
                        }
                        try{
                        articuloProduccion.setGrml(rs.getFloat(indice++));
                        }
                        catch(SQLException e){
                        articuloProduccion.setGrml(0);
                        }
                        articulos.add(articuloProduccion);
                    }
                    return articulos;
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case INSUMO:
                try {

                    String sql = "Select  CDPRODUCTO, DESCRIPCION,PRECIOCOSTE,UNIDADCOMPRA "
                            + "FROM MAESTRO.dbo.FPRODUCT ";
                    PreparedStatement ps = conexion.prepareStatement(sql);
                    int indice = 1;
                    ResultSet rs = ps.executeQuery();
                    ArticuloInsumo articuloInsumo = new ArticuloInsumo();
                           
                    while (rs.next()) {
                        indice = 1;
                        articuloInsumo.setCodigo(rs.getString(indice++));
                        articuloInsumo.setNombre(rs.getString(indice++));
                        articuloInsumo.setCosto(rs.getFloat(indice++));
                        articuloInsumo.setUnidad(rs.getString(indice++));
                    }
                    return articulos;
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                return null;
        }
         
         return articulos;
    }
     
    public Boolean actualizarFechaEntrega(Articulo partida, Date nuevaFecha) {

        return true;
    }

    public ArticuloControlador(Connection conexion) {
        this.conexion = conexion;
    }

    public Articulo extraer(String id, TipoArticulo tipoArticulo) {
        Articulo articulo = null;
        switch (tipoArticulo) {
            case PRODUCCION:
                try {

                    String sql = "SELECT    CDARTICULO, DESCRIPCION,"
                            + "(SELECT VALOR FROM MAESTRO.dbo.FARTCOMP WHERE IDARTICULO=CDARTICULO and IDCOMPONE='ANCHO') as  ancho,"
                            + "(SELECT VALOR FROM MAESTRO.dbo.FARTCOMP WHERE IDARTICULO=CDARTICULO and IDCOMPONE='GRA') as  grml "
                            + "FROM         MAESTRO.dbo.FARTICLE WHERE CDARTICULO=?";
                    PreparedStatement ps = conexion.prepareStatement(sql);
                    int indice = 1;
                    ps.setString(indice++, id);
                    ResultSet rs = ps.executeQuery();
                    ArticuloProduccion articuloProduccion = new ArticuloProduccion();
                            
                    while (rs.next()) {
                        indice = 1;
                        articuloProduccion.setCodigo(rs.getString(indice++));
                        articuloProduccion.setNombre(rs.getString(indice++));
                        articuloProduccion.setAncho(rs.getFloat(indice++));
                        articuloProduccion.setGrml(rs.getFloat(indice++));
                    }
                    return articuloProduccion;
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case INSUMO:
                try {

                    String sql = "Select  CDPRODUCTO, DESCRIPCION,PRECIOCOSTE,UNIDADCOMPRA "
                            + "FROM MAESTRO.dbo.FPRODUCT "
                            + "WHERE CDPRODUCTO=?";
                    PreparedStatement ps = conexion.prepareStatement(sql);
                    int indice = 1;
                    ps.setString(indice++, id);
                    ResultSet rs = ps.executeQuery();
                    ArticuloInsumo articuloInsumo = new ArticuloInsumo();
                           
                    while (rs.next()) {
                        indice = 1;
                        articuloInsumo.setCodigo(rs.getString(indice++));
                        articuloInsumo.setNombre(rs.getString(indice++));
                        articuloInsumo.setCosto(rs.getFloat(indice++));
                        articuloInsumo.setUnidad(rs.getString(indice++));
                    }
                    return articuloInsumo;
                } catch (SQLException ex) {
                    Logger.getLogger(ArticuloControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                return null;
        }
        return null;

    }

    @Override
    public Articulo extraer(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crear(Articulo entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Articulo entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Articulo entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
