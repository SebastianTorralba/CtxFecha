/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui.grillas.editors;

import ar.com.coder.objetos.tintoreria.Color;
import ar.com.coder.objetos.tintoreria.Maquina;
import ar.com.coder.objetos.tintoreria.NodoRuta;
import ar.com.coder.objetos.tintoreria.NodoRutaColor;
import ar.com.coder.ui.IActualizable;

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
public class MaquinaColorCellEditor extends AbstractCellEditor
        implements TableCellEditor {

    private IActualizable iActualizable;
    private List<NodoRutaColor> nodos;
    private Maquina maquina;
    private List<Maquina> maquinas;
    private Color color;
    private List<Color> colores;
    private int columna;
    private int fila;

    public void setiActualizable(IActualizable iActualizable) {
        this.iActualizable = iActualizable;
    }

    public MaquinaColorCellEditor(List<Maquina> maquinas, List<Color> colores) {
        this.maquinas = maquinas;
        this.colores = colores;
    }

    public void setNodos(List<NodoRutaColor> nodos) {
        this.nodos = nodos;
    }

    @Override
    public Object getCellEditorValue() {
        if(columna==3){
        return this.maquina;}
        if(columna==1){
        return this.color;}
        return null;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        
        if (value instanceof Maquina) {
            this.maquina = (Maquina) value;
            fila = row;
            columna=column;
            JComboBox<Maquina> comboMaquina = new JComboBox<Maquina>();

            for (Maquina m : maquinas) {
                comboMaquina.addItem(m);
            }

            comboMaquina.setSelectedItem(maquina);
            comboMaquina.addActionListener(new MaquinaListener());

            if (isSelected) {
                comboMaquina.setBackground(table.getSelectionBackground());
            } else {
                comboMaquina.setBackground(java.awt.Color.WHITE);
            }
            return comboMaquina;
        }
        if (value instanceof Color) {
            this.color = (Color) value;
            fila = row;
            columna=column;
            JComboBox<Color> comboColor = new JComboBox<Color>();

            for (Color m : colores) {
                comboColor.addItem(m);
            }

            comboColor.setSelectedItem(color);
            comboColor.addActionListener(new ColorListener());

            if (isSelected) {
                comboColor.setBackground(table.getSelectionBackground());
            } else {
                comboColor.setBackground(java.awt.Color.WHITE);
            }
            return comboColor;
        }
        return null;
    }

    private class MaquinaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        JComboBox<Maquina> comboMaquina = (JComboBox<Maquina>) e.getSource();
        maquina = (Maquina) comboMaquina.getSelectedItem();
        try {
            nodos.get(fila).setMaquina(maquina);
            iActualizable.actualizarDatos();
        } catch (Exception ex) {
        }
        }
    }
    private class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        JComboBox<Color> comboMaquina = (JComboBox<Color>) e.getSource();
        color = (Color) comboMaquina.getSelectedItem();
        try {
            nodos.get(fila).setColor(color);
            iActualizable.actualizarDatos();
        } catch (Exception ex) {
        }
        }
    }
}
