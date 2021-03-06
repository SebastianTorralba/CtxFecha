/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui;

import ar.com.coder.dominio.excel.ExcelReporteDeposito;
import ar.com.coder.Principal;
import ar.com.coder.dominio.ReporteDepositoControlador;
import ar.com.coder.objetos.ReporteDeposito;
import ar.com.coder.ui.grillas.ReporteDepositoGrilla;
import ar.com.coder.ui.grillas.renders.ReporteDepositoGrillaRender;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author sysadmin
 */
public class GrillaReporteDeposito extends javax.swing.JInternalFrame {

    private ReporteDepositoControlador psc;
    private ArrayList<ReporteDeposito> datos;
    private int[] filaSeleccionadas;
    private final ReporteDepositoGrilla grilla;
    private TableRowSorter trsGrilla;
    private ExcelReporteDeposito excelReporteDeposito=new ExcelReporteDeposito();

    /**
     * Creates new form GrillaReporteDeposito
     */
    public GrillaReporteDeposito() {

        initComponents();
        this.trsGrilla = new TableRowSorter<ReporteDepositoGrilla>();
        psc = new ReporteDepositoControlador(Principal.connection);
        grilla = new ReporteDepositoGrilla();
        trsGrilla.setModel(grilla);
        
        jtGrilla.setModel(grilla);
        jtGrilla.setRowSorter(trsGrilla);
        jtGrilla.setDefaultRenderer(Object.class, new ReporteDepositoGrillaRender());
        actualizar();
    }

    private void actualizar() {
        datos = psc.extrerTodo();
        excelReporteDeposito.setDatos(datos);
        grilla.setData(datos);
        grilla.fireTableDataChanged();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtGrilla = new javax.swing.JTable();
        jbCancelar = new javax.swing.JButton();
        jbExcel = new javax.swing.JButton();

        setTitle("Reporte de Deposito");

        jtGrilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtGrilla);

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbExcel.setText("Exportar a Excel");
        jbExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1093, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCancelar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbExcel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcelActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            excelReporteDeposito.generarArchivo(file);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jbExcelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcel;
    private javax.swing.JTable jtGrilla;
    // End of variables declaration//GEN-END:variables
}
