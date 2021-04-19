/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import ar.com.coder.objetos.ArticuloInsumo;
import ar.com.coder.objetos.ArticuloProduccion;
import java.util.ArrayList;
import java.util.Date;
import ar.com.coder.objetos.ReporteQuimico;
import ar.com.coder.objetos.TipoArticulo;
import ar.com.coder.objetos.tintoreria.Barcada;
import ar.com.coder.objetos.tintoreria.Color;
import ar.com.coder.objetos.tintoreria.Maquina;
import ar.com.coder.objetos.tintoreria.Receta;
import ar.com.coder.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReporteQuimicoControlador implements IControlador<ReporteQuimico, String> {

    private Connection conexion;

    @Override
    public ArrayList<ReporteQuimico> extrerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean actualizarFechaEntrega(ReporteQuimico partida, Date nuevaFecha) {

        return true;
    }

    public ReporteQuimicoControlador(Connection conexion) {
        this.conexion = conexion;
    }

    public ArrayList<ReporteQuimico> extraer(Date fechaInicio, Date fechafin) {
        ArrayList<ReporteQuimico> consumos = new ArrayList<ReporteQuimico>();
        try {

            String sql = "Select C.IDPRODUCTO,C.FECHA,C.CANTIDAD,IDUNIDAD,C.IDMAQUINA,case when C.IDBARCADA='' then 'MANUAL' else 'PROGRAMADA' END as modo,C.IDBARCADA, "
                    + "isnull(B.ARTICULO,B1.ARTICULO) AS ARTICULO,isnull(B.PESO,B1.PESO)AS PESO, "
                    + "isnull(B.V3,B1.V3) as metros,ISNULL(B.IDPARTIDO,B1.IDPARTIDO) as Partidas, "
                    + "ISNULL(B.COLOR,B1.COLOR) as Color,TB.DESCRIPCION AS TIPO, "
                    + "ISNULL(B.IDRECETA,B1.IDRECETA) as RECETA "
                    + "from FHISMOVI C "
                    + "LEFT OUTER JOIN MAESTRO.dbo.FUNITATS U1 ON C.UNIDAD=U1.CDUNIDAD "
                    + "LEFT OUTER JOIN MAESTRO.dbo.FHISTBAR B ON  B.CDBARCADA=C.IDBARCADA "
                    + "LEFT OUTER JOIN MAESTRO.dbo.FBARCADA B1 ON  B1.CDBARCADA=C.IDBARCADA "
                    + "LEFT OUTER JOIN MAESTRO.dbo.FTIPOBAR TB ON ISNULL(B.TIPO,B1.TIPO)=TB.CDTIPOBAR "
                    + "WHERE C.FECHA>=? and C.FECHA<=? "
                    + "ORDER BY 5,2";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            
            ps.setDate(indice++, Util.convertirDateEnSqlDate(fechaInicio));
            ps.setDate(indice++, Util.convertirDateEnSqlDate(fechafin));
            ResultSet rs = ps.executeQuery();
            ReporteQuimico reporteQuimico = null;
            ArticuloControlador articuloControlador = new ArticuloControlador(conexion);
            MaquinaControlador maquinaControlador= new MaquinaControlador(conexion);
            ColorControlador colorControlador = new ColorControlador(conexion);
            
            while (rs.next()) {
                reporteQuimico = new ReporteQuimico();
                indice = 1;
                ArticuloInsumo producto = (ArticuloInsumo) articuloControlador.extraer(rs.getString(indice++), TipoArticulo.INSUMO);
                reporteQuimico.setProducto(producto);
                reporteQuimico.setFecha(rs.getDate(indice++));
                reporteQuimico.setCantidad(rs.getFloat(indice++));
                reporteQuimico.setUnidad(rs.getString(indice++));
                Maquina maquina= maquinaControlador.extraer(rs.getString(indice++));
                reporteQuimico.setMaquina(maquina);
                String modo=rs.getString(indice++);
                reporteQuimico.setModo(modo);
                if (modo.equals("PROGRAMADA")){
                    Barcada barcada=new Barcada();
                    barcada.setNumero(rs.getInt(indice++));
                    ArticuloProduccion articuloProduccion=(ArticuloProduccion) articuloControlador.extraer(rs.getString(indice++), TipoArticulo.PRODUCCION);
                    barcada.setArticulo(articuloProduccion);
                    barcada.setPeso(rs.getFloat(indice++));
                    barcada.setMetros(rs.getFloat(indice++));
                    barcada.setPartida(rs.getString(indice++));
                    Color color=colorControlador.extraer(rs.getString(indice++));
                    barcada.setColor(color);
                    barcada.setTipo(rs.getString(indice++));
                    
                    Receta receta=new Receta();
                    receta.setCodigo(rs.getString(indice++));
                    barcada.setReceta(receta);
                    reporteQuimico.setBarcada(barcada);
                }
                consumos.add(reporteQuimico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReporteQuimicoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consumos;
    }

    @Override
    public ReporteQuimico extraer(String id) {

        return null;
    }

    @Override
    public boolean crear(ReporteQuimico entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(ReporteQuimico entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(ReporteQuimico entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
