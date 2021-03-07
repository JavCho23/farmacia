/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicamentos.interfaces;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import medicamentos.entidades.Medicamento;

/**
 *
 * @author AULA EPG 23
 */
class ListadoMedicamentosTableModel
        extends AbstractTableModel {

    private List<Medicamento> medicamentos;
    private final String[] Columnas = {"Código","Nombre", "Laboratorio","Precio"};

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int cantidad = 0;

        if (this.medicamentos != null) {
            cantidad = this.medicamentos.size();
        }

        return cantidad;
    }

    @Override
    public int getColumnCount() {
        return this.Columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Medicamento med;
        Object valor = "";

        if (this.medicamentos != null) {
            med = this.medicamentos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    valor = med.getCodigo();
                    break;
                case 1:
                    valor = med.getNombre();
                    break;
                case 2: 
                    valor = med.getLaboratorio().getNombre();
                    break;
                case 3:
                    valor = med.getPrecio();
                    break; 
            }
        }

        return valor;
    }

    @Override
    public String getColumnName(int column) {
        return this.Columnas[column];
    }
    
    

}
