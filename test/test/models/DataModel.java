/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.models;

import ar.com.coder.ui.treeTable.BaseTreeTableModel;
import java.util.Date;
import javax.swing.tree.TreePath;

/**
 *
 * @author sysadmin
 */
public class DataModel extends BaseTreeTableModel {
  static protected String[] columnNames = { "Objeto", "String", "Date", "Integer" };
 
    // Spalten Typen.
    static protected Class<?>[] columnTypes = { BaseTreeTableModel.class, String.class, Date.class, Integer.class };
 
    public DataModel(DataNode rootNode) {
        super(rootNode);
        root = rootNode;
    }
 
  @Override
    public Object getChild(Object parent, int index) {
        return ((DataNode) parent).getChildren().get(index);
    }
 
 
  @Override
    public int getChildCount(Object parent) {
        return ((DataNode) parent).getChildren().size();
    }
 
 
    public int getColumnCount() {
        return columnNames.length;
    }
 
 
  @Override
    public String getColumnName(int column) {
        return columnNames[column];
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
            return ((DataNode) node).getName();
        case 1:
            return ((DataNode) node).getCapital();
        case 2:
            return ((DataNode) node).getDeclared();
        case 3:
            return ((DataNode) node).getArea();
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
