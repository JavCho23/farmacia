
package medicamentos.entidades;

import java.util.List;

public class Medicamento {
    
    private int codigo;
    private String nombre;
    private double precio;
    private Laboratorio laboratorio;
    private boolean vigente;
    
    private List<Componente> componentes;

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }    
    
    public void setLaboratorio( Laboratorio laboratorio){
        this.laboratorio = laboratorio;
    }
    
    public Laboratorio getLaboratorio(){
        return this.laboratorio;
    }
    
    public boolean equals(Medicamento medicamento){
        Boolean isEqual = true;
       if(medicamento.getComponentes().isEmpty() || this.componentes.isEmpty()) return false;
       if(medicamento.getComponentes().size() != this.componentes.size()) return false;
        for (Componente componente : this.componentes) {
          if(!medicamento.getComponentes().contains(componente)){
              isEqual = false;
              break;
          }
        }
        return isEqual; 
    }
    
}
