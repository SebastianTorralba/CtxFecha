/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.coder.ui;

import ar.com.coder.ui.tintoreria.SimuladorQuimicos;
import ar.com.coder.ui.tintoreria.GrillaReporteQuimico;
import ar.com.coder.ui.tintoreria.CalculoConsumoQuimicos;
import javax.swing.JFrame;

/**
 *
 * @author sysadmin
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        mPedido = new javax.swing.JMenu();
        miSeguimiento = new javax.swing.JMenuItem();
        miTerminar = new javax.swing.JMenuItem();
        miSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiVerificaFecha = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmiConsumoQuimico = new javax.swing.JMenuItem();
        jmiSimuladorConsumo = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jmiDepositos = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu3.setText("File");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar1.add(jMenu4);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de Pedidos Industriales");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        mPedido.setMnemonic('f');
        mPedido.setText("Pedidos");

        miSeguimiento.setMnemonic('S');
        miSeguimiento.setText("Seguimiento");
        miSeguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSeguimientoActionPerformed(evt);
            }
        });
        mPedido.add(miSeguimiento);

        miTerminar.setMnemonic('s');
        miTerminar.setText("Terminar ");
        miTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTerminarActionPerformed(evt);
            }
        });
        mPedido.add(miTerminar);

        miSalir.setMnemonic('r');
        miSalir.setText("Salir");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        mPedido.add(miSalir);

        menuBar.add(mPedido);

        jMenu2.setText("Partidas");

        jmiVerificaFecha.setText("Verificar Fechas");
        jmiVerificaFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVerificaFechaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiVerificaFecha);

        menuBar.add(jMenu2);

        jMenu5.setText("Reporte");

        jmiConsumoQuimico.setText("Consumo Quimicos");
        jmiConsumoQuimico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsumoQuimicoActionPerformed(evt);
            }
        });
        jMenu5.add(jmiConsumoQuimico);

        jmiSimuladorConsumo.setText("Simulador Consumo");
        jmiSimuladorConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSimuladorConsumoActionPerformed(evt);
            }
        });
        jMenu5.add(jmiSimuladorConsumo);

        jMenuItem2.setText("Simulador Cosumo Masivo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jmiDepositos.setText("Depositos");
        jmiDepositos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDepositosActionPerformed(evt);
            }
        });
        jMenu5.add(jmiDepositos);

        menuBar.add(jMenu5);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSalirActionPerformed

    private void miSeguimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSeguimientoActionPerformed
        GrillaPedidoCompromiso gpc=new GrillaPedidoCompromiso();
        desktopPane.add(gpc);
        gpc.setVisible(true);
    }//GEN-LAST:event_miSeguimientoActionPerformed

    private void miTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTerminarActionPerformed
        GrillaPedidoTerminar gpt = new GrillaPedidoTerminar();
        desktopPane.add(gpt);
        gpt.setVisible(true);
    }//GEN-LAST:event_miTerminarActionPerformed

    private void jmiVerificaFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVerificaFechaActionPerformed
        AbmPartida abmPartida = new AbmPartida();
        desktopPane.add(abmPartida);
        abmPartida.setVisible(true);
    }//GEN-LAST:event_jmiVerificaFechaActionPerformed

    private void jmiDepositosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDepositosActionPerformed
           GrillaReporteDeposito grd=new GrillaReporteDeposito();
        desktopPane.add(grd);
        grd.setVisible(true);
    }//GEN-LAST:event_jmiDepositosActionPerformed

    private void jmiConsumoQuimicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsumoQuimicoActionPerformed
          GrillaReporteQuimico grq=new GrillaReporteQuimico();
        desktopPane.add(grq);
        grq.setVisible(true);
    }//GEN-LAST:event_jmiConsumoQuimicoActionPerformed

    private void jmiSimuladorConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSimuladorConsumoActionPerformed
        CalculoConsumoQuimicos ccq = new CalculoConsumoQuimicos();
        desktopPane.add(ccq);
        ccq.setVisible(true);
    }//GEN-LAST:event_jmiSimuladorConsumoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        SimuladorQuimicos sq = new SimuladorQuimicos();
        desktopPane.add(sq);
        sq.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jmiConsumoQuimico;
    private javax.swing.JMenuItem jmiDepositos;
    private javax.swing.JMenuItem jmiSimuladorConsumo;
    private javax.swing.JMenuItem jmiVerificaFecha;
    private javax.swing.JMenu mPedido;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miSalir;
    private javax.swing.JMenuItem miSeguimiento;
    private javax.swing.JMenuItem miTerminar;
    // End of variables declaration//GEN-END:variables

}
