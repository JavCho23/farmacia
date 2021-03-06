package medicamentos.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import medicamentos.entidades.Laboratorio;

public class DAOLaboratorio
        extends Conexion {

    public void registrar(Laboratorio laboratorio) throws Exception {
        String sql = "INSERT INTO Laboratorio(Nombre, Vigente) VALUES( '" +
                laboratorio.getNombre() + "', 1)";

        try {
            this.conectar();
            this.ejecutarOrden(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void modificar(Laboratorio laboratorio)throws Exception{
         String sql = "UPDATE Laboratorio SET Nombre = '"  + laboratorio.getNombre() + 
                 "', Vigente = " + (laboratorio.isVigente() == true ? "1" : "0") +
                 " where codigo = " + laboratorio.getCodigo();

        try {
            this.conectar();
            this.ejecutarOrden(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public List<Laboratorio> listar() throws Exception{
        List<Laboratorio> laboratorios = null;
        Laboratorio lab;
        ResultSet rs = null;
        String sql = "SELECT Codigo, Nombre, Vigente FROM Laboratorio ORDER BY Nombre";
        
             
        try{
            this.conectar();
            rs = this.pedirDatos(sql);
            laboratorios = new ArrayList<>();
            while( rs.next() == true){
                lab = new Laboratorio();
                lab.setCodigo(rs.getInt("Codigo"));
                lab.setNombre(rs.getString("Nombre"));
                lab.setVigente(rs.getBoolean("Vigente"));
                
                laboratorios.add(lab);
            }
            rs.close();
        }catch(Exception ex){
            throw  ex;
        }
        
        return laboratorios;
    }
    
    public List<Laboratorio> listarVigentes() throws Exception{
        List<Laboratorio> laboratorios = null;
        Laboratorio lab;
        ResultSet rs = null;
        String sql = "SELECT Codigo, Nombre, Vigente FROM Laboratorio WHERE Vigente = 1 ORDER BY Nombre";        
             
        try{
            this.conectar();
            rs = this.pedirDatos(sql);
            laboratorios = new ArrayList<>();
            while( rs.next() == true){
                lab = new Laboratorio();
                lab.setCodigo(rs.getInt("Codigo"));
                lab.setNombre(rs.getString("Nombre"));
                lab.setVigente(true);
                
                laboratorios.add(lab);
            }
            rs.close();
        }catch(Exception ex){
            throw  ex;
        }
        
        return laboratorios;
    }

}
