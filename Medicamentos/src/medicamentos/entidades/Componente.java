package medicamentos.entidades;

public class Componente {
    
    private PrincipioActivo principio;
    private Medicamento medicamento;
    private String concentracion;
    private boolean vigente;

    public PrincipioActivo getPrincipio() {
        return this.principio;
    }

    public void setPrincipio(PrincipioActivo principio) {
        this.principio = principio;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
    
}
