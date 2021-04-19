/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas;


import ar.com.coder.objetos.Articulo;
import ar.com.coder.objetos.ArticuloInsumo;
import ar.com.coder.objetos.tintoreria.simulador.ConsumoArticulo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sysadmin
 */
public class CalculoConsumoArticuloGrilla extends AbstractTableModel {

    private ArrayList<ConsumoArticulo> data = new ArrayList();
    private String[] columnas = {"Producto","Unidad","Subtotal Consumo","Subtotal $"};

    public ArrayList<ConsumoArticulo> getData() {
        return data;
    }

    public void setData(ArrayList<ConsumoArticulo> data) {
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
        ConsumoArticulo ps = data.get(rowIndex);
        switch (columnIndex) {
            case 0:                
                return ps.getProducto();
            case 1:
                return ps.getUnidad();
            case 2:
                return ps.getConsumo();
            case 3:
                return ps.getCostoConsumo();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:                
                return ArticuloInsumo.class;
            case 1:
                return String.class;
            case 2:
                return Float.class;
            case 3:
                return Float.class;
            default:
                return null;
        }
    }
    
}
