/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas;

import ar.com.coder.objetos.tintoreria.Receta;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sysadmin
 */
public class RecetaGrilla extends AbstractTableModel {

    private ArrayList<Receta> data = new ArrayList();
    private String[] columnas = {"Codigo","Denominacion","Color"};

    public ArrayList<Receta> getData() {
        return data;
    }

    public void setData(ArrayList<Receta> data) {
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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Receta ps = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ps.getCodigo();
            case 1:
                return ps.getNombre();
            case 2:
                return ps.getColor();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
