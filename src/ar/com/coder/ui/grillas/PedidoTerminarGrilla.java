/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas;

import ar.com.coder.objetos.PedidoSeguimiento;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sysadmin
 */
public class PedidoTerminarGrilla extends AbstractTableModel {

    private ArrayList<PedidoSeguimiento> data = new ArrayList();
    private String[] columnas = {"Pedido Nro", "Articulo", "Cantidad", "Etiquetado","Terminado"};

    public ArrayList<PedidoSeguimiento> getData() {
        return data;
    }

    public void setData(ArrayList<PedidoSeguimiento> data) {
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
        PedidoSeguimiento ps = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ps.getIdPedido();
            case 1:
                return ps.getCodArticulo();
            case 2:
                return ps.getCantidad();
            case 3:
                return ps.getSaldo();
            case 4:
                return ps.getTerminado();            
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
