/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.treeTable;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultTreeSelectionModel;

/**
 *
 * @author sysadmin
 */
public class BaseTreeTableSelectionModel extends DefaultTreeSelectionModel {
    public BaseTreeTableSelectionModel() {
        super();
 
        getListSelectionModel().addListSelectionListener(new ListSelectionListener() {
           
            @Override
            public void valueChanged(ListSelectionEvent e) {
                cambiaValor();
            }
        });
    }
 
    ListSelectionModel getListSelectionModel() {
        return listSelectionModel;
    }
    
    public  void cambiaValor(){
    };
}
