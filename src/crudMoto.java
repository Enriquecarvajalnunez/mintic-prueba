import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Scanner;



public class crudMoto {
    
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs =null;
    
    Scanner x = new Scanner(System.in);
    private ArrayList<MotoCicleta>datosMotos= new ArrayList<MotoCicleta>();
    
   public ArrayList<MotoCicleta> ConsultarTodosLasMotos(){
       datosMotos.clear();
        try {
           con = cn.Conecta();
           String sql="select * from Motocicletas";
           st=con.createStatement();
           rs=st.executeQuery(sql);
            while (rs.next()) {
                MotoCicleta b = new MotoCicleta(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4),rs.getInt(5));
                datosMotos.add(b);
            }
            con.close();
       } catch (Exception e) {
           System.err.println("error al generar la consulta");
       }
        return datosMotos;
    }
   
   
   public ArrayList<MotoCicleta> buscarMoto(int dato){
       datosMotos.clear();
        try {
           con = cn.Conecta();
           String sql="select * from Motocicletas where moto_id=?";
           ps = con.prepareStatement(sql);
           ps.setInt(1, dato);
           rs=ps.executeQuery();
            while (rs.next()) {
                MotoCicleta m = new MotoCicleta(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4),rs.getInt(5));
                datosMotos.add(m);
            }
            con.close();
       } catch (Exception e) {
           System.err.println("error al generar la consulta");
       }
        return datosMotos;
    }
   
   
     public boolean crearMoto() {
        boolean respuesta = false;

        try {
                con = cn.Conecta();
                String sql = "insert into Motocicletas (fk_nombre_fabricante,moto_precioUnitario,moto_autonomia,fk_proveedor)values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                System.out.println("Digite el nombre del fabricante, que ya debe estar registrado en fabricantes: "); 
                String fk_nombre_fabricante = x.nextLine();
                ps.setString(1, fk_nombre_fabricante);
                System.out.println("Digite el precio de la moto por unidad: ");
                float moto_precioUnitario = x.nextFloat();
                ps.setFloat(2, moto_precioUnitario);
                System.out.println("Digite autonomia de la bateria de esta moto: ");
                int moto_autonomia = x.nextInt();
                ps.setInt(3, moto_autonomia);
                System.out.println("Digite id del proveedor que ya debe estar registrado: ");
                int fk_proveedor = x.nextInt();
                ps.setInt(4, fk_proveedor);
                respuesta = ps.executeUpdate()>0;
                con.close();
            
        } catch (SQLException e) {
            System.err.println("error al crear Motocicleta");
        }
        return respuesta;
    }
    
    public boolean  modificarMoto(int p){
        datosMotos.clear();
        boolean respuesta = false;
        try {
            if(buscarMoto(p).size()>0){
                con = cn.Conecta();
                String sql = "update Motocicletas set fk_nombre_fabricante=?, moto_precioUnitario=?, moto_autonomia=?, fk_proveedor=? where moto_id=?";
                ps=con.prepareStatement(sql);
                System.out.println("Digite el nombre del fabricante que ya este registrado como fabricante: ");
                String fk_nombre_fabricante = x.nextLine();
                ps.setString(1, fk_nombre_fabricante);
                System.out.println("Digite el valor de la moto: ");
                float moto_precioUnitario = x.nextFloat();
                ps.setFloat(2, moto_precioUnitario);
                System.out.println("Digite autonomia de la bateria: ");
                int moto_autonomia = x.nextInt();
                ps.setInt(3, moto_autonomia);
                System.out.println("Digite id del proveedor que ya debe esta registrado: ");
                int fk_proveedor = x.nextInt();
                ps.setInt(4, fk_proveedor);
                ps.setInt(5, p);
                respuesta=ps.executeUpdate()>0;
                con.close();
            }else{
                System.err.println("Esta moto no existe en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("error al modificar la moto");
        }
        return respuesta;
    }
    
    public boolean  eliminarMoto(int m){
        datosMotos.clear();
        boolean respuesta = false;
        try {
            if(buscarMoto(m).size()>0){
                System.err.println("esta seguro que desea eliminar la bicicleta con el id "+m+" S/N");
                String opcion = x.nextLine();
                if(opcion.equalsIgnoreCase("s")){
                con = cn.Conecta();
                String sql = "delete from Motocicletas where moto_id=?";
                ps=con.prepareStatement(sql);
                ps.setInt(1, m);
                respuesta=ps.executeUpdate()>0;
                con.close();
                }                
            }else{
                System.err.println("esta moto no existe en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("error al eliminar esta Moto");
        }
        return respuesta;
  
    }
    
    public ArrayList<MotoCicleta> consulta3(){
        datosMotos.clear();
        try {
            con = cn.Conecta();
            String sql="select fk_nombre_fabricante from Motocicletas where fk_proveedor = 101";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while (rs.next()) {                
                MotoCicleta m = new MotoCicleta(rs.getString(1));
                datosMotos.add(m);
            }
        } catch (SQLException e) {
            System.err.println("Error al generar la consulta");
        }
        return datosMotos;
    }
    
}
