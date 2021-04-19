/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas.renders;

import ar.com.coder.objetos.tintoreria.Color;
import ar.com.coder.objetos.tintoreria.Maquina;
import ar.com.coder.objetos.tintoreria.Receta;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author sysadmin
 */
public class RutaRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof Maquina){
            Maquina m =  (Maquina) value;
            setText(m.toString());
        } 
        if(value instanceof Color){
            Color color =  (Color) value;
            setText(color.toString());
        } 
        if(value instanceof Receta){
            Receta receta =  (Receta) value;
            setText(receta.toString());
        }
        
        if (isSelected) {
            setBackground(table.getSelectionBackground());
        } else {
            setBackground(table.getSelectionBackground());
        }
         
        return this;
    }
    
}
