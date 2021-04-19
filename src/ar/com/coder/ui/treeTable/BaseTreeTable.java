/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.treeTable;

import java.awt.Dimension;
import javax.swing.JTable;

/**
 *
 * @author sysadmin
 */
public class BaseTreeTable extends JTable{

    private  TreeTableCellRenderer tree;

    public BaseTreeTable() {
        this.tree=null;
    }
    
    public BaseTreeTable(BaseTreeTableModel treeTableModel) {
        super();
 
        tree = new TreeTableCellRenderer(this, treeTableModel);
 
        super.setModel(new BaseTableModelAdapter(tree,treeTableModel));
 
        BaseTreeTableSelectionModel selectionModel;
        selectionModel = new BaseTreeTableSelectionModel();
        tree.setSelectionModel(selectionModel); //For the tree
        setSelectionModel(selectionModel.getListSelectionModel()); //For the table
 
 
        setDefaultRenderer(BaseTreeTableModel.class, tree);
        setDefaultEditor(BaseTreeTableModel.class, new BaseTreeTableCellEditor(tree, this));
        setShowGrid(false);
 
        setIntercellSpacing(new Dimension(0, 0));
 
    }

    public void setModel(BaseTreeTableModel treeTableModel) {
        tree = new TreeTableCellRenderer(this, treeTableModel);
 
        super.setModel(new BaseTableModelAdapter(tree,treeTableModel));
 
        BaseTreeTableSelectionModel selectionModel;
        selectionModel = new BaseTreeTableSelectionModel();
        tree.setSelectionModel(selectionModel); //For the tree
        setSelectionModel(selectionModel.getListSelectionModel()); //For the table
 
 
        setDefaultRenderer(BaseTreeTableModel.class, tree);
        setDefaultEditor(BaseTreeTableModel.class, new BaseTreeTableCellEditor(tree, this));
        setShowGrid(false);
 
        setIntercellSpacing(new Dimension(0, 0));
 
    }

   
}
