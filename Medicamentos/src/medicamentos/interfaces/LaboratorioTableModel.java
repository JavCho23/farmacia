package medicamentos.interfaces;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import medicamentos.entidades.Laboratorio;

public class LaboratorioTableModel extends AbstractTableModel {
    
    private List<Laboratorio> laboratorios;
    private final String[] Columnas={"Nombre"};

    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantidad = 0;
        
        if( this.laboratorios != null){
            cantidad = this.laboratorios.size();
        }
        
        return cantidad;
    }

    @Override
    public int getColumnCount() {
        return this.Columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Laboratorio lab;
        Object valor = "";
        
        lab = this.laboratorios.get(rowIndex);
        switch(columnIndex ){
            case 0: valor = lab.getNombre();
            break;
        }
        
        return valor;
    }

    @Override
    public String getColumnName(int column) {
        return this.Columnas[column];
    }
    
    

    
    
}
