/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicamentos;

import medicamentos.interfaces.JFLaboratorio;
import medicamentos.interfaces.JFListadoMedicamentos;
import medicamentos.interfaces.JFMedicamento;
import medicamentos.interfaces.JFPrincipioActivo;
import medicamentos.interfaces.ListarMedicamentosIguales;

/**
 *
 * @author AULA EPG 23
 */
public class JFPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFPrincipal
     * 
     */
    public JFPrincipal() {
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

        bmPrincipal = new javax.swing.JMenuBar();
        mnuDatos = new javax.swing.JMenu();
        mnuLaboratorios = new javax.swing.JMenuItem();
        mnuPrincipioActivo = new javax.swing.JMenuItem();
        mnuMedicamento = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        mnuListadoMedicamentos = new javax.swing.JMenuItem();
        mnuBusqueda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de medicamentos");

        mnuDatos.setText("Datos");

        mnuLaboratorios.setText(" Laboratorio");
        mnuLaboratorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLaboratoriosActionPerformed(evt);
            }
        });
        mnuDatos.add(mnuLaboratorios);

        mnuPrincipioActivo.setText(" Principio activo");
        mnuPrincipioActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPrincipioActivoActionPerformed(evt);
            }
        });
        mnuDatos.add(mnuPrincipioActivo);

        mnuMedicamento.setText("Medicamentos");
        mnuMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMedicamentoActionPerformed(evt);
            }
        });
        mnuDatos.add(mnuMedicamento);

        bmPrincipal.add(mnuDatos);

        mnuReportes.setText("Reportes");

        mnuListadoMedicamentos.setText("Listado de medicamentos");
        mnuListadoMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListadoMedicamentosActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuListadoMedicamentos);

        mnuBusqueda.setText("Búsqueda de medicamente iguales");
        mnuBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBusquedaActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuBusqueda);

        bmPrincipal.add(mnuReportes);

        setJMenuBar(bmPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuLaboratoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLaboratoriosActionPerformed
        JFLaboratorio frame = new JFLaboratorio();
        
        frame.setVisible(true);
    }//GEN-LAST:event_mnuLaboratoriosActionPerformed

    private void mnuMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMedicamentoActionPerformed
        JFMedicamento frame = new JFMedicamento();
        
        frame.setVisible(true);
    }//GEN-LAST:event_mnuMedicamentoActionPerformed

    private void mnuPrincipioActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPrincipioActivoActionPerformed
        JFPrincipioActivo frame = new JFPrincipioActivo();
        
        frame.setVisible(true);
    }//GEN-LAST:event_mnuPrincipioActivoActionPerformed

    private void mnuListadoMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListadoMedicamentosActionPerformed
        JFListadoMedicamentos frame = new JFListadoMedicamentos();
        frame.setVisible(true);
    }//GEN-LAST:event_mnuListadoMedicamentosActionPerformed

    private void mnuBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBusquedaActionPerformed
        ListarMedicamentosIguales frame = new ListarMedicamentosIguales();
        frame.setVisible(true);
    }//GEN-LAST:event_mnuBusquedaActionPerformed

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
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar bmPrincipal;
    private javax.swing.JMenuItem mnuBusqueda;
    private javax.swing.JMenu mnuDatos;
    private javax.swing.JMenuItem mnuLaboratorios;
    private javax.swing.JMenuItem mnuListadoMedicamentos;
    private javax.swing.JMenuItem mnuMedicamento;
    private javax.swing.JMenuItem mnuPrincipioActivo;
    private javax.swing.JMenu mnuReportes;
    // End of variables declaration//GEN-END:variables
}
