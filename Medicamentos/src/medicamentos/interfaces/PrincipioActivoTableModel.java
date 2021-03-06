/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicamentos.interfaces;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import medicamentos.entidades.PrincipioActivo;

/**
 *
 * @author Jose Guevara
 */
class PrincipioActivoTableModel extends AbstractTableModel{

    List<PrincipioActivo> principiosActivos;
    private final String[] columnas={"Nombre", "Descripción"};
    
    public List<PrincipioActivo> getPrincipiosActivos(){
        return principiosActivos;
    }
    
    public void setPrincipiosActivos(List<PrincipioActivo> principiosActivos){
        this.principiosActivos = principiosActivos;
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        int cantidad = 0;
        if(this.principiosActivos != null){
            cantidad = this.principiosActivos.size();
        }
        return cantidad;
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PrincipioActivo pAct;
        Object valor = "";
        
        pAct = this.principiosActivos.get(rowIndex);
        switch(columnIndex){
            case 0: valor = pAct.getNombre();
            break;
            case 1: valor = pAct.getDescripcion();
            break;
        }
        return valor;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnas[column];
    }
    
}
