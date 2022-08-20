
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    private String bd="ecodosruedas";
    private String url="jdbc:mysql://localhost:3306/"+bd;
    private String user="ander";
    private String pass="1118298007";
    
    Connection conect=null;
    
    public Connection Conecta(){
        
        try {
            conect=(Connection) DriverManager.getConnection(url,user,pass);
            //System.err.println("conexion exitosa");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return conect;
    }
    
}
