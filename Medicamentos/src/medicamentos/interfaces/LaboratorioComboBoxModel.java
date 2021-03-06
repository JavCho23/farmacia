/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicamentos.interfaces;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import medicamentos.entidades.Laboratorio;

/**
 *
 * @author AULA EPG 23
 */
class LaboratorioComboBoxModel
        extends AbstractListModel<Object>
        implements ComboBoxModel<Object> {

    private Laboratorio seleccionado;
    private List<Laboratorio> laboratorios;

    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
    }

    @Override
    public int getSize() {
        int cantidad = 0;

        if (this.laboratorios != null) {
            cantidad = this.laboratorios.size();
        }

        return cantidad;
    }

    @Override
    public Object getElementAt(int index) {
        String valor = "";

        valor = this.laboratorios.get(index).getNombre();

        return valor;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if (this.laboratorios != null && anItem != null) {
            for (Laboratorio lab : this.laboratorios) {
                if( anItem.toString().equalsIgnoreCase(lab.getNombre()) == true){
                    this.seleccionado = lab;
                    return ;
                }
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        String valor = "";

        if (this.seleccionado != null) {
            valor = this.seleccionado.getNombre();
        }

        return valor;
    }

    void seleccionar(Laboratorio laboratorio) {
        this.seleccionado = null;
        if (this.laboratorios != null && laboratorio != null) {
            for (Laboratorio lab : this.laboratorios) {
                if( laboratorio.getCodigo() == lab.getCodigo() ){
                    this.seleccionado = lab;
                    return ;
                }
            }
        }
    }

}
