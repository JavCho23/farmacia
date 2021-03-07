package medicamentos.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import medicamentos.entidades.PrincipioActivo;


public class DAOPrincipioActivo 
        extends Conexion {
    
    public void registrar(PrincipioActivo principio) throws Exception {
        String sql = "INSERT INTO PrincipioActivo(Nombre, Descripcion, Vigente) VALUES( '" 
                + principio.getNombre() + "', '" + principio.getDescripcion() + "', 1)";

        try {
            this.conectar();
            this.ejecutarOrden(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void modificar(PrincipioActivo principio)throws Exception{
         String sql = "UPDATE Principioactivo SET Nombre = '"  + principio.getNombre() + "', Descripcion = '"  
                 + principio.getDescripcion() + "', Vigente = " + (principio.isVigente() == true ? "1" : "0") +
                 " where codigo = " + principio.getCodigo();

        try {
            this.conectar();
            this.ejecutarOrden(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public List<PrincipioActivo> listar() throws Exception {
        List<PrincipioActivo> principiosActivos = null;
        PrincipioActivo pAct;
        ResultSet rs = null;
        String sql = "SELECT Codigo, Nombre, Descripcion, Vigente FROM PrincipioActivo ORDER BY Nombre";
        
             
        try{
            this.conectar();
            rs = this.pedirDatos(sql);
            principiosActivos = new ArrayList<>();
            while( rs.next() == true){
                pAct = new PrincipioActivo();
                pAct.setCodigo(rs.getInt("Codigo"));
                pAct.setNombre(rs.getString("Nombre"));
                pAct.setDescripcion(rs.getString("Descripcion"));
                pAct.setVigente(rs.getBoolean("Vigente"));
                
                principiosActivos.add(pAct);
            }
            rs.close();
        }catch(Exception ex){
            throw  ex;
        }
        
        return principiosActivos;
    }
    
    public List<PrincipioActivo> listarVigentes() throws Exception{
        List<PrincipioActivo> principioActivos = null;
        PrincipioActivo pAct;
        ResultSet rs = null;
        String sql = "SELECT Codigo, Nombre, Descripcion, Vigente FROM PrincipioActivo WHERE Vigente = 1 ORDER BY Nombre";        
             
        try{
            this.conectar();
            rs = this.pedirDatos(sql);
            principioActivos = new ArrayList<>();
            while( rs.next() == true){
                pAct = new PrincipioActivo();
                pAct.setCodigo(rs.getInt("Codigo"));
                pAct.setNombre(rs.getString("Nombre"));
                pAct.setDescripcion(rs.getString("Descripcion"));
                pAct.setVigente(true);
                
                principioActivos.add(pAct);
            }
            rs.close();
        }catch(Exception ex){
            throw  ex;
        }
        
        return principioActivos;
    }
    
}
