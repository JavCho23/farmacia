package medicamentos.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import medicamentos.entidades.Componente;
import medicamentos.entidades.Laboratorio;
import medicamentos.entidades.Medicamento;

public class DAOMedicamento
        extends Conexion {

    public void registrar(Medicamento medicamento) throws Exception {
        String sql = "INSERT INTO Medicamento(Laboratorio, Nombre, Precio, Vigente) VALUES( " +
                + medicamento.getLaboratorio().getCodigo() + ", '" + medicamento.getNombre() + "'," +
                 +medicamento.getPrecio() + ", 1)";

        try {
            this.conectar();
            this.ejecutarOrden(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void modificar(Medicamento medicamento)throws Exception{
         String sql = "UPDATE Medicamento SET Laboratorio = " + 
                 medicamento.getLaboratorio().getCodigo() + ", Nombre = '"  + medicamento.getNombre() + 
                 "', Precio = " + medicamento.getPrecio() + ", Vigente = " + (medicamento.isVigente() == true ? "1" : "0") +
                 " where codigo = " + medicamento.getCodigo();

        try {
            this.conectar();
            this.ejecutarOrden(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public Medicamento leer(int codigo) throws Exception{
        Laboratorio lab;
        Medicamento med = null;
        ResultSet rs = null;
        String sql = "SELECT M.Nombre, M.Precio, M.Vigente, M.Laboratorio "
                + "FROM Medicamento M "
                + "WHERE M.Codigo = " + codigo;
             
        try{
            this.conectar();
            rs = this.pedirDatos(sql);
            if( rs.next() == true){
                med = new Medicamento();
                med.setCodigo(codigo);
                med.setNombre(rs.getString("Nombre"));
                med.setPrecio(rs.getDouble("Precio"));
                med.setVigente(rs.getBoolean("Vigente"));
                lab = new Laboratorio();
                lab.setCodigo(rs.getInt("Laboratorio"));
                med.setLaboratorio(lab);
            }
            rs.close();
        }catch(Exception ex){
            throw  ex;
        }
        
        return med;
    }
    
    public List<Medicamento> listar(String nombre) throws Exception{
        List<Medicamento> medicamentos = null;
        Laboratorio lab;
        Medicamento med;
        ResultSet rs = null;
        String sql = "SELECT M.Codigo, M.Nombre, L.Nombre AS Laboratorio,M.Precio "
                + "FROM Medicamento M JOIN Laboratorio L ON M.Laboratorio = L.Codigo "
                + "WHERE M.nombre LIKE '" + nombre + "%' "
                + " ORDER BY M.Nombre, L.Nombre";
        
             
        try{
            this.conectar();
            rs = this.pedirDatos(sql);
            medicamentos = new ArrayList<>();
            while( rs.next() == true){
                med = new Medicamento();
                med.setCodigo(rs.getInt("Codigo"));
                med.setNombre(rs.getString("Nombre"));
                med.setPrecio(rs.getDouble("Precio"));

                lab = new Laboratorio();
                lab.setNombre(rs.getString("Laboratorio"));
                med.setLaboratorio(lab);
                
                medicamentos.add(med);
            }
            rs.close();
        }catch(Exception ex){
            throw  ex;
        }
        
        return medicamentos;
    }
    
    public List<Medicamento> listarVigentes() throws Exception{
        List<Medicamento> medicamentos = null;
        Laboratorio lab;
        Medicamento med;
        ResultSet rs = null;
        String sql = "SELECT M.Codigo, M.Nombre, L.Nombre AS Laboratorio, M.Precio "
                + "FROM Medicamento M JOIN Laboratorio L ON M.Laboratorio = L.Codigo "
                + "WHERE M.Vigente = 1";
        
             
        try{
            this.conectar();
            rs = this.pedirDatos(sql);
            medicamentos = new ArrayList<>();
            while( rs.next() == true){
                med = new Medicamento();
                med.setCodigo(rs.getInt("Codigo"));
                med.setNombre(rs.getString("Nombre"));
                med.setPrecio(rs.getDouble("Precio"));
                lab = new Laboratorio();
                lab.setNombre(rs.getString("Laboratorio"));
                med.setLaboratorio(lab);
                medicamentos.add(med);
            }
            rs.close();
            this.cerrar();

        }catch(Exception ex){
            throw  ex;
        }
        
        return medicamentos;
    }
     public List<Medicamento> listarExcepto(Medicamento medicamento) throws Exception{
        List<Medicamento> medicamentos = null;
        Laboratorio lab;
        Medicamento med;
        ResultSet rs = null;
        String sql = "SELECT M.Codigo, M.Nombre, L.Nombre AS Laboratorio,M.Precio "
                + "FROM Medicamento M JOIN Laboratorio L ON M.Laboratorio = L.Codigo "
                + "WHERE M.Codigo != "+ medicamento.getCodigo();
        DAOComponente daoComponente = new DAOComponente();
             
        try{
            this.conectar();
            rs = this.pedirDatos(sql);
            medicamentos = new ArrayList<>();
            while( rs.next() == true){
                med = new Medicamento();
                med.setCodigo(rs.getInt("Codigo"));
                med.setNombre(rs.getString("Nombre"));
                med.setPrecio(rs.getDouble("Precio"));
                med.setComponentes(daoComponente.listarPorMedicamento(med));
                lab = new Laboratorio();
                lab.setNombre(rs.getString("Laboratorio"));
                med.setLaboratorio(lab);
                
                medicamentos.add(med);
            }
            rs.close();
           this.cerrar();
        }catch(Exception ex){
            throw  ex;
        }
        
        return medicamentos;
    }
       public List<Medicamento> importarPrincipiosActivos(Medicamento medicamentoAActualizar,Medicamento medicamentoOrigen) throws Exception{
        List<Medicamento> medicamentos = null;
        Laboratorio lab;
        Medicamento med;
       
        DAOComponente daoComponente = new DAOComponente();
             
        try{
            List<Componente> componentes = daoComponente.listarPorMedicamento(medicamentoOrigen);
            daoComponente.eliminarPorMedicamento(medicamentoAActualizar);
            for (Componente componente : componentes) {
                componente.setMedicamento(medicamentoAActualizar);
                daoComponente.registrar(componente);
            }
         
        }catch(Exception ex){
            throw  ex;
        }
        
        return medicamentos;
    }
}
