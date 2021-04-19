/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.treeTable;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author sysadmin
 */
public class TreeTableCellRenderer extends JTree implements TableCellRenderer {

    protected int visibleRow;
    private BaseTreeTable treeTable;

    public TreeTableCellRenderer(BaseTreeTable treeTable, BaseTreeTableModel treeTableModel) {
        super(treeTableModel);
        this.treeTable = treeTable;

        setRowHeight(getRowHeight());
    }

    public void setRowHeight(int rowHeight) {
        if (rowHeight > 0) {
            super.setRowHeight(rowHeight);
            if (treeTable != null && treeTable.getRowHeight() != rowHeight) {
                treeTable.setRowHeight(getRowHeight());
            }
        }
    }

    public void setBounds(int x, int y, int w, int h) {
        super.setBounds(x, 0, w, treeTable.getHeight());
    }

    public void paint(Graphics g) {
        g.translate(0, -visibleRow * getRowHeight());

        super.paint(g);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         if (isSelected)
            setBackground(table.getSelectionBackground());
        else
            setBackground(table.getBackground());
 
        visibleRow = row;
        return this;
    }

}
