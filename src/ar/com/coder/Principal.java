/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder;

import ar.com.coder.ui.GrillaPedidoCompromiso;
import ar.com.coder.ui.grillas.PedidoGrilla;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sysadmin
 */
public class Principal {
    public static Connection connection;
    public static Connection conexionInfotint;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String url="jdbc:jtds:sqlserver://192.1.28.7/CtxLR;user=lrpedido;password=color15";
            connection=DriverManager.getConnection(url);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String url="jdbc:jtds:sqlserver://192.1.28.15/HISTORIC;user=sa;password=Eas1234";
            conexionInfotint=DriverManager.getConnection(url);
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
            ar.com.coder.ui.Principal principal=new ar.com.coder.ui.Principal();
            principal.setVisible(true);
    
    }
    
}
