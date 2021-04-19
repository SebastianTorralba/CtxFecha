/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import java.util.ArrayList;
import java.util.Date;
import ar.com.coder.objetos.ReporteDeposito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReporteDepositoControlador implements IControlador<ReporteDeposito, String>, ISemaforo<ReporteDeposito> {

    private Connection conexion;

    @Override
    public ArrayList<ReporteDeposito> extrerTodo() {
        ArrayList<ReporteDeposito> registros = new ArrayList<>();

        try {

            String sql = "exec sp_rpt_hilado";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ResultSet rs = ps.executeQuery();
            ReporteDeposito rd = null;
            while (rs.next()) {

                rd = new ReporteDeposito();
                indice = 1;
                rd.setCodArticulo(rs.getString(indice++));
                rd.setCodTipoArt(rs.getString(indice++));
                rd.setNomArticulo(rs.getString(indice++));
                rd.setEsImportado(rs.getString(indice++));
                rd.setAlmacenado(rs.getFloat(indice++));
                rd.setTransito(rs.getFloat(indice++));
                rd.setCantidadOrdenCompra(rs.getFloat(indice++));
                rd.setUltimoPrecio(rs.getFloat(indice++));
                rd.setMonenda(rs.getString(indice++));
                rd.setPromedioUltimoAño(rs.getFloat(indice++));
                rd.setPromedioUltimoTrimestre(rs.getFloat(indice++));
                rd.setPromedioUltimoMes(rs.getFloat(indice++));
                rd.setPromedioUltimaSemana(rs.getFloat(indice++));
                rd.setIngresoMesActual(rs.getFloat(indice++));
                rd.setEgresoMesActual(rs.getFloat(indice++));
                rd.setCantidadPlan(rs.getFloat(indice++));
                calcularSemaforizacion(rd);
                registros.add(rd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReporteDepositoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }

    public Boolean actualizarFechaEntrega(ReporteDeposito partida, Date nuevaFecha) {

        return true;
    }

    public ReporteDepositoControlador(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public ReporteDeposito extraer(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calcularSemaforizacion(ReporteDeposito objeto) {
        Float promedioDiario;
        Integer dias;
        if (objeto.getCantidadPlan() > 0) {
            if (objeto.getPromedioUltimoMes() > 0) {
                promedioDiario = objeto.getPromedioUltimoMes() / 30;

                if (objeto.getAlmacenado() > 0) {
                    dias = Math.round(objeto.getAlmacenado() / promedioDiario);
                    objeto.setDiasProyectados(dias);
                    if (dias >= 20) {
                        objeto.setSemaforo("VERDE");

                    } else if (dias >= 10) {
                        objeto.setSemaforo("AMARILLO");
                    } else {
                        objeto.setSemaforo("ROJO");
                    }
                } else {
                    objeto.setSemaforo("ROJO");
                }
            } else {
            }
        }
    }

    @Override
    public boolean crear(ReporteDeposito entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(ReporteDeposito entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(ReporteDeposito entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
