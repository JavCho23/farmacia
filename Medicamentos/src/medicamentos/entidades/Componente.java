package medicamentos.entidades;

public class Componente {
    
    private PrincipioActivo principio;
    private String concentracion;
    private boolean vigente;

    public PrincipioActivo getPrincipio() {
        return principio;
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
    
}
