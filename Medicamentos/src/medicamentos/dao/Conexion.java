package medicamentos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/*** POOL SE CONEXIONES
 * C1 uso
 * C2 uso
 * 
 * */

public class Conexion {

    private Connection conexion = null;

    public Connection conectar() throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_medicamentos?" +
                "useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
                "useLegacyDatetimeCode=false&serverTimezone=UTC&" +
                "user=root&password=");
        } catch (Exception ex) {
            throw ex;
        }
        return this.conexion;
    }
    
    public void ejecutarOrden( String sql) throws Exception{
        Statement st = null;
        
        st = this.conexion.createStatement();
        st.executeUpdate(sql);
        
    }

    public ResultSet pedirDatos( String sql) throws Exception{
        Statement st = null;
        ResultSet rs = null;
        
        st = this.conexion.createStatement();
        rs = st.executeQuery(sql);
        
        return rs;
    }

    public void cerrar() throws Exception{
        try {
            this.conexion.close();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
