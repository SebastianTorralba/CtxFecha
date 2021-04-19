/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas.editors;

import ar.com.coder.objetos.tintoreria.Maquina;
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
public class MaquinaCellEditor extends AbstractCellEditor
        implements TableCellEditor, ActionListener {
    private IActualizable iActualizable;
    private List<NodoRuta> nodos;
    private Maquina maquina;
    private List<Maquina> maquinas;
    private int fila;

    public void setiActualizable(IActualizable iActualizable) {
        this.iActualizable = iActualizable;
    }
    
    public MaquinaCellEditor(List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public void setNodos(List<NodoRuta> nodos) {
        this.nodos = nodos;
    }

    @Override
    public Object getCellEditorValue() {
        return this.maquina;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<Maquina> comboMaquina = (JComboBox<Maquina>) e.getSource();
        this.maquina = (Maquina) comboMaquina.getSelectedItem();
        try {
            nodos.get(fila).setMaquina(maquina);
            iActualizable.actualizarDatos();
        } catch (Exception ex) {
        }
    }

    public Maquina getMaquina() {
        return maquina;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof Maquina) {
            this.maquina = (Maquina) value;
            fila = row;
        }

        JComboBox<Maquina> comboMaquina = new JComboBox<Maquina>();

        for (Maquina m : maquinas) {
            comboMaquina.addItem(m);
        }

        comboMaquina.setSelectedItem(maquina);
        comboMaquina.addActionListener(this);

        if (isSelected) {
            comboMaquina.setBackground(table.getSelectionBackground());
        } else {
            comboMaquina.setBackground(Color.WHITE);
        }

        return comboMaquina;
    }

}
