/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas;

import ar.com.coder.objetos.tintoreria.NodoRuta;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sysadmin
 */
public class RutaGrilla extends AbstractTableModel {

    private ArrayList<NodoRuta> data = new ArrayList();
    private String[] columnas = {"Orden", "Receta", "Maquina","Etapa","Tiempo", "Rel. Baño","Litros Agua","Costo $"};

    public ArrayList<NodoRuta> getData() {
        return data;
    }

    public void setData(ArrayList<NodoRuta> data) {
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
        try{
        NodoRuta ps = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1 ;
            case 1:
                return ps.getReceta();
            case 2:
                return ps.getMaquina();
            case 3:
                return ps.getEtapaProductiva();
            case 4:
                return ps.getTiempo();
            case 5:
                return ps.getMaquina().getFactor();
            case 6:
                return ps.getLitrosAgua();            
            case 7:
                return ps.getCostoReceta();
            default:
                return null;
        }}catch(Exception e){
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 2)
            return true;
        if (columnIndex == 3)
            return true;
        return false;
    }  
}
