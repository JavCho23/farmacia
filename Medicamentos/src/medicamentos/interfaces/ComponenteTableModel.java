/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicamentos.interfaces;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import medicamentos.entidades.Componente;

/**
 *
 * @author Jose Guevara
 */
class ComponenteTableModel extends AbstractTableModel{

    List<Componente> componentes;
    private final String[] columnas={"Principio", "Concentración"};
    
    public List<Componente> getComponentes(){
        return componentes;
    }
    
    public void setComponentes(List<Componente> componentes){
        this.componentes = componentes;
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        int cantidad = 0;
        if(this.componentes != null){
            cantidad = this.componentes.size();
        }
        return cantidad;
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Componente comp;
        Object valor = "";
        
        comp = this.componentes.get(rowIndex);
        switch(columnIndex){
            case 0: valor = comp.getPrincipio().getNombre();
            break;
            case 1: valor = comp.getConcentracion();
            break;
        }
        return valor;
    }
    
    @Override
    public String getColumnName(int column) {
        return this.columnas[column];
    }
    
}
