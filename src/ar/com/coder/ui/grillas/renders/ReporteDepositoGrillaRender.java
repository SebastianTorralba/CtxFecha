/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas.renders;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author sysadmin
 */
public class ReporteDepositoGrillaRender extends DefaultTableCellRenderer {

    public static final Color COLOR_VERDE = new Color(146, 208, 80);
    public static final Color COLOR_AMARILLO = new Color(255, 255, 0);
    public static final Color COLOR_ROJO = new Color(192, 0, 0);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        String semaforo;
        semaforo = (String) table.getValueAt(row, 11);

        setBackground(Color.WHITE);
        if (semaforo != null) {
            if (semaforo.toUpperCase().trim().equals("VERDE")) {
                setBackground(COLOR_VERDE);
            }

            if (semaforo.toUpperCase().trim().equals("AMARILLO")) {
                setBackground(COLOR_AMARILLO);
            }

            if (semaforo.toUpperCase().trim().equals("ROJO")) {
                setBackground(COLOR_ROJO);
            }
        }
        return this;

    }

}
