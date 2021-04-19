/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.dominio;

import ar.com.coder.Principal;
import ar.com.coder.objetos.ArticuloInsumo;
import ar.com.coder.objetos.Deposito;
import ar.com.coder.objetos.Stock;
import ar.com.coder.objetos.StockDeposito;
import ar.com.coder.objetos.TipoArticulo;
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
public class StockDepositoControlador implements IControlador<StockDeposito, Deposito> {

    private Connection conexion;

    public StockDepositoControlador(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public ArrayList<StockDeposito> extrerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public StockDeposito extraer(Deposito id) {
        StockDeposito stockDeposito = null;
        try {

            String sql = "Select cod_articulo,SUM(cantidad*signo) as cantidad from cpf_stockaux "
                    + "where cod_estado in ('alm') "
                    + "and cod_tit=? "
                    + "group by cod_articulo";
            PreparedStatement ps = conexion.prepareStatement(sql);
            int indice = 1;
            ps.setString(indice++, id.getCodigo());
            ResultSet rs = ps.executeQuery();
            stockDeposito = new StockDeposito();
            indice = 1;
            stockDeposito.setDeposito(id);
            ArticuloControlador articuloControlador = new ArticuloControlador(Principal.conexionInfotint);
            ArticuloInsumo insumo;
            while (rs.next()) {
                insumo=(ArticuloInsumo) articuloControlador.extraer(rs.getString(indice++), TipoArticulo.INSUMO);
                float cantidad=rs.getFloat(indice++);
                stockDeposito.addItem(new Stock(insumo, cantidad));
                        indice = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StockDepositoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stockDeposito;
    }

    @Override
    public boolean crear(StockDeposito entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(StockDeposito entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(StockDeposito entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
