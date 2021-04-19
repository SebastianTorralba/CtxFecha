/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas;

import ar.com.coder.objetos.ReporteQuimico;
import ar.com.coder.objetos.ReporteQuimico;
import ar.com.coder.util.Util;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sysadmin
 */
public class ReporteQuimicoGrilla extends AbstractTableModel {

    private ArrayList<ReporteQuimico> data = new ArrayList();
    private String[] columnas = {"CODIGO", "PRODUCTO", "FECHA", "CANTIDAD", "UNIDAD",
        "MAQUINA", "MODO", "BARCADA", "ARTICULO", "PESO", "METROS", "PARTIDAS", "COLOR",
        "TIPO", "RECETA"};

    public ArrayList<ReporteQuimico> getData() {
        return data;
    }

    public void setData(ArrayList<ReporteQuimico> data) {
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
        ReporteQuimico rq = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rq.getProducto().getCodigo();
            case 1:
                return rq.getProducto().getNombre();
            case 2:
                return Util.convertirFechaDate(rq.getFecha());
            case 3:
                return rq.getCantidad();
            case 4:
                return rq.getUnidad();
            case 5:
                return rq.getMaquina().getNombre();
            case 6:
                return rq.getModo();
            case 7:
                if (rq.getBarcada() != null) {
                    return rq.getBarcada().getNumero();
                } else {
                    return "";
                }
            case 8:
                if (rq.getBarcada() != null) {
                    return rq.getBarcada().getArticulo();
                } else {
                    return "";
                }
            case 9:
                if (rq.getBarcada() != null) {
                    return rq.getBarcada().getPeso();
                } else {
                    return "";
                }

            case 10:
                if (rq.getBarcada() != null) {
                    return rq.getBarcada().getMetros();
                } else {
                    return "";
                }

            case 11:
                if (rq.getBarcada() != null) {
                    return rq.getBarcada().getPartida();
                } else {
                    return "";
                }
            case 12:
                if (rq.getBarcada() != null) {
                    return rq.getBarcada().getColor();
                } else {
                    return "";
                }
            case 13:
                if (rq.getBarcada() != null) {
                    return rq.getBarcada().getTipo();
                } else {
                    return "";
                }

            case 14:
                if (rq.getBarcada() != null) {
                    return rq.getBarcada().getReceta().getCodigo();
                } else {
                    return "";
                }

            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        return super.getColumnClass(columnIndex);

    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
