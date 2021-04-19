/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import ar.com.coder.objetos.ArticuloInsumo;
import ar.com.coder.objetos.TipoArticulo;
import java.util.ArrayList;
import java.util.Date;
import ar.com.coder.objetos.tintoreria.Formula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormulaControlador implements IControlador<Formula, String> {
    private Formula formula;

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }
    
   
    private Connection conexion;
    private TipoFormulaControlador tipoFormulaControlador;
    @Override
    public ArrayList<Formula> extrerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean actualizarFechaEntrega(Formula partida, Date nuevaFecha) {

        return true;
    }
    
    public FormulaControlador(Connection conexion) {
        this.conexion = conexion;
        this.tipoFormulaControlador=new TipoFormulaControlador(conexion);
    }

    @Override
    public Formula extraer(String id) {
        Formula formula = null;
        try {

            String sql = "Select  CDPROCESO, DESCRIPCION,IDPROCTIP FROM MAESTRO.dbo.FPROCESO WHERE CDPROCESO=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ps.setString(indice++, id);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                formula=new Formula();
                indice=1;
                formula.setCodigo(rs.getString(indice++));
                formula.setNombre(rs.getString(indice++));
                formula.setTipo(tipoFormulaControlador.extraer(rs.getString(indice++)));
                extrearDetalle(formula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormulaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formula;
    }
    private boolean extrearDetalle(Formula formula){
        ArticuloControlador articuloControlador = new ArticuloControlador(conexion);
        try {

            String sql = "Select  LINEA, IDPRODUCTO,CONCENTRACION,DESUNIDAD FROM MAESTRO.dbo.FPROCLIN WHERE IDPROCESO=? and CONCENTRACION<>''";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ps.setString(indice++, formula.getCodigo());
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                 indice = 1;
                int orden=rs.getInt(indice++);
                ArticuloInsumo articuloInsumo=(ArticuloInsumo) articuloControlador.extraer(rs.getString(indice++), TipoArticulo.INSUMO);
                Float concentracion=Float.valueOf(rs.getString(indice++));
                String unidad=rs.getString(indice++);
                formula.addInsumo(orden, articuloInsumo, concentracion, unidad);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormulaControlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean crear(Formula entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Formula entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Formula entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
