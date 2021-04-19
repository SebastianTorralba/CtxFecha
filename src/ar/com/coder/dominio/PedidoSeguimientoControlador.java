/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import ar.com.coder.objetos.PedidoSeguimiento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoSeguimientoControlador implements IControlador<PedidoSeguimiento,Integer> {

    private Connection conexion;
    Date fechaInicio = null, fechaFin = null;

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ArrayList<PedidoSeguimiento> filtarActivos(ArrayList<PedidoSeguimiento> pedidos) {
        ArrayList pedidosFiltrados;
        pedidosFiltrados = new ArrayList();
        for (PedidoSeguimiento pedido : pedidos) {
            if (pedido.getEstado().trim().toUpperCase().equals("EN PROCESO")) {
                pedidosFiltrados.add(pedido);
            }
            if (pedido.getEstado().trim().toUpperCase().equals("CRUDO DSP+")) {
                pedidosFiltrados.add(pedido);
            }
        }
        return pedidosFiltrados;
    }

    public boolean obtenerRangoFechas(ArrayList<PedidoSeguimiento> pedidos) {
        int i = 1;
        for (PedidoSeguimiento pedido : filtarActivos(pedidos)) {
            if (i == 1) {
                fechaInicio = pedido.getFechaCompromiso();
                fechaFin = pedido.getFechaCompromiso();
            } else {
                if (fechaInicio.after(pedido.getFechaCompromiso())) {
                    fechaInicio = pedido.getFechaCompromiso();
                }
                if (fechaFin.before(pedido.getFechaCompromiso())) {
                    fechaFin = pedido.getFechaCompromiso();
                }
            }
            i++;
        }
        return true;
    }

    public Map<Date, List> organizarpordia(ArrayList<PedidoSeguimiento> pedidos) {
        TreeMap<Date, List> pedidosOrganizados = new TreeMap();
        Calendar c = Calendar.getInstance();
        c.setTime(fechaInicio);
        Date fechaAux = c.getTime();
        while (!fechaAux.equals(fechaFin)) {

            List lista = new ArrayList();
            for (PedidoSeguimiento ps : filtarActivos(pedidos)) {
                if (ps.getFechaCompromiso().equals(fechaAux)) {
                    lista.add(ps);
                }
            }
            if (!lista.isEmpty()) {
                pedidosOrganizados.put(fechaAux, lista);
            }
            c.add(Calendar.DATE, 1);
            fechaAux = c.getTime();
        }
        return pedidosOrganizados;
    }

    @Override
    public ArrayList<PedidoSeguimiento> extrerTodo() {
        ArrayList<PedidoSeguimiento> pedidos = new ArrayList();
        try {
            String sql = "Exec sp_ExcelFechaEntrega";
            CallableStatement cs = conexion.prepareCall(sql);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int indice = 1;
                PedidoSeguimiento ps = new PedidoSeguimiento();
                ps.setIdPedido(rs.getInt(indice++));
                ps.setFechaIngreso(rs.getDate(indice++));
                ps.setEstado(rs.getString(indice++));
                ps.setCliente(rs.getString(indice++));
                ps.setPrioridad(rs.getInt(indice++));
                ps.setCodArticulo(rs.getString(indice++));
                ps.setCodArticuloCrudo(rs.getString(indice++));
                ps.setCodArtBase(rs.getString(indice++));
                ps.setCodDibujo(rs.getString(indice++));
                ps.setCodVarianteColor(rs.getString(indice++));
                ps.setCantidad(rs.getDouble(indice++));
                ps.setSaldo(rs.getDouble(indice++));
                ps.setNroLote(rs.getString(indice++));
                ps.setCantidadLote(rs.getDouble(indice++));
                ps.setTieneFechaEntregaDeclarada((rs.getInt(indice++) > 0) ? true : false);
                ps.setFechaEntrega(rs.getDate(indice++));
                ps.setFechaIngresoProceso(rs.getDate(indice++));
                ps.setFechaEgresoProceso(rs.getDate(indice++));
                ps.setFechaCompromiso(rs.getDate(indice++));
                ps.setFechaUltimoDespacho(rs.getDate(indice++));
                ps.setCantidadPrimeraLote(rs.getDouble(indice++));
                ps.setCantidadSegundaLote(rs.getDouble(indice++));
                ps.setObservacion(rs.getString(indice++));
                
                pedidos.add(ps);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoSeguimientoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidos;
    }

    public ArrayList<PedidoSeguimiento> extraerPedidoaTerminar() {
        ArrayList<PedidoSeguimiento> pedidos = new ArrayList();
        try {
            String sql = "Select p.id_pedido,id_articulo,pd.metros,etiq,p.terminado "
                    + "from pedidos p "
                    + "INNER JOIN pedidos_detalle pd on p.id_pedido=pd.id_pedido "
                    + "INNER JOIN "
                    + "(Select l.nro_pedido,ebi.cod_articulo,sum(ebi.cantidad) as etiq from cpt_etiqbultind ebi "
                    + "INNER JOIN cpt_lote l ON ebi.nro_lote=l.nro_lote and l.cod_calidad=1 and ebi.cod_articulo=l.cod_articulo "
                    + "GROUP BY l.nro_pedido,ebi.cod_articulo) as e ON e.nro_pedido=p.id_pedido and e.cod_articulo=pd.id_articulo "
                    + "and (etiq/pd.metros)>=0.5 "
                    + "WHERE terminado='N'"
                    + "ORDER BY 1,2";
            Statement cs = conexion.createStatement();
            ResultSet rs = cs.executeQuery(sql);

            while (rs.next()) {
                int indice = 1;
                PedidoSeguimiento ps = new PedidoSeguimiento();
                ps.setIdPedido(rs.getInt(indice++));
                ps.setCodArticulo(rs.getString(indice++));
                ps.setCantidad(rs.getDouble(indice++));
                ps.setSaldo(rs.getDouble(indice++));
                ps.setTerminado(rs.getString(indice++).charAt(0));
                pedidos.add(ps);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoSeguimientoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidos;
    }

    public Boolean terminarPedido(PedidoSeguimiento pedidoSeguimiento) {
        try {
            String sql = "update p set terminado='S', fecha_cierre=getdate()"
                    + "from pedidos p "
                    + "INNER JOIN pedidos_detalle pd on p.id_pedido=pd.id_pedido "
                    + "INNER JOIN "
                    + "(Select l.nro_pedido,ebi.cod_articulo,sum(ebi.cantidad) as etiq from cpt_etiqbultind ebi "
                    + "INNER JOIN cpt_lote l ON ebi.nro_lote=l.nro_lote and l.cod_calidad=1 and ebi.cod_articulo=l.cod_articulo "
                    + "GROUP BY l.nro_pedido,ebi.cod_articulo) as e ON e.nro_pedido=p.id_pedido and e.cod_articulo=pd.id_articulo "
                    + "and (etiq/pd.metros)>=0.5 "
                    + "WHERE terminado='N' and "
                    + "p.id_pedido=? and pd.id_articulo=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;

            ps.setInt(indice++, pedidoSeguimiento.getIdPedido());
            ps.setString(indice++, pedidoSeguimiento.getCodArticulo());

            int rtn = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoSeguimientoControlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public PedidoSeguimientoControlador(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public PedidoSeguimiento extraer(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crear(PedidoSeguimiento entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(PedidoSeguimiento entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(PedidoSeguimiento entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
