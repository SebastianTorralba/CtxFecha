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
public class PedidoGrillaRender extends DefaultTableCellRenderer {

    public static final Color COLOR_VERDE = new Color(146, 208, 80);
    public static final Color COLOR_AZUL = new Color(83, 141, 213);
    public static final Color COLOR_AMARILLO = new Color(255, 255, 0);
    public static final Color COLOR_NARANJA = new Color(250, 191, 143);
    public static final Color COLOR_ROJO = new Color(192, 0, 0);
    public static final Color COLOR_GRIS = new Color(191, 191, 191);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        String estado;
        estado = (String) table.getValueAt(row, 2);
        setBackground(Color.WHITE);
        if (estado.toUpperCase().trim().equals("PAR. TERM.")) {
            setBackground(COLOR_VERDE);
        }

        if (estado.toUpperCase().trim().equals("PAR. TD33.")) {
            setBackground(COLOR_VERDE);
        }

        if (estado.toUpperCase().trim().equals("PARA CONF.")) {
            setBackground(COLOR_VERDE);
        }

        if (estado.toUpperCase().trim().equals("EN PROCESO")) {
            setBackground(COLOR_AZUL);
        }

        if (estado.toUpperCase().trim().equals("CRUDO DSP+")) {
            setBackground(COLOR_AMARILLO);
        }

        if (estado.toUpperCase().trim().equals("TEJIENDO")) {
            setBackground(COLOR_NARANJA);
        }

        if (estado.toUpperCase().trim().equals("PENDIENTE")) {
            setBackground(COLOR_ROJO);
        }

        if (estado.toUpperCase().trim().equals("PEND SIN CRUDO")) {
            setBackground(COLOR_GRIS);
        }
        return this;

    }

}
