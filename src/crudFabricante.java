import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Scanner;



public class crudFabricante {
    
    Conexion cn = new Conexion();
    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs =null;
    
    Scanner x = new Scanner(System.in);
    private ArrayList<Fabricante>datosFabricante = new ArrayList<Fabricante>();
    
   public ArrayList<Fabricante> ConsultarTodosLosFabricantes(){
        try {
           con = cn.Conecta();
           String sql="select * from Fabricante";
           st=con.createStatement();
           rs=st.executeQuery(sql);
            while (rs.next()) {
                Fabricante f = new Fabricante(rs.getString(1),rs.getString(2),rs.getString(3));
                datosFabricante.add(f);
            }
            con.close();
       } catch (Exception e) {
           System.err.println("error al generar la consulta");
       }
        return datosFabricante;
    }
   
   
   public ArrayList<Fabricante> BuscarFabricante(String dato){
       datosFabricante.clear();
        try {
           con = cn.Conecta();
           String sql="select * from Fabricante where nombre_fabricante=?";
           ps = con.prepareStatement(sql);
           ps.setString(1, dato);
           rs=ps.executeQuery();
            while (rs.next()) {
                Fabricante f = new Fabricante(rs.getString(1),rs.getString(2),rs.getString(3));
                datosFabricante.add(f);
            }
            con.close();
       } catch (Exception e) {
           System.err.println("error al generar la consulta");
       }
        return datosFabricante;
    }
   
   
    public boolean crearFabricante(String fabricante) {
        boolean respuesta = false;

        try {
            if (BuscarFabricante(fabricante).size() == 0) {
                con = cn.Conecta();
                String sql = "insert into Fabricante values(?,?,?)";
                ps = con.prepareStatement(sql);
                //System.out.println("Digite el nombre del proveedor: ");
                //String nombre_pv = x.nextLine();
                ps.setString(1, fabricante);
                System.out.println("Digite la direccion del fabricante: ");
                String direccion_pv = x.nextLine();
                ps.setString(2, direccion_pv);
                System.out.println("Digite telefono del fabricante: ");
                String tel_pv = x.nextLine();
                ps.setString(3, tel_pv);
                respuesta = ps.executeUpdate()>0;
                con.close();
            }else{
                System.out.println("Este fabricante ya existe");
            }
        } catch (SQLException e) {
            System.err.println("error al crear el fabricante");
        }
        return respuesta;
    }
    
    public boolean  modificarFabricante(String f){
        boolean respuesta = false;
        try {
            if(BuscarFabricante(f).size()>0){
                con = cn.Conecta();
                String sql = "update Fabricante set direccion=?, telefono=?";
                ps=con.prepareStatement(sql);
                System.out.println("ingrese la direccion que sdesea modificar del fabricante");
                String direccion_fb = x.nextLine();
                ps.setString(1, direccion_fb);
                System.out.println("ingrese el telefono que desea modificar del fabricante");
                String telefono_fb = x.nextLine();
                ps.setString(2, telefono_fb);
                respuesta=ps.executeUpdate()>0;
                con.close();
            }else{
                System.err.println("Este fabricante no existe en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("error al modificar al fabricante");
        }
        return respuesta;
    }
    
    public boolean  EliminarFabricante(String f){
        boolean respuesta = false;
        try {
            if(BuscarFabricante(f).size()>0){
                con = cn.Conecta();
                String sql = "delete from Fabricante where nombre_fabricante=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, f);
                respuesta=ps.executeUpdate()>0;
                con.close();
            }else{
                System.err.println("este fabricante no existe en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("error al modificar al fabricante");
        }
        return respuesta;
    }
    
    public ArrayList<Fabricante> consulta1(){
         datosFabricante.clear();
        try {
            con=cn.Conecta();
            String sql = "SELECT nombre_fabricante FROM  Fabricante ORDER BY  nombre_fabricante";
             st=con.createStatement();
             rs=st.executeQuery(sql);
            while (rs.next()) {
                Fabricante f = new Fabricante(rs.getString(1));
                datosFabricante.add(f);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println("error al realizar la consulta "+e);
        }
        return datosFabricante;
    }
    
    
}
