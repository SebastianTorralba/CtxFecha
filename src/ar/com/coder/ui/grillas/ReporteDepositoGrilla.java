/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas;

import ar.com.coder.objetos.ReporteDeposito;
import ar.com.coder.objetos.ReporteDeposito;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sysadmin
 */
public class ReporteDepositoGrilla extends AbstractTableModel {

    private ArrayList<ReporteDeposito> data = new ArrayList();
    private String[] columnas = {"Codigo","Articulo","ALM","Prom MES/AÑO","PROM MES/TM","CONS. ULT. MES",
"CONS. ULT. SEM","ING. MES","EGR. MES","Plan","Dias Proyectados","Semaforo"};

    public ArrayList<ReporteDeposito> getData() {
        return data;
    }

    public void setData(ArrayList<ReporteDeposito> data) {
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
        ReporteDeposito rd = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rd.getCodArticulo();
            case 1:
                return rd.getNomArticulo();
            case 2:
                return rd.getAlmacenado();
            case 3:
                return rd.getPromedioUltimoAño();
            case 4:
                return rd.getPromedioUltimoTrimestre();
            case 5:
                return rd.getPromedioUltimoMes();
            case 6:
                return rd.getPromedioUltimaSemana();
            case 7:
                return rd.getIngresoMesActual();
            case 8:
                return rd.getEgresoMesActual();
            case 9:
                return rd.getCantidadPlan();
            case 10:
                return rd.getDiasProyectados();
            case 11:
                return rd.getSemaforo();
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
