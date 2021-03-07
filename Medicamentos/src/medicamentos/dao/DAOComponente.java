package medicamentos.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import medicamentos.entidades.Componente;
import medicamentos.entidades.Medicamento;
import medicamentos.entidades.PrincipioActivo;


public class DAOComponente 
        extends Conexion{
    public void registrar(Componente componente) throws Exception {
        String sql = "INSERT INTO Componente(Principio, Concentracion, Vigente) VALUES( " +
                + componente.getPrincipio().getCodigo() + ", " +
                + componente.getMedicamento().getCodigo() + ", '" + componente.getConcentracion()+ "', 1)";

        try {
            this.conectar();
            this.ejecutarOrden(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void modificar(Componente componente)throws Exception{
         String sql = "UPDATE Medicamento SET Concentracion = '"  + componente.getConcentracion()+ 
                 "', Vigente = " + (componente.isVigente() == true ? "1" : "0") +
                 " where Principio = " + componente.getPrincipio().getCodigo() 
                 + " and Medicamento = " + componente.getMedicamento().getCodigo();

        try {
            this.conectar();
            this.ejecutarOrden(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public Componente leer(int codigo) throws Exception{
        //PrincipioActivo pa;
        //Medicamento med;
        Componente comp = null;
        ResultSet rs = null;
        String sql = "SELECT C.Concentracion, C.Vigente"
                + "FROM Componente C "
                + "WHERE C.Medicamento = " + comp.getMedicamento().getCodigo();
             
        try{
            this.conectar();
            rs = this.pedirDatos(sql);
            if( rs.next() == true){
                comp = new Componente();
                comp.setConcentracion(rs.getString("Concentracion"));
                comp.setVigente(rs.getBoolean("Vigente"));
            }
            rs.close();
        }catch(Exception ex){
            throw  ex;
        }
        
        return comp;
    }
    
    public List<Componente> listar(String nombre) throws Exception{
        List<Componente> componentes = null;
        Componente comp;
        PrincipioActivo pa;
        Medicamento med;
        ResultSet rs = null;
        String sql = "SELECT PA.Nombre AS PrincipioActivo, C.Concentracion "
                + "FROM Componente C JOIN Medicamento M JOIN PrincipioActivo PA "
                + "ON C.Principio = PA.Codigo AND C.Medicamento = M.Codigo "
                + "WHERE M.nombre LIKE '" + nombre + "%' "
                + " ORDER BY PA.Nombre";
        
             
        try{
            this.conectar();
            rs = this.pedirDatos(sql);
            componentes = new ArrayList<>();
            while( rs.next() == true){
                comp = new Componente();
                pa = new PrincipioActivo();
                pa.setNombre(rs.getString("PrincipioActivo"));
                comp.setPrincipio(pa);
                comp.setConcentracion(rs.getString("Concentracion"));
                
                componentes.add(comp);
            }
            rs.close();
        }catch(Exception ex){
            throw  ex;
        }
        
        return componentes;
    }
}