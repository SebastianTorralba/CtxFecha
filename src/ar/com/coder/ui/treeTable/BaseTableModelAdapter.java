/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.treeTable;

import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author sysadmin
 */
public class BaseTableModelAdapter extends AbstractTableModel{
    JTree tree;
    BaseTreeTableModel model;

    public BaseTableModelAdapter(JTree tree, BaseTreeTableModel model) {
        this.tree = tree;
        this.model = model;
        tree.addTreeExpansionListener(new TreeExpansionListener() {
            public void treeExpanded(TreeExpansionEvent event) {
                fireTableDataChanged();
            }
 
            public void treeCollapsed(TreeExpansionEvent event) {
                fireTableDataChanged();
            }
        });
    }
    protected Object nodeForRow(int row) {
        TreePath treePath = tree.getPathForRow(row);
        return treePath.getLastPathComponent();
    }
     public boolean isCellEditable(int row, int column) {
        return model.isCellEditable(nodeForRow(row), column);
    }
    @Override
    public int getRowCount() {
        return tree.getRowCount();
    }
     public String getColumnName(int column) {
        return model.getColumnName(column);
    }
    @Override
    public int getColumnCount() {
        return model.getColumnCount();
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return model.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        return model.getValueAt(nodeForRow(row), column);
    }
    public void setValueAt(Object value, int row, int column) {
        model.setValueAt(value, nodeForRow(row), column);
    }
    
    
}
