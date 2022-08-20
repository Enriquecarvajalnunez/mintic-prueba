import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Scanner;



public class crudIntencionCompra {
    
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs =null;
    
    Scanner x = new Scanner(System.in);
    private ArrayList<IntencionCompra>compras= new ArrayList<IntencionCompra>();
    
   public ArrayList<IntencionCompra> ConsultarTodosLasIntencionesCompra(){
       compras.clear();
        try {
           con = cn.Conecta();
           String sql="select * from intencionCompra";
           st=con.createStatement();
           rs=st.executeQuery(sql);
            while (rs.next()) {
                IntencionCompra i = new IntencionCompra(rs.getString(1),rs.getString(2),rs.getString(3));
                compras.add(i);
            }
            con.close();
       } catch (Exception e) {
           System.err.println("error al generar la consulta");
       }
        return compras;
    }
   
   
   public ArrayList<IntencionCompra> buscarCompras(String dato){
       compras.clear();
        try {
           con = cn.Conecta();
           String sql="select * from intencionCompra where fk_alias_cliente=? or fk_nombre_fabricante=?";
           ps = con.prepareStatement(sql);
           ps.setString(1, dato);
           ps.setString(2, dato);
           rs=ps.executeQuery();
            while (rs.next()) {
                IntencionCompra i = new IntencionCompra(rs.getString(1),rs.getString(2),rs.getString(3));
                compras.add(i);
            }
            con.close();
       } catch (Exception e) {
           System.err.println("error al generar la consulta "+e);
       }
        return compras;
    }
   
   
     public boolean crearIntencionCompra() {
        boolean respuesta = false;
        try {
                con = cn.Conecta();
                String sql = "insert into intencionCompra values(?,?,?)";
                ps = con.prepareStatement(sql);
                System.out.println("Digite el alias del cliente interesado en el producto: "); 
                String fk_alias_cliente = x.nextLine();
                ps.setString(1, fk_alias_cliente);
                System.out.println("Digite el nombre del fabricante ");
                String fk_nombre_fabricante = x.nextLine();
                ps.setString(2, fk_nombre_fabricante);
                System.out.println("Digite fecha y hora en la que se consulto (YYYY-MM-DD HH:MM:SS) ");
                String fecha_visita = x.nextLine();
                ps.setString(3, fecha_visita);
                respuesta = ps.executeUpdate()>0;
                con.close();
            
        } catch (SQLException e) {
            System.err.println("error al crear intencion de compra");
        }
        return respuesta;
    }
    
    public boolean  modificarIntencionCompra(String p){
        boolean respuesta = false;
        try {
            if(buscarCompras(p).size()>0){
                con = cn.Conecta();
                String sql = "update intencionCompra set fk_alias_cliente=?, fk_nombre_fabricante=?, fecha_visita=? where fk_alias_cliente=? or fk_nombre_fabricante=?";
                ps=con.prepareStatement(sql);
                System.out.println("Digite el alias del cliente ");
                String fk_alias_cliente = x.nextLine();
                ps.setString(1, fk_alias_cliente);
                System.out.println("Digite el nombre del fabricante ");
                String fk_nombre_fabricante = x.nextLine();
                ps.setString(2, fk_nombre_fabricante);
                System.out.println("Digite fecha de visita (YYYY-MM-DD HH:MM:SS)");
                String fecha_visita = x.nextLine();
                ps.setString(3, fecha_visita);
                ps.setString(4, p);
                ps.setString(5, p);
                respuesta=ps.executeUpdate()>0;
                con.close();
            }else{
                System.err.println("Esta intención de compra no existe en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("error al modificar la intención de compra");
        }
        return respuesta;
    }
    
    public boolean  eliminarIntencionCompra(String b){
        boolean respuesta = false;
        try {
            if(buscarCompras(b).size()>0){
                System.err.println("esta seguro que desea eliminar la intención de compra con el cliente alias "+b+" S/N");
                String opcion = x.nextLine();
                if(opcion.equalsIgnoreCase("s")){
                con = cn.Conecta();
                String sql = "delete from intencionCompra where fk_alias_cliente=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, b);
                respuesta=ps.executeUpdate()>0;
                con.close();
                }
                
            }else{
                System.err.println("esta intención de compra no existe en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("error al eliminar esta intención de compra ");
        }
        return respuesta;
  
    }
    
     public ArrayList<IntencionCompra> consulta4(){
        compras.clear();
        try {
            con = cn.Conecta();
            String sql="select fk_nombre_fabricante from intencionCompra where fk_alias_cliente=\"lucky\" order by fk_nombre_fabricante";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while (rs.next()) {                
                IntencionCompra m = new IntencionCompra(rs.getString(1));
                compras.add(m);
            }
        } catch (SQLException e) {
            System.err.println("Error al generar la consulta");
        }
        return compras;
    }
    
}
