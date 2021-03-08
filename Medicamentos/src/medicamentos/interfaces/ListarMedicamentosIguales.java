/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicamentos.interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import medicamentos.dao.DAOComponente;
import medicamentos.dao.DAOMedicamento;
import medicamentos.entidades.Medicamento;
/**
 *
 * @author javie
 */
public class ListarMedicamentosIguales extends javax.swing.JFrame {

    private ListadoMedicamentosTableModel medicamentosModel = new ListadoMedicamentosTableModel();
    private ListadoMedicamentosTableModel medicametosIgualesModel = new ListadoMedicamentosTableModel();
    private List<Medicamento> medicamentos;
    /**
     * Creates new form BuscarMedicamentosIguales
     */
    public ListarMedicamentosIguales() {
        initComponents();
        try {
            DAOMedicamento dao = new DAOMedicamento();
            this.medicamentos = dao.listar("");
            this.medicamentosModel.setMedicamentos(this.medicamentos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Ocurrio un error al listar medicamentos");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicamentosTabla = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione un medicamento");

        medicamentosTabla.setModel(this.medicamentosModel);
        medicamentosTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicamentosTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medicamentosTabla);

        jTable1.setModel(this.medicametosIgualesModel);
        jScrollPane2.setViewportView(jTable1);

        jLabel3.setText("Listado de medicamentos iguales");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void medicamentosTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicamentosTablaMouseClicked
        // TODO add your handling code here:
        int fila = this.medicamentosTabla.getSelectedRow();
        if(fila == -1) return;
        try {
            DAOMedicamento dao = new DAOMedicamento();
            DAOComponente daoComponente = new DAOComponente();
            Medicamento medicamentoAComparar = this.medicamentos.get(fila);
            medicamentoAComparar.setComponentes(daoComponente.listarPorMedicamento(medicamentoAComparar));
            List<Medicamento> medicamentosIguales = new ArrayList<Medicamento>();
            List<Medicamento> medicamentos = dao.listarExcepto(medicamentoAComparar);

            for (Medicamento medicamento : medicamentos) {
                if(medicamentoAComparar.equals(medicamento)) medicamentosIguales.add(medicamento);
            }
            this.medicametosIgualesModel.setMedicamentos(medicamentosIguales);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Ocurrio un error al buscar los medicamentos iguales, " + e.getMessage());
        }
         
    }//GEN-LAST:event_medicamentosTablaMouseClicked

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
            java.util.logging.Logger.getLogger(ListarMedicamentosIguales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarMedicamentosIguales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarMedicamentosIguales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarMedicamentosIguales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarMedicamentosIguales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable medicamentosTabla;
    // End of variables declaration//GEN-END:variables
}