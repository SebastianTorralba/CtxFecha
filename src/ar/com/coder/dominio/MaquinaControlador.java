/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import java.util.ArrayList;
import java.util.Date;
import ar.com.coder.objetos.tintoreria.Maquina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaquinaControlador implements IControlador<Maquina, String> {

    private Connection conexion;

    @Override
    public ArrayList<Maquina> extrerTodo() {
        ArrayList<Maquina> maquinas = new ArrayList<>();
        try {

            String sql = "Select  CDMAQUINA, DESCRIPCION FROM MAESTRO.dbo.FMAQUINA";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Maquina maquina = new Maquina();
                indice = 1;
                maquina.setCodigo(rs.getString(indice++));
                maquina.setNombre(rs.getString(indice++));
                maquinas.add(maquina);
                setFactor(maquinas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maquinas;
    }

    public Boolean actualizarFechaEntrega(Maquina partida, Date nuevaFecha) {

        return true;
    }

    public MaquinaControlador(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public Maquina extraer(String id) {
        Maquina tf = null;
        try {

            String sql = "Select  CDMAQUINA, DESCRIPCION FROM MAESTRO.dbo.FMAQUINA WHERE CDMAQUINA=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ps.setString(indice++, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tf = new Maquina();
                indice = 1;
                tf.setCodigo(rs.getString(indice++));
                tf.setNombre(rs.getString(indice++));
                 setFactor(tf);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tf;
    }
    private void setFactor(Maquina m){
        switch (m.getCodigo().toUpperCase()) {
                case "J01":
                    m.setFactor(3);
                    break;
                case "J03":
                    m.setFactor(3);
                    break;
                case "J04":
                    m.setFactor(3);
                    break;
                case "J05":
                    m.setFactor(3);
                    break;
                case "J06":
                    m.setFactor((float) 2.5);
                    break;
                case "J07":
                    m.setFactor((float) 2.5);
                    break;
                case "J08":
                    m.setFactor((float) 2.5);
                    break;

                case "F01":
                    m.setFactor((float) 0.9);
                    break;

                case "F02":
                    m.setFactor((float) 0.95);
                    break;
                case "R01":
                    m.setFactor((float) 0.8);
                    break;
                case "R02":
                    m.setFactor((float) 0.8);
                    break;
                case "R03":
                    m.setFactor((float) 0.8);
                    break;
                case "I01":
                    m.setFactor((float) 0.9);
                    break;
                case "I02":
                    m.setFactor((float) 0.9);
                    break;
                case "P01":
                    m.setFactor((float) 0.75);
                    break;

                default:

                    m.setFactor(0);
            }
    }
    private void setFactor(List<Maquina> maquinas) {
        for (Maquina m : maquinas) {
            switch (m.getCodigo().toUpperCase()) {
                case "J01":
                    m.setFactor(3);
                    break;
                case "J03":
                    m.setFactor(3);
                    break;
                case "J04":
                    m.setFactor(3);
                    break;
                case "J05":
                    m.setFactor(3);
                    break;
                case "J06":
                    m.setFactor((float) 2.5);
                    break;
                case "J07":
                    m.setFactor((float) 2.5);
                    break;
                case "J08":
                    m.setFactor((float) 2.5);
                    break;

                case "F01":
                    m.setFactor((float) 0.9);
                    break;

                case "F02":
                    m.setFactor((float) 0.95);
                    break;
                case "R01":
                    m.setFactor((float) 0.8);
                    break;
                case "R02":
                    m.setFactor((float) 0.8);
                    break;
                case "R03":
                    m.setFactor((float) 0.8);
                    break;
                case "I01":
                    m.setFactor((float) 0.9);
                    break;
                case "I02":
                    m.setFactor((float) 0.9);
                    break;
                case "P01":
                    m.setFactor((float) 0.75);
                    break;

                default:

                    m.setFactor(0);
            }
        }
    }

    @Override
    public boolean crear(Maquina entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Maquina entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Maquina entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
