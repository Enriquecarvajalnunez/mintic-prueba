
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class crudCliente {
    
    Conexion cnn = new Conexion();
    Connection con = null;
    PreparedStatement ps = null;  //prepara consulta con parametros
    Statement st = null; //prepara consulta sin parametros
    ResultSet res = null;
    
    Scanner x = new Scanner(System.in);
    private ArrayList<Cliente> clients = new ArrayList<Cliente>();

    public ArrayList<Cliente> consultarTodosLosClientes() {
        clients.clear();
        try {

            con = cnn.Conecta();
            String sql = "select * from Clientes";
            st = con.createStatement();                    //preparamosla consulta con la conexion
            res = st.executeQuery(sql);  //ejecutar la consulta

            while (res.next()) {

                Cliente c = new Cliente(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
                clients.add(c);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println("error en la consulta " + e);
        }
        return clients;
    }

    public ArrayList<Cliente> buscarCliente(String dato1) {
        clients.clear();
        try {
     
            con = cnn.Conecta();
            String sql = "select * from Clientes where alias=? or cliente_nombres=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, dato1);
            ps.setString(2, dato1);
            res = ps.executeQuery();

            while (res.next()) {
                Cliente c = new Cliente(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
                clients.add(c);
            }
            con.close();
        } catch (Exception e) {
            System.err.println("Error al consultar: " + e);
        }
        return clients;
    }
    
     public boolean crearCliente(String c) {
        boolean respuesta = false;

        try {
            if (buscarCliente(c).size() == 0) {
                con = cnn.Conecta();
                String sql = "insert into Clientes values(?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                
                ps.setString(1, c);
                System.out.println("Digite el nombre del cliente: ");
                String cliente_nombres = x.nextLine();
                ps.setString(2, cliente_nombres);
                System.out.println("Digite apellidos del cliente ");
                String cliente_apellidos = x.nextLine();
                ps.setString(3, cliente_apellidos);
                System.out.println("Digite correo del cliente ");
                String cliente_email = x.nextLine();
                ps.setString(4, cliente_email);
                System.out.println("Digite celular del cliente ");
                String cliente_velular = x.nextLine();
                ps.setString(5, cliente_velular);
                System.out.println("Digite contraseña del cliente ");
                String cliente_contrasena = x.nextLine();
                ps.setString(6, cliente_contrasena);
                System.out.println("Digite fecha de nacimiento del cliente en formato(YYYY-MM-DD)");
                String cliente_fecha_nacimiento = x.nextLine();
                ps.setString(7, cliente_fecha_nacimiento);
                respuesta = ps.executeUpdate()>0;
                con.close();
            }else{
                System.out.println("Este Cliente ya existe");
            }
        } catch (SQLException e) {
            System.err.println("error al crear el Cliente");
        }
        return respuesta;
    }
    
    public boolean  modificarCliente(String c){
        boolean respuesta = false;
        try {
            if(buscarCliente(c).size()>0){
                con = cnn.Conecta();
                String sql = "update Clientes set cliente_nombres=?, cliente_apellidos=?, cliente_email=?, cliente_velular=?, cliente_contrasena=?, cliente_fecha_nacimiento=? where alias=?";
                ps=con.prepareStatement(sql);
                System.out.println("Digite el nombre del cliente: ");
                String cliente_nombres = x.nextLine();
                ps.setString(1, cliente_nombres);
                System.out.println("Digite apellidos del cliente ");
                String cliente_apellidos = x.nextLine();
                ps.setString(2, cliente_apellidos);
                System.out.println("Digite correo del cliente ");
                String cliente_email = x.nextLine();
                ps.setString(3, cliente_email);
                System.out.println("Digite celular del cliente ");
                String cliente_velular = x.nextLine();
                ps.setString(4, cliente_velular);
                System.out.println("Digite contraseña del cliente ");
                String cliente_contrasena = x.nextLine();
                ps.setString(5, cliente_contrasena);
                System.out.println("Digite fecha de nacimiento (YYYY-MM-DD)");
                String cliente_fecha_nacimiento = x.nextLine();
                ps.setString(6, cliente_fecha_nacimiento);
                ps.setString(7, c);
                respuesta=ps.executeUpdate()>0;
                con.close();
            }else{
                System.err.println("Este cliente no existe en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("error al modificar al cliente "+e);
        }
        return respuesta;
    }
    
    public boolean  eliminarCliente(String c){
        boolean respuesta = false;
        try {
            if(buscarCliente(c).size()>0){
                System.err.println("esta seguro que desea eliminar el cliente con el alias "+c+" S/N");
                String opcion = x.nextLine();
                if(opcion.equalsIgnoreCase("s")){
                con = cnn.Conecta();
                String sql = "delete from Clientes where alias=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, c);
                respuesta=ps.executeUpdate()>0;
                con.close();
                }
                
            }else{
                System.err.println("este cliente no existe en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("error al eliminar el cliente verifique que este cliente no haga  referencia en otras tablas");
        }
        return respuesta;
  
    }
    
}
