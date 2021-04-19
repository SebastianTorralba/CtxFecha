/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas;

import ar.com.coder.objetos.PartidaComparada;
import ar.com.coder.util.Util;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sysadmin
 */
public class PartidaFechaGrilla extends AbstractTableModel {

    private ArrayList<PartidaComparada> data = new ArrayList();
    private String[] columnas = {"Partida","Articulo", "Pedido", "Cantidad", "Fecha Ingreso a Proceso", "Fecha Egreso de Proceso", "Fecha en Excel","Diff"};

    public ArrayList<PartidaComparada> getData() {
        return data;
    }

    public void setData(ArrayList<PartidaComparada> data) {
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
        PartidaComparada pc = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                 return pc.getPartidaNodum().getNroLote();
            case 1:
                return pc.getPartidaNodum().getCodArticulo();
            case 2:
                return pc.getPartidaNodum().getIdPedido();
            case 3:
                return pc.getPartidaNodum().getCantidad();
            case 4:
                return Util.convertirFechaDate(pc.getPartidaNodum().getFechaIngresoProceso());
            case 5:
                return Util.convertirFechaDate(pc.getPartidaNodum().getFechaEgresoProceso());
            case 6:
                return Util.convertirFechaDate(pc.getPartidaExcel().getFechaEgresoProceso());
            case 7:
                return determinarDiferencia(pc.getPartidaNodum().getFechaEgresoProceso(), pc.getPartidaExcel().getFechaEgresoProceso());
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
    private String determinarDiferencia(Date fecha1,Date fecha2){
        String diff="ATRASO";
        if(fecha1.after(fecha2)){
            diff="ADELANTO";
        }
        return diff;
    }
}
