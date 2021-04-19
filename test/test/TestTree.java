/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import ar.com.coder.ui.treeTable.BaseTreeTable;
import ar.com.coder.ui.treeTable.BaseTreeTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.TableModel;
import test.models.DataModel;
import test.models.DataNode;

/**
 *
 * @author sysadmin
 */
public class TestTree extends javax.swing.JFrame {
    
    BaseTreeTableModel treeTableModel;
    private static DataNode createDataStructure() {
        List<DataNode> children1 = new ArrayList<DataNode>();
        children1.add(new DataNode("N12", "C12", new Date(), Integer.valueOf(60), null));
        children1.add(new DataNode("N13", "C13", new Date(), Integer.valueOf(60), null));
        children1.add(new DataNode("N14", "C14", new Date(), Integer.valueOf(70), null));
        children1.add(new DataNode("N15", "C15", new Date(), Integer.valueOf(80), null));
 
        List<DataNode> children2 = new ArrayList<DataNode>();
        children2.add(new DataNode("N12", "C12", new Date(), Integer.valueOf(10), null));
        children2.add(new DataNode("N13", "C13", new Date(), Integer.valueOf(20), children1));
        children2.add(new DataNode("N14", "C14", new Date(), Integer.valueOf(30), null));
        children2.add(new DataNode("N15", "C15", new Date(), Integer.valueOf(40), null));
 
        List<DataNode> rootNodes = new ArrayList<DataNode>();
        rootNodes.add(new DataNode("N1", "C1", new Date(), Integer.valueOf(10), children2));
        rootNodes.add(new DataNode("N2", "C2", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N3", "C3", new Date(), Integer.valueOf(10), children2));
        rootNodes.add(new DataNode("N4", "C4", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N5", "C5", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N6", "C6", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N7", "C7", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N8", "C8", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N9", "C9", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N10", "C10", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N11", "C11", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N12", "C7", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N13", "C8", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N14", "C9", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N15", "C10", new Date(), Integer.valueOf(10), children1));
        rootNodes.add(new DataNode("N16", "C11", new Date(), Integer.valueOf(10), children1));
        DataNode root = new DataNode("R1", "R1", new Date(), Integer.valueOf(10), rootNodes);
 
        return root;
    }
    /**
     * Creates new form TestTree
     */
    public TestTree() {
          treeTableModel= new DataModel(createDataStructure());
 
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        baseTreeTable1 = new BaseTreeTable(treeTableModel);
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        baseTreeTable1.setModel(treeTableModel);
        jScrollPane1.setViewportView(baseTreeTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TestTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestTree().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ar.com.coder.ui.treeTable.BaseTreeTable baseTreeTable1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
