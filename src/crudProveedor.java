import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Scanner;



public class crudProveedor {
    
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs =null;
    
    Scanner x = new Scanner(System.in);
    private ArrayList<Proveedor>datosProveedores= new ArrayList<Proveedor>();
    
   public ArrayList<Proveedor> ConsultarTodosLosProveedores(){
        try {
           con = cn.Conecta();
           String sql="select * from Proveedor";
           st=con.createStatement();
           rs=st.executeQuery(sql);
            while (rs.next()) {
                Proveedor p = new Proveedor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                datosProveedores.add(p);
            }
            con.close();
       } catch (Exception e) {
           System.err.println("error al generar la consulta");
       }
        return datosProveedores;
    }
   
   
   public ArrayList<Proveedor> buscarProveedor(int dato){
       datosProveedores.clear();
        try {
           con = cn.Conecta();
           String sql="select * from Proveedor where prov_id=?";
           ps = con.prepareStatement(sql);
           ps.setInt(1, dato);
           rs=ps.executeQuery();
            while (rs.next()) {
                Proveedor f = new Proveedor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                datosProveedores.add(f);
            }
            con.close();
       } catch (Exception e) {
           System.err.println("error al generar la consulta");
       }
        return datosProveedores;
    }
   
   
     public boolean crearProveedor(int proveedor) {
        boolean respuesta = false;

        try {
            if (buscarProveedor(proveedor).size() == 0) {
                con = cn.Conecta();
                String sql = "insert into Proveedor values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, proveedor);
                System.out.println("Digite el nombre del proveedor: ");
                String prov_nombre = x.nextLine();
                ps.setString(2, prov_nombre);
                System.out.println("Digite la direccion del proveedor");
                String prov_direccion = x.nextLine();
                ps.setString(3, prov_direccion);
                System.out.println("Digite telefono del proveedor");
                String prov_telefono = x.nextLine();
                ps.setString(4, prov_telefono);
                respuesta = ps.executeUpdate()>0;
                con.close();
            }else{
                System.out.println("Este proveedor ya existe");
            }
        } catch (SQLException e) {
            System.err.println("error al crear el proveedor");
        }
        return respuesta;
    }
    
    public boolean  modificarProveedor(int p){
        boolean respuesta = false;
        try {
            if(buscarProveedor(p).size()>0){
                con = cn.Conecta();
                String sql = "update Proveedor set prov_nombre=?, prov_direccion=?, prov_telefono=? where prov_id=?";
                ps=con.prepareStatement(sql);
                System.out.println("Digite el nombre del proveedor: ");
                String prov_nombre = x.nextLine();
                ps.setString(1, prov_nombre);
                System.out.println("Digite direccion del proveedor: ");
                String prov_direccion = x.nextLine();
                ps.setString(2, prov_direccion);
                System.out.println("Digite telefono del proveedor: ");
                String prov_telefono = x.nextLine();
                ps.setString(3, prov_telefono);
                ps.setInt(4, p);
                respuesta=ps.executeUpdate()>0;
                con.close();
            }else{
                System.err.println("Este proveedor no existe en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("error al modificar al proveedor");
        }
        return respuesta;
    }
    
    public boolean  eliminarProveedor(int p){
        boolean respuesta = false;
        try {
            if(buscarProveedor(p).size()>0){
                System.err.println("esta seguro que desea eliminar el proveedor con el id "+p+" S/N");
                String opcion = x.nextLine();
                if(opcion.equalsIgnoreCase("s")){
                con = cn.Conecta();
                String sql = "delete from Proveedor where prov_id=?";
                ps=con.prepareStatement(sql);
                ps.setInt(1, p);
                respuesta=ps.executeUpdate()>0;
                con.close();
                }
                
            }else{
                System.err.println("este proveedor no existe en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("error al eliminar el proveedor verifique que este proveedor no hagare ferencia en otras tablas");
        }
        return respuesta;
  
    }
    
}
