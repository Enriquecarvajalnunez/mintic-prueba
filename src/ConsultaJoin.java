
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ConsultaJoin {
    private String alias;
    private String nombre;
    private String apellidos;
    private String fk_alias_cliente;
    private String fk_nombre_fabricante;

    public ConsultaJoin() {
    }
    
    

    public ConsultaJoin(String alias, String nombre, String apellidos) {
         this.alias = alias;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public ConsultaJoin(String alias, String nombre, String apellidos, String fk_alias_cliente, String fk_nombre_fabricante) {
        this.alias = alias;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fk_alias_cliente = fk_alias_cliente;
        this.fk_nombre_fabricante = fk_nombre_fabricante;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFk_alias_cliente() {
        return fk_alias_cliente;
    }

    public void setFk_alias_cliente(String fk_alias_cliente) {
        this.fk_alias_cliente = fk_alias_cliente;
    }

    public String getFk_nombre_fabricante() {
        return fk_nombre_fabricante;
    }

    public void setFk_nombre_fabricante(String fk_nombre_fabricante) {
        this.fk_nombre_fabricante = fk_nombre_fabricante;
    }

    @Override
    public String toString() {
        return "ConsultaJoin{" + "alias=" + alias + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fk_alias_cliente=" + fk_alias_cliente + ", fk_nombre_fabricante=" + fk_nombre_fabricante + '}';
    }
    
    
    public ArrayList<ConsultaJoin> datosCliente(){
        Conexion cnn = new Conexion();
        Connection con = null;
        Statement st = null;
        ResultSet rs =null;
        ArrayList<ConsultaJoin>datos = new ArrayList<ConsultaJoin>();
        
        try {
            con=(Connection) cnn.Conecta();
            String sql="select alias, cliente_nombres, cliente_apellidos from Clientes inner join intencionCompra on Clientes.alias= intencionCompra.fk_alias_cliente where intencionCompra.fk_nombre_fabricante=\"Yeti\"";
            st =con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ConsultaJoin cj=new ConsultaJoin(rs.getString(1),rs.getString(2),rs.getString(3));
                datos.add(cj);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar.");
        }
        return datos;
        }
    
}
