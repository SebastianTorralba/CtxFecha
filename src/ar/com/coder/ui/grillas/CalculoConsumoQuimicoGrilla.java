/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas;

import ar.com.coder.objetos.tintoreria.NodoRutaDetalle;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sysadmin
 */
public class CalculoConsumoQuimicoGrilla extends AbstractTableModel {

    private ArrayList<NodoRutaDetalle> data = new ArrayList();
    private String[] columnas = {"Orden", "Receta", "Proceso", "Producto","Concentracion","Unidad","Costo","Subtotal Consumo","Subtotal $"};

    public ArrayList<NodoRutaDetalle> getData() {
        return data;
    }

    public void setData(ArrayList<NodoRutaDetalle> data) {
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
        NodoRutaDetalle ps = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1 ;
            case 1:
                return ps.getNodoRuta().getReceta();
            case 2:
                return ps.getFormula().getNombre();
            case 3:
                return ps.getProducto();
            case 4:
                return ps.getConcentracion();            
            case 5:
                return ps.getUnidad();
            case 6:
                return ps.getProducto().getCosto();
            case 7:
                return ps.getConsumo();
            case 8:
                return ps.getCostoConsumo();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
