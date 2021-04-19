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
public class PedidoGrilla extends AbstractTableModel {

    private ArrayList<PedidoSeguimiento> data = new ArrayList();
    private String[] columnas = {"Pedido Nro", "Fecha Ingreso", "Estado", "Cliente", "Prioridad", "Articulo","Crudo", "Base","Dibujo","Variante/Color", "Cantidad", "Saldo", "Lote/Partida", "Cantidad", "Cargado sin fecha entrega", "Fecha Entrega", "Fecha Ingreso a Proceso", "Fecha Egreso de Proceso", "Fecha Compromiso", "Fecha Ultimo Despacho", "Cantidad 1°", "Cantidad 2°","Observaciones"};

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
                return ps.getFechaIngreso();
            case 2:
                return ps.getEstado();
            case 3:
                return ps.getCliente();
            case 4:
                return ps.getPrioridad();
            case 5:
                return ps.getCodArticulo();
            case 6:
                return ps.getCodArticuloCrudo();
            case 7:
                return ps.getCodArtBase();
            case 8:
                return ps.getCodDibujo();
            case 9:
                return ps.getCodVarianteColor();

            case 10:
                return ps.getCantidad();
            case 11:
                return ps.getSaldo();
            case 12:
                return ps.getNroLote();
            case 13:
                return ps.getCantidadLote();
            case 14:
                return ps.isTieneFechaEntregaDeclarada();
            case 15:
                return ps.getFechaEntrega();
            case 16:
                return ps.getFechaIngresoProceso();
            case 17:
                return ps.getFechaEgresoProceso();
            case 18:
                return ps.getFechaCompromiso();
            case 19:
                return ps.getFechaUltimoDespacho();
            case 20:
                return ps.getCantidadPrimeraLote();
            case 21:
                return ps.getCantidadSegundaLote();
             case 22:
                return ps.getObservacion();
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
