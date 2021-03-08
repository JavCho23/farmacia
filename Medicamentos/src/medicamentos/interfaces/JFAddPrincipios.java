/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicamentos.interfaces;

import java.util.List;
import javax.swing.JOptionPane;
import medicamentos.dao.DAOComponente;
import medicamentos.dao.DAOPrincipioActivo;
import medicamentos.entidades.Componente;
import medicamentos.entidades.Medicamento;
import medicamentos.entidades.PrincipioActivo;

/**
 *
 * @author Jose Guevara
 */
public class JFAddPrincipios extends javax.swing.JFrame {

    private PrincipioActivoTableModel principioActivoTable = new PrincipioActivoTableModel();
    private ComponenteTableModel componenteTable = new ComponenteTableModel();
    private Componente actual;
    List<PrincipioActivo> principios;
    private Medicamento med;
    List<Componente> componentes;
    /**
     * Creates new form JFAddPrincipios
     * @param medicamento
     */
    public JFAddPrincipios(Medicamento medicamento) {
        initComponents();
        
        this.listarPrincipios();
        this.med = medicamento;
        this.listarComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panComponentes = new javax.swing.JPanel();
        txtMedicamento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaComponentes = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListaPrincipios = new javax.swing.JTable();
        lblConcentracion = new javax.swing.JLabel();
        txtConcentracion = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panComponentes.setBorder(javax.swing.BorderFactory.createTitledBorder("Componentes"));

        txtMedicamento.setEditable(false);
        txtMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMedicamentoActionPerformed(evt);
            }
        });

        tblListaComponentes.setModel(this.componenteTable);
        tblListaComponentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaComponentesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListaComponentes);

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblListaPrincipios.setModel(this.principioActivoTable);
        tblListaPrincipios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaPrincipiosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblListaPrincipios);

        lblConcentracion.setText("Concentración:");

        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panComponentesLayout = new javax.swing.GroupLayout(panComponentes);
        panComponentes.setLayout(panComponentesLayout);
        panComponentesLayout.setHorizontalGroup(
            panComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panComponentesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panComponentesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblConcentracion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtConcentracion, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panComponentesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAgregar)
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panComponentesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panComponentesLayout.createSequentialGroup()
                                .addComponent(txtMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panComponentesLayout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addContainerGap())))))
        );
        panComponentesLayout.setVerticalGroup(
            panComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panComponentesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panComponentesLayout.createSequentialGroup()
                        .addComponent(txtMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panComponentesLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(panComponentesLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(btnAgregar)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConcentracion)
                    .addComponent(txtConcentracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCerrar)
                    .addComponent(panComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedicamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedicamentoActionPerformed

    private void tblListaPrincipiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaPrincipiosMouseClicked
        this.activarControles(true);
    }//GEN-LAST:event_tblListaPrincipiosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Componente comp ;
        DAOComponente dao ;
        int principioIndex = this.tblListaPrincipios.getSelectedRow();
        if(principioIndex == -1) return;
        
        boolean noLoTiene = true;
         for (Componente componente : this.componentes) {
            
             if(componente.getPrincipio().getNombre().equals(this.principios.get(principioIndex).getNombre())){
               noLoTiene = false;
              }
                  
         }
        if(!noLoTiene){
        JOptionPane.showMessageDialog(this, "Ya tiene ese principio activo");
            return;
        }
            comp = this.crearEntidad();
            dao = new DAOComponente();
            try{
                dao.registrar(comp);
                
                this.listarComponentes();
                this.activarControles(false);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblListaComponentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaComponentesMouseClicked
this.activarControles(false);    }//GEN-LAST:event_tblListaComponentesMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
     
        DAOComponente dao ;
        int componenteIndex = this.tblListaComponentes.getSelectedRow();
        System.err.println(componenteIndex);
        if(componenteIndex == -1) return;
        Componente comp  = new Componente();
        comp.setConcentracion(this.txtConcentracion.getText());
        comp.setMedicamento(this.med);
        comp.setPrincipio(this.componentes.get(componenteIndex).getPrincipio());
        comp.setVigente(true);
            dao = new DAOComponente();
            try{
                dao.modificar(comp);
                this.listarComponentes();
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(JFAddPrincipios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFAddPrincipios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFAddPrincipios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFAddPrincipios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFAddPrincipios(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblConcentracion;
    private javax.swing.JPanel panComponentes;
    private javax.swing.JTable tblListaComponentes;
    private javax.swing.JTable tblListaPrincipios;
    private javax.swing.JTextField txtConcentracion;
    private javax.swing.JTextField txtMedicamento;
    // End of variables declaration//GEN-END:variables

    private void activarControles(boolean estado) {
        if(estado){
            this.lblConcentracion.setEnabled(true);
            this.txtConcentracion.setEnabled(true);
            this.btnAgregar.setEnabled(true);
             this.btnEliminar.setEnabled(false);
            this.btnEditar.setEnabled(false);
        }else{
            this.btnEliminar.setEnabled(true);
            this.btnEditar.setEnabled(true);
            this.lblConcentracion.setEnabled(true);
            this.txtConcentracion.setEnabled(true);
            this.btnAgregar.setEnabled(false);
        }
        
        
    
        
       
    }
    
    private void listarPrincipios(){
        DAOPrincipioActivo dao = new DAOPrincipioActivo();
        
        try{
            this.principios = dao.listarVigentes();
            this.principioActivoTable.setPrincipiosActivos(principios);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "No se pudo listar los principios activos");
        }       
    }
    
    private Componente crearEntidad() {
        Componente comp  =new Componente();
        int principioIndex = this.tblListaPrincipios.getSelectedRow();
        comp.setConcentracion(this.txtConcentracion.getText());
        comp.setMedicamento(this.med);
        comp.setPrincipio(this.principios.get(principioIndex));
        comp.setVigente(true);
        return comp;
    }
    
     private boolean validar() {
        int principioIndex = this.tblListaPrincipios.getSelectedRow();
        if(principioIndex == -1) return false;
        
        boolean noLoTiene= true;
         for (Componente componente : this.componentes) {
            
             if(componente.getPrincipio().getNombre().equals(this.principios.get(principioIndex).getNombre())){
               noLoTiene = false;
              }
                  
         }
        return noLoTiene;
    }
     
     private void listarComponentes() {
        DAOComponente dao = new DAOComponente();
        try{
            this.componentes = dao.listar(this.med);
            this.componenteTable.setComponentes(componentes);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "No se pudo listar los componentes");
        }
    }
}
