/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas.editors;

import ar.com.coder.objetos.tintoreria.EtapaProductiva;
import ar.com.coder.objetos.tintoreria.NodoRuta;
import ar.com.coder.ui.IActualizable;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author sysadmin
 */
public class EtapaProductivaCellEditor extends AbstractCellEditor
        implements TableCellEditor, ActionListener {
    private IActualizable iActualizable;
    private List<NodoRuta> nodos;
    private EtapaProductiva etapaProductiva;
    private List<EtapaProductiva> etapaProductivas;
    private int fila;

    public void setiActualizable(IActualizable iActualizable) {
        this.iActualizable = iActualizable;
    }
    
    public EtapaProductivaCellEditor(List<EtapaProductiva> etapaProductivas) {
        this.etapaProductivas = etapaProductivas;
    }

    public void setNodos(List<NodoRuta> nodos) {
        this.nodos = nodos;
    }

    @Override
    public Object getCellEditorValue() {
        return this.etapaProductiva;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<EtapaProductiva> comboEtapaProductiva = (JComboBox<EtapaProductiva>) e.getSource();
        this.etapaProductiva = (EtapaProductiva) comboEtapaProductiva.getSelectedItem();
        try {
            nodos.get(fila).setEtapaProductiva(etapaProductiva);
            iActualizable.actualizarDatos();
        } catch (Exception ex) {
        }
    }

    public EtapaProductiva getEtapaProductiva() {
        return etapaProductiva;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof EtapaProductiva) {
            this.etapaProductiva = (EtapaProductiva) value;
            fila = row;
        }

        JComboBox<EtapaProductiva> comboEtapaProductiva = new JComboBox<EtapaProductiva>();

        for (EtapaProductiva m : etapaProductivas) {
            comboEtapaProductiva.addItem(m);
        }

        comboEtapaProductiva.setSelectedItem(etapaProductiva);
        comboEtapaProductiva.addActionListener(this);

        if (isSelected) {
            comboEtapaProductiva.setBackground(table.getSelectionBackground());
        } else {
            comboEtapaProductiva.setBackground(Color.WHITE);
        }

        return comboEtapaProductiva;
    }

}
