/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas;

import ar.com.coder.objetos.tintoreria.NodoRuta;
import ar.com.coder.objetos.tintoreria.NodoRutaColor;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sysadmin
 */
public class RutaColorGrilla extends AbstractTableModel {

    private ArrayList<NodoRutaColor> data = new ArrayList();
    private String[] columnas = {"Orden", "Color", "Receta", "Maquina", "Rel. Baño", "Litros Agua", "Costo $"};

    public ArrayList<NodoRutaColor> getData() {
        return data;
    }

    public void setData(ArrayList<NodoRutaColor> data) {
        this.data = data;
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            NodoRutaColor ps = data.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return rowIndex + 1;
                case 1:
                    return ps.getColor();
                case 2:
                    return ps.getReceta();
                case 3:
                    return ps.getMaquina();
                case 4:
                    return ps.getMaquina().getFactor();
                case 5:
                    return ps.getLitrosAgua();
                case 6:
                    return ps.getCostoReceta();
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 1 ) {
            return true;
        }
        if (columnIndex == 3 ) {
            return true;
        } 
        return false;
    }
}
