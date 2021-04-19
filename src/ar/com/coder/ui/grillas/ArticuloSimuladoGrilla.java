/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas;


import ar.com.coder.objetos.tintoreria.simulador.ArticuloSimulado;
import ar.com.coder.ui.treeTable.BaseTreeTableModel;
import java.util.ArrayList;
import javax.swing.tree.TreePath;

/**
 *
 * @author sysadmin
 */
public class ArticuloSimuladoGrilla extends BaseTreeTableModel {

    /*private ArrayList<ArticuloSimulado> data = new ArrayList();*/
    private String[] columnas = {"Articulo","Color","Metros","Kilos","Activo"};
    private ArticuloSimulado articuloSimulado;
    static protected Class<?>[] columnTypes = { BaseTreeTableModel.class, String.class, Integer.class, Float.class,Boolean.class };

    public ArticuloSimuladoGrilla(ArticuloSimulado root) {
        super(root);
    }
    /*public ArrayList<ArticuloSimulado> getData() {
        return data;
    }

    public void setData(ArrayList<ArticuloSimulado> data) {
        this.data = data;
    }
*/
    


    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    
    /*
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ArticuloSimulado ps = data.get(rowIndex);
        ps.setMetros((Integer)aValue);
        float kilos = ps.getMetros()*ps.getRuta().getArticulo().getGrml()/1000;
        ps.setKilos(kilos);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArticuloSimulado ps = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ps.getRuta().getArticulo();
            case 1:
                return ps.getMetros();
            case 2:
                return ps.getKilos();
            case 3:
                return ps.isActiva();
            default:
                return null;
        }
    }

  
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==2 || columnIndex==4){
            return true;
        }
        return false;
    }
*/    
    
  @Override
    public Object getChild(Object parent, int index) {
        return ((ArticuloSimulado) parent).get(index);
    }
 
 
  @Override
    public int getChildCount(Object parent) {
        return ((ArticuloSimulado) parent).size();
    }
 
 
  @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
 
 
  @Override
    public Class<?> getColumnClass(int column) {
        return columnTypes[column];
    }
 
  @Override
    public Object getValueAt(Object node, int column) {
        System.out.println("node: "+node.toString());
        System.out.println("column: "+node.toString());
        switch (column) {
        case 0:
            return ((ArticuloSimulado) node).getRuta().getArticulo().getCodigo();
        case 1:
            return ((ArticuloSimulado) node).getRuta();
        case 2:
            return ((ArticuloSimulado) node).getMetros();
        case 3:
            return ((ArticuloSimulado) node).getKilos();
        case 4:
            return ((ArticuloSimulado) node).isActiva();    
        default:
            break;
        }
        return null;
    }
 
  @Override
    public boolean isCellEditable(Object node, int column) {
        return true; // Important to activate TreeExpandListener
    }
 
    public void setValueAt(Object aValue, Object node, int column) {
    }  

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   }
