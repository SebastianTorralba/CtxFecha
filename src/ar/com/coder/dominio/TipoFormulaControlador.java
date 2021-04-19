/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import java.util.ArrayList;
import java.util.Date;
import ar.com.coder.objetos.tintoreria.TipoFormula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipoFormulaControlador implements IControlador<TipoFormula, String> {

    private Connection conexion;

    @Override
    public ArrayList<TipoFormula> extrerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean actualizarFechaEntrega(TipoFormula partida, Date nuevaFecha) {

        return true;
    }
    
    public TipoFormulaControlador(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public TipoFormula extraer(String id) {
        TipoFormula tf = null;
        try {

            String sql = "Select  CDPROCTIP, DESCRIPCION FROM MAESTRO.dbo.FPROCTIP WHERE CDPROCTIP=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ps.setString(indice++, id);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                tf=new TipoFormula();
                indice=1;
                tf.setCodigo(rs.getString(indice++));
                tf.setNombre(rs.getString(indice++));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoFormulaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tf;
    }
    

    @Override
    public boolean crear(TipoFormula entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(TipoFormula entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(TipoFormula entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
