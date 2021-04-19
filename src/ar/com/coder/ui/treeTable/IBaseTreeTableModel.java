/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.treeTable;

import javax.swing.tree.TreeModel;

/**
 *
 * @author sysadmin
 */
public interface IBaseTreeTableModel extends TreeModel {

    public int getColumnCount();

    public String getColumnName(int column);

    public Class<?> getColumnClass(int column);

    public Object getValueAt(Object node, int column);

    public boolean isCellEditable(Object node, int column);

    public void setValueAt(Object aValue, Object node, int column);
}
