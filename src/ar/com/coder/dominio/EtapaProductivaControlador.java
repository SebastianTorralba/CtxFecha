/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import ar.com.coder.objetos.tintoreria.EtapaProductiva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sysadmin
 */
public class EtapaProductivaControlador implements IControlador<EtapaProductiva, String>{
    private Connection conexion;

    public EtapaProductivaControlador(Connection conexion) {
        this.conexion = conexion;
    }
    
    
 
    @Override
    public ArrayList<EtapaProductiva> extrerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public EtapaProductiva extraer(String id) {
        EtapaProductiva deposito = null;
        try {

            String sql = "Select cod_tit,nom_tit from ct_depositos where cod_tit=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ps.setString(indice++, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                deposito = new EtapaProductiva();
                indice = 1;
                deposito.setCodigo(rs.getString(indice++));
                deposito.setNombre(rs.getString(indice++));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EtapaProductivaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deposito;
    }

    @Override
    public boolean crear(EtapaProductiva entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(EtapaProductiva entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(EtapaProductiva entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
