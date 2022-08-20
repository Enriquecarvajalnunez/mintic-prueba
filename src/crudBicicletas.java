import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Scanner;



public class crudBicicletas {
    
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs =null;
    
    Scanner x = new Scanner(System.in);
    private ArrayList<Bicicleta>datosBicicletas= new ArrayList<Bicicleta>();
    
   public ArrayList<Bicicleta> ConsultarTodosLasBicicletas(){
        try {
           con = cn.Conecta();
           String sql="select * from Bicicletas";
           st=con.createStatement();
           rs=st.executeQuery(sql);
            while (rs.next()) {
                Bicicleta b = new Bicicleta(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4));
                datosBicicletas.add(b);
            }
            con.close();
       } catch (Exception e) {
           System.err.println("error al generar la consulta");
       }
        return datosBicicletas;
    }
   
   
   public ArrayList<Bicicleta> buscarbicicleta(int dato){
       datosBicicletas.clear();
        try {
           con = cn.Conecta();
           String sql="select * from Bicicletas where bici_id=?";
           ps = con.prepareStatement(sql);
           ps.setInt(1, dato);
           rs=ps.executeQuery();
            while (rs.next()) {
                Bicicleta b = new Bicicleta(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4));
                datosBicicletas.add(b);
            }
            con.close();
       } catch (Exception e) {
           System.err.println("error al generar la consulta");
       }
        return datosBicicletas;
    }
   
   
     public boolean crearBicicleta() {
        boolean respuesta = false;

        try {
                con = cn.Conecta();
                String sql = "insert into Bicicletas (fk_nombre_fabricante,bici_precioUnitario,bici_anio)values(?,?,?)";
                ps = con.prepareStatement(sql);
                System.out.println("Digite el nombre del fabricante, que ya debe estar registrado en fabricantes: "); 
                String fk_nombre_fabricante = x.nextLine();
                ps.setString(1, fk_nombre_fabricante);
                System.out.println("Digite el precio de la bicicleta por unidad: ");
                float bici_precioUnitario = x.nextFloat();
                ps.setFloat(2, bici_precioUnitario);
                System.out.println("Digite el año de la bicicleta");
                x.nextLine();
                String bici_anio = x.nextLine();
                ps.setString(3, bici_anio);
                respuesta = ps.executeUpdate()>0;
                con.close();
            
        } catch (SQLException e) {
            System.err.println("error al crear bicicleta "+e);
        }
        return respuesta;
    }
    
    public boolean  modificarBicicleta(int p){
        boolean respuesta = false;
        try {
            if(buscarbicicleta(p).size()>0){
                con = cn.Conecta();
                String sql = "update Bicicletas set fk_nombre_fabricante=?, bici_precioUnitario=?, bici_anio=? where bici_id=?";
                ps=con.prepareStatement(sql);
                System.out.println("Digite el nombre del fabricante que ya este registrado como fabricante: ");
                String fk_nombre_fabricante = x.nextLine();
                ps.setString(1, fk_nombre_fabricante);
                System.out.println("Digite el valor de la bicicleta: ");
                float bici_precioUnitario = x.nextFloat();
                ps.setFloat(2, bici_precioUnitario);
                System.out.println("Digite el año de la bicicleta: ");
                x.nextLine();
                String bici_anio = x.nextLine();
                ps.setString(3, bici_anio);
                ps.setInt(4, p);
                respuesta=ps.executeUpdate()>0;
                con.close();
            }else{
                System.err.println("Esta bibicleta no existe en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("error al modificar la bicicleta");
        }
        return respuesta;
    }
    
    public boolean  eliminarBicicleta(int b){
        boolean respuesta = false;
        try {
            if(buscarbicicleta(b).size()>0){
                System.err.println("esta seguro que desea eliminar la bicicleta con el id "+b+" S/N");
                String opcion = x.nextLine();
                if(opcion.equalsIgnoreCase("s")){
                con = cn.Conecta();
                String sql = "delete from Bicicletas where bici_id=?";
                ps=con.prepareStatement(sql);
                ps.setInt(1, b);
                respuesta=ps.executeUpdate()>0;
                con.close();
                }
                
            }else{
                System.err.println("esta bicicleta no existe en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("error al eliminar esta bicicleta");
        }
        return respuesta;
  
    }
    
    public ArrayList<Bicicleta> Consulta2(){
        datosBicicletas.clear();
        String anio = "2019";
        try {
           con = cn.Conecta();
           String sql="select  fk_nombre_fabricante, bici_precioUnitario, bici_anio FROM Bicicletas where bici_anio >=\"2019\" order by fk_nombre_fabricante";
           st=con.createStatement();
           rs=st.executeQuery(sql);
            while (rs.next()) {
                Bicicleta b = new Bicicleta(rs.getString(1),rs.getFloat(2),rs.getString(3));
                datosBicicletas.add(b);
            }
            con.close();
       } catch (SQLException e) {
           System.err.println("error al generar la consulta "+e);
       }
        return datosBicicletas;
    }
    
    public int Consulta6(){
        int cantidad=0;
        int conteo=0;
        try {
           con = cn.Conecta();
           String sql="select count(fk_nombre_fabricante) from Bicicletas where bici_anio >=\"2019\"";
           st=con.createStatement();
           rs=st.executeQuery(sql);
            if(rs.next()){
                conteo=rs.getInt(1);
            }
            con.close();
       } catch (SQLException e) {
           System.err.println("error al generar la consulta "+e);
       }
        return conteo;
    }
    
}
